package package3;

import java.io.File;
import java.util.Random;

import package2.FileFormatException;
import package2.ImpossibleMoveException;
import package2.Labyrinthe;

/**
 * Main class. 
 * First we load the file using initFormFile method and we catch the exception if there is a file format problem.
 * Then we move the user randomly until he reaches the goal. If the move is impossible, we catch the exception.
 * We display each step.
 * @author William Marques, Alexandre Bruneau
 *
 */
public class Controler {
	
	public static void main(String[] args) {
		Labyrinthe lab = new Labyrinthe();
		File labFile = new File("labyrinthe.txt");
		Random randomGen = new Random();
		int myRand;
		try {
			lab.initFromFile(labFile);
		} catch (FileFormatException e1) {
			e1.printStackTrace();
		}
		System.out.println("Labyrinthe recupere :");
		lab.print();
		System.out.println("Depart X : "+lab.getDepartX() + " Depart Y : "+lab.getDepartY());
		System.out.println("Arrivee X : "+lab.getArriveeX() + " Arrivee Y : "+lab.getArriveeY());

		while(lab.getPosX()!=lab.getArriveeX() || lab.getPosY()!=lab.getArriveeY()){
			System.out.println("X : " + lab.getPosX() + " Y : " + lab.getPosY());
			myRand=randomGen.nextInt(4);
			try {
				switch (myRand) {
				case 0:
					//up
					lab.move(lab.getPosX(), lab.getPosY()-1);
					break;
				case 1:
					//down
					lab.move(lab.getPosX(), lab.getPosY()+1);
					break;
				case 2:
					//left
					lab.move(lab.getPosX()-1, lab.getPosY());
					break;
				case 3:
					//right
					lab.move(lab.getPosX()+1, lab.getPosY());
					break;

				}		
				
			} catch (ImpossibleMoveException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Done");
	}

}
