package win.the.knight;

public class KnightFactory {
	
	/**
	 * Returns a new Object from KnightLogic
	 * @return KnightLogic
	 */
	public KnightLogic constructKnight() {
		return new KnightLogic();
	}
}
