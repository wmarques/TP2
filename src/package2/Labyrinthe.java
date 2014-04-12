package package2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import package1.Case;
import package1.CaseMur;
import package1.CaseTrou;

public class Labyrinthe {

	private Case tab[][];
	public int tailleX, tailleY;
	public int departX, departY;
	public int arriveeX, arriveeY;
	private int posX, posY;

	public void initFromFile(File lab) throws FileFormatException {
		BufferedReader lect;
		String tmp="";
		try
		{
			lect = new BufferedReader(new FileReader(lab));
			tmp = lect.readLine();
			if(tmp.length()!=11) {
				lect.close();
				throw new FileFormatException("Paramètres manquants ou en trop !");
			}
			
				tailleX = (int)(tmp.charAt(0) - '0');
				tailleY = (int)(tmp.charAt(2) - '0');
				departX = (int)(tmp.charAt(4) - '0');
				departY = (int)(tmp.charAt(6) - '0');
				arriveeX = (int)(tmp.charAt(8) - '0');
				arriveeY = (int)(tmp.charAt(10) - '0');
			
			
			if(tailleX<1 || tailleY<1 || departX <0 || departX>tailleX-1 || departY<0 || departY>tailleY-1
					|| arriveeX <0 || arriveeX>tailleX-1 || arriveeY<0 || arriveeY>tailleY-1) {
				lect.close();
				throw new FileFormatException("Paramètres taille, depart ou arrivée incorrects");
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

	public void move(int x, int y) throws ImpossibleMoveException {
		if(x>tailleX-1 || x<0 || y>tailleY-1 || y<0 || tab[x][y].canMoveToCase()==false) 
			throw(new ImpossibleMoveException("Mouvement impossible!"));
		else {
			posX = x;
			posY = y;
		}
	}

	public void automove() {
		Random randomGenerator = new Random();
		posX = randomGenerator.nextInt(tailleX);
		posY = randomGenerator.nextInt(tailleY);
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
