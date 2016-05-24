package me.apcs.bomberman;

import java.awt.Color;
import java.util.ArrayList;

public class Brick extends Inhabitant
{
	private boolean breakable;
	private ArrayList<Bomberman> playerList;
	
	/**
	 * initializes the brick
	 * @param c
	 * @param l
	 * @param b
	 */
	public Brick(Color c, Location l, boolean b, ArrayList<Bomberman> list)
	{
		super(c, l);
		breakable = b;
		playerList = list;
	}
	
	/**
	 * returns if the brick is breakable or not
	 * @return
	 */
	public boolean isBreakable()
	{
		return breakable; 
	}
	
	/**
	 * setter method for playerList
	 */
	public void setPlayerList(ArrayList<Bomberman> list) {
		playerList = list;
	}
	
	@Override
	public String toString() {
		return "Brick@" + super.getLocation().toString();
	}
}
