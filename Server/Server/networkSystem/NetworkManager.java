package networkSystem;
import gameObjects.*;

import java.io.ObjectOutputStream;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


public final class NetworkManager {
	
	public static ConcurrentHashMap<UUID, GameObject> objects = new ConcurrentHashMap<UUID, GameObject>();
	public static ConcurrentHashMap<UUID, GameObject> scene = new ConcurrentHashMap<UUID, GameObject>();
	public static ConcurrentHashMap<ObjectOutputStream, ObjectOutputStream> outputStreams = new ConcurrentHashMap<ObjectOutputStream, ObjectOutputStream>();

	public static final int SERVERPORTNUMBER = 7777;
	public static int clients = 1;
		


	private NetworkManager(){
	}
	
	public static void init(){
		
		Platform platform1 = new Platform(null, 10000, 10, -1000, 650, 0, 0, 0);





		MovingPlatform mp = new MovingPlatform(null, 50, 30, 0, 300, 255, 255, 255, 0, 100);
		MovingPlatform mp1 = new MovingPlatform(null, 50, 30, 100, 300, 255, 255, 255, 100, 200);
		MovingPlatform mp2 = new MovingPlatform(null, 50, 30, 200, 300, 255, 255, 255, 200, 300);
		MovingPlatform mp3 = new MovingPlatform(null, 50, 30, 300, 300, 255, 255, 255, 300, 400);
		MovingPlatform mp4 = new MovingPlatform(null, 50, 30, 400, 300, 255, 255, 255, 400, 500);
		
		SpawnPoint spawnPoint1 = new SpawnPoint(300, platform1.position.y - 10);

		scene.put(platform1.UUID, platform1);

		scene.put(spawnPoint1.UUID, spawnPoint1);
		
		objects.put(mp.UUID, mp);
		objects.put(mp1.UUID, mp1);
		objects.put(mp2.UUID, mp2);
		objects.put(mp3.UUID, mp3);
		objects.put(mp4.UUID, mp4);
		
		new Thread(new ServerSocketCreator()).start();
	}
	
	public synchronized void write(){
		
	}
	
	public static void handleMoveable(){
		int tick = 0;
		boolean down = false;

		while(true){
			if(tick++ % 10000 == 0){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Entry<UUID, GameObject> g : NetworkManager.objects.entrySet()){
					GameObject go = g.getValue();
					if(go.type.equals(ObjectType.MOVINGPLATFORM)){
						
						MovingPlatform mp = (MovingPlatform) go;
						if(mp.dead.equals("false")){
						if(go.position.x == mp.bounds1 )
							down = true;
						if(go.position.x == mp.bounds2 ){
							down = false;
						}
					
						if(down == true){
							go.position.x++;
							go.mesh.x++;
							ServerWrite.write(NetworkManager.objects);

						}else{
							go.position.x--;
							go.mesh.x--;	
							ServerWrite.write(NetworkManager.objects);
						}
					}else{
						NetworkManager.objects.remove(go.UUID);
					}
					}
				}
			}
		}
	}
	
}
