/**
 * @author: .....
 * @since: 27.02.2015
 * Holds user related information such as username and points and
 * includes methods to access and modify that information
 */
package is.hbv401g.code.user;

import java.util.ArrayList;

import is.hbv401g.code.fantasy.Game;

/**
 * User contains information about a particular user in the game such as budget, points,
 * and name
 *
 */
public class User {
	
	// Each seat in userTeam holds information about the
	// team the user selected for one round
	private ArrayList<UserTeam> userTeam;
	private final Game game;
	private final String name; 
	private int points;
	private double budget;
	// transferFinished is true if the user has finished selecting
	// his team for the next round
	private boolean transferFinished;
	// Each seat in the array holds information about the
	// team the user selected for one round and the users score
	// in that round. The first seat is empty so that seat number 1
	// represents the first round and etc.
	
	/**
	 * Creates new user with name as user name
	 * @param name
	 */
	public User(String name, Game game) {
		this.game = game;
		this.name = name;
		userTeam = new ArrayList<UserTeam>();
		userTeam.add(0, null);
		points = 0;
		budget = 2000.0;
		transferFinished = false;
	}
	
	/**
	 * Returns the name the user has selected
	 * for himself
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the team that the user selected for
	 * the next round
	 * @return
	 */
	public UserTeam getUserTeam(int round) {
		return userTeam.get(round);
	}

	/**
	 * Sets the users team for the next round
	 * @param userTeam
	 */
	public void setUserTeam(UserTeam userTeam, int round) {
		System.out.println("djfjd");
		this.userTeam.add(round, userTeam);
		System.out.println("djfjd");
	}

	/**
	 * Returns the users accumulated points for all rounds
	 * @return
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Updates the users points
	 * @param points
	 */
	public void updatePoints(int points) {
		this.points += points;
	}
	
	/**
	 * Returns the users current budget
	 * @return
	 */
	public double getBudget() {
		return budget;
	}
	
	/**
	 * Updates the users budget
	 * @param points
	 */
	public void updateBudget(double marketValue, String operator) {
		if (operator.equals("-")) {
			this.budget -= marketValue;
		}else{
			this.budget += marketValue;
		}

	}
	
	/**
	 * Returns true if the users budget is enough to buy
	 * a selected player with the market value marketValue
	 * Returns false otherwise.
	 * @param marketValue
	 * @return
	 */
	public boolean hasEnoughBudget(double marketValue) {
		return marketValue <= budget;
	}
	
	/**
	 * Returns true if the user has finished selecting is team for
	 * the next round
	 * @return
	 */
	public boolean isTransferFinished() {
		return transferFinished;
	}
	
	/**
	 * Updates the users transfer status 
	 * @param value
	 */
	public void setTransferFinished(boolean value) {
		transferFinished = value;
	}
}
