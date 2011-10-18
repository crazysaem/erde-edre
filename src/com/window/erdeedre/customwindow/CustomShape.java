package com.window.erdeedre.customwindow;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * CustomShape
 * based on a Class from Andrew Thompson * 
 * Source: http://stackoverflow.com/questions/7052422/image-graphic-into-a-shape-in-java/7059497#7059497
 * @author Samuel Schneider, Andrew Thompson
 * 
 *
 */
class CustomShape {
	
	BufferedImage image=null;
	
	/**
	 * Creates an Area with PixelPerfect precision
	 * @param color The color that is draws the Custom Shape
	 * @param tolerance The color tolerance
	 * @return Area
	 */
	public Area getArea(Color color, int tolerance) {
		if(image==null) return null;
		Area area = new Area();
		for (int x=0; x<image.getWidth(); x++) {
            for (int y=0; y<image.getHeight(); y++) {
            	Color pixel = new Color(image.getRGB(x,y));
            	if (isIncluded(color, pixel, tolerance)) {
                    Rectangle r = new Rectangle(x,y,1,1);
                    area.add(new Area(r));
                }
            }
		}
		
		return area;
	}
	
	public Area getArea_FastHack() {
		//Assumes Black as Shape Color
		if(image==null) return null;
		
		Area area = new Area();
		Color color = new Color(0,0,0,255);
		Rectangle r;
		int y1,y2;
		
		for (int x=0; x<image.getWidth(); x++) {
			y1=99;
			y2=-1;
            for (int y=0; y<image.getHeight(); y++) {
            	Color pixel = new Color(image.getRGB(x,y));
            	//-16777216 entspricht RGB(0,0,0)
            	//if (pixel.getRGB()==-16777216) {
            	if(isIncluded(color, pixel, 0)) {
                    if(y1==99) {y1=y;y2=y;}
                    if(y>(y2+1)) {
                    	r = new Rectangle(x,y1,1,y2-y1);
                    	area.add(new Area(r)); 
                    	y1=y;y2=y;
                    }
                    y2=y;
                }            	
            }
            if((y2-y1)>=0) {
        		r = new Rectangle(x,y1,1,y2-y1);
            	area.add(new Area(r)); 
        	}
		}
		
		return area;
	}

    public static boolean isIncluded(Color target, Color pixel, int tolerance) {
        int rT = target.getRed();
        int gT = target.getGreen();
        int bT = target.getBlue();
        int aT = target.getAlpha();        
        int rP = pixel.getRed();
        int gP = pixel.getGreen();
        int bP = pixel.getBlue();
        int aP = pixel.getAlpha();
        /*int pRGB = pixel.getRGB();
        int aP = (pRGB>>24)&255;
		int rP = (pRGB >> 16) & 0x000000FF;
		int gP = (pRGB >>8 ) & 0x000000FF;
		int bP = (pRGB) & 0x000000FF;*/
        return(
            (rP-tolerance<=rT) && (rT<=rP+tolerance) &&
            (gP-tolerance<=gT) && (gT<=gP+tolerance) &&
            (bP-tolerance<=bT) && (bT<=bP+tolerance) &&
            (aP-tolerance<=aT) && (aT<=aP+tolerance) );
    }
    
    public CustomShape(String path) {
    	try {
			BufferedImage image = ImageIO.read(new File(path));
			this.image = image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}