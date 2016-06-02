package scib.states;

import java.awt.Graphics2D;

import scib.enums.StateId;

/**
 * Abstract class for the various states in the game. Eg. Menu, Pause, Game.
 * 
 * @author Scibby
 */
public abstract class State{

	protected StateId stateId;

	public State(){
	}

	/**
	 * Runs 60 times per second.
	 */
	public abstract void tick();

	/**
	 * Renders the various objects onto the screen.
	 * 
	 * @param g
	 *        graphics object used in rendering.
	 */
	public abstract void render(Graphics2D g);
}
