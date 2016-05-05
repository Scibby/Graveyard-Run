package scib.inputs;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

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

	public void mouseClicked(MouseEvent e){

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

	/**
	 * When the mouse is moved.
	 */
	public void mouseMoved(MouseEvent e){
		//Changes the location of the MOUSE rectangle to follow the mouse.
		MOUSE.setLocation(e.getX(), e.getY());
	}

}