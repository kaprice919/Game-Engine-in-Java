package components;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

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
		if(object.type.equals( ObjectType.PLAYER ) || object.type.equals( ObjectType.MOVINGPLATFORM ) 
				|| object.type.equals(ObjectType.PLAYERSHOT) || object.type.equals(ObjectType.ENEMY)
				|| object.type.equals(ObjectType.ENEMYSHOT)){
			
			if(object.type.equals(ObjectType.MOVINGPLATFORM)){
				MovingPlatform mp = (MovingPlatform) object;
				if(mp.dead.equals("true"))
					return;
			}
			screen.pushMatrix();
			screen.translate(object.position.x, object.position.y);
			screen.shape(object.shape, 0, 0);
			screen.popMatrix();
			
		}else if ( object.type.equals(ObjectType.PLATFORM)){
			screen.shape(object.shape, 0, 0);
		}
	}
	
	//Do nothing
	public void update( GameObject object1, ConcurrentHashMap<UUID, GameObject> gameObjects){
		;
	}
	
}
