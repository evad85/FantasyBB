package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.User;
import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.dummy.Statistics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * UserGui displays the screen for user information such as name, points and the team the
 * user selected in the previous round. It also shows information about how the players in that team
 * performed.
 *
 */
public class UserGui extends JPanel {
	private JPanel panelTeam;
	private static final long serialVersionUID = 1L;
	private static Game game;
	private static User user;
	private static JLabel lblName, lblPoints;
	private JLabel goalkeeperImg;
	private JLabel defenceImg1, defenceImg2, defenceImg3, defenceImg4;
	private JLabel middleImg1, middleImg2, middleImg3, middleImg4;
	private JLabel forwardImg1, forwardImg2;
	private JLabel defenceName1, defenceName2, defenceName3, defenceName4;
	private JButton btnDefense1Info, btnDefense2Info, btnDefense3Info, btnDefense4Info;
	private JButton btnMiddle1Info, btnMiddle2Info, btnMiddle3Info, btnMiddle4Info, btnForward1Info, btnForward2Info, btnGoalKeeperInfo;
	private JLabel middleName1, middleName2, middleName3, middleName4;
	private JLabel forwardName1, forwardName2;
	private JLabel goalkeeperName;
	private ArrayList<JLabel> namesLabels, shirtLabels;
	private JLabel forwardPoints1;
	private JLabel forwardsPoints2;
	private JLabel defencePoints1;
	private JLabel defencePoints2;
	private JLabel defencePoints3;
	private JLabel defencePoints4;
	private JLabel middlePoints1;
	private JLabel middlePoints2;
	private JLabel middlePoints3;
	private JLabel middlePoints4;
	private JLabel goalkeeperPoints;
	private static ArrayList<JLabel> teamNames, teamPoints,teamImg;
	JLabel[] playerNameArray;
	private static JFrame frame = new JFrame();
	
	/**
	 * Creates the panel and initializes instance variables
	 */
	public UserGui(Game game) {
		setLayout(null);
		UserGui.game = game;
		initGui();	
	}
	
	/**
	 * Sets the users name and points
	 */
	public static void initPlayer() {
		user = game.getCurrentUser();
		lblName.setText(user.getName());
		lblPoints.setText(String.valueOf(user.getPoints()) + " points");	
	}
	
	/**
	 * Initializes the GUI
	 */
	private void initGui() {
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblName.setBounds(538, 27, 283, 29);
		add(lblName);
		
		lblPoints = new JLabel("Points: ");
		lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPoints.setBounds(538, 74, 283, 16);
		add(lblPoints);
		
		namesLabels = new ArrayList<JLabel>();
		shirtLabels = new ArrayList<JLabel>();
		MainGui.initShirts();
		initView();
	}
	
	/**
	 * Initializes the GUI
	 */
	private void initView(){
		
		panelTeam = new JPanel();
		panelTeam.setBounds(6, 0, 501, 482);
		add(panelTeam);
		panelTeam.setLayout(null);
		// Shirt images
		
		goalkeeperImg = new JLabel("");
		goalkeeperImg.setBounds(222, 0, 61, 66);
		panelTeam.add(goalkeeperImg);
		goalkeeperImg.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		
		
		//Add shirtLabels to list
		shirtLabels.add(goalkeeperImg);
		
		defenceImg1 = new JLabel("");
		defenceImg1.setBounds(67, 100, 61, 66);
		panelTeam.add(defenceImg1);
		defenceImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(defenceImg1);
				
		defenceImg2 = new JLabel("");
		defenceImg2.setBounds(165, 100, 61, 66);
		panelTeam.add(defenceImg2);
		defenceImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(defenceImg2);
		
		defenceImg3 = new JLabel("");
		defenceImg3.setBounds(281, 100, 61, 66);
		panelTeam.add(defenceImg3);
		defenceImg3.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(defenceImg3);
			
		defenceImg4 = new JLabel("");
		defenceImg4.setBounds(367, 100, 61, 66);
		panelTeam.add(defenceImg4);
		defenceImg4.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(defenceImg4);
				
		middleImg1 = new JLabel("");
		middleImg1.setBounds(67, 229, 61, 66);
		panelTeam.add(middleImg1);
		middleImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(middleImg1);
				
		middleImg2 = new JLabel("");
		middleImg2.setBounds(165, 229, 61, 66);
		panelTeam.add(middleImg2);
		middleImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(middleImg2);
		
		middleImg3 = new JLabel("");
		middleImg3.setBounds(281, 229, 61, 66);
		panelTeam.add(middleImg3);
		middleImg3.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(middleImg3);
				
		middleImg4 = new JLabel("");
		middleImg4.setBounds(367, 229, 61, 66);
		panelTeam.add(middleImg4);
		middleImg4.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(middleImg4);
		
		forwardImg1 = new JLabel("");
		forwardImg1.setBounds(165, 352, 61, 66);
		panelTeam.add(forwardImg1);
		forwardImg1.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(forwardImg1);
		
		forwardImg2 = new JLabel("");
		forwardImg2.setBounds(281, 352, 61, 66);
		panelTeam.add(forwardImg2);
		forwardImg2.setIcon(new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));
		shirtLabels.add(forwardImg2);
		
