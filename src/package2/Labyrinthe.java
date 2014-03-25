package package2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import package1.Case;

public class Labyrinthe {
	
	private Case tab[][];
	public int tailleX, tailleY;
	public int departX, departY;
	public int arriveeX, arriveeY;
	private int posX, posY;
	
	public void initFromFile(File lab) {
		BufferedReader lect;
		String tmp="";
		try
		{
			lect = new BufferedReader(new FileReader(lab));
			tmp = lect.readLine();
			tailleX = (int)(tmp.charAt(0) - '0');
			tailleY = (int)(tmp.charAt(2) - '0');
			departX = (int)(tmp.charAt(4) - '0');
			departY = (int)(tmp.charAt(6) - '0');
			arriveeX = (int)(tmp.charAt(8) - '0');
			arriveeY = (int)(tmp.charAt(10) - '0');
			for(int i=0; i<tailleX;i++) {
				for(int j=0; j<tailleY;j++) {
					
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Null Pointer");
		}
		catch(IOException e)
		{
			System.out.println("IO Issue");
		}
	}
}
