package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.scouting.objects.Team;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class TeamHandler {

    /**
     * Add a team to the database
     * @param team
     * @return true if successful
     */
    public static boolean addTeam(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(team);

        try {
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;

    }

    /**
     * Gets all Teams in the database
     * @return List of all Teams
     */
    public static List getTeams() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List teams = session.createQuery("from Team").list();
        session.getTransaction().commit();

        return teams;
    }

    /**
     * Updates a Team to the database
     * @param team 
     */
    public static void updateTeam(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(team);
        session.getTransaction().commit();
    }

    /**
     * Deletes a Team from the database
     * @param team
     * @return 
     */
    public static boolean deleteTeam(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(team);
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;
    }
}
