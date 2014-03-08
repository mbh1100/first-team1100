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

    /**
     * Adds an event to the database
     * @param event
     * @return true if successful
     */
    public static boolean addEvent(Event event) {
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
    
    /**
     * Updates an event
     * @param event 
     */
    public static void updateEvent(Event event) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(event);
        session.getTransaction().commit();
    }

    /**
     * Gets all Events from the database
     * @return 
     */
    public static List getEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List events = session.createQuery("from Event").list();

        session.getTransaction().commit();

        return events;
    }

    /**
     * Deletes an Event from the database
     * @param event
     * @return true if successful
     */
    public static boolean deleteEvent(Event event) {
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

    /**
     * Returns Event from ID
     * @param id
     * @return Event
     */
    public static Event getEventFromId(int id) {

        List events = getEvents();

        for (int i = 0; i < events.size(); i++) {
            Event event = (Event) events.get(i);
            if (event.getEventID() == id) {
                return event;
            }
        }

        return null;
    }

    /**
     * Gets the current Event that is being used
     * @return Event
     */
    public static Event getCurrentEvent() {
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
    
    /**
     * Sets the Event to the current one in the database
     * @param event 
     */
    public static void setCurrentEvent(Event event){
        Event currentEvent = getCurrentEvent();
        currentEvent.setIsCurrentEvent(false);
        updateEvent(currentEvent);
        event.setIsCurrentEvent(true);
        updateEvent(event);
        System.out.println(getCurrentEvent());
    }
}
