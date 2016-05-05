package scib.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import scib.enums.StateId;
import scib.graphics.Display;
import scib.main.Main;

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

		//FontMetrics used in getting the size of the text.
		FontMetrics fm;

		//Background colour.
		g.setColor(new Color(10, 10, 100));

		//Draws the solid colour background.
		g.fillRect(0, 0, (int) Display.WIDTH, (int) Display.HEIGHT);

		//Font used in the menu. Size is set for the title.
		Font menuFont = new Font("Demolition Crack Shadow", Font.BOLD, 60);

		//FontMetrics is set for the font which is used in the title.
		fm = g.getFontMetrics(menuFont);

		//Sets the font for the title.
		g.setFont(menuFont);

		//Colour of the title.
		g.setColor(new Color(200, 30, 30));

		//Draws the title.
		g.drawString(Main.TITLE.toUpperCase(), ((Display.WIDTH / 2) - (fm.stringWidth(Main.TITLE.toUpperCase())) / 2) + 45, 100);

	}
}
