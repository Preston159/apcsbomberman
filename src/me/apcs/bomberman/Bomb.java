package me.apcs.bomberman;

import java.awt.Color;

public class Bomb extends Inhabitant {
	
	private int bLength;
	private Location bLocation;
	
	public Bomb (Color c, Location l, int b)
	{
		super(c, l);
		bLength = b;
	}
	
	

}
