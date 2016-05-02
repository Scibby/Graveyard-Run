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
	public static StateId currentState;
	
	public State(StateId stateId){
		this.stateId = stateId;
	}
	
	public abstract void render(Graphics2D g);
}
