/**
 * @author Preston Petrie
 */

package me.apcs.bomberman;

import java.awt.Color;

public class Explosion extends Inhabitant {
	
	private int state = 0;
	
	public Explosion(Location l) {
		super(Color.RED, l);
	}
	
	/**
	 * Increment and get the current state of the explosion
	 * @return	An integer 0-9 which represents the current frame of the explosion animation or -1 if the explosion animation has ended
	 */
	public void update() {
		if(state >= 9) {
			super.destroy();
		}
		else {
			state += 1;
		}
		
		for (Inhabitant i : Game.getGrid().get(this.getLocation())) {
			if (i instanceof Brick || i instanceof Bomberman) {
				Game.queueDestroy(i);
			}
		}
	}
}
