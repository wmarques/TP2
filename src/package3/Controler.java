package package3;

import java.io.File;

import package2.FileFormatException;
import package2.ImpossibleMoveException;
import package2.Labyrinthe;

public class Controler {

	public static void main(String[] args) {
		Labyrinthe lab = new Labyrinthe();
		File labFile = new File("labyrinthe.txt");
		try {
			lab.initFromFile(labFile);
		} catch (FileFormatException e1) {
			e1.printStackTrace();
		}
		try {
			lab.move(2, 1);
		} catch (ImpossibleMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
