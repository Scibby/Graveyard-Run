package scib.inputs;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import scib.enums.StateId;
import scib.states.GameStateManager;
import scib.states.Menu;

/**
 * Class used in mouse inputs such as moving the mouse or clicking.
 * 
 * @author Scibby
 */
public class MouseInput implements MouseInputListener{

	/**
	 * Rectangle representing the location of the mouse.
	 */
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);

	/**
	 * When the mouse is clicked.
	 */
	public void mouseClicked(MouseEvent e){
		int buttonClicked = e.getButton();
		
		if(buttonClicked == MouseEvent.BUTTON1){ //If left click was pressed.
			if(GameStateManager.currentState == StateId.Menu){ //If the menu is the current state.
				if(MOUSE.intersects(Menu.playButton)){ //When the play button is pressed.
					GameStateManager.currentState = StateId.Game; //Changes the state from the menu to the game.
				}else if(MOUSE.intersects(Menu.quitButton)){ //When the quit button is pressed.
					System.exit(1); //Ends the program.
				}
			}
		}
	}

	/**
	 * When the mouse is moved.
	 */
	public void mouseMoved(MouseEvent e){
		//Changes the location of the MOUSE rectangle to follow the mouse.
		MOUSE.setLocation(e.getX(), e.getY());
	}

	public void mouseEntered(MouseEvent e){

	}

	public void mouseExited(MouseEvent e){

	}

	public void mousePressed(MouseEvent e){

	}

	public void mouseReleased(MouseEvent e){

	}

	public void mouseDragged(MouseEvent e){

	}
}