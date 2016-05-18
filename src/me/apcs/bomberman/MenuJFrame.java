/**
 * MenuJFrame.java
 * @author Logan Kulinski
 */

package me.apcs.bomberman;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class MenuJFrame extends JFrame {
	//declare fields
	private static final long serialVersionUID = -5402450417506587103L;
	private JPanel contentPane;
	
	public MenuJFrame() {
		setResizable(false);
		//set up JFrame
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create JPanel object and initialize
		JPanel panel = new JPanel();
		panel.setBounds(17, 15, 310, 198);
		contentPane.add(panel);
		panel.setLayout(null);
		
	// beginning of play button, moved to menu bar but in case y'all want to shift back old code is here
		//create JButton object, initialize, and add ActionListener
		//JButton playJButton = new JButton("Play");
		//playJButton.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent arg0) {
		//		//load game
		//		JOptionPane.showMessageDialog(contentPane, "Game loads here.", "Bomberman", JOptionPane.INFORMATION_MESSAGE);
		//	}
		//});
		//playJButton.setBounds(0, 155, 310, 43);
		
		//add playJButton to panel
		//panel.add(playJButton);
	// 	end of play button
		
		//create JLabel object and initialize
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 310, 144);
		panel.add(label);
		label.setIcon(new ImageIcon("intro.png"));
		
		// menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		JMenuItem play = new JMenuItem("Play");
		JMenuItem help = new JMenuItem("Help");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem highScores = new JMenuItem("High Scores");
		menuBar.add(mnGame);
		mnGame.add(play);
		mnGame.add(help);
		mnGame.add(exit);
		mnGame.add(highScores);
		play.addActionListener(new ActionListener() { // play
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(null,  "Game loads here", "Bomberman", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		help.addActionListener(new ActionListener() { // disps instructs; go to dispInstructs() to edit instructions
			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(null,  dispInstructs(), "Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		exit.addActionListener(new ActionListener() { // exits prog
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});
		highScores.addActionListener(new ActionListener() { // gets strBuffer from loadFile() and disps in message box
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(null, loadFile(), "High Scores", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		
		JMenuItem mntmWhyHello = new JMenuItem("");
		menuBar.add(mntmWhyHello);
	} //MenuJFrame
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJFrame frame = new MenuJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} //main
	public String dispInstructs()
	{
		return "Why hello, welcome to the wonderful world of Bomberman, where you can drop bombs and blow up bricks and stuff."
				+ "\nThere are powerups that I'll remember to put up later.  Instructions:  use keypad, press some button to drop bombs."
				+ "  Go cubs";
	}
	// read scores from scores.txt, called in high scores button in menu bar above
	public static StringBuffer loadFile()
	{
		String path = "scores.txt";
		try
		{
			
			File file = new File(path);
			StringBuffer strBuffer = new StringBuffer((int)file.length());
			BufferedReader input = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = input.readLine()) != null)
			{
				strBuffer.append(line);
				strBuffer.append("\n");
			}
			input.close();
			return strBuffer;
		}
		catch (IOException io)
		{
			StringBuffer error = new StringBuffer();
			return error.append("RUH ROH Can't find " + path);
		}
	}
}