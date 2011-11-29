package com.window.erdeedre.audio;

import java.awt.Frame;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;

/**
 * Audio Helper Class
 * @author (C) Oracle/SUN; modified by Team5-Listener
 *
 */
public class AudioHelper {
	private boolean running=false, stopPlayAudio=false, isPlayingAudio=false;
	private ByteArrayOutputStream out;
	private final AudioFormat format;
	private TargetDataLine line;
	private byte[][] frames;
	private int frameSize;
	private boolean isReversed=false;
	private static boolean linefail=false;

	public AudioHelper() {
		format = getFormat();
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);			
		try {
			line = (TargetDataLine)AudioSystem.getLine(info);
			line.open(format);
			line.start();
		} catch (LineUnavailableException e) {
			System.err.println("Line unavailable: " + e);
			if(!linefail) {
				JOptionPane.showMessageDialog(new Frame(), "We are sorry but no Line In Signal is found. Speech Output is now not supoorted.");
			}
			linefail=true;
			//System.exit(-2);
		}catch(IllegalArgumentException e){
			System.err.println("No Line found: "+ e);
			if(!linefail) {
				JOptionPane.showMessageDialog(new Frame(), "We are sorry but no Line In Signal is found. Speech Output is now not supoorted.");
			}
			linefail=true;
			//System.exit(-2);		
		}		
	}
	
	public void togglePlayAudio() {
		if((!isPlayingAudio) && (!running)) {
			this.playReverseAudio();
		} else {
			stopPlayAudio=true;
		}
	}

	public void startCaptureAudio() {
		isPlayingAudio=false;
		isReversed=false;
		stopPlayAudio=true;
		stopCaptureAudio();	
		if(out!=null) {
			out.reset();
		}

			
		Runnable runner = new Runnable() {
			int bufferSize = (int)format.getSampleRate() * format.getFrameSize();
			byte buffer[] = new byte[bufferSize];
		 
			public void run() {
				out = new ByteArrayOutputStream();
				running = true;
				try {
					while (running) {
						int count = line.read(buffer, 0, buffer.length);
						if (count > 0) {
							out.write(buffer, 0, count);
						}
					}
					out.close();

					} catch (IOException e) {
					System.err.println("I/O problems: " + e);
					System.exit(-1);
				}
			}
		};
		Thread captureThread = new Thread(runner);
		captureThread.start();		
	}
	
	public void stopCaptureAudio() {
		running = false;
	}
	public void releaseAudio(){
		if(!linefail) {
			line.close();
		}
	}
	public void playAudio(float speed) {
		isPlayingAudio=true;
		try {
			byte audio[] = out.toByteArray();
			InputStream input = new ByteArrayInputStream(audio);
			final AudioFormat format = getFormat(speed);
			final AudioInputStream ais = new AudioInputStream(input, format, audio.length / format.getFrameSize());
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			final SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
			line.open(format);
			line.start();

			Runnable runner = new Runnable() {
				int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
				byte buffer[] = new byte[bufferSize];
	 
				public void run() {
					try {
						int count;
						while (((count = ais.read(buffer, 0, buffer.length)) != -1) && (isPlayingAudio)) {
							if (count > 0) {
								System.out.println(buffer.length);
								line.write(buffer, 0, count);
							}
							if(stopPlayAudio) break;
						}
						line.drain();
						line.close();
						isPlayingAudio=false;
					} catch (IOException e) {
						System.err.println("I/O problems: " + e);
						System.exit(-3);
					}
				}
			};
			stopPlayAudio=false;
			Thread playThread = new Thread(runner);
			playThread.start();
		} catch (LineUnavailableException e) {
			System.err.println("Line unavailable: " + e);
			System.exit(-4);
		}		
	}
	
	public void playAudio() {
		playAudio(1f);
	}
	
	public void playReverseAudio() {
		isPlayingAudio=true;
		try {
			byte audio[] = out.toByteArray();
			InputStream input = new ByteArrayInputStream(audio);
			final AudioFormat format = getFormat();
			final AudioInputStream ais = new AudioInputStream(input, format, audio.length / format.getFrameSize());
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			final SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
			line.open(format);
			line.start();

			Runnable runner = new Runnable() {
	 
				public void run() {
					try {
						if(!isReversed) {getFramesFromAudioInputStream(ais);}
						for(int i=frames.length-1;i>=0;i--) {
							line.write(frames[i], 0, frameSize);
							if(stopPlayAudio) break;
						}						
						line.drain();
						line.close();
						isPlayingAudio=false;
						stopPlayAudio=false;
					} catch (IOException e) {
						System.err.println("I/O problems: " + e);
						System.exit(-3);
					}
				}
			};
			stopPlayAudio=false;
			Thread playThread = new Thread(runner);
			playThread.start();
		} catch (LineUnavailableException e) {
			System.err.println("Line unavailable: " + e);
			System.exit(-4);
		} 		
	}
	
	public boolean isPlayingAudio() {
		return isPlayingAudio;
	}
	
	private void getFramesFromAudioInputStream(AudioInputStream stream) throws IOException {
		isReversed=true;
        frameSize = stream.getFormat().getFrameSize();
        frames = new byte[stream.available() / frameSize][frameSize];
        int i = 0;
        for (; i < frames.length; i++)
        {
            byte[] frame = new byte[frameSize];
            int numBytes = stream.read(frame, 0, frameSize);
            if (numBytes == -1)
            {
                break;
            }
            frames[i] = frame;
        }
    }
	
	public void stopPlayAudio() {
		stopPlayAudio = false;
	}
	
	/**
	 * 
	 * @param speed in percent (1 = 100%, 0.5 = 50%..)
	 * @return AudioFormat
	 */	
	private AudioFormat getFormat(float speed) {
		float sampleRate = 48000*speed;
		int sampleSizeInBits = 8;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = true;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}

	private AudioFormat getFormat() {
		return getFormat(1);
	}
	
	
}
