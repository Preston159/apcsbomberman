package me.apcs.bomberman;

import java.awt.Color;

public class Bomb extends Inhabitant {
	
	private int bombLength;
	
	public Bomb (Color c, Location l, int b)
	{
		super(c, l);
		bombLength = b;
	}
	
	public int getBombLength()
	{
		return bombLength;
	}

}
