package me.apcs.bomberman;
/**
 * @author Zack Seliger
*/

public class Location {
	private double x, y;
	public static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;

	public Location (int xx, int yy) {
		x = xx + 0.5;
		y = yy + 0.5;
	}

    public int getIntX() {
        return (int)x;
    }
    public int getIntY() {
        return (int)y;
    }
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}

	public void add(int dx, int dy) {
		x += dx;
		y += dy;
	}
	public void add(double dx, double dy) {
	    x += dx;
	    y += dy;
	}
	
	/**
	 * returns true if two locations are in the same square
	 * 
	 * @param other	the location to check if equal to
	 */
	public boolean inSameSquare(Location other) {
		return (this.getIntX() == other.getIntX() && this.getIntY() == other.getIntY());
	}
	
	/**
	 * returns the direction of the location the object is moving to
	 * 
	 * this is the current location(first)
	 * @param l is the location the object is moving to(second)
	 * @return
	 */
	public int getDirection(Location l)	
	{
		if (this.getX()!=l.getX())
		{
			if (l.getX() > this.getX())
			{
				return RIGHT;
			}
			return LEFT;
		}
		else
		{
			if (l.getY() > this.getY())
			{
				return DOWN;
			}
			return UP;
		}
	}
}
