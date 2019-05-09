package networkSystem;
import java.io.*;
import java.net.*;


//This thread will listen for clients and start new threads for each connection
public class ServerSocketCreator implements Runnable {
	
	private ServerSocket serverSocket = null;	
	
	public void run(){
		

		try {
			serverSocket = new ServerSocket( );
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), NetworkManager.SERVERPORTNUMBER ));
		} catch (UnknownHostException e2) {
			System.out.println("Server already running");
			System.exit(0);
		} catch (IOException e2) {
			System.out.println("Server already running");
			System.exit(0);
		}
		
		System.out.println("Server bound to 7777@localhost");
				
		while(true){
			
			
			//This is the blocking call, when hit this we will connect to a client on clientSocket and pass that into
			// a new thread for listening and stream creation
			try {
				if (Thread.interrupted()) {
			          serverSocket.close();
			          System.exit(0);
			        }
				System.out.println("Waiting for clients..");
				Socket clientSocket = serverSocket.accept();
				//Create a new thread when we accept a new client
				new Thread(new ServerWriterReader(clientSocket)).start();
				System.out.println("Client connected");
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					serverSocket.close();
					System.exit(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}
	
	
}


