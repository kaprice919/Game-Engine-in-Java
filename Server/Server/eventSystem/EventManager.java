package eventSystem;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import events.Event;
import events.Events;
import handlers.CollisionHandler;
import handlers.GravityHandler;
import handlers.KeyPressedHandler;
import handlers.KeyReleasedHandler;

public final class EventManager {
	public static final LinkedList<Event> events = new LinkedList<Event>();
	public static final ConcurrentHashMap<Events, EventHandler> handlerList = new ConcurrentHashMap<Events, EventHandler>();
	
	private EventManager(){
		
	}
	
	
	public static void registerHandler(Events e, EventHandler handler){
		handlerList.put(e, handler);
	}
	
	public static void init(){
		
		//Register all the handlers
		EventManager.registerHandler(Events.KEYPRESSED, new KeyPressedHandler());
		EventManager.registerHandler(Events.KEYRELEASED, new KeyReleasedHandler());
		EventManager.registerHandler(Events.COLLISION, new CollisionHandler());
		EventManager.registerHandler(Events.GRAVITY, new GravityHandler());
		
		
		(new Thread(new EventHandlerThread())).start();
	}
	
	
}
