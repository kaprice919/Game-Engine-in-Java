package events;

public class KeyPressedEvent extends Event {
	public boolean left, right, jump = false;
	
	
	public KeyPressedEvent(boolean L, boolean R, boolean J){
		type = Events.KEYPRESSED;
		this.left = L;
		this.right = R;
		this.jump = J;
	}
}
