package eventSystem;

import events.Event;

public class EventHandlerThread {
	
	public static void handle(){
		
		while(!EventManager.events.isEmpty()){
			
			
			
			try{
				Event e = EventManager.events.poll();
				
				
				EventHandler eh = EventManager.handlerList.get(e.type);
				eh.handle(e);
			}catch(NullPointerException e){
				;
			}
			
		}
	}

}
