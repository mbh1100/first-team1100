package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.scouting.objects.Event;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Eddie
 */
public class EventHandler {

    public EventHandler() {
    }

    public boolean addEvent(Event event) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(event);
        try {
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;

    }

    public void updateEvent(Event event) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(event);
        session.getTransaction().commit();
    }

    public List getEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List events = session.createQuery("from Event").list();

        session.getTransaction().commit();

        return events;
    }

    public boolean deleteEvent(Event event) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(event);
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            return false;
        }

        return true;
    }

    public Event getEventFromId(int id) {

        List events = getEvents();

        for (int i = 0; i < events.size(); i++) {
            Event event = (Event) events.get(i);
            if (event.getEventID() == id) {
                return event;
            }
        }

        return null;
    }

    public Event getCurrentEvent() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List events = session.createQuery("from Event").list();
        session.getTransaction().commit();
        
        for (int i = 0; i < events.size(); i++) {
            Event event = (Event) events.get(i);
            if (event.getIsCurrentEvent()) {
                return event;
            }
        }

        return null;
    }
    
    public void setCurrentEvent(Event event){
        getCurrentEvent().setIsCurrentEvent(false);
        event.setIsCurrentEvent(true);
    }
}
