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
															"src/resources/images/style01/speakoc.png",20,100));
			mainWindow.getWindow().setplayRecordValues( new ButtonValues("src/resources/images/style01/play.png",
														"src/resources/images/style01/playmo.png",
														"src/resources/images/style01/playoc.png",180,60));
			mainWindow.getWindow().setminimizeValues( new ButtonValues("src/resources/images/style01/minus.png",
													"src/resources/images/style01/minusmo.png",
													"src/resources/images/style01/minusoc.png",640,110));
			mainWindow.getWindow().settextValues( new ButtonValues("src/resources/images/style01/text.png",
													"src/resources/images/style01/textmo.png",
													"src/resources/images/style01/textoc.png",260,80));
			mainWindow.getWindow().setgesturesValues( new ButtonValues("src/resources/images/style01/gesten.png",
													"src/resources/images/style01/gestenmo.png",
													"src/resources/images/style01/gestenoc.png",165,225));
			mainWindow.getWindow().setexitValues( new ButtonValues("src/resources/images/style01/x.png",
												"src/resources/images/style01/xmo.png",
												"src/resources/images/style01/xoc.png",660,150));
			
			//Init Main Window
			mainWindow.getWindow().initMainWindow();
			//Set Window Background
			mainWindow.getWindow().SetBackgroundImage("src/resources/images/style01/back.png");		
		break;
		case 2:
			//Create Window, Set Title, Set Shape
			mainWindow = new WindowRunnable("Erde-Edre Übersetzer", "src/resources/images/style02/shape2.png");
			
			//Set Values
			mainWindow.getWindow().setStartStopRecordValues( new ButtonValues("src/resources/images/style02/speaksmall.png",
															"src/resources/images/style02/speaksmallmo.png",
															"src/resources/images/style02/speaksmalloc.png",40,160));
			mainWindow.getWindow().setplayRecordValues( new ButtonValues("src/resources/images/style01/play.png",
														"src/resources/images/style01/playmo.png",
														"src/resources/images/style01/playoc.png",125,90));
			mainWindow.getWindow().setminimizeValues( new ButtonValues("src/resources/images/style01/minus.png",
													"src/resources/images/style01/minusmo.png",
													"src/resources/images/style01/minusoc.png",548,215));
			mainWindow.getWindow().settextValues( new ButtonValues("src/resources/images/style01/text.png",
													"src/resources/images/style01/textmo.png",
													"src/resources/images/style01/textoc.png",390,75));
			mainWindow.getWindow().setgesturesValues( new ButtonValues("src/resources/images/style01/gesten.png",
													"src/resources/images/style01/gestenmo.png",
													"src/resources/images/style01/gestenoc.png",240,15));
			mainWindow.getWindow().setexitValues( new ButtonValues("src/resources/images/style01/x.png",
												"src/resources/images/style01/xmo.png",
												"src/resources/images/style01/xoc.png",555,340));
			//Init Main Window
			mainWindow.getWindow().initMainWindow();
			//Set Window Background
			mainWindow.getWindow().SetBackgroundImage("src/resources/images/style02/back.png");	
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
