package is.hbv401g.ui;

import is.hbv401g.code.fantasy.Game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import java.awt.CardLayout;
import java.util.HashMap;

/**
 * MainGui creates the GUI panels for the game
 */
public class MainGui extends JFrame {
	private static final long serialVersionUID = 4142339874276567129L;
	private static JPanel contentPane;
	private static CardLayout cardLayout = new CardLayout();
	private final static Game game = new Game();
	
	private static HashMap<String, ImageIcon> shirts = new HashMap<String, ImageIcon>();
	private static HashMap<String, ImageIcon> logos = new HashMap<String, ImageIcon>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 800, 700);
		setContentPane(contentPane);
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		PlayRound panelPlayRound = new PlayRound(game);		
		StartGui panelStart = new StartGui(game);
		JTabbedPane panelUser = new JTabbedPane(JTabbedPane.TOP);		
		
		contentPane.add(panelPlayRound, "panelPlayRound");
		contentPane.add(panelUser, "panelUser");
		contentPane.add(panelStart, "panelStart");
		cardLayout.show(contentPane, "panelStart");
		
		
		UserGui panelUserGui = new UserGui(game);
		panelUser.addTab("User", null, panelUserGui, null);
		
		Schedule panelSchedule = new Schedule(game);
		panelUser.addTab("Schedule", null, panelSchedule, null);
		
		Transfers panelTransfers = new Transfers(game);
		panelUser.addTab("Tansfers", null, panelTransfers, null);	
	}
	
	/**
	 * Shows a cardlayout
	 * @param type
	 */
	public static void showCardLayout(String type ) {
		cardLayout.show(contentPane, type);
	}
	
	/**
	 * Links together a team name and a image for the teams shirt
	 */
	public static void initShirts(){
		shirts.put("Arsenal", new ImageIcon(Transfers.class.getResource("/resources/arsenal_shirt.png")));
		shirts.put("Chelsea", new ImageIcon(Transfers.class.getResource("/resources/chelsea_shirt.png")));
		shirts.put("Stoke", new ImageIcon(Transfers.class.getResource("/resources/stoke_shirt.png")));
		shirts.put("Manchester United", new ImageIcon(Transfers.class.getResource("/resources/manutd_shirt.png")));
		shirts.put("Manchester City", new ImageIcon(Transfers.class.getResource("/resources/mancity_shirt.png")));
		shirts.put("Southampton", new ImageIcon(Transfers.class.getResource("/resources/southampton_shirt.png")));
		shirts.put("Swansea", new ImageIcon(Transfers.class.getResource("/resources/swansea_shirt.png")));
		shirts.put("Spurs", new ImageIcon(Transfers.class.getResource("/resources/spurs_shirt.png")));
		shirts.put("West Ham", new ImageIcon(Transfers.class.getResource("/resources/westham_shirt.png")));
		shirts.put("Liverpool", new ImageIcon(Transfers.class.getResource("/resources/liverpool_shirt.png")));
		shirts.put("noTeam", new ImageIcon(Transfers.class.getResource("/resources/no_team.png")));		
	}
	
	/**
	 * Links together a team name and a image for the teams logos
	 */
	public static void initLogos(){
		logos.put("Arsenal", new ImageIcon(Transfers.class.getResource("/resources/arsenal.png")));
		logos.put("Chelsea", new ImageIcon(Transfers.class.getResource("/resources/chelsea.png")));
		logos.put("Stoke", new ImageIcon(Transfers.class.getResource("/resources/stoke.png")));
		logos.put("Manchester United", new ImageIcon(Transfers.class.getResource("/resources/manutd.png")));
		logos.put("Manchester City", new ImageIcon(Transfers.class.getResource("/resources/mancity.png")));
		logos.put("Southampton", new ImageIcon(Transfers.class.getResource("/resources/southampton.png")));
		logos.put("Swansea", new ImageIcon(Transfers.class.getResource("/resources/swansea.png")));
		logos.put("Spurs", new ImageIcon(Transfers.class.getResource("/resources/spurs.png")));
		logos.put("West Ham", new ImageIcon(Transfers.class.getResource("/resources/westham.png")));
		logos.put("Liverpool", new ImageIcon(Transfers.class.getResource("/resources/liverpool.png")));
			
	}
	
	/**
	 * returns the game variable
	 * @return
	 */
	public static Game getGame(){
		return game;
	}
	
	/**
	 * Returns the ImageIcon for a given team
	 * @param name
	 * @return
	 */
	public static ImageIcon getShirt(String name) {
		return shirts.get(name);
	}
	
	/**
	 * Returns the ImageIcon logo for a given team
	 * @param name
	 * @return
	 */
	public static ImageIcon getLogo(String name) {
		return logos.get(name);
	}
}
