package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.input.TeamEventMatchInput;
import edu.arhs.team1100.aerialassist.scouting.objects.TeamEventMatch;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class TeamEventMatchHandler {

    TeamEventMatchInput temi;

    public TeamEventMatchHandler(TeamEventMatchInput tmi) {
        this.temi = tmi;
    }

    public boolean addTeam() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        TeamEventMatch tem = new TeamEventMatch();

        tem.setEventID(1);
        tem.setTeamNumber(temi.getTeamNumber());
        tem.setMatchNumber(temi.getMatchNumber());
        tem.setAssists(temi.getAssists());
        tem.setAutoBallHigh(temi.canAutoBallHigh());
        tem.setAutoBallLow(temi.canAutoBallLow());
        tem.setBallShielding(temi.getBallShielding());
        tem.setCanCatch(temi.canCatch());
        tem.setComments(temi.getComments());
        tem.setCycles(temi.getCycles());
        tem.setDefensive(temi.getDefensive());
        tem.setFloorPickup(temi.getFloorPickup());
        tem.setHighGoalsAttempted(temi.getHighGoalsAttempted());
        tem.setHighGoalsScored(temi.getHighGoalsScored());
        tem.setLowGoalsAttempted(temi.getLowGoalsAttempted());
        tem.setLowGoalsScored(temi.getLowGoalsScored());
        tem.setPasses(temi.getPasses());
        tem.setPreloadBall(temi.canPreloadBall());
        tem.setRegularFouls(temi.getRegularFouls());
        tem.setScouter(temi.getScouter());
        tem.setStability(temi.getStability());
        tem.setStartingPosition(temi.getStartingPosition());
        tem.setTechFouls(temi.getTechFouls());
        tem.setTrussCatch(temi.canTrussCatch());
        tem.setTrussThrow(temi.canTrussToss());
        tem.setUnableToUnloadAutoBall(temi.isUnableToUnloadAutoBall());
        tem.setZoneChange(temi.getZoneChange());

        session.save(tem);
        try {
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;
    }
}
