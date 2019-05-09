package components;

import java.util.LinkedList;
import gameObjects.GameObject;

public class Moveable implements Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Updates position via velocity
	
	//Render the player to screen
	public void update( GameObject object ) {
				
		object.position.add(object.velocity);
		object.mesh.x = (int) object.position.x;
		object.mesh.y = (int) object.position.y;
		
	}

	//Do nothing
	public void update( GameObject object1, LinkedList<GameObject> gameObjects){
		;
	}
}
