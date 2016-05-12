package me.apcs.bomberman;

public class Powerup extends Inhabitant {
	public enum Type {SPEED, CAPACITY, CAN_KICK, BOMB_SIZE};
	private Bomberman bomber;
	Type type = Type.SPEED;
	
	public Powerup(Location loc) {
		super(null, loc);
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
		//else if (type == Type.BOMB_SIZE)
			
	}
	
	public void setBomber(Bomberman b) {
		bomber = b;
	}
	public void setPowerUp(Type t) {
		type = t;
	}
}
