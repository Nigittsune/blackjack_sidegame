package win.the.knight;

import java.util.Scanner;

public class KnightChessLogic {
	private final static String WIN_MESSAGE = "Congratulations, you have reached the final position";
	/**
	 * TODO
	 */
	private Position position;
	Scanner sc;
	
	public KnightChessLogic() {
		sc = new Scanner(System.in);
	}
	
	/**
	 * Starting the main functions of the game
	 * @throws PositionException 
	 */
	protected void startChess(int x, int y) throws PositionException {
		position = new Position(x, y);
		Board.getInstance().drawBoard(position);
		while (!moveKnight()) {
			
		}
	}

	/**
	 * 
	 * Converts the user String with position to Integers x & y
	 * {@link #position}
	 * @param Coordinates X & Y
	 */
	private boolean moveKnight() {
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
