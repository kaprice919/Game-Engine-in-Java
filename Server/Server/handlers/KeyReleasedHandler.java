package handlers;

import eventSystem.EventHandler;
import events.Event;
import events.KeyReleasedEvent;
import gameObjects.GameObjectManager;
import gameObjects.Player;

public class KeyReleasedHandler implements EventHandler{
	
	public KeyReleasedHandler(){
	}
	
	public void handle( Event e) {
		KeyReleasedEvent kre = (KeyReleasedEvent) e;
		Player player = (Player) GameObjectManager.gameObjects.get(0);
		
		//Key released was left or right, so stop.
		if(kre.left || kre.right) {
			player.velocity.x = 0;
		}
		//Key released was jump. If not colliding, add velocity up
		else if (kre.jump){
			player.jump = 0;
		}
	}

}
