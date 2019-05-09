package networkSystem;
import java.io.*;


import gameObjects.GameObject;



public class ClientWriter {
	
	public static ObjectOutputStream oos;


	public static void write(GameObject go){
		
		try {
			oos.reset();
			oos.writeObject(go);
		} catch (IOException e) {
			;
		}
	
	}
	
	
}
