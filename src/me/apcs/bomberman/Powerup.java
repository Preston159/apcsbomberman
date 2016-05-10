package me.apcs.bomberman;

public interface Powerup {
	double duration;
	
	public void onStart();
	public void onEnd();
}
