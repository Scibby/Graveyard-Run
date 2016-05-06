package scib.objects;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * 
 * @author Scibby
 */
public class ObjectHandler{

	/**
	 * List of all of the objects.
	 */
	public LinkedList<GameObject> objectList = new LinkedList<GameObject>();

	private GameObject object;

	/**
	 * Runs 60 times every second ticks the other objects.
	 */
	public void tick(){
		for(int i = 0; i < objectList.size(); i++){
			object = objectList.get(i);
			object.tick(objectList);
		}
	}

	/**
	 * Starts the render method for the other objects.
	 * 
	 * @param g
	 *        graphics object used to render objects onto the screen.
	 */
	public void render(Graphics g){
		for(int i = 0; i < objectList.size(); i++){
			object = objectList.get(i);
			object.render(g);
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
