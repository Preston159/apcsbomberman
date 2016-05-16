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
	
	/**
	 * Initializes the bomberman
	 * @param c
	 * @param l
	 * @param s
	 * @param bc
	 * @param bs
	 */
	public Bomberman(Color c, Location l, int s, int bc, int bs)
	{
		super(c, l);
		super.setSpeed(s);
		bombCapacity = bc;
		kickBomb = false;
		bombSize = bs;
	}
	
	/**
	 * Increases the bombCapacity by x amount
	 * @param x
	 */
	public void increaseBombs(int x)
	{
		bombCapacity += x;
	}
	
	/**
	 * Sets bomberman's ability to kick
	 * @param kick
	 */
	public void canKick(boolean kick)
	{
		kickBomb = kick;
	}
	
	/**
	 * increases bomberman's bomb size by x
	 * @param x
	 */
	public void changeBombSize(int x)
	{
		bombSize += x;
	}
	
	/**
	 * 
	 * @return bombCapacity
	 */
	public int getBombCapacity()
	{
		return bombCapacity;
	}
	
	/**
	 * 
	 * @return kickBomb
	 */
	public boolean getCanKick()
	{
		return kickBomb;
	}
	
	/**
	 * 
	 * @return bombSize
	 */
	public int getBombSize()
	{
		return bombSize;
	}
	
	public void givePowerUp(Powerup p)
	{
		p.powerUp();
		p.destroy();
	}
	
	
}
