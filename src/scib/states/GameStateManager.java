package scib.states;

import java.awt.Graphics2D;

import scib.enums.StateId;
import scib.graphics.Display;
import scib.main.Main;
import scib.objects.ObjectHandler;

/**
 * This class manages the various States.
 * 
 * @author Scibby
 */
public class GameStateManager{

	/**
	 * The current state.
	 */
	public static StateId currentState;

	private static ObjectHandler handler;

	/**
	 * Instance of the {@link Menu}
	 */
	private static Menu menu = new Menu();

	/**
	 * Instance of the {@link Game}
	 */
	private static Game game;

	public GameStateManager(ObjectHandler handler){
		this.handler = handler;

		game = new Game(handler);
	}

	/**
	 * Runs 60 times per second. Ticks the other states.
	 */
	public static void tick(){

		//Checks which is the current state and ticks that state.
		if(currentState == StateId.Menu){
			menu.tick();
		}else if(currentState == StateId.Game){
			game.tick();

			//Ticks the object handler.
			handler.tick();
		}
	}

	/**
	 * Renders the various states.
	 * 
	 * @param g
	 *        graphics object used in rendering.
	 */
	public static void render(Graphics2D g){

		//Checks which is the current state and renders that state.
		if(currentState == StateId.Menu){
			menu.render(g);
		}else if(currentState == StateId.Game){
			g.scale(Display.SCALE, Display.SCALE);
			game.render(g);

			//Renders the object handler.
			handler.render(g);
			g.scale(1, 1);
		}
	}
}
