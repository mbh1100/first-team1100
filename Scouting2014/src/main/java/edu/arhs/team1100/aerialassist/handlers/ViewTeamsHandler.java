package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.input.ViewTeamsFrame;
import edu.arhs.team1100.aerialassist.scouting.objects.Team;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eddie
 */
public class ViewTeamsHandler {

    ViewTeamsFrame vtf;

    public ViewTeamsHandler() {
        vtf = new ViewTeamsFrame();
    }

    public void addTeams() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List teams = session.createQuery("from Team").list();
        session.getTransaction().commit();

        for (int i = 0; i < teams.size(); i++) {
            vtf.addTeam((Team) teams.get(i));
        }

        vtf.setVisible(true);
    }

}
