package edu.arhs.team1100.aerialassist.handlers;

import edu.arhs.team1100.aerialassist.input.ViewEventsFrame;
import edu.arhs.team1100.aerialassist.scouting.objects.Event;
import edu.arhs.team1100.aerialassist.scouting.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eddie
 */
public class ViewEventsHandler {

    ViewEventsFrame vef;

    public ViewEventsHandler() {
        vef = new ViewEventsFrame();
    }

    public void addEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List events = session.createQuery("from Event").list();
        
        session.getTransaction().commit();

        for (int i = 0; i < events.size(); i++) {
            vef.addEvent((Event) events.get(i));
        }
        
        vef.setVisible(true);
    }

}