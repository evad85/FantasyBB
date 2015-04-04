package is.hbv401g.code.user;


public class UserRound {
	
	private final UserTeam userTeam;
	private final int points;
	
	public UserRound(UserTeam team, int points) {
		userTeam = team;
		this.points = points;
	}

	public UserTeam getUserTeam() {
		return userTeam;
	}

	public int getPoints() {
		return points;
	}

}
