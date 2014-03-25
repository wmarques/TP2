package package3;

import java.io.File;

import package2.Labyrinthe;

public class Controler {

	public static void main(String[] args) {
		Labyrinthe lab = new Labyrinthe();
		File labFile = new File("labyrinthe.txt");
		lab.initFromFile(labFile);
	}

}
