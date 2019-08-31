import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font titleFont1 = new Font("Arial", Font.PLAIN, 28);
    Font titleFont2 = new Font("Arial", Font.PLAIN, 28);
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
	GamePanel(){
		
	}
	void updateMenuState() { 
		
	}
	 void updateGameState() {  
		 
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 
	 }
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 75, 150);

	 }
}
