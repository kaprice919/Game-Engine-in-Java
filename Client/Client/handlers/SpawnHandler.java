package handlers;

import eventSystem.EventHandler;
import events.Event;
import events.SpawnEvent;

public class SpawnHandler implements EventHandler{
	
	public void handle( Event e) {
		SpawnEvent se = (SpawnEvent) e;
		se.player.position.x = se.spawnPoint.position.x;
		se.player.position.y = se.spawnPoint.position.y;
		
		se.player.mesh.x = (int) se.spawnPoint.position.x;
		se.player.mesh.y = (int) se.spawnPoint.position.y;


	}

}
