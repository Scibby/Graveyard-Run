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

		if(GameStateManager.currentState == StateId.Menu){
			if(buttonClicked == MouseEvent.BUTTON1){
				if(MOUSE.intersects(Menu.playButton)){
					GameStateManager.currentState = StateId.Game;
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