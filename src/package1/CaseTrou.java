package package1;
/**
 * Child class of CaseImplementee : the hole of our maze.
 * @author William Marques, Alexandre Bruneau
 *
 */
public class CaseTrou extends CaseImplementee {
	
	/**
	 * Constructor that calls mother class' constructor and initiate boolean vasy to true.
	 * @param inPosX X position of the case.
	 * @param inPosY Y position of the case.
	 */
	public CaseTrou(int inPosX, int inPosY) {
		super(inPosX, inPosY);
		this.vasy = true;
	}
	
	/**
	 * Basic toString override to display the maze to the user.
	 */
	public String toString() {
		return "_";
	}

}
