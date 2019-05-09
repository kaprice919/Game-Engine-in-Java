package components;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import gameObjects.*;

public interface Component extends Serializable {
	
	//for renderable
	public void update( GameObject object );
	
	//for collidable
	public void update( GameObject player, ConcurrentHashMap<UUID, GameObject> gameObjects);
	

}
