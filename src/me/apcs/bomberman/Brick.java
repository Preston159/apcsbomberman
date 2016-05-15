package me.apcs.bomberman;

import java.awt.Color;

public class Brick extends Inhabitant
{
	private boolean destroyable;
	
	public Brick(Color c, Location l, boolean d)
	{
		super(c, l);
		destroyable = d;
	}
	
	public boolean isDestroyable()
	{
		return destroyable; 
	}
}
