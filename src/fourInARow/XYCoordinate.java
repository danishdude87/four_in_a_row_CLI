package fourInARow;

//package dm550.tictactoe;

public class XYCoordinate implements Coordinate {

	/** variables specifying horizontal position on the board */
	private int x;

	/** variable specifying vertical positoin on the board */
	private int y;

	/** constructor creating a Coordinate from x and y values */
	public XYCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public boolean checkBoundaries(int xSize, int ySize) {
		if ((x >= 0 && x < xSize) && (y >= 0 && y < ySize )) {
		if ((x >= 0 && x < xSize) && (y >= 0 && y < ySize)) {
				return true;
		}
	}
		return false;}

	public Coordinate shift(int dx, int dy) {
		return new XYCoordinate(this.x+dx,this.y+dy);
	}

	@Override
	public Coordinate shift(Coordinate start, int dx, int dy) {
		// TODO Auto-generated method stub
		return null;
	}

}