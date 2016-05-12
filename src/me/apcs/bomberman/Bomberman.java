package me.apcs.bomberman;

public class Bomberman extends Inhabitant{

	private int speed;
	private int bombCapacity;
	private boolean kickBomb;
	
	
	public Bomberman(int s, int bc)
	{
		speed = s;
		bombCapacity = bc;
	}
	
	public void changeSpeed(int amt)
	{
		speed += amt;
	}
	
}
