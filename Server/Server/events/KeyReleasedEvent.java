package events;

public class KeyReleasedEvent extends Event {
	public boolean left, right, jump = false;

	public KeyReleasedEvent(boolean L, boolean R, boolean J){
		type = Events.KEYRELEASED;
		this.left = L;
		this.right = R;
		this.jump = J;
	}

}
