import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	Random random = new Random();
	int score = 0;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	ObjectManager(Rocketship ship) {
		rocket = ship;
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		rocket.update();
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
	}
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (rocket.rect.intersects(aliens.get(i).rect)) {
		rocket.isActive = false;
			}
		for (int j = 0; j < projectiles.size(); j++) {
			if (projectiles.get(j).rect.intersects(aliens.get(i).rect)) {
				projectiles.get(j).isActive = false;
				aliens.get(i).isActive = false;
				score = score+1;
			}
		}
	}
	}
	int get(){
		return score;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();
		
	}

}
