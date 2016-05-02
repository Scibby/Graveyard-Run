package scib.states;

import java.awt.Color;
import java.awt.Graphics2D;

import scib.enums.StateId;
import scib.graphics.Display;

/**
 * Class used in rendering the main menu at the beginning of the game.
 * 
 * @author Scibby
 */
public class Menu extends State{

	/**
	 * Creates the menu.
	 * 
	 * @param stateId
	 *        The stateId of the menu.
	 */
	public Menu(StateId stateId){
		super(stateId);
	}

	/**
	 * Renders the menu onto the screen.
	 * 
	 * @param g
	 *        Graphics object used in rendering the text.
	 */
	public void render(Graphics2D g){

		//Background colour.
		g.setColor(new Color(25, 25, 100));

		//Draws the solid colour background.
		g.fillRect(0, 0, (int) Display.WIDTH, (int) Display.HEIGHT);

	}
}
