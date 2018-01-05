package osgi.test.helloworld.event;

import java.util.Dictionary;

import org.osgi.service.event.Event;

public class MyEvent extends Event {

	public static final String MY_TOPIC = "osgi/test/helloworld/MyEvent"; 
	public static final Dictionary<String, ?> DICTIONARY = null;

	public MyEvent() { 
		super(MY_TOPIC, DICTIONARY);
	} 
	
    public MyEvent(String arg0, Dictionary<String, ?> arg1) { 
        super(MY_TOPIC, arg1); 
    } 
 
    public String toString() { 
        return "MyEvent"; 
    } 
}
