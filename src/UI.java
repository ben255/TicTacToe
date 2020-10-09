import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class UI {
	
	private RunController controll;
	
	private JFrame frame;
	private JPanel mainGridLayoutPanel;
	
	private JPanel inputGridLayout;
	private JLabel textPlayers, textGameMode, textBoardSize;
	private JTextField panePlayers, paneGameMode, paneBoardSize;
	
	private JPanel startCancelGridLayout;
	private JButton startBtn, cancelBtn;
	
	private JPanel displayTextGridLayout;
	private JLabel textPlayerTurn, textModeDescription;
	
	private JPanel gameGridLayout;
	private JButton[][] gameBtn;
	
	public UI(RunController controll) {
		this.controll = controll;
		init();
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//inputLayout
		this.inputGridLayout.setLayout(new GridLayout(3,2));
		this.inputGridLayout.add(textPlayers);
		this.inputGridLayout.add(panePlayers);
		this.inputGridLayout.add(textGameMode);
		this.inputGridLayout.add(paneGameMode);
		this.inputGridLayout.add(textBoardSize);
		this.inputGridLayout.add(paneBoardSize);
		
		//descriptions
		this.displayTextGridLayout.setLayout(new GridLayout(2,1));
		this.displayTextGridLayout.add(textPlayerTurn);
		this.displayTextGridLayout.add(textModeDescription);
		
		//start and cancel buttons
		this.startCancelGridLayout.setLayout(new GridLayout(1,2));
		this.startCancelGridLayout.add(startBtn);
		this.startCancelGridLayout.add(cancelBtn);
		
		
		//main layout
		this.mainGridLayoutPanel.setLayout(new GridLayout(4,0));
		this.mainGridLayoutPanel.add(this.inputGridLayout);
		this.mainGridLayoutPanel.add(this.gameGridLayout);
		this.mainGridLayoutPanel.add(this.displayTextGridLayout);
		this.mainGridLayoutPanel.add(this.startCancelGridLayout);
		this.frame.getContentPane().add(this.mainGridLayoutPanel);
		
		
        //Display the window.
        this.frame.pack();
        this.frame.setVisible(true);

		
		
	}
	private void init() {
		
	
		this.frame = new JFrame("TicTacToe");
		this.mainGridLayoutPanel = new JPanel();
		
		this.inputGridLayout = new JPanel();
		this.textPlayers = new JLabel("Players");
		this.textGameMode = new JLabel("Game Mode");
		this.textBoardSize = new JLabel("Board Size");
		this.panePlayers = new JTextField();
		this.paneGameMode = new JTextField();
		this.paneBoardSize = new JTextField();
		
		this.textPlayers.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.textGameMode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.textBoardSize.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.panePlayers.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.paneGameMode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.paneBoardSize.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.displayTextGridLayout = new JPanel();
		this.textPlayerTurn = new JLabel("");
		this.textModeDescription = new JLabel("Mode: 0 = Normal, 1 = Inverse");
		
		this.textPlayerTurn.setBorder(BorderFactory.createLineBorder(Color.black));
		this.textModeDescription.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.startCancelGridLayout = new JPanel();
		this.startBtn = new JButton("Start");
		this.cancelBtn = new JButton("Cancel");
		this.startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controll.startBtnClicked();
				
			}
		});
		this.cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controll.cancelBtnClicked();
				
			}
		});
		
		
		this.gameGridLayout = new JPanel();
	}

	public String getPlayers() {
		return this.panePlayers.getText();
	}
	public String getGameMode() {
		return this.paneGameMode.getText();
	}
	public String getBoardSize() {
		return this.paneBoardSize.getText();
	}
	public void setBoardText(String text) {
		this.paneBoardSize.setText(text);
	}
	public void setPlayerText(String text) {
		this.panePlayers.setText(text);
	}
	public void setModeText(String text) {
		this.paneGameMode.setText(text);
	}
	public void setPlayerTurnText(String text) {
		this.textPlayerTurn.setText(text);
	}
	public void invalidateFrame() {
		this.frame.invalidate();
		this.frame.pack();
		this.frame.setVisible(true);
	}
	public void endPlayButtons() {
		this.gameBtn = null;
		this.gameGridLayout.removeAll();
		invalidateFrame();
	}
	public void addPiece(int x, int y, Player player) {
		this.gameBtn[x][y].setText(String.valueOf(player.getPiece()));;
	}

	public void loadBoard(int size) {
		this.gameGridLayout.setLayout(new GridLayout(size,size));
		this.gameBtn = new JButton[size][size];
		for(int i = 0; i < size; i++) {
			final int x = i;
			for(int j = 0; j < size; j++) {
				final int y = j;
				this.gameBtn[i][j] = new JButton(" ");
				this.gameBtn[i][j].setPreferredSize(new Dimension(50,50));
				this.gameBtn[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						controll.pieceBtnClicked(x, y);
					}
				});
				this.gameGridLayout.add(gameBtn[i][j]);
			}
		}
	}
}
