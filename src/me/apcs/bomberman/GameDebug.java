package me.apcs.bomberman;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyEvent;

public class GameDebug extends JPanel implements ActionListener {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private int time = 0;
	private Grid<Inhabitant> grid;
	private List<Bomberman> players;
	private double scaleX, scaleY;
	private Keyboard keys;
	
	public GameDebug() {
		//initialize timer
		time = 0;
		Timer clock = new Timer(30, this);
		clock.start();
		
		//initialize settings
		Settings.init();
		int gridSizeX = Integer.valueOf(Settings.p.getProperty("gridSizeX"));
		int gridSizeY = Integer.valueOf(Settings.p.getProperty("gridSizeY"));
		scaleX = WIDTH / gridSizeX;
		scaleY = HEIGHT / gridSizeY;
		grid = new Grid<Inhabitant>(gridSizeX, gridSizeY);
		players = new ArrayList<Bomberman>();
		keys = new Keyboard();
		addKeyListener(keys);
		
		//add one Inhabitant
		players.add(new Bomberman(Color.BLUE, new Location(0,0), 1, 1, 1));
		grid.add(players.get(0));
	}
	
	public void render() {
		for (Location loc : grid.getOccupiedLocations()) {
			grid.get(loc).render(this.getGraphics(), scaleX, scaleY);
		}
	}
	
	public void update() {
		if (keys.getKey(KeyEvent.VK_D)) {
			players.get(0).move(0.1, 0.0);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		time++;
		update();
		render();
	}

	public static void main(String[] args) {
		JFrame w = new JFrame("DEBUG GAME");
		w.setSize(WIDTH, HEIGHT);
		Container c = w.getContentPane();
		c.add(new GameDebug());
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setResizable(false);
	    w.setVisible(true);
	}
}
