/**
 * Inhabitant.java
 * @author Preston Petrie
 * @author Braden Czerwinski
 * @author Brandon Piunti
 * @author Jacob Sako
 */

package me.apcs.bomberman;

import java.awt.Color;
import java.awt.Graphics;

public class Inhabitant {
	
	private final double stepDistance = 1d;
	
	private Color color;
	private Location loc;
	private double speed;
	private double size;
	
	/**
	 * Create <code>Inhabitant</code>
	 * @param c	<code>Inhabitant</code>'s <code>Color</code>
	 * @param l	<code>Inhabitant</code>'s <code>Location</code>
	 */
	public Inhabitant(Color c, Location l) {
		color = c;
		loc = l;
		speed = 0d;
		size = 1.0;
	}
	
	/**
	 * Create <code>Inhabitant</code>
	 */
	public Inhabitant() {
		this(new Color(255, 255, 255), new Location(0, 0));
		speed = 0d;
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
	 * @return <code>speed</code>
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * @return <code>size</code>
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Moves <code>Inhabitant</code> by the given distance
	 * @param dx	Change in x
	 * @param dy	Change in y
	 * @return	True if successfully moved, false if not
	 */
	public boolean move(double dx, double dy) {
		Location l = getLocation().clone();
		l.add(dx, dy);
		Grid<Inhabitant> g = Game.getGrid();
		if(canMove(g, l)) {
			this.setLocation(l);
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
		return move((double) dx, (double) dy);
	}
	
	/**
	 * Checks if <code>Inhabitant</code> can move to given <code>Location</code>
	 * @param g	The <code>Grid</code> on which the <code>Inhabitant</code> exists
	 * @param l	The <code>Location</code> to which the <code>Inhabitant</code> is moving
	 * @return	True if the given <code>Location</code> is on the given <code>Grid</code> and does not contain a <code>Bomb</code> or <code>Brick</code>
	 */
	public boolean canMove(Grid<Inhabitant> g, Location l) {
		if(this.getLocation().inSameSquare(l))
			return true;
		int direction = this.getLocation().getDirection(l);
		Location test = this.getLocation().clone();
		test.addDirection(direction, 0.1);
		if(test.inSameSquare(l))
			return false;
		return true;
	}
	
	/**
	 * Removes the <code>Inhabitant</code> from the <code>Grid</code>
	 */
	public void destroy() {
		Game.getGrid().remove(this.getLocation());
	}
	
	public void setSpeed(double s) {
		speed = s;
	}
	
	public void changeSpeed(double s) {
		speed += s;
	}
	
	/**
	 * Steps the <code>Inhabitant</code> in the given direction
	 * Use Inhabitant.<DIRECTION> as the direction
	 * @param direction	The direction in which to move the <code>Inhabitant</code>
	 * @return	Whether or not the <code>Inhabitant</code> was successfully moved
	 */
	public boolean step(int direction) {
		switch(direction) {
		case Location.UP:
			return move(0, -(stepDistance * speed));
		case Location.DOWN:
			return move(0, stepDistance * speed);
		case Location.LEFT:
			return move(-(stepDistance * speed), 0);
		case Location.RIGHT:
			return move(stepDistance * speed, 0);
		default:
			throw new IllegalArgumentException("Invalid step direction");
		}
	}
	
	public void render(Graphics g, double scaleX, double scaleY) {
		g.setColor(getColor());
		g.fillRect((int)(getLocation().getX() * scaleX), (int)(getLocation().getY() * scaleY), (int)(scaleX * size), (int)(scaleY * size));
	}
	
	/**
	 * Changes the size of the <code>Inhabitant</code>
	 * @param s	The new size
	 */
	public void setSize(double s) {
		size = s;
	}
	
	/**
	 * Updates itself, the default method
	 * Called by the update function of the game
	 */
	public void update() {
		
	}
}
