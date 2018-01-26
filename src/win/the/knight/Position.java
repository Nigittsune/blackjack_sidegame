package win.the.knight;

import java.util.concurrent.ThreadLocalRandom;

public class Position {
	private final static int X_WIN = 3;
	private final static int Y_WIN = 3;
	private final static String[] LEGAL_STARTING_POSITIONS = { "1 1", "1 2", "1 3", "2 1", "2 3", "3 1", "3 2" };
	
	/**
	 * Chess board row
	 */
	public int x;
	
	/**
	 * Chess board column
	 */
	public int y;
	
	public Position() {
		generateStartingPosition();
	}
	
	/**
	 * Generates random starting position of the knight.
	 * @param Returns void
	 */
	// Generates a random position of the knight at the start of the game
	private void generateStartingPosition() {
		String[] coordinates = LEGAL_STARTING_POSITIONS[ThreadLocalRandom.current().nextInt(0,
				(LEGAL_STARTING_POSITIONS.length))].split(" ");
		this.x = Integer.parseInt(coordinates[0]);
		this.y = Integer.parseInt(coordinates[1]);
	}
	/**
	 * Checks if the user has made a position
	 * between the game rules
	 * @param x - row
	 * @param y - column
	 */
	public boolean isLegalPosition(int x, int y) {
		return true;
	}
	
	/**
	 * Checks if the coordinates of x and y are equal with the
	 * winning coordinates of the game
	 * @return true or false
	 */
	public Boolean isWinningPosition() {
		return (this.x == X_WIN && this.y == Y_WIN);
	}
	
}
