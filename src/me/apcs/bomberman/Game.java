package me.apcs.bomberman;

public class Game {
	
	private static Grid<Inhabitant> grid;
	
	public static void main(String[] args) {
		Settings.init();
	}
	
	/**
	 * The <code>Grid</code> of the current game
	 * @return	The <code>Grid<Inhabitant></code>of the current game
	 */
	public static Grid<Inhabitant> getGrid() {
		return grid;
	}
	
}
