package game;


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class start extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JPanel W,E,N,S,C;

	public start() {
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLocation(500,200);
		this.setResizable(false);
		this.setTitle(" Tapping ");
		
		W = new JPanel();
		E = new JPanel();
		ClickPanel cp = new ClickPanel();
		StatePanel sp = new StatePanel(cp);
		DrawPanel vp = new DrawPanel(cp);
        
		W.setBackground(Color.decode("#023020"));
		E.setBackground(Color.decode("#023020"));
		
		add(W,BorderLayout.EAST);
		add(sp,BorderLayout.NORTH);
		add(E,BorderLayout.WEST);
		add(cp,BorderLayout.SOUTH);
		add(vp,BorderLayout.CENTER);
		
		vp.startGameThread();
		
		
	}
	
}
