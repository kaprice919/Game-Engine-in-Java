package gameObjects;

import java.awt.Rectangle;
import java.io.Serializable;

import processing.core.PApplet;
import processing.core.PVector;

public class Platform extends GameObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public transient int width, height;

	public Platform(PApplet screen, int width, int height, int x, int y, int r, int g, int b) {

		this.type = ObjectType.PLATFORM;

		color.r = r;
		color.g = g;
		color.b = b;
		
		mesh = new Rectangle();
		mesh.setBounds(x - 1, y + 1, width, height);
		
		position = new PVector(x, y);
		this.width = width;
		this.height = height;
		
		this.size.width = width;
		this.size.height = height;

	}
}
