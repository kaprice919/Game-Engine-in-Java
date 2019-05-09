package components;
import java.util.LinkedList;

import gameObjects.*;
import processing.core.*;

public class Renderable implements Component {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PApplet screen;

	public Renderable( PApplet screen ){
		this.screen = screen;
	}

	//Render the player to screen
	public void update( GameObject object ) {
		if(object.type.equals( ObjectType.PLAYER )){
			screen.pushMatrix();
			screen.translate(object.position.x, object.position.y);
			screen.shape(object.shape, 0, 0);
			screen.popMatrix();
			
		}else if ( object.type.equals(ObjectType.PLATFORM)){
			screen.shape(object.shape, 0, 0);
		}
	}
	
	//Do nothing
	public void update( GameObject object1, LinkedList<GameObject> gameObjects){
		;
	}
	
}
