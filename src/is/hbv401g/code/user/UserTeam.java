package is.hbv401g.code.user;

import is.hbv401g.dummy.FootballPlayer;

import java.util.HashMap;

/**
 * UserTeam contains the players a particular user has selected for a given 
 * round
 *
 */
public class UserTeam {
	
	// players is all the football players a user has selected
	// for his team
	private static HashMap<String, FootballPlayer> players;
	
	/**
	 * Creates a new UserTeam
	 */
	public UserTeam() {
		players = new HashMap<String, FootballPlayer>();
	}
	
	/**
	 * Returns the number of players a user has selected for 
	 * his team
	 * @return
	 */
	public int size() {
		return players.size();
	}
	
	/**
	 * Returns all the players a user has selected for his team
	 * @return
	 */
	public HashMap<String, FootballPlayer> getPlayers() {
		return players;
	}
	
	/**
	 * Adds a new player to a users team
	 * @param name
	 * @param player
	 */
	public void addPlayer(String name, FootballPlayer player) {
		players.put(name, player);
	}
	
	/**
	 * Removes the player with a particular name from the users
	 * team
	 * @param name
	 */
	public void removePlayer(String name) {
		players.remove(name);
	}
	
	/**
	 * Returns true if a users team contains a player with a
	 * particular name
	 * @param name
	 * @return
	 */
	public boolean containsPlayer(String name) {
		return players.containsKey(name);
	}
}
