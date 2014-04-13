package package1;

/**
 * Child class of CaseImplementee : the wall of our maze.
 * @author William Marques, Alexandre Bruneau
 *
 */
public class CaseMur extends CaseImplementee {
	
	/**
	 * Constructor that calls mother class' constructor and initiate boolean vasy to false.
	 * @param inPosX X position of the case.
	 * @param inPosY Y position of the case.
	 */
	public CaseMur(int inPosX, int inPosY) {
		super(inPosX, inPosY);
		this.vasy = false;
	}
	
	/**
	 * Basic toString override to display the maze to the user.
	 */
	public String toString() {
		return "X";
	}

}
