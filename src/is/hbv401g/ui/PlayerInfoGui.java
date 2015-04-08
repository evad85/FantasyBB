package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;
import is.hbv401g.code.fantasy.Market;
import is.hbv401g.dummy.FootballPlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTabbedPane;
public class PlayerInfoGui extends JDialog implements ActionListener {

  public PlayerInfoGui(FootballPlayer player, int gameRound) {
	setLocation(400, 400);
	setPreferredSize(new Dimension(350, 350));
    getContentPane().setLayout(null);
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBorder(null);
    tabbedPane.setBounds(0, 0, 334, 312);
    getContentPane().add(tabbedPane);
    PlayerMainInfo panelPlayerMainInfo= new PlayerMainInfo(player);
    PlayerStatistics panelPlayerStatistics= new PlayerStatistics(player);
    PlayerLastWeekStats panelPlayerLastWeek= new PlayerLastWeekStats(player, gameRound);
    tabbedPane.addTab("Key Facts", null, panelPlayerMainInfo, null);
    tabbedPane.addTab("Statistics", null, panelPlayerStatistics, null);
    tabbedPane.addTab("Last Round", null, panelPlayerLastWeek, null);
    panelPlayerMainInfo.setLayout(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack(); 
    setVisible(true);
    
    
  }
  public void actionPerformed(ActionEvent e) {
    setVisible(false); 
    dispose(); 
  }


}
