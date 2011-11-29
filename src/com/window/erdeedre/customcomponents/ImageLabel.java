package com.window.erdeedre.customcomponents;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Helper Class to place an Image on a Frame/Panel
 * @author Team5-Listener
 *
 */
public class ImageLabel {
	private JLabel label;
	private ImageIcon icon;
	private int x, y;
	
	public ImageLabel(String imagePath) {	
	     this(imagePath, 0, 0);
	}
	
	public ImageLabel(String imagePath, int x, int y) {
		try {
			BufferedImage image = ImageIO.read(new File(imagePath));
	        icon = new ImageIcon(image);
	        label = new JLabel(icon);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }	   
		this.x = x;
		this.y = y;
		label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
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
}
