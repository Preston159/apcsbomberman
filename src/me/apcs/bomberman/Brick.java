package me.apcs.bomberman;

import java.awt.Color;

public class Brick extends Inhabitant
{
	private boolean breakable;
	
	/**
	 * initializes the brick
	 * @param c
	 * @param l
	 * @param b
	 */
	public Brick(Color c, Location l, boolean b)
	{
		super(c, l);
		breakable = b;
	}
	
	/**
	 * returns if the brick is breakable or not
	 * @return
	 */
	public boolean isBreakable()
	{
		return breakable; 
	}
}
