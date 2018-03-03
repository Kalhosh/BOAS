package entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import resources.Coordinates;
import resources.DisplayInfo;
import resources.Rectangle;

public class Personnage1 extends Human{

	private MovementAnimation animation;
	private Rectangle etat;
	
	public Personnage1(Coordinates coords, IMap area) {
		super(coords, area);
		etat = new Rectangle(0, 0, 32, 32);
	}

	static boolean charged = false;
	static BufferedImage sprite = null;
	
	@Override
	public void display(DisplayInfo info, Coordinates position, Graphics2D g, ImageObserver io) {
		
		if(!charged) {
			
			try {
				sprite = ImageIO.read(new File("Images/Sprites/perso1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(sprite != null)
				charged = true;
			
		}
		
		if(sprite != null)
			info.displayImage(sprite, coords, g, etat, io);
		else
			System.err.println("Erreur image");
		
	}

	@Override
	protected void move(Movement direction) {
		
		if(animation == null || !animation.running) {
			
			animation = new MovementAnimation(direction);
			Thread t = new Thread(animation);
			
			t.start();
			
		}
		
	}
	
	public int indexZImage(Movement m) {
		switch(m) {
		case MOVE_DOWN:
			return 0;
		case MOVE_LEFT:
			return 3;
		case MOVE_RIGHT:
			return 2;
		case MOVE_UP:
			return 1;
		default:
			break;
		}
		return 0;
	}
	
	private class MovementAnimation implements Runnable{
		
		Movement direction;
		boolean running;
		
		public MovementAnimation(Movement direction) {
			this.direction = direction;
			this.running = false;
		}
		
		public void run() {
			
			running = true;
			
			int dx = (int) Math.cos(direction.ordinal()*Math.PI/2);
			int dy = (int) Math.sin(direction.ordinal()*Math.PI/2);
			
			for(int i = 0; i < 32; i ++) {
				
				etat.move(i/8*32, 32*indexZImage(direction));
				
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				coords.add(dx, dy);
				
			}
			
			etat.move(0, 32*indexZImage(direction));
			
			running = false;
			
		}
		
	}

}
