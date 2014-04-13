package package2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import package1.Case;
import package1.CaseMur;
import package1.CaseTrou;

/**
 * Our model class that contains all necessary methods.
 * @author William Marques, Alexandre Bruneau
 *
 */
public class Labyrinthe {
	
	/**
	 * Array of Case objects, that's the maze.
	 */
	private Case tab[][];
	
	/**
	 * Length of the maze (that's the length of the tab array too).
	 */
	public int tailleX, tailleY;
	
	/**
	 * Starting coordinates.
	 */
	public int departX, departY;
	/**
	 * Ending coordinates.
	 */
	public int arriveeX, arriveeY;
	/**
	 * User's coordinates.
	 */
	private int posX, posY;

	public int getDepartX() {
		return departX;
	}

	public int getDepartY() {
		return departY;
	}

	public int getArriveeX() {
		return arriveeX;
	}

	public int getArriveeY() {
		return arriveeY;
	}
	
	/**
	 * This method will load parameters, check them and load the maze into the tab array.
	 * @param lab File that contains parameters and maze.
	 * @throws FileFormatException Thrown if there is a problem in the file.
	 */
	public void initFromFile(File lab) throws FileFormatException {
		BufferedReader lect;
		String tmp="";
		try
		{
			lect = new BufferedReader(new FileReader(lab));
			tmp = lect.readLine();
			if(tmp.length()!=11) {
				lect.close();
				throw new FileFormatException("Param�tres manquants ou en trop !");
			}
				//Conversion from char to int
				tailleX = (int)(tmp.charAt(0) - '0');
				tailleY = (int)(tmp.charAt(2) - '0');
				departX = (int)(tmp.charAt(4) - '0');
				departY = (int)(tmp.charAt(6) - '0');
				arriveeX = (int)(tmp.charAt(8) - '0');
				arriveeY = (int)(tmp.charAt(10) - '0');
			
			
			if(tailleX<1 || tailleY<1 || departX <0 || departX>tailleX-1 || departY<0 || departY>tailleY-1
					|| arriveeX <0 || arriveeX>tailleX-1 || arriveeY<0 || arriveeY>tailleY-1) {
				lect.close();
				throw new FileFormatException("Parametres taille, depart ou arrivee incorrects");
			}

			tab = new Case[tailleX][tailleY];

			for(int i=0; i<tailleX;i++) {
				tmp = lect.readLine();
				for(int j=0; j<tailleY;j++) {
					if(tmp.charAt(j)=='_') tab[i][j] = new CaseTrou(i,j);
					else if(tmp.charAt(j)=='X') tab[i][j] = new CaseMur(i,j);
				}	
			}
			lect.close();
		}
		catch(NullPointerException e)
		{
			throw new FileFormatException("Null Pointer Exception !");
		}
		catch(IOException e)
		{
			throw new FileFormatException("IO Issue");
		}
	}
	
	/**
	 * Check if the move is possible (no wall, no out of the maze), if yes it updates posX and posY.
	 * @param x x position where the user want to go.
	 * @param y y position where the user want to go.
	 * @throws ImpossibleMoveException if the move is impossible.
	 */
	public void move(int x, int y) throws ImpossibleMoveException {
		if(x>tailleX-1 || x<0 || y>tailleY-1 || y<0 || tab[y][x].canMoveToCase()==false) 
			throw(new ImpossibleMoveException("Mouvement impossible en X:" + x + " et Y:" + y));
		else {
			posX = x;
			posY = y;
		}
	}
	
	/**
	 * Initialize randomly posX and posY
	 */
	public void automove() {
		Random randomGenerator = new Random();
		posX = randomGenerator.nextInt(tailleX);
		posY = randomGenerator.nextInt(tailleY);
	}
	
	/**
	 * Display the maze, using toString methods of CaseTrou and CaseMur.
	 */
	public void print () {
		for(int i=0;i<tailleX;i++) {
			System.out.println();
			for(int j=0;j<tailleY;j++) {
				System.out.print(tab[i][j].toString());
			}
		}
		System.out.println();
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
