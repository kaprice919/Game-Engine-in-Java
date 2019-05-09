package timeline;

final public class Timeline {
	
	//Typically FPS
	public final static int TICKSIZE = 60;
	
	public static int frameNumber;
	
	public static long gameStartTimeMillis;
	public static long gameCurrentTimeMillis;
	
	public static long gameCurrentTimeSec;

	
	public static int getFrame(){
		return frameNumber;
	}
	
	
	public static void update(){
		frameNumber++;
		
		
	}
	
	public static void init(){
		gameStartTimeMillis = System.currentTimeMillis();
	}
	
	
	public static int getCurrentTick(){
		return frameNumber / TICKSIZE;
	}
	
	
	public static long getCurrentTimeSec(){
		
		gameCurrentTimeMillis = System.currentTimeMillis();
		gameCurrentTimeMillis -= gameStartTimeMillis;
		gameCurrentTimeSec = gameCurrentTimeMillis / 1000;
		return gameCurrentTimeSec;

	}
	
	public static long getCurrentTimeMillis(){
		
		gameCurrentTimeMillis = System.currentTimeMillis();
		gameCurrentTimeMillis -= gameStartTimeMillis;
		return gameCurrentTimeMillis;
		
		
	}
	
	
}
