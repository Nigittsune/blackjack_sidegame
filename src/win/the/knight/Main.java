package win.the.knight;

public class Main {

	public static void main(String[] args) {
		KnightChessLogic chessGame = new KnightChessLogic();
		
		try {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			chessGame.startChess(x, y);
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException | PositionException e) {
			System.out.println("Illegal arguments: ");
			e.printStackTrace();
		}
		
	}

}
