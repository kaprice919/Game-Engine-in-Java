package gameObjects;

import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import components.Component;
import eventSystem.EventManager;
import events.MoveLeftEvent;
import networkSystem.NetworkManager;
import processing.core.PApplet;

public final class GameObjectManager {
	
	public static Player player;
	public static GameObject platform1;
	
	//TODO: Change linkedlist to concurrent hashmap
	public static ConcurrentHashMap<UUID, GameObject> gameObjects = new ConcurrentHashMap<UUID, GameObject>();
	
	public static ConcurrentHashMap<UUID, GameObject> staticObjects = new ConcurrentHashMap<UUID, GameObject>();
	
	public static SpawnPoint spawnPoint;
	
	public static UUID temp;
	
	public static int enemies = 5;
	public static int win = 0;
	
	private GameObjectManager(){
	}
	
	public static void init(PApplet screen){
		Random r = new Random();
		player = new Player(screen, 4, 10, 250, 100, screen, r.nextInt(255), r.nextInt(255), r.nextInt(255));

		gameObjects.put(player.UUID, player);
				
	}
	
	public static void draw(){
		for(Entry<UUID, GameObject> g : gameObjects.entrySet() ){
			GameObject go = g.getValue();
			for( Component c : go.components ){
				c.update(go);
				c.update(player, gameObjects);				
			}
		}
	}
	
	public static void handleShots(){
		for(Entry<UUID, GameObject> g : gameObjects.entrySet()){
			GameObject go = g.getValue();
			
			//If it's a PLAYER shot
			if(go.type.equals(ObjectType.PLAYERSHOT)){
				
				go.position.y -= 3;
				
				for(Entry<UUID, GameObject> f : gameObjects.entrySet()){
					GameObject fo = f.getValue();
					
					if(fo.type.equals(ObjectType.MOVINGPLATFORM)){
						fo.mesh.setLocation((int)fo.position.x, (int)fo.position.y);
						go.mesh.setLocation((int)go.position.x, (int)go.position.y);
						
						if(fo.mesh.intersects(go.mesh)){
							MovingPlatform mp = (MovingPlatform) fo;
							mp.dead = "true";
							GameObjectManager.gameObjects.remove(fo.UUID);
							NetworkManager.write(mp);
							GameObjectManager.gameObjects.remove(go.UUID);
							GameObjectManager.enemies--;
							break;
						}
					}
				}	
			} else if(go.type.equals(ObjectType.ENEMYSHOT)){
				go.position.y += 3;
			}
		}
	}
	
	public static void didWin(){
		if(enemies ==0 && win == 0){
			EventManager.events.add(new MoveLeftEvent());
			win = 1;
		}
	}

}
