package events;

public class ReplayEvent extends Event{
	
	private static final long serialVersionUID = 1L;

	public ReplayEvent(){
		this.type = Events.REPLAY;
		this.priority = 1;
	}

}
