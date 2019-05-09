package components;

import java.awt.Rectangle;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import events.CollisionEvent;
import eventSystem.EventManager;
import events.DeathEvent;
import events.GravityEvent;
import gameObjects.GameObject;
import gameObjects.ObjectType;

public class Collidable implements Component {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Collidable( ){
		
	}

	//Render the object to screen
	public void update( GameObject object ) {
		;
	}
	
	//If there is a collision, raise a new collision event
	public void update( GameObject object, ConcurrentHashMap<UUID, GameObject> gameObjects){
		for( Entry<UUID, GameObject> g : gameObjects.entrySet()){
			GameObject go = g.getValue();
		
			if( object.equals(go)){
				continue;
			}
			
			if( !object.type.equals(ObjectType.PLAYER))
				break;
			
			Rectangle nextPosition = (Rectangle) object.mesh.clone();
			nextPosition.x += object.velocity.x;
			nextPosition.y += object.velocity.y;

			if(nextPosition.intersects(go.mesh) && (go.type.equals(ObjectType.PLATFORM) || go.type.equals(ObjectType.MOVINGPLATFORM))){
				EventManager.events.add(new CollisionEvent( object, go ));
				return;
			}else if(nextPosition.intersects(go.mesh) && go.type.equals(ObjectType.DEATHZONE)){
				EventManager.events.add(new DeathEvent(object));
			}
		}
			
		
	}
}
