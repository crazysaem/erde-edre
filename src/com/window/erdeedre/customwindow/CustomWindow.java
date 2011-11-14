package com.window.erdeedre.customwindow;

import java.awt.Frame;
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
import com.window.erdeedre.skins.SkinChooser;

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
	private ImageButtonLabel startStopRecord, playRecord, skin, gestures, minimze, exit;
	private ButtonValues startStopRecordValues, playRecordValues, skinValues, gesturesValues, minimizeValues, exitValues;
	private ImageLabel background;
	private AudioHelper audioHelper;	
	
	MenuPanel menu;
	
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
	
	public void setplayRecordValues(ButtonValues playRecordValues) {
		this.playRecordValues = playRecordValues;
	}
	
	public void setskinValues(ButtonValues skinValues) {
		this.skinValues = skinValues;
	}
	
	public void setgesturesValues(ButtonValues gesturesValues) {
		this.gesturesValues = gesturesValues;
	}
	
	public void setminimizeValues(ButtonValues minimizeValues) {
		this.minimizeValues = minimizeValues;
	}
	
	public void setexitValues(ButtonValues exitValues) {
		this.exitValues = exitValues;
	}
	
	public void initMainWindow() {
		isMain=true;
		audioHelper = new AudioHelper();    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startStopRecord = new ImageButtonLabel(this, startStopRecordValues);
		this.add(startStopRecord.getLabel());
		
		playRecord = new ImageButtonLabel(this, playRecordValues);
		this.add(playRecord.getLabel());
		
		minimze = new ImageButtonLabel(this, minimizeValues);
		this.add(minimze.getLabel());
		
		skin = new ImageButtonLabel(this, skinValues);
		this.add(skin.getLabel());
		
		gestures = new ImageButtonLabel(this, gesturesValues);
		this.add(gestures.getLabel());
		
		exit = new ImageButtonLabel(this, exitValues);
		this.add(exit.getLabel());
		
		menu = new MenuPanel();
		this.add(menu);
		
	}
	public void setMenu(int x,int y,int sizex,int sizey){
		menu.setBounds(x,y,sizex,sizey);
		menu.setVisible(false);
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
			//System.out.println("Button 1 Pressed");
			audioHelper.startCaptureAudio();
			recording=true;
			return;
		}
		if((pressedButton==startStopRecord) && (recording==true)) {
			//System.out.println("Button 2 Pressed");	
			audioHelper.stopCaptureAudio();
			recording=false;
			isReadyToPlay=true;
			return;
		}
		if(pressedButton==skin){
			System.out.println("Skin Change Pressed");
			//release old Screen and Audio ressources
			this.dispose();
			audioHelper.releaseAudio();
			//init new Skin
			new SkinChooser();
			return;
			}
		
		if(pressedButton==gestures){
			System.out.println("GestureButton Pressed");
			//release old Screen and Audio ressources
			if(menu.isVisible()){
				menu.setVisible(false);
			}
			else{
				menu.setVisible(true);
			}
			return;
			}
		
		if((pressedButton==playRecord) && (audioHelper.isPlayingAudio()==false) && (isReadyToPlay)) {
			System.out.println("Button 3 Pressed");
			audioHelper.playReverseAudio();
			//audioHelper.playAudio();
			return;
		}
		if(pressedButton==minimze) {
			this.setState(Frame.ICONIFIED);
			return;
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
