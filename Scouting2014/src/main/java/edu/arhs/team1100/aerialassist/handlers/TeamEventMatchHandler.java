package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.scouting.objects.TeamEventMatch;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class TeamEventMatchHandler {

    public TeamEventMatchHandler() {
    }

    public boolean addMatch(TeamEventMatch tem) {
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

    public void updateMatch(TeamEventMatch tem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(tem);
        session.getTransaction().commit();
    }

    public List getMatches() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List tem = session.createQuery("from TeamEventMatch").list();
        session.getTransaction().commit();

        return tem;
    }

    public void deleteEvent(TeamEventMatch match) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(match);

        session.getTransaction().commit();

    }
    
    public List getMatches(TeamEventMatch referenceMatch, int eventID) {
        ArrayList matchedTeams = new ArrayList();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List allTeams = session.createQuery("from TeamEventMatch").list();
        session.getTransaction().commit();

        for (int i = 0; i < allTeams.size(); i++) {

            TeamEventMatch currentMatch = (TeamEventMatch) allTeams.get(i);
            boolean doesNotFit = false;
            if (eventID == 0 || currentMatch.getEventID() == eventID) {
                if (currentMatch.getAssists() >= referenceMatch.getAssists()
                        && currentMatch.getCycles() >= referenceMatch.getCycles()
                        && currentMatch.getDefensive() >= referenceMatch.getDefensive()
                        && currentMatch.getFloorPickup() >= referenceMatch.getFloorPickup()
                        && currentMatch.getHighGoalAccuracy() >= referenceMatch.getHighGoalAccuracy()
                        && currentMatch.getHighGoalsScored() >= referenceMatch.getHighGoalsScored()
                        && currentMatch.getLowGoalAccuracy() >= referenceMatch.getLowGoalAccuracy()
                        && currentMatch.getLowGoalsScored() >= referenceMatch.getLowGoalsScored()
                        && currentMatch.getPasses() >= referenceMatch.getPasses()) {

                    if (referenceMatch.isAutoBallHigh()) {
                        if (!currentMatch.isAutoBallHigh()) {
                            doesNotFit = true;
                        }
                    }
                    if (referenceMatch.isAutoBallLow()) {
                        if (!currentMatch.isAutoBallLow()) {
                            doesNotFit = true;
                        }
                    }
                    if (referenceMatch.isCanCatch()) {
                        if (!currentMatch.isCanCatch()) {
                            doesNotFit = true;
                        }
                    }
                    if (referenceMatch.isPreloadBall()) {
                        if (!currentMatch.isPreloadBall()) {
                            doesNotFit = true;
                        }
                    }
                    if (referenceMatch.isTrussCatch()) {
                        if (!currentMatch.isTrussCatch()) {
                            doesNotFit = true;
                        }
                    }
                    if (referenceMatch.isTrussThrow()) {
                        if (!currentMatch.isTrussThrow()) {
                            doesNotFit = true;
                        }
                    }
                    if (referenceMatch.isUnableToUnloadAutoBall()) {
                        if (!currentMatch.isUnableToUnloadAutoBall()) {
                            doesNotFit = true;
                        }
                    }
                    if (referenceMatch.isZoneChange()) {
                        if (!currentMatch.isZoneChange()) {
                            doesNotFit = true;
                        }
                    }

                    if (!doesNotFit) {
                        matchedTeams.add(currentMatch);
                    }

                }
            }
        }

        return matchedTeams;
    }

    public List getMatches(TeamEventMatch referenceMatch) {
        ArrayList matchedTeams = new ArrayList();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List allTeams = session.createQuery("from TeamEventMatch").list();
        session.getTransaction().commit();

        for (int i = 0; i < allTeams.size(); i++) {

            TeamEventMatch currentMatch = (TeamEventMatch) allTeams.get(i);
            boolean doesNotFit = false;

            if (currentMatch.getAssists() >= referenceMatch.getAssists()
                    && currentMatch.getCycles() >= referenceMatch.getCycles()
                    && currentMatch.getDefensive() >= referenceMatch.getDefensive()
                    && currentMatch.getFloorPickup() >= referenceMatch.getFloorPickup()
                    && currentMatch.getHighGoalAccuracy() >= referenceMatch.getHighGoalAccuracy()
                    && currentMatch.getHighGoalsScored() >= referenceMatch.getHighGoalsScored()
                    && currentMatch.getLowGoalAccuracy() >= referenceMatch.getLowGoalAccuracy()
                    && currentMatch.getLowGoalsScored() >= referenceMatch.getLowGoalsScored()
                    && currentMatch.getPasses() >= referenceMatch.getPasses()) {

                if (referenceMatch.isAutoBallHigh()) {
                    if (!currentMatch.isAutoBallHigh()) {
                        doesNotFit = true;
                    }
                }
                if (referenceMatch.isAutoBallLow()) {
                    if (!currentMatch.isAutoBallLow()) {
                        doesNotFit = true;
                    }
                }
                if (referenceMatch.isCanCatch()) {
                    if (!currentMatch.isCanCatch()) {
                        doesNotFit = true;
                    }
                }
                if (referenceMatch.isPreloadBall()) {
                    if (!currentMatch.isPreloadBall()) {
                        doesNotFit = true;
                    }
                }
                if (referenceMatch.isTrussCatch()) {
                    if (!currentMatch.isTrussCatch()) {
                        doesNotFit = true;
                    }
                }
                if (referenceMatch.isTrussThrow()) {
                    if (!currentMatch.isTrussThrow()) {
                        doesNotFit = true;
                    }
                }
                if (referenceMatch.isUnableToUnloadAutoBall()) {
                    if (!currentMatch.isUnableToUnloadAutoBall()) {
                        doesNotFit = true;
                    }
                }
                if (referenceMatch.isZoneChange()) {
                    if (!currentMatch.isZoneChange()) {
                        doesNotFit = true;
                    }
                }

                if (!doesNotFit) {
                    matchedTeams.add(currentMatch);
                }

            }
        }

        return matchedTeams;
    }
}
