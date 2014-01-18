/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutingdatabase;

import java.util.ArrayList;

/**
 *
 * @author Team1100
 */
public class Team {

    int teamNumber; //Team Number
    int matchNumber;
    
    int wins; //How many times the team wins
    int losses; //How  many times the team looses
    boolean passTruss;//Can pass a ball over the truss
    //boolean catchTruss; //Can catch a ball thrown over a truss
    boolean canCatch; //Can catch a ball tossed by our robot
    boolean canPass; //Will be able to pass to our robot
    String comments; //Additional Comments
    int startingPosition; //Where the robot starts the match during autonomous
    int score; //How much the team/alliance scores
    boolean scoresAuto; //Fires in the goal during autonomous
    boolean scoresHotGoal; //Fires hot goal during autonomous
    boolean driveScoreAuto; //Drives in autonomous to score points
    
    
    final int goaliePosition = 0;
    final int leftPosition = 1;
    final int rightPosition = 3;
    final int middlePosition = 2;

    private ArrayList<Integer> match = new ArrayList<Integer>();
    
    public Team(int teamNumber) {
        
    }
    private void match(){
        match.add(matchNumber);
    }
   
    public int getTeamNumber() {
        return teamNumber;
    }
}
