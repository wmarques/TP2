package package3;

import java.io.File;
import java.util.Random;

import package2.FileFormatException;
import package2.ImpossibleMoveException;
import package2.Labyrinthe;

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
		System.out.println("Arrivé X : "+lab.getArriveeX() + " Arrivé Y : "+lab.getArriveeY());

		while(lab.getPosX()!=lab.getArriveeX() && lab.getPosY()!=lab.getArriveeY()){
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
				System.out.println("X : " + lab.getPosX() + " Y : " + lab.getPosY());
			} catch (ImpossibleMoveException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Done");
	}

}
