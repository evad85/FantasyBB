package is.hbv401g.code.fantasy;

import is.hbv401g.code.user.User;
import is.hbv401g.code.user.UserTeam;
import is.hbv401g.dummy.Core;
import is.hbv401g.dummy.FootballPlayer;
import is.hbv401g.dummy.Statistics;
import is.hbv401g.ui.MainGui;
import is.hbv401g.ui.PlayRound;
import is.hbv401g.ui.Transfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Game is main Model class and the link between all the GUI classes and the other Model
 * classes 
 * 
 */
public class Game {
	private final List <User> users;
	// tmpTeam is the team the current user is selecting for the
	// next round
	private UserTeam tmpTeam;
	private int roundNumber = 1;
	private final int maxRounds = 3;
	// userTurn is the number of the user in the users List
	// that is currently selecting his team
	private int userTurn = 0;
	// core contains all the methods regarding the game simulation
	private final Core core;
	// market contains information about all the football players
	private Market market;
	
	/**
	 * Creates a new game
	 */
	public Game() {
		users = new ArrayList<>();
		tmpTeam = new UserTeam();
		core = new Core();
		market = new Market(core);
	}
	/**
	 * Creates a new user
	 * @param userName
	 */
	public void addNewUser(String userName) {
		User newUser = new User(userName, this);
		users.add(newUser);
	}
	
	/**
	 * Sets the team the user has selected for the next round
	 */
	public void updateUserTeam() {
		User user = users.get(userTurn);
		System.out.println(user.getName());
		System.out.println(tmpTeam.size());
		UserTeam roundTeam = new UserTeam();
		roundTeam.putAll(tmpTeam.getPlayers());
		System.out.println(roundNumber);
		System.out.println(roundTeam.size());
		System.out.println("dfdfdfd");
		user.setUserTeam(roundTeam, roundNumber);
		System.out.println("dfdfdfd");
		tmpTeam = new UserTeam();
	}
	
	/**
	 * Adds a new player to the team the user is selecting for
	 * the next round
	 * @param name
	 * @return
	 */
	public int addPlayer(String name) {
		User user = users.get(userTurn);
		FootballPlayer player = market.findPlayer(name);
		double marketValue = player.getMarketValue();
		System.out.println("budget before buy" + user.getBudget());
		
		if(tmpTeam.containsPlayer(name)) {
			return 1;
		} 
		else if(user.hasEnoughBudget(marketValue)) {
			tmpTeam.addPlayer(name, player);
			user.updateBudget(marketValue, "-");
			System.out.println("budget " + user.getBudget());
			System.out.println("marketvalue " +marketValue);
			System.out.println("budget after buy" + user.getBudget());
			return 0;
		}
		return -1;
	}
	
	/**
	 * Removes a player from the team the user is selecting
	 * for the next round
	 * @param name
	 */
	public void removePlayer(String name) {
		User user = users.get(userTurn);
		FootballPlayer player = market.findPlayer(name);
		double marketValue = player.getMarketValue();
		
		if (tmpTeam.size() > 0) {
			user.updateBudget(marketValue, "+");
			tmpTeam.removePlayer(name);
		}
		System.out.println("budget after sell" + user.getBudget());
	}
	
	/**
	 * Returns all the users
	 * @return
	 */
	public List<User> getUsers() {
		return users;
	}
	
	/**
	 * Returns the current user
	 * @return
	 */
	public User getCurrentUser() {
		return users.get(userTurn);
	}
	
	/**
	 * Sets the current user
	 * @param userNum
	 */
	public void setCurrentUser(int userNum) {
		userTurn = userNum;
	}
	
