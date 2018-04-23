package com.ship;

import javax.swing.JButton;

public class ShipModel extends JButton{

	// Private attributes
	private static final long serialVersionUID = 1L;
	private int type;
	
	// Class methods
	public void setType(int type){
		this.type = type;}
	public int getType(){
		return this.type;}

}
