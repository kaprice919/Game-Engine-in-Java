package handlers;

import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import eventSystem.EventHandler;
import events.Event;
import gameObjects.GameObject;
import gameObjects.GameObjectManager;
import gameObjects.ObjectType;
import gameObjects.Player;
import replaySystem.ReplayManager;

public class RecordHandler implements EventHandler {

	public void handle( Event e) {
		
		ConcurrentHashMap<UUID, GameObject> currentObjects = new ConcurrentHashMap<UUID, GameObject>();
		
		for(Entry<UUID, GameObject> g : GameObjectManager.gameObjects.entrySet()){
			
			if(g.getValue().type.equals(ObjectType.PLAYER)){
				Player player = (Player) g.getValue();
				currentObjects.put(player.UUID, player.copy());
			}else{
				currentObjects.put(g.getKey(), g.getValue());
			}
		}
				
		ReplayManager.recordingList.add(currentObjects);

	}

}
