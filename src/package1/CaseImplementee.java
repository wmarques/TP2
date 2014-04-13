package package1;

/**
 * Mother class of CaseMur and CaseTrou that implements Case interface.
 * @author William Marques, Alexandre Bruneau
 *
 */
public class CaseImplementee implements Case {
	protected int posX, posY;
	protected boolean vasy;

	@Override
	public int getPositionX() {
		return posX;
	}

	@Override
	public int getPositionY() {
		return posY;
	}

	@Override
	public boolean canMoveToCase() {
		return vasy;
	}
	
	public CaseImplementee(int inPosX, int inPosY) {
		this.posX = inPosX;
		this.posY = inPosY;
	}

}
