package knight_for_the_win.components;

/**
 * 
 * @author Kaloyan Tsenov This class contains single object of itself, created
 *         via Singleton Pattern
 */
public class Board {
	private static final int BOARD_COLUMNS = 3;
	private static final int BOARD_ROWS = 3;
	private static final char KNIGHT = 'K';

	private static Board instance = new Board();

	/**
	 * @return instance - a Board Object
	 */
	public static Board getInstance() {
		return instance;
	}

	// Creating and private constructor, so
	private Board() {

	}

	/**
	 * Draws a simple 3x3 board for the console, with the position of the chess
	 * piece
	 * 
	 * @param BOARD_COLUMNS
	 *            - an int giving the number of columns to be created
	 * @param BOARD_ROWS
	 *            - an int giving the number of rows to be created
	 * @see knight_for_the_win.components.Position
	 */
	public void drawBoard(Position pos) {
		System.out.println("    1   2   3");
		System.out.println("   -----------");
		for (int i = 0; i < BOARD_COLUMNS; i++) {
			System.out.print((i + 1) + " | ");
			for (int j = 0; j < BOARD_ROWS; j++) {
				if (isKnightPosition(pos, i, j)) {
					System.out.print(KNIGHT + " | ");
				} else {
					System.out.print("  | ");
				}
				if (j == BOARD_ROWS - 1) {
					System.out.println();
				}
			}
			System.out.println("   -----------");
		}
		// System.out.println(" ------------");
		// System.out.println("1 | " + BOARD[0][0] + " | " + BOARD[0][1] + " | "
		// + BOARD[0][2] + " |");
		// System.out.println(" -----------");
		// System.out.println("2 | " + BOARD[1][0] + " | " + BOARD[1][1] + " | "
		// + BOARD[1][2] + " |");
		// System.out.println(" -----------");
		// System.out.println("3 | " + BOARD[2][0] + " | " + BOARD[2][1] + " | "
		// + BOARD[2][2] + " |");
		// System.out.println(" -----------");
		// System.out.println();
	}

	/**
	 * Compares if Knight row and column are same as the current row and colunt
	 * 
	 * @param currX
	 *            - current column
	 * @param currY
	 *            - current row
	 * @return
	 */
	public boolean isKnightPosition(Position pos, int currX, int currY) {
		return (pos.getX() - 1 == currX && pos.getY() - 1 == currY);
	}

}
