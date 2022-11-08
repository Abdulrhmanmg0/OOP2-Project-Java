package game;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class ClickPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int Score = 0;
	public int M = 1000;
	public int Mpc = 1;
	public int Hps = 0;
	public int count = 0;
	public int UpgradeCostC = 1;
	public int lvlCLICK = 1;
	public int counter = 0;
	public double playTime;
	
	public JLabel LvlCLICK = new JLabel(" Click Level: "+lvlCLICK);
	public String mpc = String.valueOf(Mpc);
	public String money = String.valueOf(M);
	public JButton Click = new JButton("Click");
	public JButton QUIT = new JButton("QUIT");
	public JButton Details = new JButton("Details");
	public JLabel Money = new JLabel("  Money :" + money);
	public JLabel CB = new JLabel("  Per click :" + mpc); 
	public JLabel score = new JLabel("Score : " + Score);
	public JButton upgrade = new JButton("Upgrade");
	
	DecimalFormat dF =new DecimalFormat("#0.00");
	String name;
	
	public ClickPanel() {
		
		this.setPreferredSize(new Dimension(500,50));
		this.setBackground(Color.decode("#023020"));
		this.setLayout(new GridLayout(1,4));
		this.setForeground(Color.decode("#023020"));
		
		score.setForeground(Color.decode("#000000"));
		LvlCLICK.setForeground(Color.decode("#000000"));
		
		Money.setBorder(BorderFactory.createLineBorder(Color.decode("#023020"),2));
		Money.setForeground(Color.decode("#000000"));
		
		CB.setBorder(BorderFactory.createLineBorder(Color.decode("#023020"),2));
		CB.setForeground(Color.decode("#000000"));
		
		Click.setFont(new Font("Serif", Font.PLAIN, 20));
		Click.addActionListener(new Clicker());
		Click.setBackground(Color.RED);
		Click.setForeground(Color.decode("#000000"));
		Click.setBorder(BorderFactory.createLineBorder(Color.decode("#023020"),2));
		
		upgrade.setFont(new Font("Serif", Font.PLAIN, 20));
		upgrade.addActionListener(new UPGRADEC());
		upgrade.setContentAreaFilled(false);
		upgrade.setFocusPainted(false);
		upgrade.setBorderPainted(false);
		upgrade.setForeground(Color.decode("#000000"));
		
		Details.setFont(new Font("Serif", Font.PLAIN, 20));
		Details.addActionListener(new DETAILS());
		Details.setContentAreaFilled(false);
		Details.setFocusPainted(false);
		Details.setBorderPainted(false);
		Details.setForeground(Color.decode("#000000"));
		
		QUIT.setFont(new Font("Serif", Font.PLAIN, 20));
		QUIT.setContentAreaFilled(false);
		QUIT.setFocusPainted(false);
		QUIT.setBorderPainted(false);
		QUIT.addActionListener(new Quit());
		QUIT.setForeground(Color.decode("#000000"));
		
		
		
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		this.add(upgrade);
		this.add(Click);
		this.add(Details);

	}
	
	public class Clicker implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			M = M + Mpc;
			Score = Score + Mpc;
			Money.setText("   Money : " + M);
			score.setText("Score : " + Score);
		}
	}
	
	public class UPGRADEC implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(M >= 10*UpgradeCostC ) {
				M = M - (10*UpgradeCostC);
				lvlCLICK++;
				Mpc++;
				UpgradeCostC++;
				count++;
				if(count == 2) {Hps++; count = 0;}
				CB.setText("   Per click : " + Mpc);
				Money.setText("   Money : " + M);
				LvlCLICK.setText(" Click Level: " + lvlCLICK);
				score.setText("Score : " + Score);
				
			}else {
				JOptionPane.showMessageDialog(null,"You dont have enough money to upgrade !!");
			}
			
		}	
	}
	public class DETAILS implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Upgrades details: \n  Next Click upgrade cost : "+10*UpgradeCostC+"\n  Passive income : "+Hps);
			}	
	}
	public class Quit implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			name = JOptionPane.showInputDialog( "your time : "+(dF.format(playTime))+"\nyour score : "+Score+"\nProvide User Name:" );
			
			if(name == null) {
					
			}else{
				
				System.exit(0);
			}
		}
	}
	public void PaasiveIncome() {
		
		counter++;	
		if(counter >= 60) {
			counter -= 60;
			M = M + Hps;
			Score = Score + Hps;
			Money.setText("   Money : " + M);
			score.setText("Score : " + Score);
		}
	}
	
	public void TIMER(double time) {
		playTime = time;
	}
}
