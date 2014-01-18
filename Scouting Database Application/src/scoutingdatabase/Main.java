package scoutingdatabase;

import java.util.ArrayList;


/**
 *
 * @author Team 1100
 */
public class Main {
    private static ArrayList<Team> teamArray = new ArrayList<Team>();

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        FileOpener.getInstance().getTeamsFromFile();
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
    
    public static Team getTeamAt(int position){
        return teamArray.get(position);
    }
    
    public static Team getTeamNumber(int teamNumber){
        for(int i = 0; i < getTeamArraySize(); i ++){
            if(teamArray.get(i).getTeamNumber() == teamNumber){
                return teamArray.get(i);
            }
        }
        return null;
    }
    
}
