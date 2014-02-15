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
        SelectOperationFrame sof = new SelectOperationFrame();
        sof.setVisible(true);
    }

    private List listteams() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Team").list();
        session.getTransaction().commit();
        return result;
    }

    private void editTeam(int teamNumber, String location) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Team theTeam = (Team) session.load(Team.class, teamNumber);
        theTeam.setName(location);
        session.update(theTeam);
        session.getTransaction().commit();
    }

    private void createAndStoreTeam(int teamNumber, String name, String location) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Team team = new Team();
        team.setTeamNumber(teamNumber);
        team.setName(name);
        team.setLocation(location);
        session.save(team);

        session.getTransaction().commit();
    }

}
