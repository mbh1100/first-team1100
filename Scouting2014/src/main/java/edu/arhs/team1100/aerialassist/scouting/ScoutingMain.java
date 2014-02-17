package edu.arhs.team1100.aerialassist.scouting;

import edu.arhs.team1100.aerialassist.input.SelectOperationFrame;
import edu.arhs.team1100.aerialassist.scouting.objects.Team;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eddie
 */
public class ScoutingMain {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().getCurrentSession();
        SelectOperationFrame sof = new SelectOperationFrame();
        sof.setVisible(true);
    }

    private void editTeam(int teamNumber, String location) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Team theTeam = (Team) session.load(Team.class, teamNumber);
        theTeam.setName(location);
        session.update(theTeam);
        session.getTransaction().commit();
    }


}
