package package1;


public class CaseImplementee implements Case {
	protected int posX, posY;
	protected boolean vasy;

	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canMoveToCase() {
		// TODO Auto-generated method stub
		return vasy;
	}
	
	public CaseImplementee(int inPosX, int inPosY) {
		this.posX = inPosX;
		this.posY = inPosY;
	}

}
