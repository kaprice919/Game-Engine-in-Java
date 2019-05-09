package components;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import networkSystem.NetworkManager;

import processing.core.PVector;

import gameObjects.GameObject;

public class Moveable implements Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Updates position via velocity
	
	//Render the player to screen
	public void update( GameObject object ) {
		
		PVector oldPosition = object.position.copy();
		
		object.position.add(object.velocity);
		object.mesh.x = (int) object.position.x;
		object.mesh.y = (int) object.position.y;
		
		if(oldPosition.x != object.position.x || oldPosition.y != object.position.y){
			NetworkManager.write( object );
		}
		
	}

	//Do nothing
	public void update( GameObject object1, ConcurrentHashMap<UUID, GameObject> gameObjects){
		;
	}
}
