package edu.arhs.team1100.aerialassist.scouting.objects;

import java.io.Serializable;

/**
 *
 * @author Eddie
 */
public class TeamEventMatch implements Serializable {

    private int matchNumber;
    private int eventID;
    private int teamNumber;

    private int assists;
    private String ballShielding;
    private int ballsCaughtFromHP;
    private int attemptedCatchesFromHP;
    private String comments;
    private int cycles;
    private int defensive;
    private int floorPickup;
    private int highGoalsAttempted;
    private int highGoalsScored;
    private int lowGoalsAttempted;
    private int lowGoalsScored;
    private String scouter;
    private String stability;
    private int startingPosition;
    private boolean ableToTrussCatch;
    private boolean ableToTrussToss;
    private boolean ableToUnloadAutoBall;
    private boolean zoneChange;
    private int autoBallCount;
    private int autoBallGoal;
    private boolean ableToCatch;

    private double highGoalAccuracy;
    private double lowGoalAccuracy;
    private double humanPlayerAccuracy;

    public boolean isAbleToCatch() {
        return ableToCatch;
    }

    public void setAbleToCatch(boolean ableToCatch) {
        this.ableToCatch = ableToCatch;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getBallShielding() {
        return ballShielding;
    }

    public void setBallShielding(String ballShielding) {
        this.ballShielding = ballShielding;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public int getDefensive() {
        return defensive;
    }

    public void setDefensive(int defensive) {
        this.defensive = defensive;
    }

    public int getFloorPickup() {
        return floorPickup;
    }

    public void setFloorPickup(int floorPickup) {
        this.floorPickup = floorPickup;
    }

    public int getHighGoalsAttempted() {
        return highGoalsAttempted;
    }

    public void setHighGoalsAttempted(int highGoalsAttempted) {
        this.highGoalsAttempted = highGoalsAttempted;
    }

    public int getHighGoalsScored() {
        return highGoalsScored;
    }

    public void setHighGoalsScored(int highGoalsScored) {
        this.highGoalsScored = highGoalsScored;
    }

    public int getLowGoalsAttempted() {
        return lowGoalsAttempted;
    }

    public void setLowGoalsAttempted(int lowGoalsAttempted) {
        this.lowGoalsAttempted = lowGoalsAttempted;
    }

    public int getLowGoalsScored() {
        return lowGoalsScored;
    }

    public void setLowGoalsScored(int lowGoalsScored) {
        this.lowGoalsScored = lowGoalsScored;
    }

    public String getScouter() {
        return scouter;
    }

    public void setScouter(String scouter) {
        this.scouter = scouter;
    }

    public String getStability() {
        return stability;
    }

    public void setStability(String stability) {
        this.stability = stability;
    }

    public int getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int strtingPosistion) {
        this.startingPosition = strtingPosistion;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public boolean isAbleToTrussCatch() {
        return ableToTrussCatch;
    }

    public void setAbleToTrussCatch(boolean trussCatch) {
        this.ableToTrussCatch = trussCatch;
    }

    public int getBallsCaughtFromHP() {
        return ballsCaughtFromHP;
    }

    public void setBallsCaughtFromHP(int caughtBallsFromHP) {
        this.ballsCaughtFromHP = caughtBallsFromHP;
    }

    public int getAttemptedCatchesFromHP() {
        return attemptedCatchesFromHP;
    }

    public void setAttemptedCatchesFromHP(int attemptedCatchesFromHP) {
        this.attemptedCatchesFromHP = attemptedCatchesFromHP;
    }

    public boolean isAbleToTrussToss() {
        return ableToTrussToss;
    }

    public void setAbleToTrussToss(boolean trussToss) {
        this.ableToTrussToss = trussToss;
    }

    public int getAutoBallCount() {
        return autoBallCount;
    }

    public void setAutoBallCount(int autoBallCount) {
        this.autoBallCount = autoBallCount;
    }

    public int getAutoBallGoal() {
        return autoBallGoal;
    }

    public void setAutoBallGoal(int autoBallScored) {
        this.autoBallGoal = autoBallScored;
    }

    public double getHumanPlayerAccuracy() {
        updateHumanPlayerSccuracy();
        return humanPlayerAccuracy;
    }

    public void setHumanPlayerAccuracy(double humanPlayerAccuracy) {
        this.humanPlayerAccuracy = humanPlayerAccuracy;
    }

    public boolean isAbleToUnloadAutoBall() {
        return ableToUnloadAutoBall;
    }

    public void setAbleToUnloadAutoBall(boolean unableToUnloadAutoBall) {
        this.ableToUnloadAutoBall = unableToUnloadAutoBall;
    }

    public boolean isZoneChange() {
        return zoneChange;
    }

    public void setZoneChange(boolean zoneChange) {
        this.zoneChange = zoneChange;
    }

    @Override
    public String toString() {
        return "" + matchNumber;
    }

    public void setHighGoalAccuracy(double highGoalAccuracy) {
        this.highGoalAccuracy = highGoalAccuracy;
    }

    public void setLowGoalAccuracy(double lowGoalAccuracy) {
        this.lowGoalAccuracy = lowGoalAccuracy;
    }

    public double getHighGoalAccuracy() {
        updateHighGoalAccuracy();
        return highGoalAccuracy;
    }

    public double getLowGoalAccuracy() {
        updateLowGoalAccuracy();
        return lowGoalAccuracy;
    }

    private void updateHighGoalAccuracy() {
        if (highGoalsAttempted == 0) {
            highGoalAccuracy = 0;
        } else {
            highGoalAccuracy = (double) highGoalsScored / highGoalsAttempted;
        }
    }

    private void updateLowGoalAccuracy() {
        if (lowGoalsAttempted == 0) {
            lowGoalAccuracy = 0;
        } else {
            lowGoalAccuracy = (double) lowGoalsScored / lowGoalsAttempted;
        }
    }

    private void updateHumanPlayerSccuracy() {
        if (attemptedCatchesFromHP == 0) {
            humanPlayerAccuracy = 0;
        } else {
            humanPlayerAccuracy = (double) ballsCaughtFromHP / attemptedCatchesFromHP;
        }
    }
}
