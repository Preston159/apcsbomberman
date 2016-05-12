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
	 * Create <code>Inhabitant</code>
	 * @param c	<code>Inhabitant</code>'s <code>Color</code>
	 * @param l	<code>Inhabitant</code>'s <code>Location</code>
	 */
	public Inhabitant(Color c, Location l) {
		color = c;
		loc = l;
	}
	
	/**
	 * Create <code>Inhabitant</code>
	 */
	public Inhabitant() {
		this(new Color(255, 255, 255), new Location(0, 0));
	}
	
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
	public boolean move(double dx, double dy) {
		Location l = getLocation();
		l.add(dx, dy);
		Grid<Inhabitant> g = Game.getGrid();
		if(canMove(g, l)) {
			setLocation(l);
			return true;
		}
		return false;
	}
	
	/**
	 * Moves <code>Inhabitant</code> by the given distance
	 * @param dx	Change in x
	 * @param dy	Change in y
	 * @return	True if successfully moved, false if not
	 */
	public boolean move(int dx, int dy) {
		return move(dx, dy);
	}
	
	/**
	 * Checks if <code>Inhabitant</code> can move to given <code>Location</code>
	 * @param g	The <code>Grid</code> on which the <code>Inhabitant</code> exists
	 * @param l	The <code>Location</code> to which the <code>Inhabitant</code> is moving
	 * @return	True if the given <code>Location</code> is on the given <code>Grid</code> and does not contain a <code>Bomb</code> or <code>Brick</code>
	 */
	public boolean canMove(Grid<Inhabitant> g, Location l) {
		Location player = this.getLocation();
		if(player.inSameSquare(l) == true)
			return true;
		if(g.get(l) instanceof Bomberman || g.get(l) instanceof Powerup)
			return true;
		return false;
	}
	
	/**
	 * Removes the <code>Inhabitant</code> from the <code>Grid</code>
	 */
	public void destroy() {
		Game.getGrid().remove(this.getLocation());
	}
}
