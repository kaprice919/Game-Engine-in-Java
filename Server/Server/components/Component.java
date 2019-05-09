package components;
import java.io.Serializable;
import java.util.LinkedList;

import gameObjects.*;

public interface Component extends Serializable {
	
	//for renderable
	public void update( GameObject object );
	
	//for collidable
	public void update( GameObject player, LinkedList<GameObject> gameObjects);
	

}
