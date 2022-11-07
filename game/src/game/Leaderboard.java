package game;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.*;


public class Leaderboard extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JPanel p,b;
	public JButton btn;
	public JLabel ImageLeaderG,Col1,Col2,Col3;
	public Main m;
	String NAME = "", LEVEL = "",SCORE = "";

	public Leaderboard() {
			this.setSize(500, 500);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(true);
			this.setLocation(500,200);
			this.setResizable(false);
			this.setTitle(" Tapping ");
			
			try {
				File f = new File("HighScore.txt");
				Scanner read = new Scanner(f);
				
					String line = read.nextLine();
	                String[] details = line.split(",");        
	                 NAME = details[0];
	                 SCORE = details[1];
	            	 LEVEL = details[2];
	            	read.close();

			} catch (Exception e){e.printStackTrace();}
			
			
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(Main.class.getResource("/pic/LeadrG.png")).getImage().getScaledInstance(500, 510, Image.SCALE_DEFAULT));
			ImageLeaderG = new JLabel(imageIcon);
			
			this.add(ImageLeaderG);
			ImageLeaderG.setLayout(new GridLayout(4,1));
			
			b = new JPanel();
			b.setOpaque(false);
			b.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
			
			p = new JPanel();
			p.setOpaque(false);
			p.setLayout(new GridLayout(1,6));
			
			Col1 = new JLabel(NAME);
			Col1.setFont(new Font("Serif", Font.PLAIN, 20));
			Col2 = new JLabel(LEVEL);
			Col2.setFont(new Font("Serif", Font.PLAIN, 20));
			Col3 = new JLabel(SCORE);
			Col3.setFont(new Font("Serif", Font.PLAIN, 20));
			
			p.add(new JLabel(""));
			p.add(Col1);
			p.add(new JLabel(""));
			p.add(Col2);
			p.add(new JLabel(""));
			p.add(Col3);
			p.add(new JLabel(""));			
			
			btn = new JButton("Back");
			b.add(btn);
			btn.setFont(new Font("Arial", Font.PLAIN, 30));
			btn.setContentAreaFilled(false);
			btn.setFocusPainted(false);
			btn.setBorderPainted(false);
			btn.setToolTipText("Click to go back");
			btn.addActionListener(new Back());
			
			ImageLeaderG.add(new JLabel(""));
			ImageLeaderG.add(p);
			ImageLeaderG.add(new JLabel(""));
			ImageLeaderG.add(b);
	}
	public class Back implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
		}
	}
}
