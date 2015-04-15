package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.dummy.Statistics;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PlayerMainInfo extends JPanel {
	JButton button; 
	/**
	 * Create the panel.
	 */
	public PlayerMainInfo(FootballPlayer player, int gameRound) {
			setPreferredSize(new Dimension(342, 438));
			setLayout(null);
		    JPanel buttonPane = new JPanel();
		    
		    JLabel labelPlayerInfoName = new JLabel(player.getName());
		    labelPlayerInfoName.setBounds(0, 49, 342, 44);
		    add(labelPlayerInfoName);
		    labelPlayerInfoName.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelPlayerInfoName.setHorizontalAlignment(SwingConstants.CENTER);
		    
		    JPanel panelPlayerInfo = new JPanel();
		    panelPlayerInfo.setBackground(Color.WHITE);
		    panelPlayerInfo.setBounds(0, 129, 342, 160);
		    add(panelPlayerInfo);
		    panelPlayerInfo.setLayout(null);
		    
		    JPanel panelPositionInfo = new JPanel();
		    panelPositionInfo.setBackground(Color.WHITE);
		    panelPositionInfo.setLayout(null);
		    panelPositionInfo.setBounds(0, 40, 342, 40);
		    panelPlayerInfo.add(panelPositionInfo);
		    
		    JLabel labelPosition = new JLabel("Position:");
		    labelPosition.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelPosition.setHorizontalAlignment(SwingConstants.LEFT);
		    labelPosition.setBounds(10, 0, 83, 40);
		    panelPositionInfo.add(labelPosition);
		    
		    JLabel labelPlayerPosition = new JLabel(player.getPosition().getPos());
		    labelPlayerPosition.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelPlayerPosition.setHorizontalAlignment(SwingConstants.LEFT);
		    labelPlayerPosition.setBounds(103, 0, 228, 40);
		    panelPositionInfo.add(labelPlayerPosition);
		    
		    JPanel panelValueInfo = new JPanel();
		    panelValueInfo.setBackground(Color.WHITE);
		    panelValueInfo.setLayout(null);
		    panelValueInfo.setBounds(0, 80, 342, 40);
		    panelPlayerInfo.add(panelValueInfo);
		    
		    JLabel labelValue = new JLabel("Value:");
		    labelValue.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelValue.setHorizontalAlignment(SwingConstants.LEFT);
		    labelValue.setBounds(10, 0, 83, 40);
		    panelValueInfo.add(labelValue);
		    
		    JLabel labelPlayerValue = new JLabel(String.valueOf(player.getMarketValue()));
		    labelPlayerValue.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelPlayerValue.setHorizontalAlignment(SwingConstants.LEFT);
		    labelPlayerValue.setBounds(103, 0, 50, 40);
		    panelValueInfo.add(labelPlayerValue);
		    
		    JPanel panelTotalPoints = new JPanel();
		    panelTotalPoints.setBackground(Color.WHITE);
		    panelTotalPoints.setLayout(null);
		    panelTotalPoints.setBounds(0, 120, 342, 40);
		    panelPlayerInfo.add(panelTotalPoints);
		    
		    JLabel labelTotalPoints = new JLabel("Total Points:");
		    labelTotalPoints.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelTotalPoints.setHorizontalAlignment(SwingConstants.LEFT);
		    labelTotalPoints.setBounds(10, 0, 83, 40);
		    panelTotalPoints.add(labelTotalPoints);
		    
		    JLabel labelPlayerTotalPoints = new JLabel(String.valueOf(player.getScore()));
		    labelPlayerTotalPoints.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelPlayerTotalPoints.setHorizontalAlignment(SwingConstants.LEFT);
		    labelPlayerTotalPoints.setBounds(103, 0, 50, 40);
		    panelTotalPoints.add(labelPlayerTotalPoints);
		    
		    JPanel panelTeam = new JPanel();
		    panelTeam.setBackground(Color.WHITE);
		    panelTeam.setLayout(null);
		    panelTeam.setBounds(0, 0, 342, 40);
		    panelPlayerInfo.add(panelTeam);
		    
		    JLabel labelTeam = new JLabel("Team:");
		    labelTeam.setHorizontalAlignment(SwingConstants.LEFT);
		    labelTeam.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelTeam.setBounds(10, 0, 83, 40);
		    panelTeam.add(labelTeam);
		    
		    JLabel labelPlayerTeam = new JLabel(player.getTeamName());
		    labelPlayerTeam.setHorizontalAlignment(SwingConstants.LEFT);
		    labelPlayerTeam.setFont(new Font("Arial", Font.PLAIN, 14));
		    labelPlayerTeam.setBounds(103, 0, 228, 40);
		    panelTeam.add(labelPlayerTeam);
		    
		    JLabel labelKeyFacts = new JLabel("Key Facts");
		    labelKeyFacts.setHorizontalAlignment(SwingConstants.CENTER);
		    labelKeyFacts.setFont(new Font("Arial", Font.PLAIN, 16));
		    labelKeyFacts.setBounds(0, 0, 342, 44);
		    add(labelKeyFacts);
		    Statistics [] stats = player.getStats();
		    Statistics roundStats = stats[gameRound];
		    Object rowData[][] = { 	{ "Minutes played", roundStats.getMinutes()},
					{ "Goals scored",  roundStats.getGoals()},
					{ "Assists", roundStats.getAssists()},
					{ "Goals Conceded", roundStats.getGoalsConceded()},
					{ "Own Goals", roundStats.getOwnGoals() },
					{ "Red Cards", roundStats.getRedCards() },
					{ "Yellow Cards", roundStats.getYellowCards() },
					{ "Saves", roundStats.getSaves() }};
			Object columnNames[] = { "Statistic", "Value" };
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 129, 342, 160);
			add(scrollPane);
	}
}
