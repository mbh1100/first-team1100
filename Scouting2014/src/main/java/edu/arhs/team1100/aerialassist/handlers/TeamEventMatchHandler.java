package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.scouting.objects.TeamEventMatch;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class TeamEventMatchHandler {

    /**
     * Adds a TeamEventMatch to the database
     *
     * @param tem
     * @return true if successful
     */
    public static boolean addMatch(TeamEventMatch tem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(tem);
        try {
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;
    }

    /**
     * Updates a TeamEventMatch to the database
     *
     * @param tem
     */
    public static void updateMatch(TeamEventMatch tem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(tem);
        session.getTransaction().commit();
    }

    /**
     * Get all matches from the database
     *
     * @return List of all matches
     */
    public static List getMatches() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List tem = session.createQuery("from TeamEventMatch").list();
        session.getTransaction().commit();

        return tem;
    }

    /**
     * Deletes a match form the database
     *
     * @param match
     */
    public static void deleteEvent(TeamEventMatch match) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(match);

        session.getTransaction().commit();

    }

}