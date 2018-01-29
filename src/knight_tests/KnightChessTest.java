/**
 * 
 */
package knight_tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import knight_for_the_win.KnightFactory;
import knight_for_the_win.KnightLogic;
import knight_for_the_win.components.Board;
import knight_for_the_win.components.Position;
import knight_for_the_win.exceptions.PositionException;

/**
 * @author Kaloyan
 *
 */
public class KnightChessTest {

	private KnightLogic logicObject;
	private KnightFactory factoryObject;
	private Position positionObject;

	private HashMap<String, Integer[]> coord;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		factoryObject = new KnightFactory();
		logicObject = factoryObject.constructKnight();
		coord = new HashMap<>();
		coord.put("default", new Integer[] { 1, 2 });
		coord.put("nextmove", new Integer[] { 3, 1 });
		coord.put("win", new Integer[] { 3, 3 });
		coord.put("outofboard", new Integer[] { 4, 5 });

		positionObject = new Position(1, 2);
	}

	@Test
	public void testKnightFactoryObjectNotNull() {
		assertNotNull(factoryObject);
	}

	@Test
	public void testBoardObjectNotNull() {
		assertNotNull(Board.getInstance());
	}

	/**
	 * Test method for {@link knight_for_the_win.KnightLogic#KnightLogic()}.
	 */
	@Test
	public void testKnightLogicObjectNotNull() {
		assertNotNull(logicObject);
	}

	@Test
	public void testPositionObjectNull() {
		assertNotNull(positionObject);
	}

	/**
	 * Invoking an PositionException which is not catched by catch clause.
	 * 
	 * @throws PositionException
	 */
	@Test(expected = PositionException.class)
	public void testStartGameWithPositionOutOfBoards() throws PositionException {
		logicObject.startGame(coord.get("outofboard")[0], coord.get("outofboard")[0]);
	}

	/**
	 * Test if the boolean parameter return true when the game is won.
	 * 
	 * @throws PositionException
	 */
	@Test
	public void testIsGameFinishedParameter() throws PositionException {
		// win scenario
		logicObject.startGame(coord.get("default")[0], coord.get("default")[1]);
		logicObject.moveKnight(new String[] { "3", "3" });

		assertTrue(logicObject.isGameFinished());
	}

	/**
	 * Test the position of the chess piece in two cases: First when the
	 * position is legal and returns true Seconds when the position is out of
	 * board and returns false
	 */
	@Test
	public void testIsLegalPosition() {
		// test with legal position
		assertTrue(positionObject.isLegalPosition(coord.get("nextmove")[0], coord.get("nextmove")[1]));
		// test with not legal position
		assertFalse(positionObject.isLegalPosition(coord.get("outofboard")[0], coord.get("outofboard")[1]));
	}

}
