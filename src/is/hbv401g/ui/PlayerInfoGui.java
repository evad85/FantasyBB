package is.hbv401g.ui;


import is.hbv401g.dummy.FootballPlayer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

/**
 * PlayerInfoGui displays informations about players in a users roster
 */
public class PlayerInfoGui extends JDialog implements ActionListener {

	private static final long serialVersionUID = -8033559734669396904L;
	
	public PlayerInfoGui(FootballPlayer player, int gameRound) {
	setLocation(400, 400);
	setPreferredSize(new Dimension(350, 350));
    getContentPane().setLayout(null);
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBorder(null);
    tabbedPane.setBounds(0, 0, 334, 348);
    getContentPane().add(tabbedPane);
    PlayerMainInfo panelPlayerMainInfo= new PlayerMainInfo(player, gameRound);
    PlayerStatistics panelPlayerStatistics= new PlayerStatistics(player, gameRound);
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
