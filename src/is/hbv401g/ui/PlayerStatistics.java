package is.hbv401g.ui;

import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.dummy.Statistics;

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
	public PlayerStatistics(FootballPlayer player, int gameRound) {
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
		table = new JTable(rowData,columnNames);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}

}
