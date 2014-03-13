package edu.arhs.team1100.aerialassist.scouting.objects;

import java.sql.Date;

/**
 *
 * @author Eddie
 */
public class Event {
    int eventID;
    String name;
    String location;
    Date date;
    boolean isCurrentEvent;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public boolean getIsCurrentEvent(){
        return isCurrentEvent;
    }
    
    public void setIsCurrentEvent(boolean isCurrentEvent){
        this.isCurrentEvent = isCurrentEvent;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
