import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame gameFrame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gamePanel = new GamePanel();
	public static void main(String[] args) {
		LeagueInvaders leaugeInvaders = new LeagueInvaders();
		
	}
	LeagueInvaders(){
		gameFrame = new JFrame();
		setup();
	gameFrame.addKeyListener(gamePanel);
		
	}
	void setup(){
		gameFrame.add(gamePanel);
		gameFrame.setSize(WIDTH, HEIGHT);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
