package me.apcs.bomberman;

import java.awt.Color;

public abstract class Inhabitant {
	
	private Color color;
	private Location l;
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Location getLocation() {
		return l;
	}
	
	public void setLocation() {
		
	}
	
	public void move(int dx, int dy) {
		
	}
	
}
