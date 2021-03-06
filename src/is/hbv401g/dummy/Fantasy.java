package is.hbv401g.dummy;

import java.io.IOException;

public class Fantasy {
    private int roundsDone;
    private FootballTeam[] teamTotal;
    private Scheduler schedule;
    private MatchResults[] matchResults;
    private int numAllMatches = 90;
    private int numRounds;
    private int numRoundMatches;
     
    //Gets all teams and creates scheduler out of them.
    //initialize roundsDone and matchResults
    public Fantasy( ) throws JSONException, IOException{
        roundsDone = 0;
        teamTotal = DataConnection.createFootballTeams();
        schedule = new Scheduler(teamTotal);
        matchResults = new MatchResults[ this.numAllMatches ];
        numRoundMatches = schedule.getNumMatchInRound();
        numRounds = schedule.getNumRounds();
    }
     
    // Simulate the next Round (5 matches) and return MatchResults for those
    public MatchResults[] simulateNextRound( ){
        FootballTeam[][] teams = schedule.getNextRoundSchedule();
        int numMatch = numRoundMatches;
        for (int i = 0; i < numMatch; i++) {
            matchResults[roundsDone*numMatch+i]= Simulate.match(teams[i][0],teams[i][1],roundsDone+1);
        }
        MatchResults[] theseFiveMatches = new MatchResults[5];
        for (int i = 0; i < numMatch; i++) {
            theseFiveMatches[i] = matchResults[roundsDone*5 + i];
        }
        roundsDone++;
         
        return theseFiveMatches;
    }
     
    // pre:  0 <= matchNumber <= 89
    // post: Returns MatchResults from the game matchNumber.
    public MatchResults getMatchResults(int matchNumber) {
        if (0 <= matchNumber && matchNumber <= numAllMatches-1)
            return this.matchResults[matchNumber];
        return null;
    }
     
    public Scheduler getScheduler() {
        return this.schedule;
    }
     
    public FootballTeam[] getTeamTotal() {
        return this.teamTotal;
    }
 
    public MatchResults[] getMatchResults() {
        return this.matchResults;
    }
     
    public int getNumAllMatches(){
        return this.numAllMatches;
    }
     
    public int getNumRounds(){
        return this.numRounds;
    }
     
    public int getRoundsDone(){
        return this.roundsDone;
    }
     
    public int getNumOfNextRound() {
        return this.roundsDone+1;
    }
}