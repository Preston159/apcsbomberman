package me.apcs.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	
	private static int tickLength;
	
	private static volatile Grid<Inhabitant> grid;
	private static List<Bomberman> players;
	
	public static volatile ArrayList<Inhabitant> toDestroy = new ArrayList<Inhabitant>();
	public static volatile ArrayList<Inhabitant> toAdd = new ArrayList<Inhabitant>();
	
	public static void main(String[] args) {
		Settings.init();
		tickLength = (int) ((double) 1 / Integer.valueOf(Settings.p.getProperty("ticksPerSecond")) * 1000);
		createGrid();
		players = new ArrayList<Bomberman>();
	}
	
	/**
	 * Creates a <code>Grid</code> and stores it in the <code>grid</code> field
	 */
	public static void createGrid() {
		int sizeX = Integer.valueOf(Settings.p.getProperty("gridSizeX"));
		int sizeY = Integer.valueOf(Settings.p.getProperty("gridSizeY"));
		grid = new Grid<Inhabitant>(sizeX, sizeY);
	}
	
	/**
	 * The <code>Grid</code> of the current game
	 * @return	The <code>Grid<Inhabitant></code>of the current game
	 */
	public static Grid<Inhabitant> getGrid() {
		return grid;
	}
	
	/**
	 * A <code>List</code> of all current <code>Bomberman</code>s
	 * @return	</code>ArrayList<Bomberman></code> containing all <code>Bomberman</code>s on the <code>Grid</code>
	 */
	public static List<Bomberman> getPlayers() {
		return players;
	}
	
	public static void tick() {
		new Timer().schedule(
				new TimerTask() {
					@Override
					public void run() {
						for(Inhabitant i : toDestroy)
							Game.getGrid().remove(i);
						toDestroy.clear();
						for(Inhabitant i : toAdd)
							Game.getGrid().add(i);
						toAdd.clear();
						for(Inhabitant i : grid.getAll()) {		
							if(i == null)
								continue;
							if(i instanceof Explosion)
								//increment all Bomb animations
								((Explosion) i).incrementState();
						}
						render();
						tick();
					}
				}, tickLength
		);
	}
	
	public static void queueDestroy(Inhabitant i) {
		System.out.println("Adding to destroy queue: " + i);
		try {
			for(Inhabitant inhabitant : toDestroy)
				if(i.getId().equals(inhabitant.getId()))
					return;
			toDestroy.add(i);
		} catch(NullPointerException npe) {
			return;
		}
	}
	
	public static void queueAdd(Inhabitant i) {
		System.out.println("Adding to add queue: " + i);
		try {
			for(Inhabitant inhabitant : toAdd)
				if(i.getId().equals(inhabitant.getId()))
					return;
			toAdd.add(i);
		} catch(NullPointerException npe) {
			return;
		}
	}
	
	/**
	 * Render the game GUI
	 */
	private static void render() {
		
	}
	
}
