package knight_for_the_win.components;

import knight_for_the_win.exceptions.PositionException;

/**
 * 
 * @author Kaloyan Tsenov
 * @see Position.{@link #x}
 * @see Position.{@link #y}
 */
public class Position {
	private final static int MIN_POSITION = 1;
	private final static int STUCK_POSITION = 2;
	private final static int MAX_POSITION = 3;
	private final static int WIN_POSITION = 3;
	
	/**
	 * Chess piece column
	 */
	private int x;
	
	/**
	 * Chess piece row
	 */
	private int y;
	
	/**
	 * Constructor, sets the object starting coordinations
	 * @param x - chess piece column
	 * @param y - chess pice row
	 * @throws PositionException - occurs when the params x and y are not legal
	 */
	public Position(int x, int y) throws PositionException {
		// don`t give the position to be accepted if it`s not legal
		if(!isPositionOnBoard(x, y) || !isLegalStartPosition(x, y)) {
			throw new PositionException("You can`t start on the final "
					+ "or stuck position: " + x + " " + y);
		}
		setPositionCoordinates(x, y);
	}
	
	//setter for x - column and y - row
	public void setPositionCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// getter for x - column
	public int getX() {
		return this.x;
	}
	
	// getter for y - row
	public int getY() {
		return this.y;
	}
	
	/**
	 * Checks if the starting position is not already the winning
	 * position or if it`s stuck position.
	 */
	private boolean isLegalStartPosition(int x, int y) {
		if ( (x == STUCK_POSITION && y == STUCK_POSITION) 
				|| (x == WIN_POSITION && y == WIN_POSITION)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if the user has made a position
	 * between the game rules
	 * @param x - row
	 * @param y - column
	 */
	public boolean isLegalPosition(int x, int y) {
		if(isPositionOnBoard(x, y)) {
			//deltaX and deltaY are representation of the absolute value of the old and new coordinates
			int deltaX = Math.abs(this.x - x);
			int deltaY = Math.abs(this.y - y);
			
			if((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check if the position is within the chess board.
	 * @return boolean value of the checked position
	 */
	private boolean isPositionOnBoard(int x, int y) {
		return ((x >= MIN_POSITION && x <= MAX_POSITION) && (y >= MIN_POSITION && y <= MAX_POSITION));
	}

	/**
	 * Checks if the coordinates of x and y are equal with the
	 * winning coordinates of the game.
	 * @return boolean value of the current and win position
	 */
	public Boolean isWinningPosition() {
		return (this.x == WIN_POSITION && this.y == WIN_POSITION);
	}
	
}
