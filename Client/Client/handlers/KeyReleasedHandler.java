package handlers;

import eventSystem.EventHandler;
import events.Event;
import events.KeyReleasedEvent;
import gameObjects.GameObjectManager;
import gameObjects.Player;
import replaySystem.ReplayManager;

public class KeyReleasedHandler implements EventHandler{
	
	public KeyReleasedHandler(){
	}
	
	public void handle( Event e) {
		KeyReleasedEvent kre = (KeyReleasedEvent) e;
		Player player = (Player) GameObjectManager.gameObjects.get(GameObjectManager.player.UUID);
		
		//Key released was left or right, so stop.
		if(kre.left || kre.right) {
			player.velocity.x = 0;
		}
	}

}
