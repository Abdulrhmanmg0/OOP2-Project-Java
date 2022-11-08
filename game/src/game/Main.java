package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel L1;
	public JButton B1,B2,B3;
	public JLabel LM;
	public JPanel P1,P2,P3,P4;
	public Leaderboard LB = new Leaderboard();
	public start ST = new start();
	public JMenuBar mb;
	public JMenu Cont,shortcuts;
	
	public Main() {
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLocation(500,200);
		this.setResizable(false);
		this.setTitle(" Tapping ");
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(Main.class.getResource("/pic/backG.png")).getImage().getScaledInstance(500, 510, Image.SCALE_DEFAULT));
		L1 = new JLabel(imageIcon);
		this.add(L1);
		L1.setLayout(new GridLayout(4,3));
		mb = new JMenuBar();
		
		Cont = new JMenu("contact");	
		Cont.add(new JMenuItem("Abdulrhman 2141138"));
		Cont.add(new JMenuItem("Saif 2140904"));
	
		mb.add(Cont);
		P1 = new JPanel();
		P2 = new JPanel();
		P3 = new JPanel();
		P4 = new JPanel();
		
		LM = new JLabel("");	
		
		B1 = new JButton("Start game");
		B1.setFont(new Font("Arial", Font.PLAIN, 30));
		B1.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
		B1.setContentAreaFilled(false);
		B1.setFocusPainted(false);
		B1.setBorderPainted(false);
		B1.setToolTipText("Click to lunch the game");
		B1.addActionListener(new START());
		B1.setForeground(Color.decode("#000000"));
		
		B2 = new JButton("Champion");
		B2.setFont(new Font("Arial", Font.PLAIN, 30));
		B2.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
		B2.setContentAreaFilled(false);
		B2.setFocusPainted(false);
		B2.setBorderPainted(false);
		B2.setToolTipText("Click to show the Champion");
		B2.addActionListener((new LEADERBOARD()));
		B2.setForeground(Color.decode("#000000"));
		
		B3 = new JButton("Exit");
		B3.setFont(new Font("Arial", Font.PLAIN, 30));
		B3.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
		B3.setContentAreaFilled(false);
		B3.setFocusPainted(false);
		B3.setBorderPainted(false);
		B3.setToolTipText("Click to leave the game");
		B3.addActionListener(new EXiT());
		B3.setForeground(Color.decode("#000000"));
		
		P1.setOpaque(false);
		P2.setOpaque(false);
		P3.setOpaque(false);
		P4.setOpaque(false);
		
		P1.add(LM);
		P2.add(B1);
		P3.add(B2);
		P4.add(B3);
		
		L1.add(P1);
		L1.add(P2);
		L1.add(P3);
		L1.add(P4);
		
		mb.setBackground(Color.decode("#006400"));
		this.setJMenuBar(mb);
		
		this.setVisible(true);
	}
	
	public class START implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ST.setVisible(true);
		}
	}
	
	public class LEADERBOARD implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			LB.setVisible(true);
		}
	}
	
	public class EXiT implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
		new Main();
		
	}
}
