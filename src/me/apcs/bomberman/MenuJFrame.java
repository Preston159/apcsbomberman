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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuJFrame extends JFrame {
	//declare fields
	private static final long serialVersionUID = -5402450417506587103L;
	private JPanel contentPane;
	
	public MenuJFrame() {
		//set up JFrame
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create JPanel object and initialize
		JPanel panel = new JPanel();
		panel.setBounds(10, 9, 310, 198);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//create JButton object, initialize, and add ActionListener
		JButton playJButton = new JButton("Play");
		playJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//load game
				JOptionPane.showMessageDialog(contentPane, "Game loads here.", "Bomberman", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		playJButton.setBounds(0, 155, 310, 43);
		
		//add playJButton to panel
		panel.add(playJButton);
		
		//create JLabel object and initialize
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 310, 144);
		panel.add(label);
		label.setIcon(new ImageIcon("intro.png"));
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
}