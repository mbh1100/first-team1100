package edu.arhs.team1100.aerialassist.scouting.objects;

/**
 *
 * @author Eddie
 */
public class Team {
    private int teamNumber;
    private String location;
    private String name;
    
    public Team(){
        
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "" + teamNumber;
    }
    
}
