package win.the.knight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class KnightChessLogic {
	final static int MIN_COORDINATE_VALUE = 1;
	final static int MAX_COORDINATE_VALUE = 3;
	private static String WIN_MESSAGE = "Congratulations, you have reached the final position";
 
	private int [] x = {1, 2, 2, 1, -1, -2, -2, -1};
	private int [] y = {2, 1, -1, -2, -2, -1, 1, 2};
	private Position position;
	
	public KnightChessLogic() {
		
	}
	
	/**
	 * Starting the main functions of the game
	 */
	protected void startChess() {
		position = new Position();
		Board.getInstance().drawBoard(position);
		moveKnight();
	}

	/**
	 * 
	 * Converts the user String with position to Integers x & y
	 * @param Coordinates X & Y
	 */
	public void moveKnight() {
		if(position.isWinningPosition()) {
			System.out.println(WIN_MESSAGE);
			return ;
		}
		System.out.println("Enter Knight coordinates");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] userInputCoordinates = br.readLine().split(" ");
			
			//position.isLegalPosition(int x, int y)
			position.x = Integer.parseInt(userInputCoordinates[0]);
			position.y = Integer.parseInt(userInputCoordinates[1]);
			Board.getInstance().drawBoard(position);
			moveKnight();
		} catch (IOException e) {
			System.out.println("An error has occured");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Only Integers are accepted");
			e.printStackTrace();
		} finally {
			
		}
	}
/**
 * 
 * 
 */
	public static void main(String[] args) {
		KnightChessLogic chessGame = new KnightChessLogic();
		chessGame.startChess();
	}

}
