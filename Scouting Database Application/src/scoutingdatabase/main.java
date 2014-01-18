/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scoutingdatabase;

import java.util.ArrayList;


/**
 *
 * @author Team 1100
 */
public class main {
    ArrayList<Team> teams = new ArrayList<Team>();

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
    }
    
    public void addTeam(int teamNumber) {
        for(int i = 0; i < teams.size(); i++) {
            //Test to see if the team already exsists
            if(teams.get(i).getTeamNumber() == teamNumber) {
                break;  
            }
        }
        //Adds the new team.
        teams.add(new Team(teamNumber));
    } 
    public void setMatch(int teamNumber, int matchNumber){
    teams.get(0).setMatch(matchNumber);
}
    
    
}
