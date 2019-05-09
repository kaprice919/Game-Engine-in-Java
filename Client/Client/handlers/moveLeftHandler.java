package handlers;

import eventSystem.EventHandler;
import events.Event;
import gameObjects.GameObjectManager;
import scriptSystem.ScriptManager;

public class moveLeftHandler implements EventHandler {
	
	public void handle( Event e) {
		
		//run a script to win
		ScriptManager.loadScript("Scripts/moveLeft.js");
		ScriptManager.bindArgument("object", GameObjectManager.player);
		ScriptManager.executeScript();
		
	}
	

}