	/**
	 * Ends the current round and starts a new one
	 */
	public void endRound() {
		if (roundNumber>maxRounds) {
			System.out.println("hae �etta er MAX ROUNDS! LEIKUR �TTI A� VERA B�INN");
			endGame();
		} else {
			System.out.println("�ETTA er r�tt leikur er ekki b�inn round: "+ getCurrentRound());
			core.simulateNextRound();
			System.out.println("B�INN A� SIMULATA ROUND ");
			FootballPlayer[] players = core.getAllFootballPlayers();
			for (int i = 0; i<players.length; i++) {
				Statistics[] stats = players[i].getStats();
				System.out.println(players[i].getName() + " " + stats[1].getGoals());
			}
			calculatePoints();
			roundNumber++;
		}
		users.get(0).setTransferFinished(false);
		users.get(1).setTransferFinished(false);
	}
	
	//TODO
	private void endGame() {
		PlayRound.endGame();
		int score1 = users.get(0).getPoints();
		int score2 = users.get(1).getPoints();
		String winnerString;
		if(score1 > score2){
			winnerString = users.get(0).getName() + " " + "won!";
		}
		else if (score2 > score1) {
			winnerString = users.get(1).getName() + " " + "won!";;
		}
		else {
			winnerString = "there was a tie!";
		}
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(Game.class.getResource("/resources/cup.png"));
		JOptionPane.showMessageDialog(null, winnerString, "Congratulations", JOptionPane.OK_OPTION, icon);
	}
	
	/**
	 * Returns core
	 * @return
	 */
	public Core getCore() {
		return core;
	}
	
	/**
	 * Returns the number of the current user
	 * @return
	 */
	public int getUserTurn() {
		return userTurn;
	}
	
	// TODO
		private void calculatePoints() {
			for (int i = 0; i<2; i++){
				User user = users.get(i);
				int currentRound=roundNumber;
				HashMap <String, FootballPlayer> team = user.getUserTeam(currentRound).getPlayers();
				int points = 0;
				
				Iterator it = team.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        String name = (String) pair.getKey();
			        FootballPlayer player = market.findPlayer(Game.getLastName(name));
					Statistics [] stats = player.getStats();
					System.out.println("Score: " + player.getStats()[currentRound].getScore() + " Player " + player.getName());
					points += player.getStats()[currentRound].getScore();  	        
			    }
			    System.out.println("Poiints " + points + user.getName());
				user.updatePoints(points);
			}
		}
	
	/**
	 * Returns the current round
	 * @return
	 */
	public int getCurrentRound() {
		return roundNumber;
	}
	
	/**
	 * Returns the game player market
	 * @return
	 */
	public Market getMarket(){
		return market;
	}
	
	/**
	 * Sets the team the current user has selected for the next round
	 * @param tmpTeam
	 */
	public void setTmpTeam(UserTeam tmpTeam) {
		this.tmpTeam = tmpTeam;
	}
	
	/**
	 * Returns the number of players the current user has selected for the
	 * next round
	 * @return
	 */
	public int getNumberOfSelectedPlayers() {
		return tmpTeam.size();
	}
	
	/**
	 * Ends the currents users turn and sets his team for the
	 * next round
	 */
	public void endUserTurn() {
		updateUserTeam();

		users.get(userTurn).setTransferFinished(true);
		PlayRound.endUserTurn();
		MainGui.showCardLayout("panelPlayRound");

	}
	
	/**
	 * Returns all the football players in the market
	 * @return
	 */
	public List <FootballPlayer> getAllPlayers() {
		return market.getAllPlayers();
	}
	
	/**
	 * Returns all the football players in the market that play 
	 * for a given team
	 * @param name
	 * @return
	 */
	public List <FootballPlayer> getAllPlayersByTeamName(String name) {
		return market.getAllPlayersByTeamName(name);
	}
	
	/**
	 * Returns all the football players in the market that play a
	 * given position
	 * @param position
	 * @return
	 */
	public List <FootballPlayer> getAllPlayersByPosition(String position) {
		return market.getAllPlayersByPosition(position);
	}
	
	/**
	 * Returns the maximum number of rounds for the game 
	 * @return
	 */
	public int getMaxRounds() {
		return maxRounds;
	}
	
	public static String getLastName(String name){
		String[] lastName = name.split("\\s+");
		return lastName[0];
	}
}
