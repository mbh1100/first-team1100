package scoutingdatabase;

import java.util.ArrayList;

/**
 *
 * @author Team1100
 */
public class Team {

    int teamNumber; //Team Number

    private ArrayList<Match> match = new ArrayList<Match>();//Array of matches this team has played
    
    public Team(int teamNumber) {
        this.teamNumber = teamNumber;
    }
    public void setMatch(int matchNumber){
        match.add(new Match(matchNumber));
    }
   
    public int getTeamNumber() {
        return teamNumber;
    }
}
