
public class RunController {
	
	private UI view;
	private Board board;
	private RuleEngine rule;
	public RunController() {
		
	}
	
	public void setView(UI view) {
		this.view = view;
	}
	
	public void pieceBtnClicked(int x, int y) {
		System.out.println(x+ " ... "+y);
		this.rule.updateTurn();
		
		
		
		this.view.setPlayerTurnText("Player "+this.rule.getTurn()+" turn");
		this.view.invalidateFrame();
	}
	
	public void startBtnClicked() {
		this.view.endPlayButtons();
		System.out.println("Starting...");
		
		//get boardsize
		String boardSize = this.view.getBoardSize();
		char[] tempBoard = boardSize.toCharArray();
		boolean containsInvalidBoard = false;
		for(char ch : tempBoard) {
			if(ch < '0' || ch > '9')
				containsInvalidBoard = true;
		}
		
		//get playersize
		String playerSize = this.view.getPlayers();
		char[] tempPlayer = playerSize.toCharArray();
		boolean containsInvalidPlayer = false;
		for(char ch : tempPlayer) {
			if(ch < '0' || ch > '9')
				containsInvalidPlayer = true;
		}
		
		//get gamemode
		String gameMode = this.view.getGameMode();
		char[] tempMode = gameMode.toCharArray();
		boolean containsInvalidMode = false;
		for(char ch : tempMode) {
			if(ch < '0' || ch > '9')
				containsInvalidMode = true;
		}
		
		//create board
		try {
			boolean startBoard = true;
			if(containsInvalidBoard || tempBoard[0] == '0' || boardSize.toCharArray().length <= 0) {
				this.view.setBoardText("Only 0-9");
				startBoard = false;
			}
			if(containsInvalidPlayer || tempPlayer[0] == '0'  || playerSize.toCharArray().length <= 0) {
				this.view.setPlayerText("Only 0-9");
				startBoard = false;
			}
			if(containsInvalidMode || tempMode[0] == '0' || gameMode.toCharArray().length <= 0) {
				this.view.setModeText("Only 0-9");
				startBoard = false;
			}
			if(startBoard){
				this.board = new Board(Integer.valueOf(boardSize),Integer.valueOf(playerSize));
				this.rule = new RuleEngine(RuleEngine.Rule.NORMAL, Integer.valueOf(playerSize));
				this.view.setPlayerTurnText("Player 1 turn");
				this.view.loadBoard(board.getSize());
				this.view.invalidateFrame();
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			//didnt fill out all the forms
		}
		
		
	}

	public void cancelBtnClicked() {
		System.out.println("Canceling...");
		this.view.endPlayButtons();
		
	}
}
