package is.hbv401g.ui;

import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 * Utils contains variables and methods that classes utilize together
 *
 */
public class Utils {
	
	private static HashMap<String, ImageIcon> shirts;
	private static HashMap<String, ImageIcon> logos;
	
	public Utils() {
		shirts = new HashMap<String, ImageIcon>();
		logos = new HashMap<String, ImageIcon>();
	}

	/**
	 * Links together a team name and a image for the teams shirt
	 */
	public static void initShirts(){
		shirts.put("Arsenal", new ImageIcon(Transfers.class.getResource("/resources/arsenal_shirt.png")));
		shirts.put("Chelsea", new ImageIcon(Transfers.class.getResource("/resources/chelsea_shirt.png")));
		shirts.put("Stoke", new ImageIcon(Transfers.class.getResource("/resources/stoke_shirt.png")));
		shirts.put("Man Utd", new ImageIcon(Transfers.class.getResource("/resources/manutd_shirt.png")));
		shirts.put("Man City", new ImageIcon(Transfers.class.getResource("/resources/mancity_shirt.png")));
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
	public static void initLogo(){
		logos.put("Arsenal", new ImageIcon(Transfers.class.getResource("/resources/arsenal.png")));
		logos.put("Chelsea", new ImageIcon(Transfers.class.getResource("/resources/chelsea.png")));
		logos.put("Stoke", new ImageIcon(Transfers.class.getResource("/resources/stoke.png")));
		logos.put("Man Utd", new ImageIcon(Transfers.class.getResource("/resources/manutd.png")));
		logos.put("Man City", new ImageIcon(Transfers.class.getResource("/resources/mancity.png")));
		logos.put("Southampton", new ImageIcon(Transfers.class.getResource("/resources/southampton.png")));
		logos.put("Swansea", new ImageIcon(Transfers.class.getResource("/resources/swansea.png")));
		logos.put("Spurs", new ImageIcon(Transfers.class.getResource("/resources/spurs.png")));
		logos.put("West Ham", new ImageIcon(Transfers.class.getResource("/resources/westham.png")));
		logos.put("Liverpool", new ImageIcon(Transfers.class.getResource("/resources/liverpool.png")));
			
	}
}
