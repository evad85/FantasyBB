package is.hbv401g.ui;

import is.hbv401g.dummy.FootballPlayer;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PlayerStatistics extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public PlayerStatistics(FootballPlayer player) {
		setPreferredSize(new Dimension(342,339));
		setLayout(null);
		
		JLabel labelSeasonStatistics = new JLabel("Season Statistics");
		labelSeasonStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeasonStatistics.setFont(new Font("Arial", Font.PLAIN, 16));
		labelSeasonStatistics.setBounds(0, 0, 342, 44);
		add(labelSeasonStatistics);
		
		JLabel labelPlayerName = new JLabel(player.getName());
		labelPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerName.setFont(new Font("Arial", Font.PLAIN, 14));
		labelPlayerName.setBounds(0, 49, 342, 44);
		add(labelPlayerName);
	    Object rowData[][] = { 	{ "Minutes played", player.getMinutes()},
	    						{ "Goals scored",  player.getGoals()},
	    						{ "Assists", player.getAssists()},
	    						{ "Goals Conceded", player.getGoalsConceded()},
	    						{ "Own Goals", player.getOwnGoals() },
	    						{ "Red Cards", player.getRedCards() },
	    						{ "Yellow Cards", player.getYellowCards() },
	    						{ "Saves", player.getSaves() }};
	    Object columnNames[] = { "Statistic", "Value" };
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 129, 342, 160);
		add(scrollPane);
		table = new JTable(rowData,columnNames);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}

}
