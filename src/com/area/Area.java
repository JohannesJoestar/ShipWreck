package com.area;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.ship.ShipType;

public class Area extends JButton {
	
	// Private attributes
	private static final long serialVersionUID = 1L;
	private AreaType type;
	
	// Indexes
	int xIndex;
	int yIndex;
	
	// Constructor
	public  Area (String text){
		super(text);
		setType(AreaType.BLANK); // Type of the area
		setSize(64, 64); // Size of the area
		}
		
	// Class methods
	public void setType(AreaType type){
		this.type = type;}
	public AreaType getType(){
		return this.type;}
	
	public void changeIcon(AreaType type){
		try {
			
			// Define and build ImageIcon objects
			ImageIcon IMG_BLANK = new ImageIcon(ImageIO.read(getClass().getResource("/blank.png")));
			ImageIcon IMG_MISS = new ImageIcon(ImageIO.read(getClass().getResource("/miss.png")));
			ImageIcon IMG_HIT = new ImageIcon(ImageIO.read(getClass().getResource("/hit.png")));
			ImageIcon IMG = null;
			
			// Change icon according to given parameter
			if (type == AreaType.BLANK){
				IMG = IMG_BLANK;
			} else if (type == AreaType.MISS){
				IMG = IMG_MISS;
			} else if (type == AreaType.HIT){
				IMG = IMG_HIT;
			} else {
				System.out.println("Invalid type.");
			} this.setIcon(IMG); // Set icon
			
		} catch (Exception E){
			E.printStackTrace();
		}
	}
	
	public void changeIcon(ShipType type){
		
		// Define and build icons
		try{
			ImageIcon IMG_XCENTER = new ImageIcon(ImageIO.read(getClass().getResource("/shipcenterx.png")));
			ImageIcon IMG_YCENTER = new ImageIcon(ImageIO.read(getClass().getResource("/shipcentery.png")));
			ImageIcon IMG_DOWN = new ImageIcon(ImageIO.read(getClass().getResource("/shipdown.png")));
			ImageIcon IMG_RIGHT = new ImageIcon(ImageIO.read(getClass().getResource("/shipright.png")));
			ImageIcon IMG_LEFT = new ImageIcon(ImageIO.read(getClass().getResource("/shipleft.png")));
			ImageIcon IMG_UP = new ImageIcon(ImageIO.read(getClass().getResource("/shipup.png")));
			ImageIcon IMG = null;
			
			// Change icon according to ship type
			if (type == ShipType.XCENTER){
				IMG = IMG_XCENTER;
			} else if (type == ShipType.YCENTER){
				IMG = IMG_YCENTER;
			} else if (type == ShipType.DOWN){
				IMG = IMG_DOWN;
			} else if (type == ShipType.RIGHT){
				IMG = IMG_RIGHT;
			} else if (type == ShipType.LEFT){
				IMG = IMG_LEFT;
			} else if (type == ShipType.UP){
				IMG = IMG_UP;
			} else {
				System.out.println("Invalid type.");
			} this.setIcon(IMG); // Set icon
			
		} catch (Exception ex) {System.out.println(ex);}
	}
	
	// Getters & Setters
	// Getters
	public int getXIndex(){
		return this.xIndex;}
	public int getYIndex(){
		return this.yIndex;}
	// Setters
	public void setXIndex(int xIndex){
		this.xIndex = xIndex;}
	public void setYIndex(int yIndex){
		this.yIndex = yIndex;}
	

}
