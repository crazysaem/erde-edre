package com.window.erdeedre.customcomponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.window.erdeedre.customwindow.CustomWindow;

/**
 * This Function simulates a Button through an Icon placed on a Label
 * @author Samuel Schneider
 *
 */
public class ImageButtonLabel implements MouseListener, MouseMotionListener {
	private JLabel label;
	private ImageIcon icon, iconOver, iconPressed;
	private BufferedImage image, imageOver, imagePressed;
	private int x, y;
	private boolean mouseDown=false;
	private CustomWindow parent=null;
	
	public ImageButtonLabel(CustomWindow parent, String imagePath, String imageMouseOverPath, String imageMousePressedPath) {	
	     this(parent, imagePath, imageMouseOverPath, imageMousePressedPath, 0, 0);
	}
	
	public ImageButtonLabel(CustomWindow parent, String imagePath, String imageMouseOverPath, String imageMousePressedPath, int x, int y) {
		try {
			image = ImageIO.read(new File(imagePath));
	        icon = new ImageIcon(image);
	        label = new JLabel(icon);
	        
	        imageOver = ImageIO.read(new File(imageMouseOverPath));
	        iconOver = new ImageIcon(imageOver);
	        
	        imagePressed = ImageIO.read(new File(imageMousePressedPath));
	        iconPressed = new ImageIcon(imagePressed);
	        
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }	   
		this.x = x;
		this.y = y;
		label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
		
		label.addMouseListener(this);
        label.addMouseMotionListener(this);   
        this.parent = parent;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
		label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
	}
	
	public int getWidth() {
		return icon.getIconWidth();
	}
	
	public int getHeight() {
		return icon.getIconHeight();
	}
	
	public int getXPos() {
		return x;
	}
	
	public int getYPos() {
		return y;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	/**
	 * Checks whether the Pixel from the Image sample is transparent or not
	 * @param img	The BufferedImage from which you want to sample
	 * @param x		The X Position of the sample pixel
	 * @param y		The Y Position of the sample pixel
	 * @return
	 */
	private boolean transparencyCheck(BufferedImage img, int x, int y) {
		if((x<0) || (y<0) || (x>=img.getWidth()) || (y>=img.getHeight())) return false;
		int color = img.getRGB(x, y);
		int alpha = (color>>24)&255;
		//int red = (color >> 16) & 0x000000FF;
		//int green = (color >>8 ) & 0x000000FF;
		//int blue = (color) & 0x000000FF;
		if (alpha>0) return true; 
			else 
		return false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if((!transparencyCheck(image, e.getX(), e.getY())) && (!mouseDown)) {
			parent.mouseDragged(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(!mouseDown) {
			if(!transparencyCheck(image, e.getX(), e.getY())) return;
			label.setIcon(iconOver);	
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(!transparencyCheck(image, e.getX(), e.getY())) {
			return;
		}
		label.setIcon(iconOver);	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(transparencyCheck(image, e.getX(), e.getY())) {
			return;
		}
		label.setIcon(icon);		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!transparencyCheck(image, e.getX(), e.getY())) {
			parent.mousePressed(e);
			return;
		}
		label.setIcon(iconPressed);	
		mouseDown=true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(!transparencyCheck(image, e.getX(), e.getY())) {
			return;
		}
		label.setIcon(iconOver);	
		mouseDown=false;
		parent.ButtonCallBack(this);
	}	
}
