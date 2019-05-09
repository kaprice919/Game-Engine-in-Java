package components;

import java.awt.Rectangle;
import java.util.LinkedList;

import eventSystem.CollisionEvent;
import eventSystem.EventManager;
import events.GravityEvent;
import gameObjects.GameObject;

public class Collidable implements Component {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Collidable( ){
		
	}

	//Render the player to screen
	public void update( GameObject player ) {
		;
	}
	
	//If there is a collision, raise a new collision event
	public void update( GameObject player, LinkedList<GameObject> gameObjects){
		for( GameObject g : gameObjects){
			if( player.equals(g)){
				continue;
			}
			
			Rectangle nextPosition = (Rectangle) player.mesh.clone();
			nextPosition.x += player.velocity.x;
			nextPosition.y += player.velocity.y;

			if(nextPosition.intersects(g.mesh)){
				EventManager.events.add(new CollisionEvent( player, g ));
				return;
			}
			EventManager.events.add(new GravityEvent( player ));
		}
		
		
	}
}
