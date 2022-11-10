package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel  extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BufferedImage imageH,imageBG,imagePR,imagePL,imageR,imageCarG,imageCarY,imageCarR;
	public ClickPanel cp;
	double playTime;
	public int ScreenX =500,ScreenY =500;
	int END = 80;
	public int Velocity1 = 2,Velocity2 = 3,Velocity3 = 4;
	public int xDir1 = 50,xDir2 = 50,xDir3 = 50;
	public long cur ;
	public String  c,name,lv,lvl,sc;
	DecimalFormat dF =new DecimalFormat("#0.00");
	int x1=0,x2=0,x3=0;
	Thread gameThread;
	public JButton btn = new JButton("");
	
	public DrawPanel(ClickPanel cp){
		
        this.setPreferredSize(new Dimension(ScreenX,ScreenY));
        this.setBackground(Color.decode("#023020"));
        this.setPreferredSize(new Dimension(500,500));
		this.setBorder(BorderFactory.createLineBorder(Color.black,2));
		setPic();
		this.setLayout(new BorderLayout());
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.addActionListener(new Quit());
		
		this.add(btn);
		this.cp = cp;
	}
	public class Quit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int err=0;
			if(gameThread == null) {
				
				
				name = JOptionPane.showInputDialog("Provide NickName MAXIMUM 5 Char" );
				
				try {
					nameLength(name);
					err = 0;
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					err++;
				}
				if(err == 0) {
					try {
						
						BufferedWriter bw = new BufferedWriter(new FileWriter("HighScore.txt"));
						
						bw.write(name+","+lvl+","+sc);
						bw.close();
						
					} catch (IOException e1) {e1.printStackTrace();}
					
					if(name == null) {
							
					}else{
						
						System.exit(0);
					}
				}
			}
		}	
	}
	public void setPic() {
		try {
			imagePL = ImageIO.read(getClass().getResourceAsStream("/pic/Flowers.png"));
			imagePR = ImageIO.read(getClass().getResourceAsStream("/pic/Tree.png"));
			imageR = ImageIO.read(getClass().getResourceAsStream("/pic/Road.png"));
			imageH = ImageIO.read(getClass().getResourceAsStream("/pic/Hous.png"));
			imageBG = ImageIO.read(getClass().getResourceAsStream("/pic/grass.png"));
			imageCarY = ImageIO.read(getClass().getResourceAsStream("/pic/car.png"));
			imageCarR = ImageIO.read(getClass().getResourceAsStream("/pic/car2.png"));
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();	   
    }
	
	@Override
	public void run() {
	
        while(gameThread != null){
            
            double drawInterval = 1000000000/60;
            
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            
            while(gameThread != null){
            
                currentTime = System.nanoTime();       
                delta += (currentTime - lastTime) / drawInterval;
                lastTime = currentTime;
                
                if(delta >= 1){
                	
                    update();
                    repaint();
                    delta--;
                }
            }
            
            update();
            repaint();
        }	
		
		
	}
	public void houses(Graphics2D g2) {
		int midX =30;
		int midY =100;

				if( cp.playTime <= END) {
					cp.TIMER(playTime += (double)1/40);
					sc = ""+cp.Score;
					lvl = ""+cp.lvlCLICK;
					c = "Score :"+cp.Score;
					lv= "Level :"+cp.lvlCLICK;
				}
					g2.setFont(new Font("Ink Free", Font.BOLD, 20));
			        g2.setColor(Color.black);
					g2.drawString(dF.format(playTime),12, 20);
				
				x1 = x1 + Velocity1;
				if(x1 > 600) {Velocity1 *= -1; xDir1 *= -1;}
				if(x1 < -50) {Velocity1 *= -1; xDir1 *= -1;}
				
				x2 = x2 + Velocity2;
				if(x2 > 600) {Velocity2 *= -1; xDir2 *= -1;}
				if(x2 < -50) {Velocity2 *= -1; xDir2 *= -1;}
				
				x3 = x3 + Velocity3;
				if(x3 > 600) {Velocity3 *= -1; xDir3 *= -1;}
				if(x3 < -50) {Velocity3 *= -1; xDir3 *= -1;}
				
				g2.drawImage(imageH,midX,10,80,80,null);
				g2.drawImage(imageR,0,60,500,100,null);
				
				if(cp.lvlCLICK >= 2) {
					g2.drawImage(imagePL, -10, 25, 50, 50,null);
					g2.drawImage(imagePL, 125, 30, 50, 50,null);
				}
				if(cp.lvlCLICK >= 3) {
					g2.drawImage(imageH,midX+160,10,80,80,null);
					g2.drawImage(imagePR, 100, 25, 50, 50,null);
				}
				if(cp.lvlCLICK >= 4) {
					g2.drawImage(imagePL, 285, 25, 50, 50,null);
					g2.drawImage(imagePL, 420, 30, 50, 50,null);
					g2.drawImage(imagePR, 320, 25, 50, 50,null);
				} 
				if(cp.lvlCLICK >= 5) {
					g2.drawImage(imageH,midX+320,10,80,80,null);
					g2.drawImage(imageCarY,x1,80,xDir1,50,null);
				}
				if(cp.lvlCLICK >= 7) {
					g2.drawImage(imageH,midX,midY,80,80,null);
					g2.drawImage(imagePL, -10, 125, 50, 50,null);
					g2.drawImage(imagePL, 125, 130, 50, 50,null);
					g2.drawImage(imageR,0,150,500,100,null);
				}
				if(cp.lvlCLICK >= 8) {
					g2.drawImage(imageH,midX+160,midY,80,80,null);
					g2.drawImage(imagePR, 100, 125, 50, 50,null);
					
				}
				if(cp.lvlCLICK >= 9) {
					g2.drawImage(imagePL, 285, 125, 50, 50,null);
					g2.drawImage(imagePL, 420, 130, 50, 50,null);
					g2.drawImage(imagePR, 320, 125, 50, 50,null);
				} 
				if(cp.lvlCLICK >= 10) {
					g2.drawImage(imageH,midX+320,midY,80,80,null);
					g2.drawImage(imageCarR,x2+50,180,xDir2,50,null);
				}
				if(cp.lvlCLICK >= 12) {
					g2.drawImage(imageH,midX,midY+100,80,80,null);
					g2.drawImage(imagePL, -10, 225, 50, 50,null);
					g2.drawImage(imagePL, 125, 230, 50, 50,null);
					g2.drawImage(imageR,0,250,500,100,null);
				}
				if(cp.lvlCLICK >= 13) {
					g2.drawImage(imageH,midX+160,midY+100,80,80,null);
					g2.drawImage(imagePR, 100, 225, 50, 50,null);
	
					
				}
				if(cp.lvlCLICK >= 14) {
					g2.drawImage(imagePL, 285, 225, 50, 50,null);
					g2.drawImage(imagePL, 420, 230, 50, 50,null);
					g2.drawImage(imagePR, 320, 225, 50, 50,null);
				} 
				if(cp.lvlCLICK >= 15) {
					g2.drawImage(imageH,midX+320,midY+100,80,80,null);
					g2.drawImage(imageCarY,x3,280,xDir3,50,null);
				}
				
				if(cp.playTime >= END) {
					
					g2.setColor(new Color(0,0,0,70));
					g2.fillRect(100, 100, 270, 170);
					g2.setColor(Color.black);
					String text  = "Time Out";
					g2.setFont(new Font("Ink Free", Font.BOLD, 30));
					g2.drawString(text, 165, 200);
					g2.drawString(c, 165, 170);
					cp.LvlCLICK.setText("");
					cp.CB.setText("");
					cp.Money.setText("");
					cp.score.setText("");
					g2.drawString("click anywhere", 145, 350);
					gameThread = null ;
					
					}
			}
	

	public void drawbackground(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0; 
		int y = 0;
		
			while(col < 5 && row < 5 ) {
				
				g2.drawImage(imageBG,x,y,100,100,null);
				
				col++;
				
				x += 100;
				
				if(col == 5) {
					col = 0;
					x = 0;
					row++;
					y += 100;
				}
			}
	}
	

	public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        drawbackground(g2);
        houses(g2);
        g2.dispose();
	}
	public void update() {
		cp.PaasiveIncome();
	}
	public void nameLength(String s)throws Exception {
		
		if(s.length() > 5) {
			throw new Exception("Please enter 5 char as miaximum");
		}
		
		return;
	}
}