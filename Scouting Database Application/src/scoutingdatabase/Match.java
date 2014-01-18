package scoutingdatabase;

/**
 *
 * @author Team 1100
 */
public class Match {

    private int matchNumber;
    
    private boolean wonMatch; //Wether or not the Team won the match
    
    private boolean passTruss;//Can pass a ball over the truss
    private boolean canCatch; //Can catch a ball tossed by our robot
    private boolean canPass; //Will be able to pass to our robot
    
    private String comments; //Additional Comments
    private String scoutName; //Name of scout
   
    private int score; //How much the team/alliance scores
    
    private boolean scoresAuto; //Fires in the goal during autonomous
    private boolean scoresHotGoal; //Fires hot goal during autonomous
    private boolean driveScoreAuto; //Drives in autonomous to score points
    
    private boolean scoresHigh;
    private boolean scoresLow;
    
    public enum StartingPosition{
        GOALIE, LEFT, MIDDLE, RIGHT
    }
    
    private StartingPosition startingPosition; //Where the robot starts the match during autonomous

    public Match(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public void setStaringPosition(StartingPosition startingPosition){
        this.startingPosition = startingPosition;
    }
    
    public void setPassing(boolean passTruss, boolean canCatch, boolean canPass) {
        this.passTruss = passTruss;
        this.canCatch = canCatch;
        this.canPass = canPass;
    }
    
    public void setAutonomous(boolean scoresAuto, boolean scoresHotGoal, boolean driveScoreAuto){
        this.scoresAuto = scoresAuto;
        this.scoresHotGoal = scoresHotGoal;
        this.driveScoreAuto = driveScoreAuto;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public void setResult(boolean wonMatch){
        this.wonMatch = wonMatch;
    }
    
    public void setComment(String comments, String scoutName){
        this.comments = comments;
        this.scoutName = scoutName;
    }
    
    public void setScoring(boolean scoresHigh, boolean scoresLow){
        this.scoresHigh = scoresHigh;
        this.scoresLow = scoresLow;
    }
    
    public int getMatchNumber(){
        return matchNumber;
    }
    
    public boolean didWin(){
        return wonMatch;
    }
    
    public boolean canPassOverTruss(){
        return passTruss;
    }
    
    public boolean canCatch(){
        return canCatch;
    }
    
    public boolean canPass(){
        return canPass;
    }
    
    public String getComments(){
        return comments;
    }
    
    public String getScoutName(){
        return scoutName;
    }
    
    public int getScore(){
        return score;
    }
    
    public boolean canScoreInAuto(){
        return scoresAuto;
    }
    
    public boolean canScoreInHotGoal(){
        return scoresHotGoal;
    }
    
    public boolean canDriveInAuto(){
        return driveScoreAuto;
    }
    
    public boolean canScoreHigh(){
        return scoresHigh;
    }
    
    public boolean canScoreLow(){
        return scoresLow;
    }
    
    public StartingPosition getStartingPosition(){
        return startingPosition;
    }
}
