
public class Board {
	private int size;
	private int pieces[][];
	private Player players[];
	private RuleEngine.Rule rule;
	
	
	public Board(int size, int playerSize) {
		this.size = size;
		this.pieces = new int[size][size];
		this.rule = RuleEngine.Rule.NORMAL;
		this.players = new Player[playerSize];
		
		char[] tempPiece = {'X','Y', 'A', 'B', 'C'};
		//create players
		for(int i = 0; i < playerSize; i++) {
			this.players[i] = new Player(tempPiece[i]);
		}
		
	}
	
	public int getSize() {
		return this.size;
	}
	public int[][] getPieces(){
		return pieces;
	}
	public void setPiece(int i, int j, int value) {
		pieces[i][j] = value;
	}

}
