package gameObjects;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;

import components.*;
import processing.core.*;

public class Player extends GameObject implements Serializable {
	
	/**
	 * 
	 */
	private transient static final long serialVersionUID = 1L;
	public transient float jumpSpeed;
	public transient float moveSpeed;

	public transient float gravity = .3f;

	

	public transient boolean collision = true;

	//Its just a rectangle, for now

	public Player( PApplet screen, float moveSpeed, float jumpSpeed, int x, int y, PApplet applet, int r, int g, int b) {
		
		this.width = 60;
		this.height = 30;
		
		this.type = ObjectType.PLAYER;
		components = new LinkedList<Component>();
		
		Renderable renderable = new Renderable( screen );
		Collidable collidable = new Collidable();
		Moveable moveable = new Moveable();
		
		components.add(renderable);
		components.add(collidable);
		components.add(moveable);
		
		
		this.position = new PVector();
		this.velocity = new PVector();
		
		
		mesh = new Rectangle();
		mesh.setBounds(x, y, width, height);
		// Set the base ground height

		position = new PVector(x, y);

		velocity = new PVector(0, 0);

		// Set movement speed
		this.moveSpeed = moveSpeed;
		this.jumpSpeed = jumpSpeed;

		// Instantiate the shape
		float[] ary = { 0, 0, width, height };
		shape = applet.createShape(PShape.RECT, ary);

		// Set the color
		shape.setFill(applet.color(r, g, b));
		
	}
	
	
	
}
