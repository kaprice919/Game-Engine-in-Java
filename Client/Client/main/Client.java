package main;

import eventSystem.EventHandlerThread;
import eventSystem.EventManager;
import events.KeyReleasedEvent;
import events.PlayerShootEvent;
import events.MoveLeftEvent;
import events.KeyPressedEvent;
import gameObjects.*;
import networkSystem.NetworkManager;
import processing.core.*;
import replaySystem.ReplayManager;
import replaySystem.ReplaySpeeds;
import timeline.Timeline;

/**
 * 
 * @author Kevin Price
 * 
 *         Background image used from:
 * 
 *         http://www.spyderonlines.com/image-html.php?pic=/images/wallpapers/
 *         game-background-images/game-background-images-10.jpg
 *
 */

public class Client extends PApplet {

	PImage background;
	PImage replay;
	public static PImage win;
	public static PApplet screen;



	public void settings() {

		size(650, 700);
		background = loadImage("650x700.jpg");
		replay = loadImage("Replay.jpg");
		

	}

	public void setup() {
		
		screen = this;
		
		EventManager.init();
		GameObjectManager.init(this);
		NetworkManager.init();
		Timeline.init();

	}

	public void draw() {
		
		//ScriptManager.loadScript("Scripts/hello_world.js");

		if(ReplayManager.replay == true){
			
			if(ReplayManager.replaySpeed.equals(ReplaySpeeds.HALFSPEED)){
				if(Timeline.frameNumber % 2 == 0){
					background( background );
					image( replay, this.width - replay.width, 0 + replay.height);
					ReplayManager.replay();
				}
			}else{
				background( background );
				image( replay, this.width - replay.width, 0 + replay.height);
				ReplayManager.replay();
			}
			
			
			
			Timeline.update();

						
		}else{
			background(background);
		
			GameObjectManager.draw();
				
			Timeline.update();
		
			EventHandlerThread.handle();	
		
			ReplayManager.handle();
			
			GameObjectManager.handleShots();
			
			GameObjectManager.didWin();

		}
		
		
	}

	
	//HID
	public void keyPressed() {

		switch (this.keyCode) {

		case LEFT:
			//EventManager.events.add(new KeyPressedEvent(true, false, false, false, false, false, false, false, false));
			EventManager.events.add(new MoveLeftEvent());
			break;

		case RIGHT:
			EventManager.events.add(new KeyPressedEvent(false, true, false, false, false, false, false, false, false));
			break;

		case ' ':
			EventManager.events.add(new PlayerShootEvent(GameObjectManager.player));
			break;
		}
		
		switch (this.key) {
		
		case 'r':
			EventManager.events.add(new KeyPressedEvent(false, false, false, true, false, false, false, false, false));
			break;
			
		case 'p':
			EventManager.events.add(new KeyPressedEvent(false, false, false, false, true, false, false, false, false));
			break;

		case 't':
			EventManager.events.add(new KeyPressedEvent(false, false, false, false, false, true, false, false, false));
			break;
			
		case 'o':
			EventManager.events.add(new KeyPressedEvent(false, false, false, false, false, false, true, false, false));
			break;
			
		case 'i':
			EventManager.events.add(new KeyPressedEvent(false, false, false, false, false, false, false, false, true));
			break;
			
		case 'u':
			EventManager.events.add(new KeyPressedEvent(false, false, false, false, false, false, false, true, false));
			break;
		}

	}
	
	//HID
	public void keyReleased() {

		switch (this.keyCode) {

		case LEFT:
			EventManager.events.add(new KeyReleasedEvent(true, false, false, false));
			break;

		case RIGHT:
			EventManager.events.add(new KeyReleasedEvent(false, true, false, false));
			break;
			
		}
		
		switch (this.key) {
		
		case 114:
			EventManager.events.add(new KeyReleasedEvent(false,false,false,true));
			break;


		}

	}

	public static void main(String[] args) {

		PApplet.main("main.Client");

	}

}
