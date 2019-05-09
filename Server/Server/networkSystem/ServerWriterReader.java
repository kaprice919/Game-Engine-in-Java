package networkSystem;
import gameObjects.GameObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


//This thread will handle the socket logic
public class ServerWriterReader  implements Runnable  {
		
		private Socket socket = null;
		
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		GameObject go;
		
		public ServerWriterReader(Socket socket){
			this.socket = socket;
		}
				
		public void run(){
			
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				System.out.println("Cant open stream with Client");
				return;
			}
			
			try {
				ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				System.out.println("Cant open stream with Client");
				return;
			}
			
			NetworkManager.outputStreams.put(oos, oos);

			init();

			
			
			
			while(true){
				
				try {
					go = (GameObject) ois.readObject();
					if(NetworkManager.objects.containsKey(go.UUID))
						NetworkManager.objects.replace(go.UUID, go);
					else
						NetworkManager.objects.put(go.UUID, go);
		
				} catch (ClassNotFoundException e) {
					;
				} catch (IOException e) {
					NetworkManager.outputStreams.remove(oos);
					
				}finally{
					ServerWrite.write(NetworkManager.objects);
				}
			}
		}

		
		public void init(){

			ServerWrite.write(NetworkManager.scene);
		}
		
	}