/*
 * Authors: Preston Petrie, Braden Czerwinski, Brandon Piunti, Jacob Sako
 */

package me.apcs.bomberman;

import java.awt.Color;

public class Inhabitant {
	
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
	
	public void setLocation(Location l) {
		loc = l;
	}
	
	/**
	 * Moves <code>Inhabitant</code> by the given distance
	 * @param dx	Change in x
	 * @param dy	Change in y
	 * @return	True if successfully moved, false if not
	 */
	public boolean move(int dx, int dy) {
		Location l = getLocation();
		l.add(dx, dy);
		//check isn't out of bounds
		setLocation(l);
		return true;
	}
	
}
