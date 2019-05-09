package events;

import gameObjects.GameObject;
import gameObjects.Player;

public class DeathEvent extends Event{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Player player;
	
	public DeathEvent(GameObject player){
		this.type = Events.DEATH;
		this.player = (Player) player;
		this.priority = 3;
	}

}
