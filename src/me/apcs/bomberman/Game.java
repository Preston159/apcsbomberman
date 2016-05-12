package me.apcs.bomberman;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private Grid<Inhabitant> grid;
	private List<Bomberman> players;
	
	public void init() {
		Settings.init();
		int sizeX = Integer.valueOf(Settings.p.getProperty("gridSizeX"));
		int sizeY = Integer.valueOf(Settings.p.getProperty("gridSizeY"));
		grid = new Grid<Inhabitant>(sizeX, sizeY);
		players = new ArrayList<Bomberman>();
	}
	
	/**
	 * The <code>Grid</code> of the current game
	 * @return	The <code>Grid<Inhabitant></code>of the current game
	 */
	public Grid<Inhabitant> getGrid() {
		return grid;
	}
	
	/**
	 * A <code>List</code> of all current <code>Bomberman</code>s
	 * @return	</code>ArrayList<Bomberman></code> containing all <code>Bomberman</code>s on the <code>Grid</code>
	 */
	public List<Bomberman> getPlayers() {
		return players;
	}
	
}
