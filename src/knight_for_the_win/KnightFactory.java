package knight_for_the_win;

/**
 * 
 * @author Kaloyan Tsenov
 *
 */
public class KnightFactory {
	
	/**
	 * Returns a new Object from KnightLogic
	 * @return KnightLogic
	 */
	public KnightLogic constructKnight() {
		return new KnightLogic();
	}
}
