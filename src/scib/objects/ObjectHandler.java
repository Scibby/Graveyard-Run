package scib.objects;

import java.awt.Graphics2D;
import java.util.LinkedList;

/**
 * Used in handling various functions of objects. Adds, removes, ticks and renders all of the different objects.
 * 
 * @author Scibby
 */
public class ObjectHandler{

	/**
	 * List of all of the objects.
	 */
	public LinkedList<GameObject> objectList = new LinkedList<GameObject>();

	/**
	 * Runs 60 times every second ticks the other objects.
	 */
	public void tick(){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).tick(objectList);

		}
	}

	/**
	 * Starts the render method for the other objects.
	 * 
	 * @param g
	 *        Graphics object used to render objects onto the screen.
	 */
	public void render(Graphics2D g){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).render(g);
		}
	}

	/**
	 * Adds an object onto the screen.
	 * 
	 * @param object
	 *        object to add.
	 */
	public void addObject(GameObject object){
		this.objectList.add(object);
	}

	/**
	 * Removes an object from the screen.
	 * 
	 * @param object
	 *        object to remove.
	 */
	public void removeObject(GameObject object){
		this.objectList.remove(object);
	}

	/**
	 * Clears the entire level.
	 */
	public void clearLevel(){
		objectList.clear();
	}
}
