/**
 * 
 */
package knight_tests;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		factoryObject = new KnightFactory();
		logicObject = factoryObject.constructKnight();
	}

	@Test
	public void isKnightFactoryObjectNull() {
		assertNotNull(factoryObject);
	}
	
	/**
	 * Test method for {@link knight_for_the_win.KnightLogic#KnightLogic()}.
	 */
	@Test
	public void isKnightLogicObjectNull() {
		assertNotNull(logicObject);
	}
	
	/**
	 * Test method for {@link knight_for_the_win.KnightLogic#startGame(int, int)}.
	 * @throws PositionException 
	 * @throws AWTException 
	 */
	@Test
	public void testStartGame() throws PositionException, AWTException {
		int x = 1;
		int y = 2;
		Robot inputSimulation = new Robot();
		
		logicObject.startGame(x, y);
//		assertNotNull(Board.getInstance());
		
		inputSimulation.keyRelease(KeyEvent.VK_3);
		inputSimulation.keyPress(KeyEvent.VK_SPACE);
		inputSimulation.keyRelease(KeyEvent.VK_SPACE);
		inputSimulation.keyPress(KeyEvent.VK_3);
		inputSimulation.keyRelease(KeyEvent.VK_3);
	}

	public void asdasd() throws AWTException {
//		char[] randomPos = Position.generateStartingPosition().toCharArray();
//		
//		Robot inputSimulation = new Robot();
//		
//		for(int i = 0; i < randomPos.length; i++) {
//			inputSimulation.keyPress(randomPos[i]);
//			inputSimulation.keyRelease(randomPos[i]);
//		}
	}
	
}
