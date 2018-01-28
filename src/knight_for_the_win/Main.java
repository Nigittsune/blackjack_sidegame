package knight_for_the_win;

import knight_for_the_win.exceptions.PositionException;

/**
 * 
 * @author Kaloyan Tsenov
 *
 */
public class Main {

	public static void main(String[] args) {
		KnightFactory factory = new KnightFactory();
		KnightLogic knightGame = factory.constructKnight();
		
		try {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			knightGame.startGame(x, y);
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException | PositionException e) {
			System.out.println("Illegal arguments: " + e.getMessage());
		}
		
	}

}
