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
	
	public Location(double xx, double yy) {
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
	public int getDirection(Location l)	{
		double dx, dy;
		dx = l.getX() - this.getX();
		System.out.println("l:" + l.getX() + "," + this.getX());
		dy = l.getY() - this.getY();
		System.out.println("dy:" + dy);
		if(Math.abs(dx) >= Math.abs(dy)) {
			if(dx >= 0)
				return RIGHT;
			return LEFT;
		}
		if(dy >= 0)
			return DOWN;
		return UP;
	}
	
	public void addDirection(int direction, double amount) {
		switch(direction) {
		case UP:
			this.add(-amount, 0);
			break;
		case DOWN:
			this.add(amount, 0);
			break;
		case RIGHT:
			this.add(0, amount);
			break;
		case LEFT:
			this.add(0, -amount);
			break;
		default: break;
		}
	}
	
	public Location clone() {
		return new Location(x - 0.5, y - 0.5);
	}
	
	@Override
	public String toString() {
		return x + "," + y;
	}
}
