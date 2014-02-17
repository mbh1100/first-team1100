package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.input.EventInput;
import edu.arhs.team1100.aerialassist.scouting.objects.Event;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class EventHandler {

    EventInput ei;

    public EventHandler(EventInput ei) {
        this.ei = ei;
    }

    public boolean addTeam() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event event = new Event();
        
        event.setName(ei.getEventName());
        event.setLocation(ei.getEventLocation());
        event.setDate(ei.getDate());
        
        session.save(event);
        try {
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;
        
    }
}
