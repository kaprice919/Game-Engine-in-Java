package handlers;

import eventSystem.EventHandler;
import events.Event;
import events.GravityEvent;

public class GravityHandler implements EventHandler {

	public void handle( Event e) {
		GravityEvent ge = (GravityEvent) e;
		ge.player.velocity.y += ge.player.gravity;
	}
}
