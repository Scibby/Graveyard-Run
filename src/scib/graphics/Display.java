package scib.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import scib.main.Main;

public class Display extends Canvas{

	/**
	 * Dimensions of the window.
	 */
	private final static Dimension DIMENTION = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Minimum width of the game.
	 */
	public static final int MIN_WIDTH = 1280;

	/**
	 * Minimum height if the game.
	 */
	public static final int MIN_HEIGHT = 720;

	/**
	 * Width of the window. Get the maximum width of the user's monitor.
	 */
	public static final int WIDTH = (int) DIMENTION.getWidth();

	/**
	 * Height of the window. Get the maximum height of the user's monitor.
	 */
	public static final int HEIGHT = (int) DIMENTION.getWidth();

	/**
	 * Scale to use when scaling the window on different screens.
	 */
	public static final float SCALE = WIDTH / MIN_WIDTH;
	
	/**
	 * Creates the window.
	 */
	public Display(){
		JFrame frame = new JFrame(Main.TITLE);

		setPreferredSize(DIMENTION);
		setMaximumSize(DIMENTION);
		setMinimumSize(DIMENTION);

		frame.add(this);
		frame.setUndecorated(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Renders objects onto the screen. 
	 * Is called by the run method in the {@link Main} class.
	 */
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.dispose();
		bs.show();
	}
}
