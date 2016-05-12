package me.apcs.bomberman;

import java.awt.Color;

public class Bomberman extends Inhabitant{

	private int speed;
	private int bombCapacity;
	private boolean kickBomb;
	
	
	public Bomberman(Color c, Location l, int s, int bc)
	{
		super(c, l);
		speed = s;
		bombCapacity = bc;
	}
	
	public void changeSpeed(int amt)
	{
		speed += amt;
	}
	
}
