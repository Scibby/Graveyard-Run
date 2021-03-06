package scib.launchers;

import scib.enums.StateId;
import scib.graphics.Display;
import scib.inputs.MouseInput;
import scib.objects.ObjectHandler;
import scib.states.GameStateManager;
import scib.util.Fonts;

public class GameLauncher implements Runnable{

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
	 * Instance of the {@link Display}.
	 */
	private static Display disp;

	/**
	 * Instance of the {@link ObjectHandler}.
	 */
	private ObjectHandler handler;

	/**
	 * Initialisation. Runs once to initialise any variables or objects used
	 * throughout the whole program.
	 */
	private void init(){

		MouseInput mouse = new MouseInput(); //An instance of the mouse input class.

		disp = new Display(); //Initiates the display.
		handler = new ObjectHandler(); //Initiates the object handler;

		GameStateManager.currentState = StateId.Menu; //The state in the beginning.

		disp.addMouseListener(mouse); //Adds the listener for the mouse clicks.
		disp.addMouseMotionListener(mouse); //Adds the listener for the mouse movements.

		new Fonts("demolitionCrackShadow"); //Adds the font to the program.
	}

	/**
	 * Runs 60 times a second. Is called by the run method.
	 */
	private void tick(){
		GameStateManager.tick(); //Ticks the game state manager.
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
	 * Main method. Starts the game.
	 */
	public static void main(String[] args){

		new GameLauncher().start();
		;
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
	@SuppressWarnings("unused")
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

}
