/**
 * @Author - Noah Sebenste
 * @author - Donovan Ewing
 * @Author - Umang Godhani
 * @Author - Nemenja Drezga
 */

package me.apcs.bomberman;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Bomberman extends Inhabitant {

	private int bombCapacity;
	private boolean kickBomb;
	private int bombSize;
	private Keyboard keys;
	
	private int player;
	
	/**
	 * Initializes the bomberman
	 * @param c
	 * @param l
	 * @param s
	 * @param bc
	 * @param bs
	 */
	public Bomberman(Color c, Location l, ImageIcon i, double s, int bc, int bs)
	{
		super(c, l, i);
		super.setSpeed(s);
		bombCapacity = bc;
		kickBomb = false;
		bombSize = bs;
		player = 0;
	}
	
	public void setKey(Keyboard k)
	{
		keys = k;
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
		p.setBomber(this);
		p.powerUp();
		p.destroy();
	}
	
	public int getPlayer() {
		return player;
	}
	
	public void setPlayer(int _player) {
		player = _player;
	}
	
	public void update()
	{
		if(getPlayer() == 0) {
			if (keys.getKey(KeyEvent.VK_UP)) {
				this.step(Location.UP);
			}
			if (keys.getKey(KeyEvent.VK_DOWN)) {
				this.step(Location.DOWN);
			}
			if (keys.getKey(KeyEvent.VK_LEFT)) {
				this.step(Location.LEFT);
			}
			if (keys.getKey(KeyEvent.VK_RIGHT)) {
				this.step(Location.RIGHT);
			}
			if (keys.getKey(KeyEvent.VK_CONTROL)) {
				boolean place = true;
				for(int i = 0;i < Game.getGrid().get(this.getLocation()).size();i++) {
					Inhabitant inhabitant = Game.getGrid().get(this.getLocation()).get(i);
					if(!(inhabitant instanceof Bomberman))
						place = false;
				}
				if(place)
					Game.queueAdd(new Bomb(this.getLocation().center(), bombSize, new ImageIcon("big_bomb.png")));
			}
		} else if(getPlayer() == 1) {
			if (keys.getKey(KeyEvent.VK_W)) {
				this.step(Location.UP);
			}
			if (keys.getKey(KeyEvent.VK_S)) {
				this.step(Location.DOWN);
			}
			if (keys.getKey(KeyEvent.VK_A)) {
				this.step(Location.LEFT);
			}
			if (keys.getKey(KeyEvent.VK_D)) {
				this.step(Location.RIGHT);
			}
			if (keys.getKey(KeyEvent.VK_SPACE)) {
				boolean place = true;
				for(int i = 0;i < Game.getGrid().get(this.getLocation()).size();i++) {
					Inhabitant inhabitant = Game.getGrid().get(this.getLocation()).get(i);
					if(!(inhabitant instanceof Bomberman))
						place = false;
				}
				if(place)
					Game.queueAdd(new Bomb(this.getLocation().center(), bombSize, new ImageIcon("big_bomb.png")));
			}
		}
	}
}
