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
public class Main {
    private static ArrayList<Team> teamArray = new ArrayList();

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
    }
    
    public void addTeamToArray(int teamNumber) {
        for(int i = 0; i < teamArray.size(); i++) {
            //Test to see if the team already exsists
            if(teamArray.get(i).getTeamNumber() == teamNumber) {
                return;
                
            }
        }
        //Adds the new team.
        teamArray.add(new Team(teamNumber));
    } 
 
    public static int getTeamArraySize(){
        return teamArray.size();
    }
    
    public static Team getTeam(int position){
        return teamArray.get(position);
    }
    
}
