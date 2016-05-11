package me.apcs.bomberman;
/**
 * @author Zack Seliger
*/

public class Location {
	private double x, y;

	public Location (double xx, double yy) {
		x = xx;
		y = yy;
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

		y = (int)y;
		x = (int)x;
	}
	public void add(double dx, double dy) {
	    x += dx;
	    y += dy;
	}
}
