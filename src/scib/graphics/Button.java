package scib.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.sound.sampled.Clip;

import scib.inputs.MouseInput;
import scib.util.AudioPlayer;

public class Button extends Rectangle{

	/**
	 * Text which is being displayed in the button.
	 */
	private String text;

	/**
	 * Colour of the button.
	 */
	private Color colour;

	/**
	 * The colour to be used when the button is hovered over.
	 */
	private Color hoverColour;

	private boolean played = false;

	private AudioPlayer buttonSFX = new AudioPlayer("buttonAudio");

	/**
	 * Creates the button.
	 * 
	 * @param text
	 *        text to be displayed on the button.
	 * @param x
	 *        x co-ordinate of the button.
	 * @param y
	 *        y co-ordinate of the button.
	 * @param width
	 *        width of the button.
	 * @param height
	 *        height of the button.
	 * @param colour
	 *        colour of the button.
	 * @param hoverColour
	 *        colour of the button when it is hovered over.
	 */
	public Button(String text, float x, float y, float width, float height, Color colour, Color hoverColour){
		super((int) x, (int) y, (int) width, (int) height);
		this.text = text;
		this.colour = colour;
		this.hoverColour = hoverColour;
	}

	/**
	 * Renders the button and the text onto the screen.
	 * 
	 * @param g
	 *        graphics object used in rendering onto the screen.
	 */
	public void drawButton(Graphics2D g){

		//FontMetrics used in getting the dimensions of the text.
		FontMetrics fm = g.getFontMetrics(g.getFont());

		/*
		 * Checks if the mouse is intersecting the button.
		 */
		if(MouseInput.MOUSE.intersects(this)){
			g.setColor(hoverColour);
			if(!played){
				buttonSFX.play();
				played = true;
			}
		}else{
			g.setColor(colour);
			played = false;
		}

		//Sets the thickness of the rectangle to 3, rather than the default 1.
		g.setStroke(new BasicStroke(3));

		//Draws the rectangle.
		g.draw(this);

		//Draws the text of the button.
		g.drawString(text, x + width / 2 - (fm.stringWidth(text) / 2), y + height / 2 + 15);

		//Sets the thickness back to the default thickness.
		g.setStroke(new BasicStroke(1));
	}

	public String getText(){
		return text;
	}

	public void setText(String text){
		this.text = text;
	}

	public Color getColour(){
		return colour;
	}

	public void setColour(Color colour){
		this.colour = colour;
	}

	public Color getHoverColour(){
		return hoverColour;
	}

	public void setHoverColour(Color hoverColour){
		this.hoverColour = hoverColour;
	}
}
