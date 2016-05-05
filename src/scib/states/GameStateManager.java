package scib.states;

import java.awt.Graphics2D;

import scib.enums.StateId;

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
	
	/**
	 * Instance of the {@link Menu}
	 */
	private Menu menu = new Menu();

	/**
	 * Instance of the {@link Game}
	 */
	private Game game = new Game();

	/**
	 * Runs 60 times per second. Ticks the other states.
	 */
	public void tick(){
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
	 *        Graphics object used in rendering.
	 */
	public void render(Graphics2D g){
		//Checks which is the current state and renders that state.
		if(currentState == StateId.Menu){
			menu.render(g);
		}else if(currentState == StateId.Game){
			game.render(g);
		}
	}
}
