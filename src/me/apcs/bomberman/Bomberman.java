/**
 * @Author - Noah Sebenste
 * @author - Donovan Ewing
 * @Author - Umang Godhani
 * @Author - Nemenja Drezga
 */

package me.apcs.bomberman;

import java.awt.Color;

public class Bomberman extends Inhabitant{

	private int bombCapacity;
	private boolean kickBomb;
	private int bombSize;
	
	public Bomberman(Color c, Location l, int s, int bc, int bs)
	{
		super(c, l);
		super.setSpeed(s);
		bombCapacity = bc;
		kickBomb = false;
		bombSize = bs;
	}
	
	public void increaseBombs(int x)
	{
		bombCapacity += x;
	}
	
	public void canKick(boolean kick)
	{
		kickBomb = kick;
	}
	
	public void changeBombSize(int x)
	{
		bombSize += x;
	}
	
}
