package is.hbv401g.mock;

import java.util.HashMap;
import java.util.Random;

import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.FootballPlayer;

public class RandomNumberOfPlayersMock {
	
	HashMap<String, FootballPlayer> players;
	
	
	public RandomNumberOfPlayersMock() {
		// TODO Auto-generated constructor stub
		players = new HashMap<String, FootballPlayer>();

		
	}

	public int getNumberOfPlayers() {
		Random rand = new Random();
	    int randomNum = rand.nextInt((15 - 0) + 1) + 0;
		return randomNum;
	}
	
	public HashMap<String, FootballPlayer> getPlayers() {
		return players;
	}

}
