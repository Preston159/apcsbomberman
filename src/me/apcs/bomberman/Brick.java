package me.apcs.bomberman;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Brick extends Inhabitant
{
	private boolean breakable;
	
	/**
	 * initializes the brick
	 * @param c
	 * @param l
	 * @param b
	 */
	public Brick(Color c, Location l, ImageIcon i, boolean b)
	{
		super(c, l, i);
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
