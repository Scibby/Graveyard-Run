package scib.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import scib.main.Main;
import scib.states.Game;
import scib.states.GameStateManager;
import scib.states.Menu;

/**
 * The window of the program. All render methods are called from this class.
 * 
 * @author Scibby
 */
public class Display extends Canvas{

	/**
	 * Dimensions of the window.
	 */
	private final static Dimension DIMENTION = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Minimum width of the game.
	 */
	public static final float MIN_WIDTH = 1280;

	/**
	 * Minimum height if the game.
	 */
	public static final float MIN_HEIGHT = 720;

	/**
	 * Width of the window. Get the maximum width of the user's monitor.
	 */
	public static final float WIDTH = (int) DIMENTION.getWidth();

	/**
	 * Height of the window. Get the maximum height of the user's monitor.
	 */
	public static final float HEIGHT = (int) DIMENTION.getHeight();

	/**
	 * Scale to use when scaling the window on different screens.
	 */
	public static final float SCALE = HEIGHT / MIN_HEIGHT;

	/**
	 * Creates the window.
	 */
	public Display(){
		JFrame frame = new JFrame(Main.TITLE);

		/*
		 * The size of the window.
		 */
		setPreferredSize(DIMENTION);
		setMaximumSize(DIMENTION);
		setMinimumSize(DIMENTION);

		/*
		 * Sets the properties of the frame.
		 */
		frame.add(this);
		frame.setUndecorated(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Renders objects onto the screen. Is called by the run method in the
	 * {@link Main} class.
	 */
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3); //'3' is the frames it can load in advance.
			return;
		}

		//Initiates the graphics object used in various other classes.
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		//Avoids flickering.
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (int) WIDTH, (int) HEIGHT);

		//Renders the game state manager.
		GameStateManager.render(g);

		// Clears the graphics object.
		g.dispose();

		//Shows the graphics.
		bs.show();
	}
}
