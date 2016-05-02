package scib.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import scib.graphics.Display;

/**
 * Main class of the program. Contains the main loop and the frame.
 * 
 * @author Scibby
 */
public class Main extends Canvas implements Runnable{

	/**
	 * Title of the game.
	 */
	public static final String TITLE = "Graveyard Run";

	/**
	 * Whether the game is running or not.
	 */
	private boolean running = false;

	/**
	 * Thread of the game.
	 */
	private Thread thread;

	/**
	 * Instance of the display.
	 */
	private Display disp;

	/**
	 * Initialisation. Runs once to initialise any variables or objects.
	 */
	private void init(){
		disp = new Display();
	}

	/**
	 * Runs 60 times a second. Is called by the run method.
	 */
	private void tick(){

	}

	/**
	 * Runs when the thread starts. Contains the game loop. The game loop forces
	 * the game to run at 60 times per second.
	 */
	public void run(){

		init();

		long initialNanoTime = System.nanoTime();
		double ticksPerSecond = 1000000000 / 60;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long milli = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - initialNanoTime) / ticksPerSecond;
			initialNanoTime = now;
			if(delta >= 1){
				tick();
				updates++;
				disp.render();
				frames++;
				delta--;
			}

			if(System.currentTimeMillis() - milli > 1000){
				milli += 1000;
				System.out.println(updates + " ticks, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
	}

	/**
	 * Starts the thread and the game loop.
	 */
	private synchronized void start(){
		if(running) return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Stops the thread and closes the game.
	 */
	private synchronized void stop(){
		if(!running) return;

		running = false;
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}

	/**
	 * Main method. Starts the game.
	 */
	public static void main(String[] args){
		Main main = new Main();

		main.start();
	}
}
