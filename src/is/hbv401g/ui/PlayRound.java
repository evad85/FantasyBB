package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;
import is.hbv401g.code.user.UserTeam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

/**
 * TODO
 *
 */
public class PlayRound extends JPanel {
	private static final long serialVersionUID = 4089039972033224279L;
	private static Game game;
	private static User user1;
	private static User user2;
	private static JButton btnUser1, btnUser2,btnPlayRound;
	private static JButton[] btnUserArray;
	private static JLabel labelPlayer1PointsText,labelPlayer1Points,labelPlayer1NameText;
	private static JLabel labelPlayer2NameText,labelPlayer2Points,labelPlayer2PointsText;
	private static JLabel lblRound;
	
	
	public PlayRound(final Game game) {
		setLayout(null);
		PlayRound.game = game;	
		initGui();
	}
	
	/**
	 * Initializes user information
	 */
	public static void initPlayers() {
		user1 = game.getUsers().get(0);
		user2 = game.getUsers().get(1);
		labelPlayer1NameText.setText(user1.getName());
		labelPlayer2NameText.setText(user2.getName());
	}
	
	/**
	 * Updates the label that shows the users points
	 */
	public static void updatePoints() {
		labelPlayer1PointsText.setText(String.valueOf(user1.getPoints()));
		labelPlayer2PointsText.setText(String.valueOf(user2.getPoints()));
	}
	
	/**
	 * Updates the label that shows the number of the current round
	 */
	public static void updateRound() {
		lblRound.setText("Round: " + String.valueOf(game.getCurrentRound()));
	}
	
	/**
	 * Makes the button for team transfer unable for the user that has finished
	 * selecting his team. Enables the button for ending the round if all the users
	 * have selected their teams
	 */
	public static void endUserTurn(){
		btnUserArray[game.getUserTurn()].setEnabled(false);
		if(user1.isTransferFinished() && user2.isTransferFinished()){
			btnPlayRound.setEnabled(true);
		}
	}
	
	/**
	 * Initializes the GUI
	 */
	private void initGui() {
		btnUser1 = new JButton("Pick team");
		btnUser1.addActionListener(new User1TransferActionListener());
		btnUser1.setBounds(36, 140, 104, 44);
		add(btnUser1);
		
		btnUser2 = new JButton("Pick team");
		btnUser2.addActionListener(new User2TransferActionListener());
		btnUser2.setBounds(244, 140, 104, 44);
		add(btnUser2);
		
		btnPlayRound = new JButton("Play round");
		btnPlayRound.addActionListener(new EndRoundActionListener());
		btnPlayRound.setEnabled(false);
		btnPlayRound.setBounds(320, 296, 177, 44);
		add(btnPlayRound);
		
		labelPlayer1PointsText = new JLabel("0");
		labelPlayer1PointsText.setBounds(118, 99, 33, 14);
		add(labelPlayer1PointsText);
		
		labelPlayer1Points = new JLabel("Points:");
		labelPlayer1Points.setBounds(47, 95, 61, 23);
		add(labelPlayer1Points);
		
		labelPlayer1NameText = new JLabel("Player 1");
		labelPlayer1NameText.setBounds(47, 73, 104, 14);
		add(labelPlayer1NameText);
		
		labelPlayer2NameText = new JLabel("Player 2");
		labelPlayer2NameText.setBounds(255, 73, 104, 14);
		add(labelPlayer2NameText);
		
		labelPlayer2Points = new JLabel("Points:");
		labelPlayer2Points.setBounds(255, 99, 61, 14);
		add(labelPlayer2Points);
		
		labelPlayer2PointsText = new JLabel("0");
		labelPlayer2PointsText.setBounds(328, 99, 33, 14);
		add(labelPlayer2PointsText);
		
		JLabel lblUsers = new JLabel("Players");
		lblUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsers.setBounds(166, 16, 104, 25);
		add(lblUsers);
		
		lblRound = new JLabel("Round: 1");
		lblRound.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRound.setBounds(41, 306, 99, 16);
		add(lblRound);
		
		btnUserArray = new JButton[]{btnUser1,btnUser2};
	}
	
	class User1TransferActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			game.setCurrentUser(0);
			UserGui.initPlayer();
			Transfers.initPlayer();
			if(game.getCurrentRound()>1){
				UserTeam team = game.getCurrentUser().getUserTeam(game.getCurrentRound()-1);
				UserGui.setTeam(team);
				Transfers.setTeam(team);
			}
			MainGui.showCardLayout("panelUser");
			
		}
	}
	
	class User2TransferActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			game.setCurrentUser(1);
			UserGui.initPlayer();
			Transfers.initPlayer();
			if(game.getCurrentRound()>1){
				UserTeam team = game.getCurrentUser().getUserTeam(game.getCurrentRound()-1);
				UserGui.setTeam(team);
				Transfers.setTeam(team);
			}
			MainGui.showCardLayout("panelUser");
		}
	}
	
	class EndRoundActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			game.endRound();
			updateRound();
			updatePoints();
			btnUserArray[0].setEnabled(true);
			btnUserArray[1].setEnabled(true);
			btnPlayRound.setEnabled(false);

		}
	}
}