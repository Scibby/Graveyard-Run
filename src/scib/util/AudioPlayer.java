package scib.util;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Scibby
 */
public class AudioPlayer{

	/**
	 * Instance of the {@link ResourceLoader}.
	 */
	private ResourceLoader resLoader = new ResourceLoader();

	/**
	 * Audio clip which is being played.
	 */
	private Clip clip;

	/**
	 * Plays an audio file.
	 * 
	 * @param fileName
	 *        name of the audio file to be played.
	 */
	public AudioPlayer(String fileName){
		try{
			AudioInputStream ais = resLoader.loadAudio(fileName);

			AudioFormat baseFormat = ais.getFormat(); //The undecoded format.
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false); //The decoded format.
			AudioInputStream dias = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dias); //Sets the 'clip' to the audio file given.
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Starts the audio file.
	 */
	public void play(){
		if(clip == null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}

	/**
	 * Stops the audio file.
	 */
	public void stop(){
		if(clip.isRunning()) clip.stop();
	}

	/**
	 * Closes the audio file.
	 */
	public void close(){
		stop();
		clip.close();
	}
}
