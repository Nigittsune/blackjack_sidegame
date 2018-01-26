package win.the.knight;

public class ChessFactory {
	
	/**
	 * Returns a new Object from
	 * @return KnightChessLogic
	 */
	public KnightChessLogic getChess() {
		return new KnightChessLogic();
	}
}
