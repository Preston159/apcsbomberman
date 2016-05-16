package me.apcs.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	
	private static int tickLength;
	
	private static Grid<Inhabitant> grid;
	private static List<Bomberman> players;
	
	public static void main(String[] args) {
		Settings.init();
		int sizeX = Integer.valueOf(Settings.p.getProperty("gridSizeX"));
		int sizeY = Integer.valueOf(Settings.p.getProperty("gridSizeY"));
		tickLength = (int) ((double) 60 / Integer.valueOf(Settings.p.getProperty("ticksPerSecond")) * 1000);
		grid = new Grid<Inhabitant>(sizeX, sizeY);
		players = new ArrayList<Bomberman>();
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
						ArrayList<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
						for(int a = 0;a < grid.getNumRows();a++)
							for(int b = 0;b < grid.getNumCols();b++) {
								Inhabitant i = grid.get(new Location(a, b));
								if(i == null)
									continue;
								inhabitants.add(i);
							}
						for(Inhabitant i : inhabitants) {
							if(i instanceof Explosion)
								//add one to all Bomb
								((Explosion) i).incrementState();
						}
						render();
						tick();
					}
				}, tickLength
		);
	}
	
	/**
	 * Render the game GUI
	 */
	private static void render() {
		
	}
	
}
