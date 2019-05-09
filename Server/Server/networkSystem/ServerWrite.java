package networkSystem;



import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import gameObjects.GameObject;

public class ServerWrite {
		
	
	public static synchronized  void write(ConcurrentHashMap<UUID, GameObject> objects){

			
				
				try {
					//For every client, send the given hashmap
					for( Entry<ObjectOutputStream, ObjectOutputStream> os : NetworkManager.outputStreams.entrySet()){
						ObjectOutputStream oos = os.getValue();
						oos.reset();
						oos.writeObject(objects);
						oos.flush();

					}
			
				} catch (IOException e) {
					;
				} 
				

			
		
	}

}
