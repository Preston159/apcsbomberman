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
	
	/**
	 * override <code>Inhabitant's</code> update method to provide collision
	 */
	public void update() {
		for (Bomberman bomber : playerList) {
			//if they are touching
			if (this.getLocation().getX()-(this.getSize()/2) <= bomber.getLocation().getX()+(bomber.getSize()/2) &&
				this.getLocation().getX()+(this.getSize()/2) >= bomber.getLocation().getX()-(bomber.getSize()/2) &&
			    this.getLocation().getY()-(this.getSize()/2) <= bomber.getLocation().getY()+(bomber.getSize()/2) &&
			    this.getLocation().getY()+(this.getSize()/2) >= bomber.getLocation().getY()-(bomber.getSize()/2)) {
				//if bomber is inside on the right
				if (this.getLocation().getX()-(this.getSize()/2) <= bomber.getLocation().getX()+(bomber.getSize()/2))
					bomber.move(-bomber.getSpeed(), 0.0);
				//if the bomber is inside on the left
				else if (this.getLocation().getX()+(this.getSize()/2) >= bomber.getLocation().getX()-(bomber.getSize()/2))
					bomber.move(bomber.getSpeed(), 0.0);
				//if the bomber is inside on the top
				if (this.getLocation().getY()-(this.getSize()/2) <= bomber.getLocation().getY()+(bomber.getSize()/2))
					bomber.move(0.0, -bomber.getSpeed());
				//if the bomber is inside on the bottom
				else if (this.getLocation().getY()+(this.getSize()/2) >= bomber.getLocation().getY()-(bomber.getSize()/2))
					bomber.move(0.0, bomber.getSpeed());
			}
		}
	}
}
