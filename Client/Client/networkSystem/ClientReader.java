package networkSystem;
import eventSystem.EventManager;
import events.SpawnEvent;
import gameObjects.GameObject;
import gameObjects.GameObjectManager;
import gameObjects.ObjectType;
import gameObjects.SpawnPoint;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map.Entry;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import processing.core.PShape;

import main.Client;

import components.*;

public class ClientReader implements Runnable {
	
	public static ObjectInputStream ois;
	public static ConcurrentHashMap<UUID, GameObject> recievedObjects = new ConcurrentHashMap<UUID, GameObject>();


	@SuppressWarnings("unchecked")
	public void run(){
		
		init();
		
		while(true){
			try {
				recievedObjects = (ConcurrentHashMap<UUID, GameObject>) ois.readObject();
			} catch (ClassNotFoundException e) {
				;
			} catch (IOException e) {
				;
			}catch (ClassCastException e) {
				;
			}finally{
				
				for(Entry<UUID, GameObject> g : recievedObjects.entrySet()){
					GameObject go = g.getValue();
										
					//If ourselves, don't build the shape
					if(go.UUID.equals(GameObjectManager.player.UUID) || go.type.equals(ObjectType.PLATFORM))
						continue;
					
					go.components = new LinkedList<Component>();
					build(go);
					
						
					if(!GameObjectManager.gameObjects.contains(go)){
						GameObjectManager.gameObjects.put(go.UUID, go);
					}else{
						GameObjectManager.gameObjects.replace(go.UUID, go);
					}
					
				}
			}
		}
		
		
	}
	public void build(GameObject go){
		
		float[] ary = { 0, 0, go.size.width, go.size.height };
		go.shape = Client.screen.createShape(PShape.RECT, ary);	
		go.shape.setFill(Client.screen.color(go.color.r, go.color.g, go.color.b));
		
		go.components.add(new Renderable(Client.screen));

		
	}
	
	
	@SuppressWarnings("unchecked")
	public void init(){
		try {
			GameObjectManager.staticObjects = (ConcurrentHashMap<UUID, GameObject>) ois.readObject();
		} catch (ClassNotFoundException e) {
			;
		} catch (IOException e) {
			;
		}finally{
			for(Entry<UUID, GameObject> g : GameObjectManager.staticObjects.entrySet()){
				GameObject go = g.getValue();
				
				go.components = new LinkedList<Component>();
				
				if(go.type.equals(ObjectType.PLATFORM) || go.type.equals(ObjectType.PLAYER)){
					Renderable renderable = new Renderable( Client.screen );
					go.components.add(renderable);
					float[] ary = { go.position.x, go.position.y, go.size.width, go.size.height };
					go.shape = Client.screen.createShape(PShape.RECT, ary);
					go.shape.setFill(Client.screen.color(go.color.r, go.color.g, go.color.b));
				}
				
				if(go.type.equals(ObjectType.SPAWNPOINT)){
					GameObjectManager.spawnPoint = (SpawnPoint) go;
					EventManager.events.add(new SpawnEvent(GameObjectManager.player, GameObjectManager.spawnPoint));
				}
				
				GameObjectManager.gameObjects.put(go.UUID, go);
				
			}
		}
	}
	
	
}
