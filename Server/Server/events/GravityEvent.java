package events;

import gameObjects.GameObject;
import gameObjects.Player;

public class GravityEvent extends Event{

	public Player player;
	public GravityEvent(GameObject player){
		this.type = Events.GRAVITY;
		this.player = (Player) player;
	}
}
