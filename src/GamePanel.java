import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font titleFont1 = new Font("Arial", Font.PLAIN, 28);
    Font titleFont2 = new Font("Arial", Font.PLAIN, 28);
    Timer frameDraw;
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    Rocketship rocketship = new Rocketship(250,700,50,50);
    ObjectManager objectManager = new ObjectManager(rocketship);
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
			
		    drawGameState(g);
		}else if(currentState == END){
			
		    drawEndState(g);
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	GamePanel(){
		 frameDraw = new Timer(1000/60,this);
		    frameDraw.start();
		    if (needImage) {
		        loadImage ("space.png");
		    }
	}
	void updateMenuState() { 
		
	}
	 void updateGameState() {  
		 objectManager.update();
	 }
	 void updateEndState()  { 
		 
	 }
	void drawMenuState(Graphics g) {  
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("League Invaders", 75, 150);
		g.setFont(titleFont1);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to start", 100, 450);
		g.setFont(titleFont2);
		g.setColor(Color.WHITE);
		g.drawString("Press SPACE for instructions", 50, 600);

	 }
	void drawGameState(Graphics g) { 
		
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		objectManager.draw(g);
	 }
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 150);
		g.setFont(titleFont1);
		g.setColor(Color.BLACK);
		g.drawString("You killed  enemies!", 100, 400);
		g.setFont(titleFont1);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 80, 550);
	 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}	
		if(currentState == GAME){
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    if (rocketship.y > 0) {
		    rocketship.up();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    if (rocketship.y + rocketship.height < LeagueInvaders.HEIGHT) {
		    rocketship.down();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    if (rocketship.x + rocketship.width < LeagueInvaders.WIDTH) {	
		    rocketship.right();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    if (rocketship.x > 0) {
		    rocketship.left();
		    }
		}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
}
