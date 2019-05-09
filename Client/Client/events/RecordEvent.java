package events;

public class RecordEvent extends Event{

	private static final long serialVersionUID = 1L;
	
	public RecordEvent() {
		this.type = Events.RECORD;
		this.priority = 4;
	}

}
