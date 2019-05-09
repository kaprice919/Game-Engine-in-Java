package events;

import gameObjects.GameObject;
import gameObjects.Player;
import gameObjects.SpawnPoint;

public class SpawnEvent extends Event{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Player player;
	public SpawnPoint spawnPoint;
	
	public SpawnEvent(GameObject player, GameObject spawnPoint){
		this.type = Events.SPAWN;
		this.player = (Player) player;
		this.spawnPoint = (SpawnPoint) spawnPoint;
		this.priority = 3;
	}

}
