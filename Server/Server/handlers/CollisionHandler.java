package handlers;

import eventSystem.CollisionEvent;
import eventSystem.EventHandler;
import events.Event;
import gameObjects.ObjectType;


public class CollisionHandler implements EventHandler{
	
	public void handle( Event e) {
		CollisionEvent ce = (CollisionEvent) e;
		
		
		
		//If a player is colliding with a platform
		if (ce.object1.type.equals(ObjectType.PLAYER) && ce.object2.type.equals(ObjectType.PLATFORM)){
			if( ce.object1.jump == 0 ){
				ce.object1.velocity.y = 0;
				ce.object1.position.y = ce.object2.position.y - ce.object1.height + 2;
			}
		}
		
		
		//If player is hitting wall
		else if (ce.object1.type.equals(ObjectType.PLAYER) && ce.object2.type.equals(ObjectType.WALL)){
			//check for left or right movement
		}
		
	}
	
	

}
