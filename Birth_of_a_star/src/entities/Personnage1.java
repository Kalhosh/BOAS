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

	public Personnage1(Coordinates coords, IMap area) {
		super(coords, area);
	}

	static boolean charged = false;
	static BufferedImage sprite = null;
	
	@Override
	public void display(DisplayInfo info, Coordinates position, Graphics2D g, ImageObserver io) {

		System.out.println("Affichage");
		
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
			info.displayImage(sprite, coords, g, new Rectangle(0,0,32,32), io);
		else
			System.err.println("Erreur image");
		
	}

	@Override
	protected void move(Movement direction) {
		// TODO Auto-generated method stub
		
	}

}
