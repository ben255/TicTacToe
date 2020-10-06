
public class RuleEngine {
	public enum Rule{
		NORMAL,
		INVERSE
	}
	
	private Rule rule;
	private int turn = 1;
	private int players = 0;
	
	public RuleEngine(Rule rule, int players) {
		this.rule = rule;
		this.players = players;
	}
	
	public Rule getRule(){
		return this.rule;
	}
	
	public void checkWin(Board board) {
		
	}
	public Player checkNormal(Board board) {
		return new Player('N');
	}
	public Player checkInverse(Board board) {
		return new Player('N');
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
