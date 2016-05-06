package scib.states;

import java.awt.Graphics2D;

import scib.enums.StateId;
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
	private static Game game = new Game();
	
	public GameStateManager(ObjectHandler handler){
		this.handler = handler;
	}

	/**
	 * Runs 60 times per second. Ticks the other states.
	 */
	public static void tick(){
		
		//Ticks the object handler.
		handler.tick();
		
		//Checks which is the current state and ticks that state.
		if(currentState == StateId.Menu){
			menu.tick();
		}else if(currentState == StateId.Game){
			game.tick();
		}
	}

	/**
	 * Renders the various states.
	 * 
	 * @param g
	 *        graphics object used in rendering.
	 */
	public static void render(Graphics2D g){
		
		//Renders the object handler.
		handler.render(g);
		
		//Checks which is the current state and renders that state.
		if(currentState == StateId.Menu){
			menu.render(g);
		}else if(currentState == StateId.Game){
			game.render(g);
		}
	}
}
