package handlers;

import eventSystem.EventHandler;
import events.Event;
import events.PlayerShootEvent;
import gameObjects.GameObjectManager;
import gameObjects.PlayerShot;

public class PlayerShootHandler implements EventHandler {
	public void handle( Event e) {
		
		PlayerShootEvent pse = (PlayerShootEvent) e;

		
		PlayerShot ps = new PlayerShot(((int)pse.player.position.x + pse.player.width / 2) -2, (int)pse.player.position.y - 10);
		GameObjectManager.gameObjects.put(ps.UUID, ps);

	}
}
