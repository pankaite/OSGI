package osgi.test.helloworld;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;

import osgi.test.helloworld.impl.DefaultAppServiceImpl;
import osgi.test.helloworld.impl.DefaultHelloServiceImpl;
import osgi.test.helloworld.service.IAppService;
import osgi.test.helloworld.service.IHello;
import osgi.test.helloworld.servlet.MyServlet;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private Registry registry;
	
	public static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Hello World!");
		context.registerService(IHello.class.getName(), new DefaultHelloServiceImpl(), null);
		HttpService httpService = (HttpService) context.getService(context.getServiceReference(HttpService.class.getName()));
		httpService.registerResources("/", "/pages", null);
		MyServlet ms = new MyServlet();
		httpService.registerServlet("/ms", ms, null, null);
		IAppService appService = new DefaultAppServiceImpl(context);
		context.registerService(IAppService.class.getName(), appService, null);
		startRmiServer(appService);
	}

	private void startRmiServer(IAppService service) throws RemoteException { 
	    if(registry == null) { 
	        registry = LocateRegistry.createRegistry(1099); 
	    } 
	    // 注册 appService 远程服务 . 
	    IAppService theService = 
	        (IAppService)UnicastRemoteObject.exportObject(service,0); 
	    registry.rebind("appService", theService); 
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
