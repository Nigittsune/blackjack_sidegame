package knight_for_the_win;

import java.util.Scanner;

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
	private final static String ENTER_POSITION_MESSAGE = "Enter Knight next position:";
	
	private Position position;
	private Scanner sc;
	
	/**
	 * @param sc - initializing a new Scanner Object
	 */
	public KnightLogic() {
		sc = new Scanner(System.in);
	}
	
	/**
	 * Starting the main functions of the game
	 * @throws PositionException 
	 */
	public void startGame(int x, int y) throws PositionException {
		//Creating a starting position of the player and draws board with the Knight position.
		position = new Position(x, y);
		Board.getInstance().drawBoard(position);
		
		while (!moveKnight());
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
	private boolean moveKnight() {
		// Check if the coordinates of the player are 3 x 3, if they aren`t the function continues.
		if(position.isWinningPosition()) {
			System.out.println(WIN_MESSAGE);
			sc.close();
			return true;
		}
		
		System.out.println(ENTER_POSITION_MESSAGE);
		try {
			String[] userCoord = sc.nextLine().split(" ");
			int x = Integer.parseInt(userCoord[0]);
			int y = Integer.parseInt(userCoord[1]);
			if(position.isLegalPosition(x, y)) {
				position.x = x;
				position.y = y;
			} else {
				System.out.println("Position " + x + ", " + y + " is not legal");
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Only Integers accepted, number of Integer = 2, current symbols inserted " + e.getMessage());
		} finally {
			Board.getInstance().drawBoard(position);
		}
		return false;
	}

}
