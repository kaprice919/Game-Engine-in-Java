package events;

public class KeyPressedEvent extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean left, right, shoot, record, playReplay, terminate, halfSpeed,regularSpeed,doubleSpeed = false;
	
	
	public KeyPressedEvent(boolean L, boolean R, boolean J, boolean record, boolean playReplay,
			boolean terminate, boolean halfSpeed, boolean regularSpeed, boolean doubleSpeed){
		type = Events.KEYPRESSED;
		this.left = L;
		this.right = R;
		this.shoot = J;
		this.record = record;
		this.priority = 2;
		this.playReplay = playReplay;
		this.terminate = terminate;
		this.halfSpeed = halfSpeed;
		this.doubleSpeed = doubleSpeed;
		this.regularSpeed = regularSpeed;
	}
}
