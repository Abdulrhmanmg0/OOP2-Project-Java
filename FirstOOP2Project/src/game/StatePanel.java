package game;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;


public class StatePanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ClickPanel cp;
	DecimalFormat dF =new DecimalFormat("#0.00");
	public String name;
	
	
	
	public StatePanel(ClickPanel cp) {
		
		this.setPreferredSize(new Dimension(320,40));
		this.setBackground(Color.decode("#023020"));
		this.setLayout(new GridLayout(1,5));
		this.cp = cp;
		this.add(cp.Money);
		this.add(cp.CB);
		this.add(cp.LvlCLICK);
		this.add(cp.score);
	}		
}
