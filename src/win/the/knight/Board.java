package win.the.knight;

public class Board {
	
	private static int[] boardColumns = {0, 1, 2, 3};
	private static int[] boardRows = {0, 1, 2, 3};
	private static Board instance = new Board();
	
	/**
	 * Created with Singleton Pattern
	 * @return Board Object
	 */
	public static Board getInstance() {
		return instance;
	}
	
	private Board() {
		//DO NOTHING
	}
	
	public void drawBoard(Position pos) {
		
		for(int i = 0; i < boardRows.length; i++){
			
			if(i == 0){
				System.out.println("     1   2   3");
				System.out.print("   -------------");
				continue;
			}else{
			
				for(int k = 0; k < boardColumns.length; k++){
					if(k == 0){
						System.out.println();
						System.out.print(" " + i + " |");
						continue;
					}
				
					if(k != 0){
						if(isKnightHere(pos, i, k)){
							System.out.print(" K |");
						}else{
							System.out.print("   |");
						}
						
						if(k == boardColumns.length -1){
						System.out.println();
						System.out.print("   -------------");
						}
					}
				}
			}
		}
		
		System.out.println();
	}
	
	public boolean isKnightHere(Position pos, int xPos, int yPos){
		
		return (pos.x == xPos && pos.y == yPos);
	}
	
}
