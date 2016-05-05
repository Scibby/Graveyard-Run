package scib.libs;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import scib.main.Main;

/**
 * The class responsible for the creation of custom fonts.
 * 
 * @author Scibby
 */
public class Fonts{

	/**
	 * File name of the font being registered.
	 */
	private String fileLocation;

	/**
	 * Creates the font. The fileName variable is given the prefix and the
	 * suffix of the complete file location.
	 * 
	 * @param fileName
	 *        Name of the font.
	 */
	public Fonts(String fileName){
		this.fileLocation = ResourceLoader.FONT_LOCATION + fileName + ResourceLoader.FONT_ENDING;
		registerFont();
	}

	/**
	 * Registers the font onto the {@link GraphicsEnvironment}.
	 */
	public void registerFont(){
		GraphicsEnvironment ge = Main.getGe();
		try{
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(fileLocation)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}