package handlers;


import eventSystem.EventHandler;
import events.Event;
import events.KeyPressedEvent;
import gameObjects.GameObjectManager;
import gameObjects.Player;
import replaySystem.ReplayManager;
import replaySystem.ReplaySpeeds;

public class KeyPressedHandler implements EventHandler {
	
	public KeyPressedHandler(){
	}
	
	public void handle( Event e) {
		KeyPressedEvent kpe = (KeyPressedEvent) e;
		Player player = (Player) GameObjectManager.gameObjects.get(GameObjectManager.player.UUID);

		if(kpe.record == true){
			ReplayManager.record = true;
			System.out.println("Recording");

		}
		
		if(kpe.doubleSpeed == true){
			ReplayManager.replaySpeed = ReplaySpeeds.DOUBLESPEED;
			System.out.println("Double replay speed");

		}
		
		if(kpe.regularSpeed == true){
			ReplayManager.replaySpeed = ReplaySpeeds.REGULAR;
			System.out.println("Regular replay speed");

		}
		
		if(kpe.terminate == true){
			ReplayManager.record = false;
			System.out.println("Ended recording");
		}
		
		if(kpe.playReplay == true){
			ReplayManager.replay = true;
			System.out.println("Playing replay");
		}
		
		if(kpe.halfSpeed == true){
			ReplayManager.replaySpeed = ReplaySpeeds.HALFSPEED;
			System.out.println("Half replay speed");

		}
		if(kpe.left == true){
			player.velocity.x = player.moveSpeed*-1;
		}
		if(kpe.right == true){
			player.velocity.x = player.moveSpeed;
		}

	}

}
