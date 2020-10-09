
public class Board {
	private int size;
	private char pieces[][];
	private Player players[];
	private RuleEngine rule;
	
	
	public Board(int size, int playerSize, RuleEngine rule) {
		this.size = size;
		this.pieces = new char[size][size];
		this.rule = rule;
		this.players = new Player[playerSize];
		
		char[] tempPiece = {'X','Y', 'A', 'B', 'C'};
		//create players
		for(int i = 0; i < playerSize; i++) {
			this.players[i] = new Player(tempPiece[i]);
		}
		//add empty pieces
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				this.pieces[i][j] = ' ';
			}
		}
		
	}
	
	public int getSize() {
		return this.size;
	}
	public char[][] getPieces(){
		return this.pieces;
	}
	public void setPiece(int i, int j, char value) {
		this.pieces[i][j] = value;
	}
	public char getPiece(int i, int j) {
		return this.pieces[i][j];
	}
	public Player getCurrentPlayer() {
		return this.players[rule.getTurn()-1];
	}
	public Player getPlayerFromPiece(char piece) {
		for(int i = 0; i < players.length; i++) {
			if(this.players[i].getPiece() == piece)
				return this.players[i];
		}
		return null;
	}
	public int getPlayerPosition(Player player) {
		for(int i = 0; i < this.players.length; i++) {
			if(this.players[i].getPiece() == player.getPiece())
				return i;
		}
		return -1;
	}
	public boolean hasPiece(int x, int y) {
		if(pieces[x][y] == ' ')
			return false;
		else
			return true;
	}

}
