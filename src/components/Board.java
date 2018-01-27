package components;

/**
 * 
 * @author Kaloyan Tsenov
 * This class contains single object of itself,
 * created via Singleton Pattern
 */
public class Board {
	
	private final static int[] BOARD_COLUMNS = {0, 1, 2, 3};
	private final static int[] BOARD_ROWS = {0, 1, 2, 3};
	private static Board instance = new Board();
	
	/**
	 * @return instance - a Board Object
	 */
	public static Board getInstance() {
		return instance;
	}
	
	//Creating and private constructor, so 
	private Board() {
		
	}
	
	/**
	 * Draws a simple 3x3 board for the console, with the position of the chess piece
	 * @param pos - an Object from Position class used for chess piece coordinates
	 * @see components.Position
	 */
	public void drawBoard(Position pos) {
		
		for(int i = 0; i < BOARD_ROWS.length; i++){
			
			if(i == 0){
				System.out.println("     1   2   3");
				System.out.print("   -------------");
				continue;
			}else{
			
				for(int k = 0; k < BOARD_COLUMNS.length; k++){
					if(k == 0){
						System.out.println();
						System.out.print(" " + i + " |");
						continue;
					}
				
					if(k != 0){
						if(isKnightPosition(pos, i, k)){
							System.out.print(" K |");
						}else{
							System.out.print("   |");
						}
						
						if(k == BOARD_COLUMNS.length -1){
						System.out.println();
						System.out.print("   -------------");
						}
					}
				}
			}
		}
		
		System.out.println();
	}
	/**
	 * Compares if Knight row and column are same as
	 * the current row and colunt
	 * @param currX - current column
	 * @param currY - current row
	 * @return
	 */
	public boolean isKnightPosition(Position pos, int currX, int currY){
		return (pos.x == currX && pos.y == currY);
	}
	
}
