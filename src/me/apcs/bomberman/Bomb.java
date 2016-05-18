package me.apcs.bomberman;

import java.awt.Color;

public class Bomb extends Inhabitant
{
	private int bombLength;
	
	/**
	 * Initializes the bomb
	 * @param c
	 * @param l
	 * @param b
	 */
	public Bomb (Color c, Location l, int b)
	{
		super(c, l);
		bombLength = b;
	}
	
	/**
	 * @return bombLength
	 */
	public int getBombLength()
	{
		return bombLength;
	}
	
	/**
	 * Creates an explosion in each direction that is equal to bombLength
	 */
	public void explode()
	{
		//sets l to bomb location
		Location l = this.getLocation();
		
		//declare the boolean variables 
		boolean right = true;
		boolean left = true;
		boolean up = true;
		boolean down = true;
		boolean c = false;
		int nn = 0;
		
		
		//initiate for loop, while x <= Bomb Size
		for(int x = 0; x <= this.getBombLength(); x++)
		{
			
			
			//if you haven't hit a wall, right is true
			if (right == true)
			{	
				//sets l x right of the location of the bomb
				l = new Location(this.getLocation().getIntX() + x, this.getLocation().getIntY());
				//if l is a valid location on the grid
				if (Game.getGrid().isValid(l))
				{	
					//if the location l is a brick, set right to false
					for (int n = 0; n < Game.getGrid().get(l).size(); n++)
					{
						if(Game.getGrid().get(l).get(n) instanceof Brick)
						{
							c = true;
							nn = n;
						}
					}
					
					if (c == true)
					{
						right = false;
						Brick b = (Brick)Game.getGrid().get(l).get(nn);
						//	if the brick is breakable, set the location of the brick to an explosion
						if(b.isBreakable())
							Game.getGrid().set(l,  new Explosion(super.getColor(), l));
						//if it isn't a brick, set space to explosion
					}
					else
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
				nn = 0;
				c = false;
			}
			
			//if you haven't hit a wall, left is true
			if (left == true)
			{	
				//sets l x right of the location of the bomb
				l = new Location(this.getLocation().getIntX() - x, this.getLocation().getIntY());
				//if l is a valid location on the grid
				if (Game.getGrid().isValid(l))
				{	
					//if the location l is a brick, set right to false
					for (int n = 0; n < Game.getGrid().get(l).size(); n++)
					{
						if(Game.getGrid().get(l).get(n) instanceof Brick)
						{
							c = true;
							nn = n;
						}
					}
					
					if (c == true)
					{
						right = false;
						Brick b = (Brick)Game.getGrid().get(l).get(nn);
						//	if the brick is breakable, set the location of the brick to an explosion
						if(b.isBreakable())
							Game.getGrid().set(l,  new Explosion(super.getColor(), l));
						//if it isn't a brick, set space to explosion
					}
					else
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
				nn = 0;
				c = false;
			}
			
			//if you haven't hit a wall yet, up is true
			if (up == true)
			{	
				//sets l x right of the location of the bomb
				l = new Location(this.getLocation().getIntX(), this.getLocation().getIntY() + x);
				//if l is a valid location on the grid
				if (Game.getGrid().isValid(l))
				{	
					//if the location l is a brick, set right to false
					for (int n = 0; n < Game.getGrid().get(l).size(); n++)
					{
						if(Game.getGrid().get(l).get(n) instanceof Brick)
						{
							c = true;
							nn = n;
						}
					}
					
					if (c == true)
					{
						right = false;
						Brick b = (Brick)Game.getGrid().get(l).get(nn);
						//	if the brick is breakable, set the location of the brick to an explosion
						if(b.isBreakable())
							Game.getGrid().set(l,  new Explosion(super.getColor(), l));
						//if it isn't a brick, set space to explosion
					}
					else
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
				nn = 0;
				c = false;
			}
			
			//if you haven't hit a wall yet, down is true
			if (down == true)
			{	
				//sets l x right of the location of the bomb
				l = new Location(this.getLocation().getIntX(), this.getLocation().getIntY() - x);
				//if l is a valid location on the grid
				if (Game.getGrid().isValid(l))
				{	
					//if the location l is a brick, set right to false
					for (int n = 0; n < Game.getGrid().get(l).size(); n++)
					{
						if(Game.getGrid().get(l).get(n) instanceof Brick)
						{
							c = true;
							nn = n;
						}
					}
					
					if (c == true)
					{
						right = false;
						Brick b = (Brick)Game.getGrid().get(l).get(nn);
						//	if the brick is breakable, set the location of the brick to an explosion
						if(b.isBreakable())
							Game.getGrid().set(l,  new Explosion(super.getColor(), l));
						//if it isn't a brick, set space to explosion
					}
					else
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
				nn = 0;
				c = false;
			}
		}
		//destroy the bomb
		this.destroy();
	}
}
