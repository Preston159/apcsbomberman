package me.apcs.bomberman;

import java.awt.Color;

public abstract class Inhabitant {
	
	private Color color;
	private Location loc;
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public void setLocation() {
		
	}
	
	public void move(int dx, int dy) {
		
	}
	
}
