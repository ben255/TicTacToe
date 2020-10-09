
public class RuleEngine {
	public enum Rule{
		NORMAL,
		INVERSE
	}
	
	private Rule rule;
	private int turn = 1;
	private int players = 0;
	
	public RuleEngine(int mode, int players) {
		if(mode == 0) {
			this.rule = Rule.NORMAL;
		}else if(mode == 1) {
			this.rule = Rule.INVERSE;
		}
		this.players = players;
	}
	
	public Rule getRule(){
		return this.rule;
	}
	
	public Player checkNormal(Board board) {
		//check rows and columns
		char[] rows = new char[board.getSize()];
		char[] cols = new char[board.getSize()];
		for(int i = 0; i < board.getSize(); i++) {
			// fill up a row and column
			for(int j = 0; j < board.getSize(); j++) {
				//rows
				rows[j] = board.getPiece(i, j);
				cols[j] = board.getPiece(j, i);
			}
			
			//check if the row and column are all the same
			boolean rowIsFull = true;
			boolean colIsFull = true;
			for(char ch : rows) {
				if(ch != rows[0])
					rowIsFull = false;
			}
			for(char ch: cols) {
				if(ch != cols[0])
					colIsFull = false;
			}
			if(rowIsFull) {
				return board.getPlayerFromPiece(rows[0]);
			}else if(colIsFull) {
				return board.getPlayerFromPiece(cols[0]);
			}
		}
		
		return null;
	}
	public Player checkInverse(Board board) {
		//check rows and columns
		char[] rows = new char[board.getSize()];
		char[] cols = new char[board.getSize()];
		for(int i = 0; i < board.getSize(); i++) {
			// fill up a row and column
			for(int j = 0; j < board.getSize(); j++) {
				//rows
				rows[j] = board.getPiece(i, j);
				cols[j] = board.getPiece(j, i);
			}
			
			//check if the row and column are all the same
			boolean rowIsFull = true;
			boolean colIsFull = true;
			for(char ch : rows) {
				if(ch != rows[0])
					rowIsFull = false;
			}
			for(char ch: cols) {
				if(ch != cols[0])
					colIsFull = false;
			}
			if(rowIsFull) {
				return board.getPlayerFromPiece(rows[0]);
			}else if(colIsFull) {
				return board.getPlayerFromPiece(cols[0]);
			}
		}
		
		return null;
	}
	public int getTurn() {
		return this.turn;
	}
	public void updateTurn() {
		this.turn++;
		System.out.println(this.players);
		if(this.turn > this.players)
			this.turn = 1;
	}
	
}
