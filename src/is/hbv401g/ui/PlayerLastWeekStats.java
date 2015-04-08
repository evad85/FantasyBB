package is.hbv401g.ui;

import java.awt.Dimension;

import is.hbv401g.dummy.FootballPlayer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PlayerLastWeekStats extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PlayerLastWeekStats(FootballPlayer player, int gameRound) {
		setPreferredSize(new Dimension(342,339));
		setLayout(null);
		
		JLabel labelLastWeek = new JLabel("Last Week Statistics");
		labelLastWeek.setHorizontalAlignment(SwingConstants.CENTER);
		labelLastWeek.setFont(new Font("Arial", Font.PLAIN, 16));
		labelLastWeek.setBounds(0, 0, 342, 44);
		add(labelLastWeek);
		
		JLabel labelPlayerName = new JLabel(player.getName());
		labelPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerName.setFont(new Font("Arial", Font.PLAIN, 14));
		labelPlayerName.setBounds(0, 49, 342, 44);
		add(labelPlayerName);
	    Object rowData[][] = { 	{ "Minutes played", player.getStats()[gameRound].getMinutes()},
								{ "Goals scored",  player.getStats()[gameRound].getGoals()},
								{ "Assists", player.getStats()[gameRound].getAssists()},
								{ "Goals Conceded", player.getStats()[gameRound].getGoalsConceded()},
								{ "Own Goals", player.getStats()[gameRound].getOwnGoals()},
								{ "Red Cards", player.getStats()[gameRound].getRedCards()},
								{ "Yellow Cards", player.getStats()[gameRound].getYellowCards()},
								{ "Saves", player.getStats()[gameRound].getSaves() }};
	    Object columnNames[] = { "Statistic", "Value" };
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 129, 342, 160);
		add(scrollPane);
		table = new JTable(rowData,columnNames);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}
}
