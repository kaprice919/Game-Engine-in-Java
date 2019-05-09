package eventSystem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

import events.Event;
import events.Events;
import handlers.*;


public final class EventManager {
	
	public static final Comparator<Event> comparator = new EventComparator();
	public static final PriorityQueue<Event> events = new PriorityQueue<Event>(comparator);
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
		EventManager.registerHandler(Events.SPAWN, new SpawnHandler());
		EventManager.registerHandler(Events.DEATH, new DeathHandler());
		EventManager.registerHandler(Events.RECORD, new RecordHandler());
		EventManager.registerHandler(Events.REPLAY, new ReplayHandler());
		EventManager.registerHandler(Events.PLAYERSHOOTEVENT, new PlayerShootHandler());
		EventManager.registerHandler(Events.LEFT, new moveLeftHandler());
		
		
	}
	
	
}
