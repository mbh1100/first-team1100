/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutingdatabase;

/**
 *
 * @author Team 1100
 */
public class Match {

    boolean wonMatch; //Wether or not the Team won the match
    
    boolean passTruss;//Can pass a ball over the truss
    boolean canCatch; //Can catch a ball tossed by our robot
    boolean canPass; //Will be able to pass to our robot
    
    String comments; //Additional Comments
    String scoutName; //Name of scout
    
    int startingPosition; //Where the robot starts the match during autonomous
    
    int score; //How much the team/alliance scores
    
    boolean scoresAuto; //Fires in the goal during autonomous
    boolean scoresHotGoal; //Fires hot goal during autonomous
    boolean driveScoreAuto; //Drives in autonomous to score points
    
    boolean scoresHigh;
    boolean scoresLow;

    //Variables for goal positions
    public final int goaliePosition = 0;
    public final int leftPosition = 1;
    public final int rightPosition = 3;
    public final int middlePosition = 2;

    public Match(int matchNumber) {

    }

    public void getPassing(boolean passTruss, boolean canCatch, boolean canPass) {

    }
    
    public void getAutonomous(boolean scoresAuto, boolean scoresHotGoal, boolean driveScoreAuto){
        
    }
    
    public void getScore(int score){
        
    }
    
    public void getResult(boolean wonMatch){
        
    }
    
    public void getComment(String comments, String scoutName){
        
    }
    
    public void getScoring(boolean scoresHigh, boolean scoresLow){
        
    }
    
}
