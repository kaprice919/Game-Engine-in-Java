package events;

import gameObjects.GameObject;
import gameObjects.Player;

public class PlayerShootEvent extends Event{
	
	private static final long serialVersionUID = 1L;
	public Player player;
	
	public PlayerShootEvent(GameObject player){
		this.type = Events.PLAYERSHOOTEVENT;
		this.player = (Player) player;
		this.priority = 2;
	}

}
