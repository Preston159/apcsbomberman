/**
 * @author Joey Munsie
 * @author Zach Seliger
 * @author Marcellus Hunt
 * @author Haroon Mohiuddin
 */

package me.apcs.bomberman;

public class Powerup extends Inhabitant {
	public enum Type {SPEED, CAPACITY, CAN_KICK, BOMB_SIZE};
	private Bomberman bomber;
	private Type type;

	/**
	 * Initializes powerup location
	 * @param loc - powerup location
	 */
	public Powerup(Location loc) {
		super(null, loc);
	}
	
	/**
	 * Initializes powerup
	 * @param loc - location of where the powerup will spawn
	 * @param t - the type of powerup that will spawn
	 */
	public Powerup(Location loc, Type t) {
		super(null, loc);
		type=t;
	}
	
	/**
	 * upgrades the bomber based on <code>type</code>
	 */
	public void powerUp() {
		if (type == Type.SPEED)
			bomber.changeSpeed(5);
		else if (type == Type.CAPACITY)
			bomber.increaseBombs(1);
		else if (type == Type.CAN_KICK)
			bomber.canKick(true);
		else if (type == Type.BOMB_SIZE)
			bomber.changeBombSize(1);
	}
	
	/**
	 * @param b
	 */
	public void setBomber(Bomberman b) {
		bomber = b;
	}
	
	/**
	 * @param t
	 */
	public void setPowerUp(Type t) {
		type = t;
	}
}
