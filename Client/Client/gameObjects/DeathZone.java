package gameObjects;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;

import processing.core.PVector;

import components.Collidable;
import components.Component;

public class DeathZone extends GameObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeathZone(int x, int y, int width, int height){
		
		components = new LinkedList<Component>();

		
		this.type = ObjectType.DEATHZONE;
		
		this.position = new PVector(x,y);
		
		this.size = new Size();
		this.size.width = width;
		this.size.height = height;
		
		Collidable collidable = new Collidable();
		this.components.add(collidable);
		
		mesh = new Rectangle();
		mesh.setBounds(x - 1, y + 1, width, height);
		
	}

}
