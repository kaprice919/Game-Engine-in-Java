package gameObjects;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

import components.Component;
import components.Renderable;

public class MovingPlatform extends GameObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public transient int width, height, bounds1, bounds2;
	
	public String dead = "false";


	public MovingPlatform(PApplet screen, int width, int height, int x, int y, int r, int g, int b, int bounds1, int bounds2) {

		this.type = ObjectType.MOVINGPLATFORM;
		
		components = new LinkedList<Component>();
		Renderable renderable = new Renderable( screen );
		
		color.r = r;
		color.g = g;
		color.b = b;
		
		components.add(renderable);
		
		
		mesh = new Rectangle();
		mesh.setBounds(x - 1, y + 1, width, height);
		
		position = new PVector(x, y);
		this.width = width;
		this.height = height;
		
		this.bounds1 = bounds1;
		this.bounds2 = bounds2;
		
		this.size.width = width;
		this.size.height = height;


	}
}
