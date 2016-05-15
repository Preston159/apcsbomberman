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
		Location l = this.getLocation();
		
		for(int x = 0; x <= this.getBombLength(); x++)
		{
			boolean right = true;
			boolean left = true;
			boolean up = true;
			boolean down = true;
			
			if (right == true)
			{	
				l = new Location(this.getLocation().getIntX() + x, this.getLocation().getIntY());
				if (Game.getGrid().isValid(l))
				{
					if(Game.getGrid().get(l) instanceof Brick)
					{
						right = false;
						Brick b = (Brick)Game.getGrid().get(l);
						if(b.isBreakable())
							Game.getGrid().set(l,  new Explosion(super.getColor(), l));
					}
					else
						Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
			}
			
			if(left == true)
			{
				l = new Location(this.getLocation().getIntX() - x, this.getLocation().getIntY());
				if (Game.getGrid().isValid(l))
				{
					if(Game.getGrid().get(l) instanceof Brick)
					{
						left = false;
						Brick b = (Brick)Game.getGrid().get(l);
						if (b.isBreakable())
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
					}
					else
						Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
			}
			
			if (up == true)
			{
				l = new Location(this.getLocation().getIntX(), this.getLocation().getIntY() + x);
				if (Game.getGrid().isValid(l))
				{
					if(Game.getGrid().get(l) instanceof Brick)
					{
						up = false;
						Brick b = (Brick)Game.getGrid().get(l);
						if(b.isBreakable())
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
					}
					else
						Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
			}
			
			if (down == true)
			{
				l = new Location(this.getLocation().getIntX(), this.getLocation().getIntY() - x);
				if(Game.getGrid().isValid(l))
				{
					if(Game.getGrid().get(l) instanceof Brick)
					{
						down = false;
						Brick b = (Brick)Game.getGrid().get(l);
						if(b.isBreakable())
							Game.getGrid().set(l,  new Explosion(super.getColor(), l));
					}
					else
						Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
			}
			
			this.destroy();
		}
	}
}
