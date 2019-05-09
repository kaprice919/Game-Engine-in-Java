package events;

public class MoveLeftEvent extends Event{
	
	public MoveLeftEvent(){
		this.type = Events.LEFT;
		this.priority = 1;
	}

}
