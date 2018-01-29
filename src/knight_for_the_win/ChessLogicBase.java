package knight_for_the_win;

import knight_for_the_win.components.Position;
import knight_for_the_win.exceptions.PositionException;

public abstract class ChessLogicBase {

	public final static String WIN_MESSAGE = "Congratulations, you have reached the final position!";
	protected Position position;

	public abstract void startGame(int x, int y) throws PositionException;

	public abstract boolean isGameFinished();
}
