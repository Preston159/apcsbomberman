package me.apcs.bomberman;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Bomb extends Inhabitant
{
	private boolean exploded;
	private int bombLength;
	Timer timer;
	
	/**
	 * Initializes the bomb
	 * @param c
	 * @param l
	 * @param b
	 */
	public Bomb (Location l, int b, ImageIcon i)
	{
		super(Color.BLACK, l, i);
		setSize(1);
		bombLength = b;
		timer = new Timer();
		exploded = false;
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
	public void explode() {
		boolean up = true, down = true, left = true, right = true;
		int current = 1;
		Location l = this.getLocation().clone();
		Grid<Inhabitant> g = Game.getGrid().clone();
		while(up && current <= bombLength) BLOCK1: {
			l.add(-1d, 0d);
			if(!Game.getGrid().isValid(l))
				break;
			for (int j = 0; j < g.get(l).size(); j++) {
				if(g.get(l).get(j) instanceof Brick) {
					Brick b = (Brick) g.get(l).get(j);
					if(!b.isBreakable())
						break BLOCK1;
					b.destroy();
					up = false;
				}
			}
			Explosion explosion = new Explosion(l.clone(), new ImageIcon("explosion.png"));
			Game.queueAdd(explosion);
			current++;
		}
		current = 1;
		l = this.getLocation().clone();
		while(down && current <= bombLength) BLOCK1: {
			l.add(1d, 0d);
			if(!Game.getGrid().isValid(l))
				break;
			
			for (int j = 0; j < g.get(l).size(); j++) {
				if(g.get(l).get(j) instanceof Brick) {
					Brick b = (Brick) g.get(l).get(j);
					if(!b.isBreakable())
						break BLOCK1;
					b.destroy();
					down = false;
				}
			}
			Explosion explosion = new Explosion(l.clone(), new ImageIcon("explosion.png"));
			Game.queueAdd(explosion);
			current++;
		}
		current = 1;
		l = this.getLocation().clone();
		while(left && current <= bombLength) BLOCK1: {
			l.add(0d, -1d);
			if(!Game.getGrid().isValid(l))
				break;
			for (int j = 0; j < g.get(l).size(); j++) {
				if(g.get(l).get(j) instanceof Brick) {
					Brick b = (Brick) g.get(l).get(j);
					if(!b.isBreakable())
						break BLOCK1;
					b.destroy();
					left = false;
				}
			}
			Explosion explosion = new Explosion(l.clone(), new ImageIcon("explosion.png"));
			Game.queueAdd(explosion);
			current++;
		}
		current = 1;
		l = this.getLocation().clone();
		while(right && current <= bombLength) BLOCK1: {
			l.add(0d, 1d);
			if(!Game.getGrid().isValid(l))
				break;
			for (int j = 0; j < g.get(l).size(); j++) {
				if(g.get(l).get(j) instanceof Brick) {
					Brick b = (Brick) g.get(l).get(j);
					if(!b.isBreakable())
						break BLOCK1;
					b.destroy();
					right = false;
				}
			}
			Explosion explosion = new Explosion(l.clone(), new ImageIcon("explosion.png"));
			Game.queueAdd(explosion);
			current++;
		}
		super.destroy();
		exploded = true;
	}
	
	public class RemindTask extends TimerTask
	{
		private Bomb bomb;
		public RemindTask(Bomb b)
		{
		bomb = b;	
		}
		@Override
		public void run() 
		{
			bomb.explode();
		}
		
	}
	
	public void update()
	{
		timer.schedule(new RemindTask(this), 4000);
	}
	
	public boolean isExploded() {
		return exploded;
	}
}
