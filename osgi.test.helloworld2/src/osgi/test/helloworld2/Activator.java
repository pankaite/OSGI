package osgi.test.helloworld2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import osgi.test.helloworld.event.MyEvent;
import osgi.test.helloworld.service.IAppService;
import osgi.test.helloworld.service.IHello;
import osgi.test.helloworld2.eventhandler.MyEventHandler;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Hello World2!");

		/**
		 * 添加事件处理器 .
		 */
		String[] topics = new String[] { MyEvent.MY_TOPIC };
		Hashtable<String, String[]> ht = new Hashtable<String, String[]>();
		ht.put(EventConstants.EVENT_TOPIC, topics);
		EventHandler myHandler = new MyEventHandler();
		context.registerService(EventHandler.class.getName(), myHandler, ht);
		System.out.println("event handler registered");

		IHello hello1 = (IHello) context.getService(context.getServiceReference(IHello.class.getName()));
		System.out.println(hello1.getHello());
		IAppService appService1 = (IAppService) context.getService(context.getServiceReference(IAppService.class.getName()));
		System.out.println(appService1.getAppName());
		
		String host = "127.0.0.1"; 
		int port = 1099; 
		IAppService appServiceStub = null;
		try { 
		    Registry registry = LocateRegistry.getRegistry(host,port); 
		    appServiceStub = (IAppService) registry.lookup("appService"); 
		} catch (Exception e) { 
		    e.printStackTrace(); 
		} 
		System.out.println("rmi:"+appServiceStub.getAppName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
