package me.apcs.bomberman;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameDebug extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3892977334156950067L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private static int tickLength;
	
	private int time;
	private List<Bomberman> players;
	private double scaleX, scaleY;
	private Keyboard keys;
	
	private static int gridSizeX;
	private static int gridSizeY;
	
	public GameDebug() {
		//set focus
		setFocusable(true);
		requestFocusInWindow();
		
		//initialize settings
		Settings.init();
		tickLength = (int) ((double) 1 / Integer.valueOf(Settings.p.getProperty("ticksPerSecond")) * 1000);
		gridSizeX = Integer.valueOf(Settings.p.getProperty("gridSizeX"));
		gridSizeY = Integer.valueOf(Settings.p.getProperty("gridSizeY"));
		scaleX = WIDTH / gridSizeX;
		scaleY = HEIGHT / gridSizeY;
		Game.createGrid();
		players = new ArrayList<Bomberman>();
		
		//add one Inhabitant
		players.add(new Bomberman(Color.BLUE, new Location(1,1), 0.1, 1, 2));
		Game.queueAdd(players.get(0));
		
		//add some Bricks
		ArrayList<Brick> bricks = genBricks();
	
		for(Brick b : bricks)
			Game.queueAdd(b);
		
	/*	for (int i = 0; i < 7; i++) {
			Game.queueAdd(new Brick(Color.GRAY, new Location((int)(Math.random() * gridSizeX), (int)(Math.random() * gridSizeY)), false, (ArrayList<Bomberman>) players));
		}	*/
		
		//set up keyboard actions
		keys = new Keyboard();
		addKeyListener(keys);
		players.get(0).setKey(keys);
		
		update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0;i < Game.getGrid().getAll().size();i++)
			Game.getGrid().getAll().get(i).render(g, scaleX, scaleY);
	}
	
	public void update() {
		new Timer().schedule(
				new TimerTask() {
					@Override
					public void run() {
						for(int i = 0;i < Game.toDestroy.size();i++)
							Game.getGrid().remove(Game.toDestroy.get(i));
						Game.toDestroy.clear();
						for(int i = 0;i < Game.toAdd.size();i++)
							Game.getGrid().add(Game.toAdd.get(i));
						Game.toAdd.clear();
						for(int i = 0;i < Game.getGrid().getAll().size();i++)
							try {
								Game.getGrid().getAll().get(i).update();
							} catch(NullPointerException npe) { }
						//
						time++;
						repaint();
						update();
					}
				}, tickLength
		);
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
	
	private static ArrayList<Brick> genBricks() {
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(1, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(2, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(3, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(4, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(5, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(6, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(7, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(8, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 0), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(1, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(2, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(3, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(4, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(5, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(6, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(7, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(8, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 9), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 1), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 1), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 2), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 2), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 3), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 3), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 4), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 4), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 5), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 5), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 6), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 6), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 7), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 7), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(0, 8), false));
		bricks.add(new Brick(Color.DARK_GRAY, new Location(9, 8), false));
		for(int i = 0;i < 8;i++) {
			Location l = new Location((int) (Math.random() * gridSizeX), (int) (Math.random() * gridSizeY));
			if(!Game.getGrid().isEmpty(l))
				continue;
			bricks.add(new Brick(Color.GRAY, l, true));
		}
		return bricks;
	}
}

