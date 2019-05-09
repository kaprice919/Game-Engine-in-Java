package gameObjects;

import java.awt.Rectangle;
import java.util.LinkedList;

import components.*;
import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class Wall extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width, height;

	public Wall(int width, int height, int x, int y, PApplet applet, int r, int g, int b) {

		this.type = ObjectType.WALL;
		components = new LinkedList<Component>();
		
		mesh = new Rectangle();
		mesh.setBounds(x - 1, y + 1, width, height);

		position = new PVector(x, y);
		this.width = width;
		this.height = height;

		// Instantiate the shape
		float[] ary = { position.x, position.y, width, height };
		
		shape = applet.createShape(PShape.RECT, ary);

		// Set the color
		shape.setFill(applet.color(r, g, b));

	}

}
