package me.apcs.bomberman;

public class Location {
	private int x, y;
	
	public Location (int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void add(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}
}
