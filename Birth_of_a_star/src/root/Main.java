package root;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import algorithms.OptimiserTag;
import algorithms.Path;
import algorithms.Pathfinding;
import display_modes.GamePanel;
import map_exceptions.InvalidMapDimensionException;
import map_exceptions.OutOfMapBoundsException;
import maps.AbstractMap;
import path_exceptions.PathIndexOutOfBoundsException;
import resources.AbstractGround;
import resources.Coordinates;
import resources.DisplayInfo;

public class Main {

	public static void testPathfinding() throws InvalidMapDimensionException, OutOfMapBoundsException {
		
		// test pathfinding
		
		int taille = 60;
		int size = 10;
		
		AbstractGround obstacle = new AbstractGround() {
			
			public boolean canPassThrough() {
				return false;
			}

			@Override
			public void display(DisplayInfo info, Coordinates position, Graphics2D g, ImageObserver io) {
				
			}
			
		};
		
		AbstractGround vide = new AbstractGround() {
			
			public boolean canPassThrough() {
				return true;
			}

			@Override
			public void display(DisplayInfo info, Coordinates position, Graphics2D g, ImageObserver io) {
				
			}
			
		};
		
		AbstractMap m = new AbstractMap(taille,taille) {

			public void fillMap() {
				
				for(int i = 0; i < getWidth(); i++) {
					
					for(int j = 0; j < getHeight(); j++) {
						
						if(Math.random() < 0.3d)
							addGround(obstacle, i, j);
						else
							addGround(vide, i, j);
						
					}
					
				}
					
			}
			
		};
		
		Pathfinding p = new Pathfinding(m);
		
		Coordinates p1 = new Coordinates(5, 5);
		Coordinates p2 = new Coordinates(taille - 5, taille - 5);
		
		// affichage
		
		JPanel jp = new JPanel() {

			/**
			 * osef
			 */
			private static final long serialVersionUID = -7464773642467514756L;
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				Graphics2D g2d = (Graphics2D)g;
				
				Coordinates bufferPoint = new Coordinates();
				Rectangle2D bufferRectangle = new Rectangle2D.Double();
				
				// cases de la carte
				for(int i=0; i < taille; i ++) {
					
					for(int j=0; j < taille; j++) {
						
						bufferPoint.setCoordinates(i, j);
						if(m.canPassThrough(bufferPoint))
							g2d.setPaint(Color.WHITE);
						else
							g2d.setPaint(new Color(0,0,0,100));
							
						bufferRectangle.setRect(i*size, j*size, size, size);
						g2d.fill(bufferRectangle);
						
					}
					
				}
				
				// time values
				
				long BEGIN;
				long END;
				
				// path
				
				Path path1 = null;
				Path path2 = null;
				try {
					
					BEGIN = System.nanoTime();
					path1 = p.findShortestPath(p1,p2,OptimiserTag.DISTANCE_OPTIMISER);
					END = System.nanoTime();
					
					System.out.println("Duree d'execution (Fast) : " + (END - BEGIN)/1000 + " ùs"); 
					if(path1 != null)
						System.out.println("PathLength : " + path1.size());
					else
						System.out.println("pas de chemin");
					
					BEGIN = System.nanoTime();
					path2 = p.findShortestPath(p1,p2,OptimiserTag.NONE);
					END = System.nanoTime();
					
					System.out.println("Duree d'execution (Brute) : " + (END - BEGIN)/1000 + " ùs"); 
					if(path2 != null)
						System.out.println("PathLength : " + path2.size());
					else
						System.out.println("pas de chemin");
					
				} catch (OutOfMapBoundsException e1) {
					e1.printStackTrace();
				}
				
				g2d.setPaint(new Color(150,0,255,100));
				
				while(path1 != null && path1.hastNext()) {
					
					Coordinates p = null;
					try {
						
						p = path1.next();
						
					} catch (PathIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
					
					if(p != null) {
						int x = p.getX();
						int y = p.getY();
						
						bufferRectangle.setRect(x*size, y*size, size, size);
						
						g2d.fill(bufferRectangle);
						
					}
					
				}
				
				g2d.setPaint(new Color(0,189,120,100));
				
				while(path2 != null && path2.hastNext()) {
					
					Coordinates p = null;
					try {
						
						p = path2.next();
						
					} catch (PathIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
					
					if(p != null) {
						int x = p.getX();
						int y = p.getY();
						
						bufferRectangle.setRect(x*size, y*size, size, size);
						
						g2d.fill(bufferRectangle);
						
					}
					
				}
				
				g2d.setPaint(Color.BLUE);
				bufferRectangle.setRect(p1.getX()*size, p1.getY()*size, size, size);
				g2d.fill(bufferRectangle);
				
				g2d.setPaint(Color.GREEN);
				bufferRectangle.setRect(p2.getX()*size, p2.getY()*size, size, size);
				g2d.fill(bufferRectangle);
				
			}
			
		};
		
		JFrame j = new JFrame("test pathfinding");
		
		j.setSize(620, 645);
		j.add(jp);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		
		// fin test pathfinding
		
	}
	
	public static void main(String[] args) throws IOException, InvalidMapDimensionException{
		
		JFrame test = new JFrame();
		GamePanel gp = new GamePanel();
		test.setContentPane(gp);
		test.setSize(500,500);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
		
	}

}
