package gameObjects;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;

import components.Collidable;
import components.Component;
import components.Renderable;
import main.Client;
import processing.core.PShape;
import processing.core.PVector;

public class EnemyShot extends GameObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public EnemyShot(int x, int y ){
		
		this.type = ObjectType.ENEMYSHOT;
		components = new LinkedList<Component>();
		Renderable renderable = new Renderable( Client.screen );
		Collidable collidable = new Collidable(  );
		components.add(renderable);
		components.add(collidable);
		color.r = 255;
		color.b = 0;
		color.g = 0;
		
		position = new PVector(x, y);
		this.width = 5;
		this.height = 10;
		
		this.size.width = 5;
		this.size.height = 10;
		
		mesh = new Rectangle();
		mesh.setBounds(x, y, 5, 10);
		
		float[] ary = { 0, 0, width, height };
		shape = Client.screen.createShape(PShape.RECT, ary);

		// Set the color
		shape.setFill(Client.screen.color(color.r, color.g, color.b));
		
		
		
	}
}