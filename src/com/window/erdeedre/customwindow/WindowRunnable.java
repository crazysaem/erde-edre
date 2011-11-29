package com.window.erdeedre.customwindow;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * WindowRunnable wraps the CustomWindow and Inits various things
 * @author Team5-Listener
 *
 */
public class WindowRunnable implements Runnable {
	//TODO: Implement transparency
	private boolean isTranslucencySupported;
	private CustomWindow sw = null;
	
	public WindowRunnable(String title, String imagePath) {
		init();		
		sw = new CustomWindow(title, imagePath);
	}
	
	private void init() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        isTranslucencySupported = gd.isWindowTranslucencySupported(TRANSLUCENT);        
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
