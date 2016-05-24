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
	
	public GameDebug() {
		//set focus
		setFocusable(true);
		requestFocusInWindow();
		
		//initialize settings
		Settings.init();
		tickLength = (int) ((double) 1 / Integer.valueOf(Settings.p.getProperty("ticksPerSecond")) * 1000);
		int gridSizeX = Integer.valueOf(Settings.p.getProperty("gridSizeX"));
		int gridSizeY = Integer.valueOf(Settings.p.getProperty("gridSizeY"));
		scaleX = WIDTH / gridSizeX;
		scaleY = HEIGHT / gridSizeY;
		Game.createGrid();
		players = new ArrayList<Bomberman>();
		
		//add one Inhabitant
		players.add(new Bomberman(Color.BLUE, new Location(0,0), 0.1, 1, 1));
		Game.queueAdd(players.get(0));
		
		//add a Brick
		Game.queueAdd(new Brick(Color.GRAY, new Location(0, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(1, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(2, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(3, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(4, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(5, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(6, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(7, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(8, 0), false, (ArrayList<Bomberman>) players));
		Game.queueAdd(new Brick(Color.GRAY, new Location(9, 0), false, (ArrayList<Bomberman>) players));
		
		//add a Bomb
		Game.queueAdd(new Bomb(new Location(4,4), 4));
		
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
							Game.getGrid().add(Game.toDestroy.get(i));
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
	
/*	public void actionPerformed(ActionEvent e) {
		time++;
		update();
		repaint();
	}	*/

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

