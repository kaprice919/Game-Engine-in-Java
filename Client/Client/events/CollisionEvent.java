package events;

import events.Event;
import events.Events;
import gameObjects.GameObject;

public class CollisionEvent extends Event {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameObject object1;
	public GameObject object2;
	
	public CollisionEvent(GameObject object1, GameObject object2){
		type = Events.COLLISION;
		this.object1 = object1;
		this.object2 = object2;
		this.priority = 1;
	}

}
