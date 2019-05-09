package events;

import gameObjects.GameObject;
import gameObjects.Player;

public class GravityEvent extends Event{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Player player;
	public GravityEvent(GameObject player){
		this.type = Events.GRAVITY;
		this.player = (Player) player;
		this.priority = 1;
	}
}
