package com.window.erdeedre.customwindow;

import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * WindowRunnable wraps the CustomWindow and Inits various things
 * @author Samuel Schneider
 *
 */
public class WindowRunnable implements Runnable {
	//TODO: Implement transparency
	private String title;
	private boolean isTranslucencySupported;
	private boolean isWindowTranslucencySupported;
	private int width, height;
	private String imagePath;
	private CustomWindow sw = null;
	
	public WindowRunnable(String title, String imagePath) {
		this.title = title;
		this.imagePath = imagePath;
		
		init();		
		sw = new CustomWindow(title, imagePath);
	}
	
	private void init() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        isTranslucencySupported = gd.isWindowTranslucencySupported(TRANSLUCENT);        
        isWindowTranslucencySupported = gd.isWindowTranslucencySupported(PERPIXEL_TRANSPARENT);
	}
	
	public CustomWindow getWindow() {
		return sw;
	}

	@Override
	public void run() {

        if (isTranslucencySupported) {
            sw.setOpacity(1f);
        }

        // Display the window.
        sw.setVisible(true);
	}

}
