package is.hbv401g.ui;

import java.util.ArrayList;
import java.util.Arrays;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.dummy.FootballTeam;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
	private static Game game;
	private FootballTeam[][] teams;
	private ArrayList<FootballTeam> schedule = new ArrayList<FootballTeam>();
	private ArrayList<JLabel> teamLabels;
	private static ArrayList<JLabel> logoLabels;

	/**
	 * Create the panel.
	 */
	public Schedule(final Game game) {
		setLocation(-249, -61);
		setLayout(null);
		
		initView();
		Schedule.game = game;
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
	 * Initializes the GUI
	 */
	private void initView(){
		MainGui.initLogos();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(165, 84, 623, 254);
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
		lblScheduleForNext.setBounds(348, 28, 216, 16);
		add(lblScheduleForNext);
		
		teamLabels = new ArrayList<JLabel>(Arrays.asList(home_1, away_1, home_2, away_2,home_3, away_3,home_4, away_4,home_5, away_5 ));
		logoLabels = new ArrayList<JLabel>(Arrays.asList(home_img1, away_img1, home_img2, away_img2,home_img3, away_img3,home_img5, away_img4,home_img4, away_img5 ));
	}
}
