package me.apcs.bomberman;

import java.awt.Color;

public class Bomb extends Inhabitant
{
	private int bombLength;
	
	public Bomb (Color c, Location l, int b)
	{
		super(c, l);
		bombLength = b;
	}
	
	public int getBombLength()
	{
		return bombLength;
	}
	
	public void explode()
	{
		this.destroy();
		Location l = this.getLocation();
		
		for(int x = 0; x <= this.getBombLength(); x++)
		{
			boolean right = true;
			boolean left = true;
			
			if (right == true)
			{	
				l = new Location(this.getLocation().getIntX() + x, this.getLocation().getIntY());
				if (Game.getGrid().isValid(l))
				{
					if(Game.getGrid().get(l) instanceof Brick)
					{
						right = false;
						Brick b = (Brick)Game.getGrid().get(l);
						if(b.isDestroyable())
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
						if (b.isDestroyable())
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
					}
					else
						Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
			}
		}
		
		for (int y = 0; y <= this.getBombLength(); y++)
		{
			boolean up = true;
			boolean down = true;
			
			if (up == true)
			{
				l = new Location(this.getLocation().getIntX(), this.getLocation().getIntY() + y);
				if (Game.getGrid().isValid(l))
				{
					if(Game.getGrid().get(l) instanceof Brick)
					{
						up = false;
						Brick b = (Brick)Game.getGrid().get(l);
						if(b.isDestroyable())
							Game.getGrid().set(l, new Explosion(super.getColor(), l));
					}
					else
						Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
			}
			
			if (down == true)
			{
				l = new Location(this.getLocation().getIntX(), this.getLocation().getIntY() - y);
				if(Game.getGrid().isValid(l))
				{
					if(Game.getGrid().get(l) instanceof Brick)
					{
						down = false;
						Brick b = (Brick)Game.getGrid().get(l);
						if(b.isDestroyable())
							Game.getGrid().set(l,  new Explosion(super.getColor(), l));
					}
					else
						Game.getGrid().set(l, new Explosion(super.getColor(), l));
				}
			}
		}
		
	}
}
