package osgi.test.helloworld2.eventhandler;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class MyEventHandler implements EventHandler{

	@Override
	public void handleEvent(Event event) { 
        System.out.println("handle event started--"+event); 
        try { 
			Thread.currentThread().sleep(5*1000); 
        } catch (InterruptedException e) { 
             
        } 
        System.out.println("handle event ok--"+event); 
     } 

}
