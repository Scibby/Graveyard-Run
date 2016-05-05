package scib.states;

import java.awt.Color;
import java.awt.Graphics2D;

import scib.graphics.Display;

/**
 * Class used in rendering the actual game.
 * 
 * @author Scibby
 */
public class Game extends State{

	/**
	 * Starts the game state.
	 */
	public Game(){
	}

	/**
	 * Runs 60 times per second.
	 */
	public void tick(){
		
	}
	
	/**
	 * Renders the objects onto the screen.
	 */
	public void render(Graphics2D g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, (int) Display.WIDTH / 2, (int)  Display.HEIGHT / 2);
	}
}
