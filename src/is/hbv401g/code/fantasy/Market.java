package is.hbv401g.code.fantasy;

import java.util.ArrayList;
import java.util.List;

import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballPlayer;

/**
 * Market contains all the players in the league
 */
public class Market {
	
	private List <FootballPlayer> players;
	// core contains all the methods regarding the game simulation
	private final Core core;
	
	/**
	 * Creates a new player market
	 * @param core
	 */
	public Market(Core core) {
		this.core = core;
		FootballPlayer[] playerArray = core.getAllFootballPlayers();
		players = toList(playerArray);
	}
	
	/**
	 * Converts an Array to an ArrayList and returns it
	 * @param playerArray
	 * @return
	 */
	private List <FootballPlayer> toList(FootballPlayer[] playerArray) {
		List <FootballPlayer> players = new ArrayList <FootballPlayer>();
		for(int i = 0; i<playerArray.length; i++) {
			players.add(playerArray[i]);
		}
		return players;
	}
	
	/**
	 * Updates the player market 
	 */
	public void updateMarket() {
		players = toList(core.getAllFootballPlayers());
	}
	
	/**
	 * Returns the football player with the given name
	 * @param name
	 * @return
	 */
	public FootballPlayer findPlayer(String name) {
		FootballPlayer player = null;
		for(int i = 0; i<players.size(); i++) {
			String playerName = Game.getLastName(players.get(i).getName());
			if(playerName.equals(name)) {
				player = players.get(i);
			}
		}
		return player;	
	}
	
	/**
	 * Returns all the football players in the market
	 * @return
	 */
	public List <FootballPlayer> getAllPlayers() {
		return players;
	}
	
	/**
	 * Returns all the football players in the market that play 
	 * for a given team
	 * @param name
	 * @return
	 */
	public List <FootballPlayer> getAllPlayersByTeamName(String name) {
		List <FootballPlayer> newPlayers = new ArrayList <FootballPlayer>();
		for (int i = 0; i<players.size(); i++) {
			String teamName = players.get(i).getTeamName();
			if (teamName.equals(name)) {
				newPlayers.add(players.get(i));
			}
		}
		return newPlayers;
	}
	
	/**
	 * Returns all the football players in the market that play a
	 * given position
	 * @param position
	 * @return
	 */
	public List <FootballPlayer> getAllPlayersByPosition(String position) {
		List <FootballPlayer> newPlayers = new ArrayList <FootballPlayer>();
		for (int i = 0; i<players.size(); i++) {
			String playerPosition = players.get(i).getPosition().getPos();
			if (playerPosition.equals(position)) {
				newPlayers.add(players.get(i));
			}
		}
		return newPlayers;
	}
}
