package me.apcs.bomberman;

import java.awt.Color;

public class Brick extends Inhabitant
{
	private boolean breakable;
	
	public Brick(Color c, Location l, boolean b)
	{
		super(c, l);
		breakable = b;
	}
	
	public boolean isBreakable()
	{
		return breakable; 
	}
}
