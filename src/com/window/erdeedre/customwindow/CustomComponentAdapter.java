package com.window.erdeedre.customwindow;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Area;
import javax.swing.JFrame;

/**
 * Helper Class for Custom Shapes
 * @author Samuel Schneider
 *
 */
public class CustomComponentAdapter extends ComponentAdapter {
	private JFrame Window = null;
	private CustomShape customShape;
	private Area customArea;
	
	public CustomComponentAdapter(JFrame Window, String imagePath) {
		this.Window = Window;
		customShape = new CustomShape(imagePath);
		
		//Color color = new Color(0,0,0);
		//customArea = customShape.getArea(color, 10);
		customArea = customShape.getArea_FastHack();
	}
	
	@Override
    public void componentResized(ComponentEvent e) {		
		Window.setShape(customArea);
    }
	
	public Area getShape() {
		return customArea;
	}
}
