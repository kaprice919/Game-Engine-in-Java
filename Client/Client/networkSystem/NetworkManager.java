package networkSystem;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;



import gameObjects.GameObject;


final public class NetworkManager {
	
	static int SERVERPORTNUMBER = 7777;
	static Socket socket = null;
		
	private NetworkManager(){
	}
	
	public static void init(){
		
		try {
			//Create a socket for the client at IP 7777
			socket = new Socket(InetAddress.getLocalHost(), 7777);

		} catch (UnknownHostException e) {
			System.out.println("Could not connect to Server.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Could not connect to Server.");
			System.exit(0);
		}
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		ClientReader.ois = ois;
		ClientWriter.oos = oos;
		(new Thread(new ClientReader())).start();
	}
	
	public static void write(GameObject go){
		ClientWriter.write(go);
	}

}
