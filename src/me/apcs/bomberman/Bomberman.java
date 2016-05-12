/**
 * @Author - Noah Sebenste
 * @author - Donovan Ewing
 * @Author - Umang Godhani
 * @Author - Nemenja Drezga
 */

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
	
	public void increaseBombs(int x)
	{
		bombCapacity += x;
	}
	
	public void canKick(boolean kick)
	{
		kickBomb = kick;
	}
	
}
