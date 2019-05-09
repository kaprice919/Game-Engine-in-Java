package gameObjects;

import java.util.LinkedList;

import processing.core.PApplet;

public final class GameObjectManager {
	
	public static GameObject player;
	public static GameObject platform1;
	public final static LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
	
	private GameObjectManager(){
	}
	
	public static void init(PApplet screen){
		
		player = new Player(screen, 4, 10, 250, 100, screen, 100, 100, 255);

		gameObjects.add(player);
				
	}

	
	

}
