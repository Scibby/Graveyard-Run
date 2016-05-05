package scib.main;

import java.awt.GraphicsEnvironment;

import scib.enums.StateId;
import scib.graphics.Display;
import scib.inputs.MouseInput;
import scib.libs.Fonts;
import scib.libs.ResourceLoader;
import scib.states.GameStateManager;

/**
 * Main class of the program. Contains the main loop and the frame.
 * 
 * @author Scibby
 * @version 3
 */
public class Main implements Runnable{

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
	 * Instance of the {@link ResourceLoader}
	 */
	private static ResourceLoader resLoader;

	/**
	 * Instance of the {@link GraphicsEnvironment}.
	 */
	private static GraphicsEnvironment ge;

	/**
	 * Instance of the {@link Display}.
	 */
	private static Display disp;

	/**
	 * Instance of the {@link GameStateManager}.
	 */
	private static GameStateManager gsm;

	/**
	 * Initialisation. Runs once to initialise any variables or objects used
	 * throughout the whole program.
	 */
	private void init(){

		MouseInput mouse = new MouseInput(); //An instance of the mouse input class.

		resLoader = new ResourceLoader(); //Initiates the resourceLoader.
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //Initiates the graphics environment.
		disp = new Display(); //Initiates the display.
		gsm = new GameStateManager(); //Initiates the game state manager.

		GameStateManager.currentState = StateId.Menu; //The state in the beginning.

		disp.addMouseListener(mouse); //Adds the listener for the mouse clicks.
		disp.addMouseMotionListener(mouse); //Adds the listener for the mouse movements.

		new Fonts("demolitionCrackShadow"); //Adds the font to the program.
	}

	/**
	 * Runs 60 times a second. Is called by the run method.
	 */
	private void tick(){
		gsm.tick(); //Ticks the game state manager.
	}

	/**
	 * Runs when the thread starts. Contains the game loop. The game loop forces
	 * the game to run at 60 times per second.
	 */
	public void run(){

		init();

		/**
		 * Forces the game to render and tick at 60 times per second.
		 */
		long initialNanoTime = System.nanoTime();
		double ticksPerSecond = 1000000000 / 60; //The number '60' is the amount of ticks per second.
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long milli = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - initialNanoTime) / ticksPerSecond;
			initialNanoTime = now;
			if(delta >= 1){
				tick(); //Tick method.
				updates++;
				disp.render(); //Render method.
				frames++;
				delta--;
			}

			if(System.currentTimeMillis() - milli > 1000){
				milli += 1000;
				updates = 0;
				frames = 0;
			}
		}
	}

	/**
	 * @return The instance of the {@link ResourceLoader} used.
	 */
	public static ResourceLoader getResLoader(){
		return resLoader;
	}

	/**
	 * @return The instance of the {@link GraphicsEnvironment} program.
	 */
	public static GraphicsEnvironment getGe(){
		return ge;
	}

	/**
	 * @return The instance of the {@link Display} used.
	 */
	public static Display getDisplay(){
		return disp;
	}

	public static GameStateManager getGsm(){
		return gsm;
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
