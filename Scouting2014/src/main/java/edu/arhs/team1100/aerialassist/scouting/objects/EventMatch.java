package edu.arhs.team1100.aerialassist.scouting.objects;

import java.io.Serializable;

/**
 *
 * @author Eddie
 */
public class EventMatch implements Serializable {
    int matchNumber;
    int eventID;
    int redOne;
    int redTwo;
    int redThree;
    int blueOne;
    int blueTwo;
    int blueThree;
    int redScore;
    int blueScore;

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getRedOne() {
        return redOne;
    }

    public void setRedOne(int redOne) {
        this.redOne = redOne;
    }

    public int getRedTwo() {
        return redTwo;
    }

    public void setRedTwo(int redTwo) {
        this.redTwo = redTwo;
    }

    public int getRedThree() {
        return redThree;
    }

    public void setRedThree(int redThree) {
        this.redThree = redThree;
    }

    public int getBlueOne() {
        return blueOne;
    }

    public void setBlueOne(int blueOne) {
        this.blueOne = blueOne;
    }

    public int getBlueTwo() {
        return blueTwo;
    }

    public void setBlueTwo(int blueTwo) {
        this.blueTwo = blueTwo;
    }

    public int getBlueThree() {
        return blueThree;
    }

    public void setBlueThree(int blueThree) {
        this.blueThree = blueThree;
    }

    public int getRedScore() {
        return redScore;
    }

    public void setRedScore(int redScore) {
        this.redScore = redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }

    public void setBlueScore(int blueScoure) {
        this.blueScore = blueScoure;
    }
            
           
}
