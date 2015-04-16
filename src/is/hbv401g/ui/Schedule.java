package is.hbv401g.ui;

import java.util.ArrayList;
import java.util.Arrays;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.FootballTeam;
import is.hbv401g.dummy.MatchResults;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * Displays the schedule for next round
 *
 */
public class Schedule extends JPanel {
	private static final long serialVersionUID = 208275117573517329L;
	private static FootballTeam[][] teams;
	private static ArrayList<FootballTeam> schedule = new ArrayList<FootballTeam>();
	private static ArrayList<JLabel> teamLabels;
	private static ArrayList<JLabel> logoLabels;
	
	private static ArrayList<JLabel> homeLabels;
	private static ArrayList<JLabel> homeLogoLabels;
	private static ArrayList<JLabel> awayLabels;
	private static ArrayList<JLabel> awayLogoLabels;
	private static ArrayList<JLabel> scoreLabels;
	
	private static MatchResults[] lastRoundResults;

	/**
	 * Create the panel.
	 */
	public Schedule(final Game game) {
		setLocation(-249, -61);
		setLayout(null);

		initView();
		teams = game.getCore().getScheduleForNextRound();
		

		for (int i = 0; i < teams.length; i++) {
		    for (int j = 0; j < teams[i].length; j++) {
		        FootballTeam team = teams[i][j];
		        schedule.add(team);
		    }
		}
		
		for (int i = 0; i < schedule.size(); i++) {
			teamLabels.get(i).setText(schedule.get(i).getName());
			logoLabels.get(i).setIcon(MainGui.getLogo(schedule.get(i).getName()));
		}	
	}
	
