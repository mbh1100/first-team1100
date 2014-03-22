package edu.arhs.team1100.aerialassist.scouting;

import edu.arhs.team1100.aerialassist.input.TeamEventMatchViewer;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;

/**
 *
 * @author Eddie
 */
public class ScoutingMain {

    public static String URL = "127.0.0.1";
    public static String USER = "root";
    public static String PASSWORD = "root";
    public static int LAST_MATCH = 1;

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-ip")) {
                URL = args[i + 1];
            } else if (args[i].equals("-u")) {
                USER = args[i + 1];
            } else if (args[i].equals("-p")) {
                PASSWORD = args[i + 1];
            }
        }
        
        

        HibernateUtil.getSessionFactory().getCurrentSession();
        new TeamEventMatchViewer().setVisible(true);
    }
}
