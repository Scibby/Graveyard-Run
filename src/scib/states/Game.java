package scib.states;

import java.awt.Color;
import java.awt.Graphics2D;

import scib.enums.ObjectId;
import scib.graphics.Display;
import scib.objects.ObjectHandler;
import scib.objects.Player;

/**
 * Class used in rendering the actual game.
 * 
 * @author Scibby
 */
public class Game extends State{

	private ObjectHandler handler;

	/**
	 * Starts the game state.
	 * 
	 * @param handler
	 *        handler used to add or remove objects.
	 */
	public Game(ObjectHandler handler){
		this.handler = handler;
		handler.addObject(new Player(100, 100, 100, 100, ObjectId.Player, handler));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void tick(){

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void render(Graphics2D g){

	}

}
