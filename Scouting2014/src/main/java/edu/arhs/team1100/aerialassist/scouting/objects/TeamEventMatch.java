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
    private boolean autoBallHigh;
    private boolean autoBallLow;
    private String ballShielding;
    private boolean canCatch;
    private String comments;
    private int cycles;
    private int defensive;
    private int floorPickup;
    private int highGoalsAttempted;
    private int highGoalsScored;
    private int lowGoalsAttempted;
    private int lowGoalsScored;
    private int passes;
    private boolean preloadBall;
    private int regularFouls;
    private String scouter;
    private String stability;
    private int startingPosition;
    private int techFouls;
    private boolean trussCatch;
    private boolean trussThrow;
    private boolean unableToUnloadAutoBall;
    private boolean zoneChange;

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

    public boolean isAutoBallHigh() {
        return autoBallHigh;
    }

    public void setAutoBallHigh(boolean autoBallHigh) {
        this.autoBallHigh = autoBallHigh;
    }

    public boolean isAutoBallLow() {
        return autoBallLow;
    }

    public void setAutoBallLow(boolean autoBallLow) {
        this.autoBallLow = autoBallLow;
    }

    public String getBallShielding() {
        return ballShielding;
    }

    public void setBallShielding(String ballShielding) {
        this.ballShielding = ballShielding;
    }

    public boolean isCanCatch() {
        return canCatch;
    }

    public void setCanCatch(boolean canCatch) {
        this.canCatch = canCatch;
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

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public boolean isPreloadBall() {
        return preloadBall;
    }

    public void setPreloadBall(boolean preloadBall) {
        this.preloadBall = preloadBall;
    }

    public int getRegularFouls() {
        return regularFouls;
    }

    public void setRegularFouls(int regularFouls) {
        this.regularFouls = regularFouls;
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

    public int getTechFouls() {
        return techFouls;
    }

    public void setTechFouls(int techFouls) {
        this.techFouls = techFouls;
    }

    public boolean isTrussCatch() {
        return trussCatch;
    }

    public void setTrussCatch(boolean trussCatch) {
        this.trussCatch = trussCatch;
    }

    public boolean isTrussThrow() {
        return trussThrow;
    }

    public void setTrussThrow(boolean trussThrow) {
        this.trussThrow = trussThrow;
    }

    public boolean isUnableToUnloadAutoBall() {
        return unableToUnloadAutoBall;
    }

    public void setUnableToUnloadAutoBall(boolean unableToUnloadAutoBall) {
        this.unableToUnloadAutoBall = unableToUnloadAutoBall;
    }

    public boolean isZoneChange() {
        return zoneChange;
    }

    public void setZoneChange(boolean zoneChange) {
        this.zoneChange = zoneChange;
    }

}
