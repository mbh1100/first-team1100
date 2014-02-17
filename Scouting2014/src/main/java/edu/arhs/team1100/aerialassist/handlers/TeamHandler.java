/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.input.TeamInput;
import edu.arhs.team1100.aerialassist.scouting.objects.Team;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class TeamHandler {

    TeamInput ti;

    public TeamHandler(TeamInput ti) {
        this.ti = ti;
    }

    public boolean addTeam() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Team team = new Team();

        team.setTeamNumber(ti.getTeamNumber());
        team.setName(ti.getTeamName());
        team.setLocation(ti.getTeamLocation());
        
        session.save(team);
        try {
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;
        
    }
}
