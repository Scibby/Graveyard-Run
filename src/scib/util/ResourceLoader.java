package scib.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Used in loading various resources, eg. images.
 * 
 * @author Scibby
 */
public class ResourceLoader{

	/**
	 * Location of the images.
	 */
	public final static String IMAGE_LOCATION = "/images/";
	
	/**
	 * File extension of the images.
	 */
	public final static String IMAGE_ENDING = ".png";
	
	/**
	 * Location of the fonts.
	 */
	public final static String FONT_LOCATION = "/fonts/";
	
	/**
	 * File extension of the fonts.
	 */
	public final static String FONT_ENDING = ".ttf";
	
	/**
	 * Loads the image from the res folder.
	 * 
	 * @param path
	 *            path to the image used
	 * @return the image object
	 */
	public BufferedImage loadImage(String imageName){
		BufferedImage image = null;
		try{
			image = ImageIO.read(getClass().getResource(IMAGE_LOCATION + imageName + IMAGE_ENDING));
		}catch(IOException e){
			e.printStackTrace();
		}
		return image;
	}
}
