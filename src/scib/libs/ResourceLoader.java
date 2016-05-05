package scib.libs;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

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
	 * Location of the audio files.
	 */
	public final static String AUDIO_LOCATION = "/audio/";

	/**
	 * File extension of the audio files.
	 */
	public final static String AUDIO_ENDING = ".wav";

	/**
	 * Loads the image from the res folder.
	 * 
	 * @param name
	 *        name of the image used
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

	/**
	 * Loads the audio files from the res folder.
	 * 
	 * @param audioName
	 *        the name of the audio file.
	 * @return the audio file, in an {@link AudioInputStream} format.
	 */
	public AudioInputStream loadAudio(String audioName){
		AudioInputStream ais = null;
		try{
			ais = AudioSystem.getAudioInputStream(getClass().getResource(AUDIO_LOCATION + audioName + AUDIO_ENDING));
		}catch(Exception e){
			e.printStackTrace();
		}

		return ais;
	}
}