		initButtons();
		
		//Name labels
		
		defenceName1 = new JLabel("Name");
		defenceName1.setBounds(52, 190, 76, 16);
		panelTeam.add(defenceName1);
		defenceName1.setForeground(Color.WHITE);
		defenceName1.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName1);
		
		defenceName2 = new JLabel("Name");
		defenceName2.setBounds(150, 190, 76, 16);
		panelTeam.add(defenceName2);
		defenceName2.setForeground(Color.WHITE);
		defenceName2.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName2);
		
		defenceName3 = new JLabel("Name");
		defenceName3.setBounds(266, 190, 76, 16);
		panelTeam.add(defenceName3);
		defenceName3.setForeground(Color.WHITE);
		defenceName3.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName3);
		
		defenceName4 = new JLabel("Name");
		defenceName4.setBounds(351, 190, 76, 16);
		panelTeam.add(defenceName4);
		defenceName4.setForeground(Color.WHITE);
		defenceName4.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(defenceName4);
		
		middleName1 = new JLabel("Name");
		middleName1.setBounds(67, 319, 48, 16);
		panelTeam.add(middleName1);
		middleName1.setForeground(Color.WHITE);
		middleName1.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName1);
		
		middleName2 = new JLabel("Name");
		middleName2.setBounds(150, 319, 76, 16);
		panelTeam.add(middleName2);
		middleName2.setForeground(Color.WHITE);
		middleName2.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName2);
		
		middleName3 = new JLabel("Name");
		middleName3.setBounds(266, 319, 76, 16);
		panelTeam.add(middleName3);
		middleName3.setForeground(Color.WHITE);
		middleName3.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName3);
		
		middleName4 = new JLabel("Name");
		middleName4.setBounds(351, 319, 76, 16);
		panelTeam.add(middleName4);
		middleName4.setForeground(Color.WHITE);
		middleName4.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(middleName4);
		
		forwardName1 = new JLabel("Name");
		forwardName1.setBounds(150, 441, 76, 16);
		panelTeam.add(forwardName1);
		forwardName1.setForeground(Color.WHITE);
		forwardName1.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(forwardName1);
		
		forwardName2 = new JLabel("Name");
		forwardName2.setBounds(266, 441, 77, 16);
		panelTeam.add(forwardName2);
		forwardName2.setForeground(Color.WHITE);
		forwardName2.setHorizontalAlignment(SwingConstants.CENTER);
		namesLabels.add(forwardName2);
		
		goalkeeperName = new JLabel("Name");
		goalkeeperName.setBounds(210, 90, 61, 16);
		panelTeam.add(goalkeeperName);
		goalkeeperName.setForeground(Color.WHITE);
		goalkeeperName.setHorizontalAlignment(SwingConstants.CENTER);
		
		forwardPoints1 = new JLabel("0");
		forwardPoints1.setHorizontalAlignment(SwingConstants.CENTER);
		forwardPoints1.setForeground(Color.WHITE);
		forwardPoints1.setBounds(165, 457, 38, 14);
		panelTeam.add(forwardPoints1);
		
		forwardsPoints2 = new JLabel("0");
		forwardsPoints2.setHorizontalAlignment(SwingConstants.CENTER);
		forwardsPoints2.setForeground(Color.WHITE);
		forwardsPoints2.setBounds(281, 457, 38, 14);
		panelTeam.add(forwardsPoints2);
		
		defencePoints1 = new JLabel("0");
		defencePoints1.setHorizontalAlignment(SwingConstants.CENTER);
		defencePoints1.setForeground(Color.WHITE);
		defencePoints1.setBounds(67, 204, 38, 14);
		panelTeam.add(defencePoints1);
		
		defencePoints2 = new JLabel("0");
		defencePoints2.setHorizontalAlignment(SwingConstants.CENTER);
		defencePoints2.setForeground(Color.WHITE);
		defencePoints2.setBounds(165, 204, 38, 14);
		panelTeam.add(defencePoints2);
		
		defencePoints3 = new JLabel("0");
		defencePoints3.setHorizontalAlignment(SwingConstants.CENTER);
		defencePoints3.setForeground(Color.WHITE);
		defencePoints3.setBounds(281, 204, 38, 14);
		panelTeam.add(defencePoints3);
		
		defencePoints4 = new JLabel("0");
		defencePoints4.setHorizontalAlignment(SwingConstants.CENTER);
		defencePoints4.setForeground(Color.WHITE);
		defencePoints4.setBounds(367, 204, 38, 14);
		panelTeam.add(defencePoints4);
		
		middlePoints1 = new JLabel("0");
		middlePoints1.setHorizontalAlignment(SwingConstants.CENTER);
		middlePoints1.setForeground(Color.WHITE);
		middlePoints1.setBounds(67, 335, 38, 14);
		panelTeam.add(middlePoints1);
		
		middlePoints2 = new JLabel("0");
		middlePoints2.setHorizontalAlignment(SwingConstants.CENTER);
		middlePoints2.setForeground(Color.WHITE);
		middlePoints2.setBounds(165, 335, 38, 14);
		panelTeam.add(middlePoints2);
		
		middlePoints3 = new JLabel("0");
		middlePoints3.setHorizontalAlignment(SwingConstants.CENTER);
		middlePoints3.setForeground(Color.WHITE);
		middlePoints3.setBounds(281, 335, 38, 14);
		panelTeam.add(middlePoints3);
		
		middlePoints4 = new JLabel("0");
		middlePoints4.setHorizontalAlignment(SwingConstants.CENTER);
		middlePoints4.setForeground(Color.WHITE);
		middlePoints4.setBounds(367, 335, 38, 14);
		panelTeam.add(middlePoints4);
		
		goalkeeperPoints = new JLabel("0");
		goalkeeperPoints.setHorizontalAlignment(SwingConstants.CENTER);
		goalkeeperPoints.setForeground(Color.WHITE);
		goalkeeperPoints.setBounds(220, 106, 38, 14);
		panelTeam.add(goalkeeperPoints);
		playerNameArray = new JLabel[]{goalkeeperName,defenceName1, defenceName2, defenceName3, defenceName4,
				middleName1, middleName2, middleName3, middleName4, forwardName1, forwardName2};
		teamNames = new ArrayList<JLabel>(Arrays.asList(goalkeeperName, defenceName1, defenceName2, defenceName3, defenceName4, middleName1,middleName2, middleName3,middleName4,forwardName1, forwardName2 ));
		teamPoints = new ArrayList<JLabel>(Arrays.asList(goalkeeperPoints, defencePoints1, defencePoints2, defencePoints3, defencePoints4, middlePoints1,middlePoints2, middlePoints3,middlePoints4,forwardPoints1, forwardsPoints2 ));
		teamImg = new ArrayList<JLabel>(Arrays.asList(goalkeeperImg, defenceImg1, defenceImg2, defenceImg3, defenceImg4, middleImg1,middleImg2, middleImg3,middleImg4,forwardImg1, forwardImg2 ));
		//Pitch
		JLabel pitch = new JLabel("");
		pitch.setBounds(6, 0, 520, 495);
		panelTeam.add(pitch);
		pitch.setIcon(new ImageIcon(getClass().getResource("/resources/pitch.png")));
		
	}
	
	/**
	 * Initializes buttons
	 */
	private void initButtons(){
		//info buttons
		btnGoalKeeperInfo = new JButton("i");
		btnGoalKeeperInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[0].getText();
				createUserInfoGui(playerName);
			}
		});
		btnGoalKeeperInfo.setBounds(228, 72, 20, 16);
		panelTeam.add(btnGoalKeeperInfo);
		btnGoalKeeperInfo.setBackground(Color.YELLOW);
		
		btnDefense1Info = new JButton("i");
		btnDefense1Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[1].getText();
				createUserInfoGui(playerName);
			}
		});
		btnDefense1Info.setBounds(77, 171, 20, 16);
		panelTeam.add(btnDefense1Info);
		btnDefense1Info.setBackground(Color.LIGHT_GRAY);
		
		btnDefense2Info = new JButton("i");
		btnDefense2Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[2].getText();
				createUserInfoGui(playerName);
			}
		});
		btnDefense2Info.setBounds(175, 171, 20, 16);
		panelTeam.add(btnDefense2Info);
		btnDefense2Info.setBackground(Color.YELLOW);
		
		btnDefense3Info = new JButton("i");
		btnDefense3Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[3].getText();
				createUserInfoGui(playerName);
			}
		});
		btnDefense3Info.setBounds(291, 171, 20, 16);
		panelTeam.add(btnDefense3Info);
		btnDefense3Info.setBackground(Color.YELLOW);
		
		btnDefense4Info = new JButton("i");
		btnDefense4Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[4].getText();
				createUserInfoGui(playerName);
			}
		});
		btnDefense4Info.setBounds(377, 171, 20, 16);
		panelTeam.add(btnDefense4Info);
		btnDefense4Info.setBackground(Color.YELLOW);
		
		btnMiddle1Info = new JButton("i");
		btnMiddle1Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[5].getText();
				createUserInfoGui(playerName);
			}
		});
		btnMiddle1Info.setBounds(77, 301, 20, 16);
		panelTeam.add(btnMiddle1Info);
		btnMiddle1Info.setBackground(Color.YELLOW);
		
		btnMiddle2Info = new JButton("i");
		btnMiddle2Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[6].getText();
				createUserInfoGui(playerName);
			}
		});
		btnMiddle2Info.setBounds(175, 301, 20, 16);
		panelTeam.add(btnMiddle2Info);
		btnMiddle2Info.setBackground(Color.YELLOW);
		
		btnMiddle3Info = new JButton("i");
		btnMiddle3Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[7].getText();
				createUserInfoGui(playerName);
				
			}
		});
		btnMiddle3Info.setBounds(291, 301, 20, 16);
		panelTeam.add(btnMiddle3Info);
		btnMiddle3Info.setBackground(Color.YELLOW);
		
		btnMiddle4Info = new JButton("i");
		btnMiddle4Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[8].getText();
				createUserInfoGui(playerName);
			}
		});
		btnMiddle4Info.setBounds(377, 301, 20, 16);
		panelTeam.add(btnMiddle4Info);
		btnMiddle4Info.setBackground(Color.YELLOW);
		
		btnForward1Info = new JButton("i");
		btnForward1Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[9].getText();
				createUserInfoGui(playerName);
			}
		});
		btnForward1Info.setBounds(175, 423, 20, 16);
		panelTeam.add(btnForward1Info);
		btnForward1Info.setBackground(Color.YELLOW);
		
		btnForward2Info = new JButton("i");
		btnForward2Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName=playerNameArray[10].getText();
				createUserInfoGui(playerName);
			}
		});
		btnForward2Info.setBounds(291, 423, 20, 16);
		panelTeam.add(btnForward2Info);
		btnForward2Info.setBackground(Color.YELLOW);
				
	}
	
	/**
	 * Initializes the GUI for player information
	 * @param playerName
	 */
	public void createUserInfoGui(String playerName) {
		if(playerName!="Name"){
			FootballPlayer player = game.getMarket().findPlayer(playerName);
			new PlayerInfoGui(player, game.getCurrentRound());
		}
	}

	/**
	 * Initializes the users as the team that he selected for the previous round
	 * @param userTeam
	 */
	public static void setTeam(UserTeam userTeam) {
		int i=0;
		for (Iterator<FootballPlayer> iterator = userTeam.getPlayers().values().iterator(); iterator
				.hasNext();) {
			FootballPlayer player = iterator.next();
			Statistics [] stats = player.getStats();
		    Statistics roundStats = stats[game.getCurrentRound()-1];
		    for (int j = 0; j<18; j++) {
				System.out.println(j + " " + player.getName() + " " + stats[j].getScore());
			}
			System.out.println(game.getCurrentRound());
			teamNames.get(i).setText(Game.getLastName(player.getName()));
			teamPoints.get(i).setText(roundStats.getScore() + "");
			teamImg.get(i).setIcon(MainGui.getShirt(player.getTeamName()));
			i++;
		}
	}
}
