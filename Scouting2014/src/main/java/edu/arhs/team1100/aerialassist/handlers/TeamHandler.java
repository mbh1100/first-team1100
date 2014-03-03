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

    public TeamHandler() {
    }

    public boolean addTeam(Team team) {
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

    public List getTeams() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List teams = session.createQuery("from Team").list();
        session.getTransaction().commit();

        return teams;
    }

    public void updateTeam(Team team) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(team);
        session.getTransaction().commit();
    }

    public boolean deleteTeam(Team team) {
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
