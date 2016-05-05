package scib.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import scib.enums.StateId;
import scib.framework.Button;
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

	/*
	 * Buttons on the menu.
	 */
	Button playButton = new Button("PLAY", Display.WIDTH / 2 - 100, 150, 300, 75, Color.WHITE, new Color(200, 30, 30));
	Button optionsButton = new Button("OPTIONS", Display.WIDTH / 2 - 100, 250, 300, 75, Color.WHITE, new Color(200, 30, 30));
	Button quitButton = new Button("QUIT", Display.WIDTH / 2 - 100, 350, 300, 75, Color.WHITE, new Color(200, 30, 30));
	
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
		
		//Font size changed for the buttons.
		menuFont = menuFont.deriveFont(Font.PLAIN, 28);
		
		//Sets the font to the smaller button font.
		g.setFont(menuFont);
		
		/**
		 * Renders the buttons onto the screen.
		 */
		playButton.drawButton(g);
		optionsButton.drawButton(g);
		quitButton.drawButton(g);
		
	}
}
