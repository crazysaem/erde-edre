package com.window.erdeedre;

import com.window.erdeedre.customwindow.WindowRunnable;

/**
 * Main Entry into the Program
 * @author Samuel Schneider
 * 
 *
 */
public class _main {
	public static void main(String[] args) {
		boolean showSplashScreen=true;
		
		if(showSplashScreen) {
			//Create Window, Set Title, Set Shape
			WindowRunnable splashScreen = new WindowRunnable("Erde-Edre Übersetzer", "src/resources/images/windowlogo_shape.png");
			//Set Window Background
			splashScreen.getWindow().SetBackgroundImage("src/resources/images/windowlogo.png");
			//Show the Window
			splashScreen.run();    
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			splashScreen.getWindow().setEnabled(false);
			splashScreen.getWindow().setFocusable(false);
			splashScreen.getWindow().setVisible(false);
		}
		
		//Create Window, Set Title, Set Shape
		WindowRunnable mainWindow = new WindowRunnable("Erde-Edre Übersetzer", "src/resources/images/player2_shape.png");
		//Init Main Window
		mainWindow.getWindow().initMainWindow();
		//Set Window Background
		mainWindow.getWindow().SetBackgroundImage("src/resources/images/player2.png");		
    	//Show the Window
		mainWindow.run();    	
    }
}