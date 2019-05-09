package gameObjects;

import java.awt.Rectangle;
import java.io.Serializable;
import processing.core.PVector;
import gameObjects.ObjectType;

public class SpawnPoint extends GameObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpawnPoint(float x, float y){
		
		this.type = ObjectType.SPAWNPOINT;
		
		this.position = new PVector(x,y);
		
		this.mesh = new Rectangle();


	}

}
