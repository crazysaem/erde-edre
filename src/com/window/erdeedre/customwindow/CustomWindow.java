package com.window.erdeedre.customwindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.window.erdeedre.audio.AudioHelper;
import com.window.erdeedre.customcomponents.ImageButtonLabel;
import com.window.erdeedre.customcomponents.ImageButtonLabelCallBack;
import com.window.erdeedre.customcomponents.ImageLabel;
import com.window.erdeedre.skins.ButtonValues;

/**
 * Custom Window extends JFrame
 * Extends JFrame to better support custom shape and pixel transparency
 * @author Samuel Schneider
 *
 */
public class CustomWindow extends JFrame implements MouseMotionListener, MouseListener, ImageButtonLabelCallBack, WindowStateListener {
	private static final long serialVersionUID = 1L;
	private CustomComponentAdapter customComponentAdapter;
	private boolean mousedown=false, recording=false, isReadyToPlay=false, isMain=false;
	private int mousex1, mousey1;
	private ImageButtonLabel startStopRecord, stopRecord, playRecord, exit;
	private ButtonValues startStopRecordValues;
	private ImageLabel background;
	private AudioHelper audioHelper;	
	
	public CustomWindow(String title, String imagePath) {
		//Define Window Title
        super(title);
        
        customComponentAdapter = new CustomComponentAdapter(this, imagePath);
        addComponentListener(customComponentAdapter);
        
        BufferedImage shape=null;
        
        try {
			shape = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}               
        
        //Disable Window Frame
        setUndecorated(true);
        //Set Size to predefined Shape
        setSize(shape.getWidth(), shape.getHeight());
        //Move Window to the middle of the Screen
        setLocationRelativeTo(null);
        //Choose Absolut Layout
        setLayout(null);    
        
        //Add MouseListener to move the Application
        this.addMouseListener(this);
        this.addMouseMotionListener(this);   
        //this.addWindowStateListener(this);
    }
	
	public void setStartStopRecordValues(ButtonValues startStopRecordValues) {
		this.startStopRecordValues = startStopRecordValues;
	}
	
	public void initMainWindow() {
		isMain=true;
		audioHelper = new AudioHelper();    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        startStopRecord = new ImageButtonLabel(this,
        							 "src/resources/images/buttons/button_speak_up.png",
        							 "src/resources/images/buttons/button_speak_up_highlight.png",
        							 "src/resources/images/buttons/button_speak_down.png");*/
		startStopRecord = new ImageButtonLabel(this,startStopRecordValues.path,startStopRecordValues.pathmo,startStopRecordValues.pathoc);
        this.add(startStopRecord.getLabel());
        startStopRecord.setPos(startStopRecordValues.x, startStopRecordValues.y);
        
        stopRecord = new ImageButtonLabel(this,
				 "src/resources/images/buttons/button_speak_up.png",
				 "src/resources/images/buttons/button_speak_up_highlight.png",
				 "src/resources/images/buttons/button_speak_down.png");
		this.add(stopRecord.getLabel());
		stopRecord.setPos(140, 50);

		playRecord = new ImageButtonLabel(this,
				 "src/resources/images/buttons/button_speak_up.png",
				 "src/resources/images/buttons/button_speak_up_highlight.png",
				 "src/resources/images/buttons/button_speak_down.png");
		this.add(playRecord.getLabel());
		playRecord.setPos(280, 50);
		
		exit = new ImageButtonLabel(this,
				 "src/resources/images/buttons/button_speak_up.png",
				 "src/resources/images/buttons/button_speak_up_highlight.png",
				 "src/resources/images/buttons/button_speak_down.png");
		this.add(exit.getLabel());
		exit.setPos(210, 180);
	}
	
	public void SetBackgroundImage(String imagePath) {
		background = new ImageLabel(imagePath);
		add(background.getLabel());
	}

	//Mouse Functions:	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	
	}

	@Override
	public void mousePressed(MouseEvent mouse) {
		mousedown=true;	
		mousex1=mouse.getLocationOnScreen().x-this.getLocationOnScreen().x;
		mousey1=mouse.getLocationOnScreen().y-this.getLocationOnScreen().y;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mousedown=false;		
	}

	@Override
	public void mouseDragged(MouseEvent mouse) {
		if(mousedown) {
			this.setLocation(mouse.getLocationOnScreen().x-mousex1, mouse.getLocationOnScreen().y-mousey1);		
		}		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}

	@Override
	public void ButtonCallBack(ImageButtonLabel pressedButton) {		
		if((pressedButton==startStopRecord) && (recording==false)) {
			System.out.println("Button 1 Pressed");
			audioHelper.startCaptureAudio();
			recording=true;
		}
		if((pressedButton==stopRecord) && (recording==true)) {
			System.out.println("Button 2 Pressed");	
			audioHelper.stopCaptureAudio();
			recording=false;
			isReadyToPlay=true;
		}
		if((pressedButton==playRecord) && (audioHelper.isPlayingAudio()==false) && (isReadyToPlay)) {
			System.out.println("Button 3 Pressed");
			//audioHelper.playReverseAudio();
			audioHelper.playAudio();
		}
		if(pressedButton==exit) {
			System.exit(0);
		}
	}

	@Override
	public void windowStateChanged(WindowEvent arg0) {
		if((arg0.getNewState()==WindowEvent.WINDOW_CLOSED) && (isMain)) {
			System.exit(0);
		}
		
	}
}
