package knight_for_the_win.components;

/**
 * 
 * @author Kaloyan Tsenov
 * This class contains single object of itself,
 * created via Singleton Pattern
 */
public class Board {
	
	private final static int[] BOARD_COLUMNS = {0, 1, 2, 3};
	private final static int[] BOARD_ROWS = {0, 1, 2, 3};
	private static Board instance = new Board();
	
	/**
	 * @return instance - a Board Object
	 */
	public static Board getInstance() {
		return instance;
	}
	
	//Creating and private constructor, so 
	private Board() {
		
	}
	
	/**
	 * Draws a simple 3x3 board for the console, with the position of the chess piece
	 * @param pos - an Object from Position class used for chess piece coordinates
	 * @see knight_for_the_win.components.Position
	 */
	public void drawBoard(Position pos) {
		char[][] board = new char[3][3];
	     char knight = 'K';

	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[i].length; j++) {
	            	if(pos.x - 1 == i && pos.y - 1 == j) {
	            		board[i][j] = knight;
	            		continue ;
	            	}
	                board[i][j] = ' ';
	            }
	        }

	        System.out.println("    1   2   3");
	        System.out.println("  ------------");
	        System.out.println("1 | " + board[0][0] + " | " + board[0][1] + " | "
	                + board[0][2] + " |");
	        System.out.println("   -----------");
	        System.out.println("2 | " + board[1][0] + " | " + board[1][1] + " | "
	                + board[1][2] + " |");
	        System.out.println("   -----------");
	        System.out.println("3 | " + board[2][0] + " | " + board[2][1] + " | "
	                + board[2][2] + " |");
	        System.out.println("   -----------");
	        System.out.println();
	}
	/**
	 * Compares if Knight row and column are same as
	 * the current row and colunt
	 * @param currX - current column
	 * @param currY - current row
	 * @return
	 */
	public boolean isKnightPosition(Position pos, int currX, int currY){
		return (pos.x == currX && pos.y == currY);
	}
	
}
