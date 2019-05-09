package events;

public class KeyReleasedEvent extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean left, right, shoot, record = false;

	public KeyReleasedEvent(boolean L, boolean R, boolean J, boolean Record){
		type = Events.KEYRELEASED;
		this.left = L;
		this.right = R;
		this.shoot = J;
		this.record = Record;
		this.priority = 2;
	}

}
