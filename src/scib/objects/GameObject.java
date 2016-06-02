package scib.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import scib.enums.ObjectId;

/**
 * @author Scibby
 */
public abstract class GameObject{

	/**
	 * The x co-ordinate of the object.
	 */
	protected float x;

	/**
	 * The y co-ordinate of the object.
	 */
	protected float y;

	/**
	 * The width of the object.
	 */
	protected float width;

	/**
	 * The height of the object.
	 */
	protected float height;

	/**
	 * The horizontal velocity of the object.
	 */
	protected float velX;

	/**
	 * The vertical velocity of the object.
	 */
	protected float velY;

	/**
	 * The id of the object
	 */
	protected ObjectId id;

	/**
	 * The object handler used throughout the class.
	 */
	protected ObjectHandler handler;

	/**
	 * Whether the object is falling or not.
	 */
	protected boolean falling = false;

	/**
	 * Whether the object is jumping or not.
	 */
	protected boolean jumping = false;

	/**
	 * Creates a game object. This is used in order to create all other game
	 * objects.
	 * 
	 * @param x
	 *        x co-ordinate to spawn the object.
	 * @param y
	 *        y co-ordinate to spawn the object.
	 * @param width
	 *        width of the object.
	 * @param height
	 *        height of the object.
	 * @param id
	 *        id of the object.
	 * @param handler
	 *        used to interact with other objects.
	 */
	public GameObject(float x, float y, float width, float height, ObjectId id, ObjectHandler handler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.handler = handler;
	}

	/**
	 * Runs 60 times a second. Contains the bulk of the code.
	 * 
	 * @param objectList
	 *        list of all the objects
	 */
	public abstract void tick(LinkedList<GameObject> objectList);

	/**
	 * Renders the graphics on the screen.
	 * 
	 * @param g
	 *        the graphics object used for rendering the object.
	 */
	public abstract void render(Graphics2D g);

	/**
	 * @return the rectangle of the whole object.
	 */
	public Rectangle getBounds(){
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	/**
	 * @return the top part of the object, used for collision.
	 */
	public Rectangle getBoundsTop(){
		return new Rectangle((int) x + 6, (int) y, (int) width - 12, 12);
	}

	/**
	 * @return the bottom part of the object, used for collision.
	 */
	public Rectangle getBoundsBottom(){
		return new Rectangle((int) x + 6, (int) ((int) y + (height - 12)), (int) width - 12, 12);
	}

	/**
	 * @return the left part of the object, used for collision.
	 */
	public Rectangle getBoundsLeft(){
		return new Rectangle((int) x, (int) y + 6, 6, (int) height - 12);
	}

	/**
	 * @return the right part of the object, used for collision.
	 */
	public Rectangle getBoundsRight(){
		return new Rectangle((int) ((int) x + (width - 6)), (int) y + 6, 6, (int) height - 12);
	}

	public float getX(){
		return x;
	}

	public void setX(float x){
		this.x = x;
	}

	public float getY(){
		return y;
	}

	public void setY(float y){
		this.y = y;
	}

	public float getWidth(){
		return width;
	}

	public void setWidth(float width){
		this.width = width;
	}

	public float getHeight(){
		return height;
	}

	public void setHeight(float height){
		this.height = height;
	}

	public ObjectId getId(){
		return id;
	}

	public float getVelX(){
		return velX;
	}

	public void setVelX(float velX){
		this.velX = velX;
	}

	public float getVelY(){
		return velY;
	}

	public void setVelY(float velY){
		this.velY = velY;
	}

	public boolean isFalling(){
		return falling;
	}

	public void setFalling(boolean falling){
		this.falling = falling;
	}

	public boolean isJumping(){
		return jumping;
	}

	public void setJumping(boolean jumping){
		this.jumping = jumping;
	}
}
