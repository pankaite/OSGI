package osgi.test.helloworld.impl;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.EventAdmin;

import osgi.test.helloworld.Activator;
import osgi.test.helloworld.event.MyEvent;
import osgi.test.helloworld.service.IHello;

public class DefaultHelloServiceImpl implements IHello {

	public static BundleContext context = Activator.getContext();
	public static EventAdmin eventAdmin;

	@Override
	public String getHello() {
		//post a event 
	    ServiceReference<?> ref =  context.getServiceReference(EventAdmin.class.getName()); 
	    if(ref!=null) { 
	        eventAdmin = (EventAdmin)context.getService(ref); 
	        if(eventAdmin!=null) { 
	            System.out.println("post event started"); 
	            eventAdmin.sendEvent(new MyEvent()); 
	            System.out.println("post event returned"); 
	        } 
	    } 
		return "Hello OSGI Service";
	}

}
