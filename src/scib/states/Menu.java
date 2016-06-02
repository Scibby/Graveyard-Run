package scib.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import scib.graphics.Display;
import scib.launchers.GameLauncher;
import scib.ui.Button;
import scib.util.ResourceLoader;

/**
 * Class used in rendering the main menu at the beginning of the game.
 * 
 * @author Scibby
 */
public class Menu extends State{

	/**
	 * Creates the menu state.
	 */
	public Menu(){
		
	}


	/*
	 * Buttons on the menu.
	 */
	public static Button playButton 		= new Button("PLAY",	 Display.WIDTH / 2 - 100, 175, 300, 75, Color.WHITE, new Color(200, 35, 35));
	public static Button optionsButton	 	= new Button("OPTIONS",	 Display.WIDTH / 2 - 100, 280, 300, 75, Color.WHITE, new Color(200, 35, 35));
	public static Button quitButton 		= new Button("QUIT",	 Display.WIDTH / 2 - 100, 385, 300, 75, Color.WHITE, new Color(200, 35, 35));

	//Background image used.
	private BufferedImage background = new ResourceLoader().loadImage("backgroundMenu");

	/**
	 * Runs 60 times per second.
	 */
	public void tick(){

	}

	/**
	 * Renders the menu onto the screen.
	 * 
	 * @param g
	 *        graphics object used in rendering the text.
	 */
	public void render(Graphics2D g){

		//Font to be used throughout the menu.
		Font menuFont;

		//Font metrics used in calculating the size of text.
		FontMetrics fm;

		//Background colour.
		g.setColor(new Color(10, 10, 100));

		//Draws the solid colour background.
		g.fillRect(0, 0, (int) Display.WIDTH, (int) Display.HEIGHT);

		//Background image.
		g.drawImage(background, 0, 50, (int) (background.getWidth() * 1.5), (int) Display.HEIGHT, null);

		//Font used for the title.
		menuFont = new Font("Demolition Crack Shadow", Font.BOLD, 60);

		//Font metrics set to the title font.
		fm = g.getFontMetrics(menuFont);

		//Sets the font for the title.
		g.setFont(menuFont);

		//Colour of the title.
		g.setColor(new Color(200, 35, 35));

		//Draws the title.
		g.drawString(GameLauncher.TITLE.toUpperCase(), ((Display.WIDTH / 2) - (fm.stringWidth(GameLauncher.TITLE.toUpperCase())) / 2) + 45, 100);

		//Changes the size of the font to be used for the buttons. 
		menuFont = menuFont.deriveFont(menuFont.getStyle(), 28);

		//Sets the font for the buttons.
		g.setFont(menuFont);

		/*
		 * Renders the buttons onto the screen.
		 */
		playButton.drawButton(g);
		optionsButton.drawButton(g);
		quitButton.drawButton(g);
	}
}