	/**
	 * Update match results
	 *
	 */
	public static void updateMatchResults(Game game){
		if (game.getCurrentRound() > 1) {
			lastRoundResults = game.getMatchResults();
			System.out.println("magnea" + lastRoundResults[1].getAwayTeam().getName());
		}
		
		for (int i = 0; i < lastRoundResults.length; i++) {
			homeLabels.get(i).setText(lastRoundResults[i].getHomeTeam().getName());
			awayLabels.get(i).setText(lastRoundResults[i].getAwayTeam().getName());
			scoreLabels.get(i).setText(lastRoundResults[i].getHomeGoals() + " - " + lastRoundResults[i].getAwayGoals());
			homeLogoLabels.get(i).setIcon(MainGui.getLogo(lastRoundResults[i].getHomeTeam().getName()));
			awayLogoLabels.get(i).setIcon(MainGui.getLogo(lastRoundResults[i].getAwayTeam().getName()));
		}	
		
		teams = game.getCore().getScheduleForNextRound();
		schedule = new ArrayList<FootballTeam>();
		System.out.println(schedule.size());

		for (int i = 0; i < teams.length; i++) {
		    for (int j = 0; j < teams[i].length; j++) {
		        FootballTeam team = teams[i][j];
		        System.out.println(teams[i][j].getName());
		        schedule.add(team);
		    }
		}
		
		for (int i = 0; i < schedule.size(); i++) {
			teamLabels.get(i).setText(schedule.get(i).getName());
			logoLabels.get(i).setIcon(MainGui.getLogo(schedule.get(i).getName()));
		}	
	}
	
	
	/**
	 * Initializes the GUI
	 */
	private void initView(){
		MainGui.initLogos();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(24, 76, 623, 254);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("ProgressBar.background")));
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(6, 6, 608, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel home_img1 = new JLabel("");
		home_img1.setBounds(202, 0, 53, 38);
		panel_1.add(home_img1);
		home_img1.setBackground(Color.ORANGE);
		home_img1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel home_1 = new JLabel("New label");
		home_1.setBounds(0, 10, 182, 28);
		panel_1.add(home_1);
		home_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
				
		JLabel away_1 = new JLabel("New label");
		away_1.setBounds(419, 6, 189, 32);
		panel_1.add(away_1);
		away_1.setHorizontalAlignment(SwingConstants.LEFT);
		
				
		JLabel lblVs = new JLabel("vs");
		lblVs.setBounds(267, 16, 61, 16);
		panel_1.add(lblVs);
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel away_img1 = new JLabel("");
		away_img1.setBounds(354, 0, 53, 38);
		panel_1.add(away_img1);
		away_img1.setBackground(Color.ORANGE);
		away_img1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(6, 51, 608, 53);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel home_img2 = new JLabel("");
		home_img2.setBounds(202, 6, 53, 38);
		panel_2.add(home_img2);
		home_img2.setBackground(Color.ORANGE);
		home_img2.setHorizontalAlignment(SwingConstants.CENTER);
				
				
		JLabel home_2 = new JLabel("New label");
		home_2.setBounds(0, 12, 182, 28);
		panel_2.add(home_2);
		home_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
				
		JLabel away_2 = new JLabel("New label");
		away_2.setBounds(419, 10, 189, 32);
		panel_2.add(away_2);
		away_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblVs_1 = new JLabel("vs");
		lblVs_1.setBounds(267, 18, 61, 16);
		panel_2.add(lblVs_1);
		lblVs_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel away_img2 = new JLabel("");
		away_img2.setBounds(354, 6, 53, 38);
		panel_2.add(away_img2);
		away_img2.setBackground(Color.ORANGE);
		away_img2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel_3.setBounds(6, 105, 608, 47);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel home_img3 = new JLabel("");
		home_img3.setBounds(202, 6, 53, 38);
		panel_3.add(home_img3);
		home_img3.setBackground(Color.ORANGE);
		home_img3.setHorizontalAlignment(SwingConstants.CENTER);
		
				
		JLabel home_3 = new JLabel("New label");
		home_3.setBounds(0, 6, 182, 28);
		panel_3.add(home_3);
		home_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
				
		JLabel away_3 = new JLabel("New label");
		away_3.setBounds(419, 6, 189, 28);
		panel_3.add(away_3);
		away_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblVs_2 = new JLabel("vs");
		lblVs_2.setBounds(267, 12, 61, 16);
		panel_3.add(lblVs_2);
		lblVs_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel away_img3 = new JLabel("");
		away_img3.setBounds(354, 6, 53, 38);
		panel_3.add(away_img3);
		away_img3.setBackground(Color.ORANGE);
		away_img3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel_5.setBounds(6, 200, 608, 47);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel home_img5 = new JLabel("");
		home_img5.setBounds(202, 7, 53, 38);
		panel_5.add(home_img5);
		home_img5.setBackground(Color.ORANGE);
		home_img5.setHorizontalAlignment(SwingConstants.CENTER);
		
				
		JLabel home_5 = new JLabel("New label");
		home_5.setBounds(0, 7, 182, 28);
		panel_5.add(home_5);
		home_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
				
		JLabel away_5 = new JLabel("New label");
		away_5.setBounds(419, 7, 189, 28);
		panel_5.add(away_5);
		away_5.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblVs_4 = new JLabel("vs");
		lblVs_4.setBounds(267, 13, 61, 16);
		panel_5.add(lblVs_4);
		lblVs_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel away_img5 = new JLabel("");
		away_img5.setBounds(354, 6, 53, 39);
		panel_5.add(away_img5);
		away_img5.setHorizontalAlignment(SwingConstants.CENTER);
		away_img5.setBackground(Color.ORANGE);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(6, 152, 608, 47);
		panel.add(panel_4);
		panel_4.setLayout(null);

		
		JLabel home_4 = new JLabel("New label");
		home_4.setBounds(0, 6, 182, 26);
		panel_4.add(home_4);
		home_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
				
		JLabel away_4 = new JLabel("New label");
		away_4.setBounds(419, 6, 189, 28);
		panel_4.add(away_4);
		away_4.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblVs_3 = new JLabel("vs");
		lblVs_3.setBounds(267, 11, 61, 16);
		panel_4.add(lblVs_3);
		lblVs_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel home_img4 = new JLabel("");
		home_img4.setBounds(202, 6, 53, 38);
		panel_4.add(home_img4);
		home_img4.setHorizontalAlignment(SwingConstants.CENTER);
		home_img4.setBackground(Color.ORANGE);
		
		JLabel away_img4 = new JLabel("");
		away_img4.setBounds(354, 6, 53, 38);
		panel_4.add(away_img4);
		away_img4.setHorizontalAlignment(SwingConstants.CENTER);
		away_img4.setBackground(Color.ORANGE);
		
		JLabel lblScheduleForNext = new JLabel("Schedule for next round");
		lblScheduleForNext.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblScheduleForNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblScheduleForNext.setBounds(205, 29, 216, 16);
		add(lblScheduleForNext);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(287, 398, 61, 16);
		add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(211, 211, 211));
		panel_6.setBounds(699, 76, 623, 254);
		add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(UIManager.getColor("ProgressBar.background")));
		panel_7.setBackground(SystemColor.textHighlight);
		panel_7.setBounds(6, 6, 608, 47);
		panel_6.add(panel_7);
		
		JLabel himg_1 = new JLabel("");
		himg_1.setHorizontalAlignment(SwingConstants.CENTER);
		himg_1.setBackground(Color.ORANGE);
		himg_1.setBounds(202, 0, 53, 38);
		panel_7.add(himg_1);
		
		JLabel h_1 = new JLabel("New label");
		h_1.setHorizontalAlignment(SwingConstants.RIGHT);
		h_1.setBounds(0, 10, 182, 28);
		panel_7.add(h_1);
		
		JLabel a_1 = new JLabel("New label");
		a_1.setHorizontalAlignment(SwingConstants.LEFT);
		a_1.setBounds(419, 6, 189, 32);
		panel_7.add(a_1);
		
		JLabel score1 = new JLabel("vs");
		score1.setHorizontalAlignment(SwingConstants.CENTER);
		score1.setBounds(267, 16, 61, 16);
		panel_7.add(score1);
		
		JLabel aimg_1 = new JLabel("");
		aimg_1.setHorizontalAlignment(SwingConstants.CENTER);
		aimg_1.setBackground(Color.ORANGE);
		aimg_1.setBounds(354, 0, 53, 38);
		panel_7.add(aimg_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(6, 51, 608, 53);
		panel_6.add(panel_8);
		
		JLabel himg_2 = new JLabel("");
		himg_2.setHorizontalAlignment(SwingConstants.CENTER);
		himg_2.setBackground(Color.ORANGE);
		himg_2.setBounds(202, 6, 53, 38);
		panel_8.add(himg_2);
		
		JLabel h_2 = new JLabel("New label");
		h_2.setHorizontalAlignment(SwingConstants.RIGHT);
		h_2.setBounds(0, 12, 182, 28);
		panel_8.add(h_2);
		
		JLabel a_2 = new JLabel("New label");
		a_2.setHorizontalAlignment(SwingConstants.LEFT);
		a_2.setBounds(419, 10, 189, 32);
		panel_8.add(a_2);
		
		JLabel score2 = new JLabel("vs");
		score2.setHorizontalAlignment(SwingConstants.CENTER);
		score2.setBounds(267, 18, 61, 16);
		panel_8.add(score2);
		
		JLabel aimg_2 = new JLabel("");
		aimg_2.setHorizontalAlignment(SwingConstants.CENTER);
		aimg_2.setBackground(Color.ORANGE);
		aimg_2.setBounds(354, 6, 53, 38);
		panel_8.add(aimg_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(SystemColor.textHighlight);
		panel_9.setBounds(6, 105, 608, 47);
		panel_6.add(panel_9);
		
		JLabel himg_3 = new JLabel("");
		himg_3.setHorizontalAlignment(SwingConstants.CENTER);
		himg_3.setBackground(Color.ORANGE);
		himg_3.setBounds(202, 6, 53, 38);
		panel_9.add(himg_3);
		
		JLabel h_3 = new JLabel("New label");
		h_3.setHorizontalAlignment(SwingConstants.RIGHT);
		h_3.setBounds(0, 6, 182, 28);
		panel_9.add(h_3);
		
		JLabel a_3 = new JLabel("New label");
		a_3.setHorizontalAlignment(SwingConstants.LEFT);
		a_3.setBounds(419, 6, 189, 28);
		panel_9.add(a_3);
		
		JLabel score3 = new JLabel("vs");
		score3.setHorizontalAlignment(SwingConstants.CENTER);
		score3.setBounds(267, 12, 61, 16);
		panel_9.add(score3);
		
		JLabel aimg_3 = new JLabel("");
		aimg_3.setHorizontalAlignment(SwingConstants.CENTER);
		aimg_3.setBackground(Color.ORANGE);
		aimg_3.setBounds(354, 6, 53, 38);
		panel_9.add(aimg_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(SystemColor.textHighlight);
		panel_10.setBounds(6, 200, 608, 47);
		panel_6.add(panel_10);
		
		JLabel himg_5 = new JLabel("");
		himg_5.setHorizontalAlignment(SwingConstants.CENTER);
		himg_5.setBackground(Color.ORANGE);
		himg_5.setBounds(202, 7, 53, 38);
		panel_10.add(himg_5);
		
		JLabel h_5 = new JLabel("New label");
		h_5.setHorizontalAlignment(SwingConstants.RIGHT);
		h_5.setBounds(0, 7, 182, 28);
		panel_10.add(h_5);
		
		JLabel a_5 = new JLabel("New label");
		a_5.setHorizontalAlignment(SwingConstants.LEFT);
		a_5.setBounds(419, 7, 189, 28);
		panel_10.add(a_5);
		
		JLabel score5 = new JLabel("vs");
		score5.setHorizontalAlignment(SwingConstants.CENTER);
		score5.setBounds(267, 13, 61, 16);
		panel_10.add(score5);
		
		JLabel aimg_5 = new JLabel("");
		aimg_5.setHorizontalAlignment(SwingConstants.CENTER);
		aimg_5.setBackground(Color.ORANGE);
		aimg_5.setBounds(354, 6, 53, 39);
		panel_10.add(aimg_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(6, 152, 608, 47);
		panel_6.add(panel_11);
		
		JLabel h_4 = new JLabel("New label");
		h_4.setHorizontalAlignment(SwingConstants.RIGHT);
		h_4.setBounds(0, 6, 182, 26);
		panel_11.add(h_4);
		
		JLabel a_4 = new JLabel("New label");
		a_4.setHorizontalAlignment(SwingConstants.LEFT);
		a_4.setBounds(419, 6, 189, 28);
		panel_11.add(a_4);
		
		JLabel score4 = new JLabel("vs");
		score4.setHorizontalAlignment(SwingConstants.CENTER);
		score4.setBounds(267, 11, 61, 16);
		panel_11.add(score4);
		
		JLabel himg_4 = new JLabel("");
		himg_4.setHorizontalAlignment(SwingConstants.CENTER);
		himg_4.setBackground(Color.ORANGE);
		himg_4.setBounds(202, 6, 53, 38);
		panel_11.add(himg_4);
		
		JLabel aimg_4 = new JLabel("");
		aimg_4.setHorizontalAlignment(SwingConstants.CENTER);
		aimg_4.setBackground(Color.ORANGE);
		aimg_4.setBounds(354, 6, 53, 38);
		panel_11.add(aimg_4);
		
		teamLabels = new ArrayList<JLabel>(Arrays.asList(home_1, away_1, home_2, away_2,home_3, away_3,home_4, away_4,home_5, away_5 ));
		logoLabels = new ArrayList<JLabel>(Arrays.asList(home_img1, away_img1, home_img2, away_img2,home_img3, away_img3,home_img4, away_img4,home_img5, away_img5 ));
		
		homeLabels = new ArrayList<JLabel>(Arrays.asList(h_1,h_2,h_3,h_4,h_5));
		homeLogoLabels = new ArrayList<JLabel>(Arrays.asList(himg_1,himg_2,himg_3,himg_4,himg_5));
		awayLabels = new ArrayList<JLabel>(Arrays.asList(a_1, a_2,a_3, a_4, a_5));
		awayLogoLabels = new ArrayList<JLabel>(Arrays.asList(aimg_1, aimg_2,aimg_3,aimg_4, aimg_5 ));
		scoreLabels = new ArrayList<JLabel>(Arrays.asList(score1, score2, score3,score4, score5 ));
		
	}
}
