package replaySystem;

import java.util.LinkedList;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import processing.core.PImage;

import timeline.Timeline;

import components.Component;

import eventSystem.EventManager;
import events.RecordEvent;
import events.ReplayEvent;
import gameObjects.GameObject;
import gameObjects.ObjectType;
import main.Client;

public class ReplayManager {
	
	public static boolean record, replay = false;
	
	
	public static ReplaySpeeds replaySpeed = ReplaySpeeds.REGULAR;
		
	public static LinkedList<ConcurrentHashMap<UUID, GameObject>> recordingList = new LinkedList<ConcurrentHashMap<UUID, GameObject>>();

	
	public static void handle(){
		if(record == true){
		
			EventManager.events.add(new RecordEvent());
		}
			
		
	}
	
	
	
	public static void replay(){
		if(ReplayManager.recordingList.isEmpty()){
			ReplayManager.replay = false;
			System.out.println("Replay finished");
			return;
		}
		
		if(replaySpeed.equals(ReplaySpeeds.REGULAR)){
			ConcurrentHashMap<UUID, GameObject> hm = ReplayManager.recordingList.pop();
			for(Entry<UUID, GameObject> g : hm.entrySet() ){
				GameObject go = g.getValue();
				render(go);
			}
		} else if(replaySpeed.equals(ReplaySpeeds.DOUBLESPEED)){
			
			ConcurrentHashMap<UUID, GameObject> hm = ReplayManager.recordingList.pop();
			for(Entry<UUID, GameObject> g : hm.entrySet() ){
				GameObject go = g.getValue();
				render(go);
			}
			
			if(ReplayManager.recordingList.isEmpty()){
				ReplayManager.replay = false;
				System.out.println("Replay finished");
				return;
			}
			
			hm = ReplayManager.recordingList.pop();
			for(Entry<UUID, GameObject> g : hm.entrySet() ){
				GameObject go = g.getValue();
				render(go);
			}
			
			
		}else if(replaySpeed.equals(ReplaySpeeds.HALFSPEED)){
				ConcurrentHashMap<UUID, GameObject> hm = ReplayManager.recordingList.pop();
				for(Entry<UUID, GameObject> g : hm.entrySet() ){
					GameObject go = g.getValue();
					render(go);
				}
			
		}
	}
	
	public static void render(GameObject go){
		
		for( Component c : go.components ){
			c.update(go);
		}
	}

}
