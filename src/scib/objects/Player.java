package scib.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import scib.enums.ObjectId;
import scib.util.ResourceLoader;

/**
 * Class responsible for the player.
 * 
 * @author Scibby
 */
public class Player extends GameObject{

	/**
	 * Gravity of the player, how fast he falls to the ground
	 */
	private final float GRAVITY = 1.25f;
	
	/**
	 * Max speed of the player
	 */
	private final float MAX_SPEED = 10;
	
	/**
	 * Creates the player.
	 * 
	 * @param x
	 *        x co-ordinate to spawn the player.
	 * @param y
	 *        y co-ordinate to spawn the player.
	 * @param width
	 *        width of the player.
	 * @param height
	 *        height of the player.
	 * @param id
	 *        id of the player.
	 * @param handler
	 *        used to interact with other objects.
	 */
	public Player(float x, float y, float width, float height, ObjectId id, ObjectHandler handler){
		super(x, y, width, height, id, handler);
		velX = 1;
	}

	/**
	 * Runs 60 times per second.
	 */
	public void tick(LinkedList<GameObject> objectList){
		
	}

	/**
	 * Renders objects onto the screen.
	 */
	public void render(Graphics2D g){
		
		g.setColor(Color.BLUE);
		g.draw(getBoundsTop());
		g.draw(getBoundsBottom());
		g.draw(getBoundsLeft());
		g.draw(getBoundsRight());
	}
}
