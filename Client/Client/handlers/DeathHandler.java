package handlers;

import eventSystem.EventHandler;
import eventSystem.EventManager;
import events.DeathEvent;
import events.Event;
import events.SpawnEvent;
import gameObjects.GameObjectManager;

public class DeathHandler implements EventHandler{
	
	public void handle( Event e) {
		DeathEvent de = (DeathEvent) e;
		EventManager.events.add(new SpawnEvent(de.player, GameObjectManager.spawnPoint));


	}

}