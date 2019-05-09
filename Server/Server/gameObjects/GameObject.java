package gameObjects;
import java.awt.Rectangle;
import java.util.UUID;
import java.io.Serializable;
import java.util.LinkedList;
import components.*;
import processing.core.PShape;
import processing.core.PVector;

public abstract class GameObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UUID UUID = java.util.UUID.randomUUID();
	
	public Size size = new Size();;

	public ObjectType type;
	
	public Moveable moveable;
	public Collidable collidable;
	public Renderable renderable;
	
	public transient PShape shape;
	public Rectangle mesh;
	public Color color  = new Color();
	
	public transient int clientNumber;
	
	public transient float left;
	public transient float right;
	public transient float jump;
	
	public transient int width,height;
	
	public PVector position;
	public transient PVector velocity;

	public transient LinkedList<Component> components;


}
