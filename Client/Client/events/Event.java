package events;

import java.io.Serializable;
import java.util.UUID;

import timeline.Timeline;

public abstract class Event implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UUID UUID = java.util.UUID.randomUUID();

	public Events type;
	
	public transient int priority;
	public transient int timeStamp_FrameNumber;
	public transient int age;
	
	public Event(){
		timeStamp_FrameNumber = Timeline.getFrame();
		age = 0;
	}
	
}
