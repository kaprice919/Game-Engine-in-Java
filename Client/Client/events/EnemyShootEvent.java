package events;

import gameObjects.GameObject;
import gameObjects.MovingPlatform;

public class EnemyShootEvent extends Event{
	
	private static final long serialVersionUID = 1L;
	public MovingPlatform enemy;
	
	public EnemyShootEvent(GameObject enemy){
		this.type = Events.ENEMYSHOOTEVENT;
		this.enemy = (MovingPlatform) enemy;
		this.priority = 2;
	}

}
