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
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * PlayRound displays the games main screen. It shows information such as the current round
 * and the users name and points.
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
	private JLabel lblNewLabel;
	
	/**
	 * Create the panel
	 * @param game
	 */
	public PlayRound(final Game game) {
		setBackground(new Color(238, 238, 238));
		
		Image bg = Toolkit.getDefaultToolkit().createImage("bacground.jpg");
		//this.drawImage(bg, 0,0,null);
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
		btnUser1.setBounds(317, 237, 104, 44);
		btnUser1.addActionListener(new User1TransferActionListener());
		setLayout(null);
		add(btnUser1);
		
		btnUser2 = new JButton("Pick team");
		btnUser2.setBounds(516, 237, 104, 44);
		btnUser2.addActionListener(new User2TransferActionListener());
		add(btnUser2);
		
		btnPlayRound = new JButton("Play round");
		btnPlayRound.setBounds(371, 435, 192, 44);
		btnPlayRound.addActionListener(new EndRoundActionListener());
		btnPlayRound.setEnabled(false);
		add(btnPlayRound);
		
		labelPlayer1PointsText = new JLabel("0");
		labelPlayer1PointsText.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		labelPlayer1PointsText.setForeground(Color.WHITE);
		labelPlayer1PointsText.setBounds(390, 171, 33, 14);
		add(labelPlayer1PointsText);
		
		labelPlayer1Points = new JLabel("Points:");
		labelPlayer1Points.setFont(new Font("Dialog", Font.BOLD, 18));
		labelPlayer1Points.setForeground(Color.WHITE);
		labelPlayer1Points.setBounds(317, 167, 61, 23);
		add(labelPlayer1Points);
		
		labelPlayer1NameText = new JLabel("Player 1");
		labelPlayer1NameText.setFont(new Font("Dialog", Font.BOLD, 18));
		labelPlayer1NameText.setForeground(Color.WHITE);
		labelPlayer1NameText.setBounds(317, 132, 104, 23);
		add(labelPlayer1NameText);
		
		labelPlayer2NameText = new JLabel("Player 2");
		labelPlayer2NameText.setFont(new Font("Dialog", Font.BOLD, 18));
		labelPlayer2NameText.setForeground(Color.WHITE);
		labelPlayer2NameText.setBounds(514, 132, 104, 23);
		add(labelPlayer2NameText);
		
		labelPlayer2Points = new JLabel("Points:");
		labelPlayer2Points.setFont(new Font("Dialog", Font.BOLD, 18));
		labelPlayer2Points.setForeground(Color.WHITE);
		labelPlayer2Points.setBounds(516, 164, 61, 29);
		add(labelPlayer2Points);
		
		labelPlayer2PointsText = new JLabel("0");
		labelPlayer2PointsText.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		labelPlayer2PointsText.setForeground(Color.WHITE);
		labelPlayer2PointsText.setBounds(587, 171, 33, 14);
		add(labelPlayer2PointsText);
		
		JLabel lblUsers = new JLabel("Players");
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setBounds(411, 46, 119, 44);
		lblUsers.setFont(new Font("Helvetica", Font.BOLD, 24));
		add(lblUsers);
		
		lblRound = new JLabel("Round: 1");
		lblRound.setHorizontalAlignment(SwingConstants.CENTER);
		lblRound.setForeground(Color.WHITE);
		lblRound.setBounds(319, 363, 301, 35);
		lblRound.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblRound);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PlayRound.class.getResource("/resources/background.jpg")));
		lblNewLabel.setBounds(0, -12, 1001, 823);
		add(lblNewLabel);
		
		btnUserArray = new JButton[]{btnUser1,btnUser2};
	}
	
	/**
	 * Sets the team for user1 as the team he selected in the previous rounds
	 * Also displays a screen where user1 can change his team
	 */
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
				Schedule.updateMatchResults(game);
			}
			MainGui.showCardLayout("panelUser");	
		}
	}
	
	/**
	 * Sets the team for user2 as the team he selected in the previous rounds
	 * Also displays a screen where user2 can change his team
	 */
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
				Schedule.updateMatchResults(game);

				
			}
			MainGui.showCardLayout("panelUser");
		}
	}
	
	/**
	 * Updates the users points and the round number.
	 */
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
	
	/**
	 * Makes the buttons for ending a round and transfers
	 * disabled
	 */
	public static void endGame(){
		btnPlayRound.setEnabled(false);
		btnUser1.setEnabled(false);
		btnUser2.setEnabled(false);
	}
}