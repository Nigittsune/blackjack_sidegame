package win.the.knight;

public class ChessFactory {
	
	/**
	 * Returns a new Object from
	 * @return KnightChessLogic
	 */
	public KnightChessLogic constructChess() {
		return new KnightChessLogic();
	}
}
