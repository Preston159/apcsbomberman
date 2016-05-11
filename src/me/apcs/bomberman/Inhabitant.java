/**
 * Inhabitant.java
 * @author Preston Petrie
 * @author Braden Czerwinski
 * @author Brandon Piunti
 * @author Jacob Sako
 */

package me.apcs.bomberman;

import java.awt.Color;

public class Inhabitant {
	
	private Color color;
	private Location loc;
	
	/**
	 * Returns the current <code>Color</code>
	 * @return	The current <code>Color</code> of the <code>Inhabitant</code>
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Changes the <code>Color</code> of the <code>Inhabitant</code>
	 * @param c	The <code>Color</code> to which to change the <code>Inhabitant</code>
	 */
	public void setColor(Color c) {
		color = c;
	}
	
	/**
	 * Returns the current <code>Location</code>
	 * @return	The current <code>Location</code> of the <code>Inhabitant</code>
	 */
	public Location getLocation() {
		return loc;
	}
	
	/**
	 * Moves the <code>Inhabitant</code> to the specified <code>Location</code>
	 * @param l	The <code>Location</code> to which to move
	 */
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
		if(canMove(g, l)) {
			setLocation(l);
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if <code>Inhabitant</code> can move to given <code>Location</code>
	 * @param g	The <code>Grid</code> on which the <code>Inhabitant</code> exists
	 * @param l	The <code>Location</code> to which the <code>Inhabitant</code> is moving
	 * @return	True if the given <code>Location</code> is on the given <code>Grid</code> and does not contain a <code>Bomb</code> or <code>Brick</code>
	 */
	public boolean canMove(Grid g, Location l) {
		
	}
	
}
