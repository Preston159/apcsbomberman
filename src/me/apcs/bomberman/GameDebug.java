package me.apcs.bomberman;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameDebug extends JPanel implements ActionListener {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private int time;
	private List<Bomberman> players;
	private double scaleX, scaleY;
	private Keyboard keys;
	
	public GameDebug() {
		//initialize timer
		time = 0;
		Timer clock = new Timer(15, this);
		clock.start();
		
		//set focus
		setFocusable(true);
		requestFocusInWindow();
		
		//initialize settings
		Settings.init();
		int gridSizeX = Integer.valueOf(Settings.p.getProperty("gridSizeX"));
		int gridSizeY = Integer.valueOf(Settings.p.getProperty("gridSizeY"));
		scaleX = WIDTH / gridSizeX;
		scaleY = HEIGHT / gridSizeY;
		Game.createGrid();
		players = new ArrayList<Bomberman>();
		
		//add one Inhabitant
		players.add(new Bomberman(Color.BLUE, new Location(0,0), 0.1, 1, 1));
		Game.getGrid().add(players.get(0));
		
		//add a Brick
		Game.getGrid().add(new Brick(Color.GRAY, new Location(1, 1), true, (ArrayList<Bomberman>) players));
		
		//set up keyboard actions
		keys = new Keyboard();
		addKeyListener(keys);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Inhabitant i : Game.getGrid().getAll()) {
			i.render(g, scaleX, scaleY);
		}
	}
	
	public void update() {
		for (Inhabitant i : Game.getGrid().getAll()) {
			i.update();
		}
		
		if (keys.getKey(KeyEvent.VK_UP)) {
			players.get(0).move(0.0, -players.get(0).getSpeed());
		}
		if (keys.getKey(KeyEvent.VK_DOWN)) {
			players.get(0).move(0.0, players.get(0).getSpeed());
		}
		if (keys.getKey(KeyEvent.VK_LEFT)) {
			players.get(0).move(-players.get(0).getSpeed(), 0.0);
		}
		if (keys.getKey(KeyEvent.VK_RIGHT)) {
			players.get(0).move(players.get(0).getSpeed(), 0.0);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		time++;
		update();
		repaint();
	}

	public static void main(String[] args) {
		Game.createGrid();
		JFrame w = new JFrame("DEBUG GAME");
		w.setSize(WIDTH, HEIGHT);
		
		Container c = w.getContentPane();
		c.add(new GameDebug());
		
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setResizable(false);
	    w.setVisible(true);
	}
}

