package handlers;
import eventSystem.EventHandler;
import events.Event;
import events.KeyPressedEvent;
import gameObjects.GameObject;
import gameObjects.GameObjectManager;
import gameObjects.ObjectType;
import gameObjects.Player;

public class KeyPressedHandler implements EventHandler {
	
	public KeyPressedHandler(){
	}
	
	public void handle( Event e) {
		KeyPressedEvent kpe = (KeyPressedEvent) e;
		Player player = (Player) GameObjectManager.gameObjects.get(0);

		if(kpe.left == true){
			player.velocity.x = player.moveSpeed*-1;
		}
		if(kpe.right == true){
			player.velocity.x = player.moveSpeed;
		}
		for( GameObject go : GameObjectManager.gameObjects ){
			if( go.type.equals(ObjectType.PLATFORM)){
				if( kpe.jump == true && player.mesh.intersects(go.mesh)){
					player.jump = -1;
					player.velocity.y = -player.jumpSpeed;
				}
			}
		}
	}

}
