package knight_for_the_win;

import knight_for_the_win.components.Board;
import knight_for_the_win.components.Position;
import knight_for_the_win.exceptions.PositionException;

/**
 * 
 * @author Kaloyan Tsenov
 *
 */
public class KnightLogic {
	private final static String WIN_MESSAGE = "Congratulations, you have reached the final position!";
	public final static String ENTER_POSITION_MESSAGE = "Enter Knight new position:";
	
	private Position position;
	//becomes true, when the game is won.
	private boolean isGameFinished;
	
	protected KnightLogic() {
		
	}
	
	/**
	 * Creating a starting position of the player 
	 * and draws board with the position in the console.
	 * @throws PositionException 
	 */
	public void startGame(int x, int y) throws PositionException {
		//Creating a new Position object and giving coordinates x and y to it.
		position = new Position(x, y);
		//Drawing a board and chess piece in the console
		Board.getInstance().drawBoard(position);
	}

	/**
	 * Converts the user String with position to Integers x and y.
	 * Checks if the new position is legal or is it a winning one.
	 * Contains {@link #position}.
	 * @param userCoord a String containing the int representation to be parsed
	 * @param WIN_MESSAGE a String used only if user have reached the final point.
	 * @param ENTER_POSITION_MESSAGE a String used as a hint for the 
	 * player to enter new position.
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void moveKnight(String[] userCoord) {
		try {
			int x = Integer.parseInt(userCoord[0]);
			int y = Integer.parseInt(userCoord[1]);
			//checks if the new position is legal and sets the new x and y
			//if it`s not legal a message occurs. 
			if(position.isLegalPosition(x, y)) {
				position.setPositionCoordinates(x, y);
				System.out.println("Knight moved to " + x + ", " + y);
			} else {
				System.out.println("Position " + x + ", " + y + " is not legal");
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Only Integers accepted, number of required int: 2, current symbols inserted: " + e.getMessage());
		} finally {
			Board.getInstance().drawBoard(position);
		}
		// Check if the coordinates of the player are 3 x 3, if they are, 
		//prints message and sets isGameFinished to true.
		if(position.isWinningPosition()) {
			System.out.println(WIN_MESSAGE);
			isGameFinished = true;
		}
	}
	
	/**
	 * 
	 * @return Boolean - true if the game has finished, false if the game continues.
	 */
	public Boolean isGameFinished() {
		return this.isGameFinished;
	}

}
