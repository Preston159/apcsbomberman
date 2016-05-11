package me.apcs.bomberman;
/**
 * @author Zack Seliger
*/

public class Location {
	private double x, y;

	public Location (int xx, int yy) {
		x = xx;
		y = yy;
	}

    public int getIntX() {
        return (int)x;
    }
    public int getIntY() {
        return (int)y;
    }
	public double getX() {
		return x + 0.5;
	}
	public double getY() {
		return y + 0.5;
	}

	public void add(int dx, int dy) {
		x += dx;
		y += dy;
	}
	public void add(double dx, double dy) {
	    x += dx;
	    y += dy;
	}
}
