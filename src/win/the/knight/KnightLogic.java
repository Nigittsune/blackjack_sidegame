package win.the.knight;

import java.util.Scanner;

/**
 * 
 * @author Kaloyan Tsenov
 *
 */
public class KnightLogic {
	private final static String WIN_MESSAGE = "Congratulations, you have reached the final position";
	/**
	 * TODO
	 */
	private Position position;
	Scanner sc;
	
	public KnightLogic() {
		sc = new Scanner(System.in);
	}
	
	/**
	 * Starting the main functions of the game
	 * @throws PositionException 
	 */
	protected void startGame(int x, int y) throws PositionException {
		//Creating a starting position of the player and draws board with the Knight position.
		position = new Position(x, y);
		Board.getInstance().drawBoard(position);
		
		while (!moveKnight());
	}

	/**
	 * 
	 * Converts the user String with position to Integers x and y
	 * Checks if the new position is legal or is it a winning position
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private boolean moveKnight() {
		// Check if the new location of the player is 3 x 3, if it`s not the function continues.
		if(position.isWinningPosition()) {
			System.out.println(WIN_MESSAGE);
			sc.close();
			return true;
		}
		
		System.out.println("Enter Knight coordinates: ");
		try {
			String[] userInputCoordinates = sc.nextLine().split(" ");
			int x = Integer.parseInt(userInputCoordinates[0]);
			int y = Integer.parseInt(userInputCoordinates[1]);
			if(position.isLegalPosition(x, y)) {
				position.x = x;
				position.y = y;
			} else {
				System.out.println("Position x,y is not legal");
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Only Integers accepted, number of Integer = 2 -" + e.getMessage());
		} finally {
			Board.getInstance().drawBoard(position);
		}
		return false;
	}

}
