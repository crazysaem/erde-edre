package com.window.erdeedre.skins;

import com.window.erdeedre.customwindow.WindowRunnable;

public class SkinChooser {
	
	private WindowRunnable mainWindow;
	
	public SkinChooser(int id, boolean showSplashScreen) {
		WindowRunnable splashScreen = null;
		if(showSplashScreen) {
			//Create Window, Set Title, Set Shape
			splashScreen = new WindowRunnable("Erde-Edre Übersetzer", "src/resources/images/windowlogo_shape.png");
			//Set Window Background
			splashScreen.getWindow().SetBackgroundImage("src/resources/images/windowlogo.png");
			//Show the Window
			splashScreen.run();  
		}
		switch(id) {
		case 1:
			//Create Window, Set Title, Set Shape
			mainWindow = new WindowRunnable("Erde-Edre Übersetzer", "src/resources/images/style01/shape.png");
			
			//Set Values
			mainWindow.getWindow().setStartStopRecordValues( new ButtonValues("src/resources/images/style01/speak.png",
															"src/resources/images/style01/speakmo.png",
															"src/resources/images/style01/speakoc.png",0,50));
			
			//Init Main Window
			mainWindow.getWindow().initMainWindow();
			//Set Window Background
			mainWindow.getWindow().SetBackgroundImage("src/resources/images/style01/back.png");		
			
			
	    	
		break;
		}
		if(showSplashScreen) {
			splashScreen.getWindow().setEnabled(false);
			splashScreen.getWindow().setFocusable(false);
			splashScreen.getWindow().setVisible(false);
		}
		if(mainWindow!=null) {
			//Show the Window
			mainWindow.run();
		}
	}
}
