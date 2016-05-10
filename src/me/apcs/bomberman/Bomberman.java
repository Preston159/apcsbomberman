package me.apcs.bomberman;

public class Bomberman extends Inhabitant{

	private int speed;
	private int bombCapacity;
	
	
	public Bomberman(int s, int bc)
	{
		speed = s;
		bombCapacity = bc;
	}
	
	public void upgradeSpeed(int amt)
	{
		speed += amt;
	}
	
}
