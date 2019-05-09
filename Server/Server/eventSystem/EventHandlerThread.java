package eventSystem;

import java.util.NoSuchElementException;

import events.Event;

public class EventHandlerThread implements Runnable{
	
	public void run(){
		while(true){
			
			try{
				Event e = EventManager.events.pop();
				EventHandler eh = EventManager.handlerList.get(e.type);
				eh.handle(e);
			}catch(NoSuchElementException e){
				
			}
			
		}
	}

}
