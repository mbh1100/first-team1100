package edu.arhs.team1100.aerialassist.scouting;

import edu.arhs.team1100.aerialassist.input.TeamEventMatchViewer;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;

/**
 *
 * @author Eddie
 */
public class ScoutingMain {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().getCurrentSession();
        new TeamEventMatchViewer().setVisible(true);
    }
}
