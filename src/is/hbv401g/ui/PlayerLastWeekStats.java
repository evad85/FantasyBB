package is.hbv401g.ui;

import java.awt.Dimension;

import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.dummy.Statistics;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * PlayerLastWeekStats displays statistics for players in a users roster in
 * the previous round
 */
public class PlayerLastWeekStats extends JPanel {

	private static final long serialVersionUID = -1767010612727821441L;
	private JTable table;

	/**
	 * Initilaize the GUI
	 * @param player
	 * @param gameRound
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
		Statistics [] stats = player.getStats();
	    Statistics roundStats = stats[gameRound-1];
	    Object rowData[][] = { 	{ "Minutes played", roundStats.getMinutes()},
								{ "Goals scored",  roundStats.getGoals()},
								{ "Assists", roundStats.getAssists()},
								{ "Goals Conceded", roundStats.getGoalsConceded()},
								{ "Own Goals", roundStats.getOwnGoals()},
								{ "Red Cards", roundStats.getRedCards()},
								{ "Yellow Cards", roundStats.getYellowCards()},
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
