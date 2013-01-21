/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ServerApp;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Akshay
 */
public class BallBounceServerApp extends ServerApp{
    
    static final String APPNAME = "Ball Bounce";
    
    private final float MAX_X = 1.0f;
    private final float MAX_Y = 1.0f;
    private final float MIN_X = 0.0f;
    private final float MIN_Y = 0.0f;
    
    private JFrame frame;
    private JPanel panel;
    
    private float dx, dy;
    private float x,y;
    

    @Override
    public void init() {
        frame = new JFrame("Ball Bounce ServerApp");
        panel = new JPanel();
        frame.add(panel);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        
        dx = dy = 0.01f;
        x = (float)Math.random();
        y = (float)Math.random();
        
    }

    @Override
    public void update() {
        x += dx;
        y += dy;
        
        if(x > MAX_X){
            x = MAX_X;
            dx *= -1;
        } else if (x < MIN_X){
            x = MIN_X;
            dx *= -1;
        }
        
        if(y > MAX_Y){
            y = MAX_Y;
            dy *= -1;
        } else if (y < MIN_Y){
            y = MIN_Y;
            dy *= -1;
        } 
        
        Graphics g = panel.getGraphics();
        if(g != null){
            //background
            g.setColor(Color.BLACK);
            g.fillRect(0,0, panel.getWidth(), panel.getHeight());
            //ball
            g.setColor(Color.WHITE);            
            int radius = panel.getWidth()/20;
            g.fillOval((int)(x*panel.getWidth()), (int)(y*panel.getHeight()), (int)radius, (int)radius);
            //draw lines & clientID text to represent client windows
            int spacing = panel.getWidth()/clients.size();
            for(int i = 0; i < clients.size(); i++){
                g.drawLine(i*spacing, 0, i*spacing, panel.getHeight());
                g.drawString(clients.get(i), i*spacing+10, 20);
            }
        }
    }

    @Override
    public String getCommand(String id) {
        int i = clients.indexOf(id);
        if(i == -1)return null;
        
        float windowSize = MAX_X/clients.size();
        float minx = i*windowSize;
        float maxx = (i+1)*windowSize;
        float cx = (x-minx)/(maxx-minx);
        return cx+","+y;
    }

    @Override
    public void commandRecieved(String id, String command) {
        return;
    }
    
    public void end(){
        frame.setVisible(false);
    }

    @Override
    public String toString() {
        return APPNAME;
    }
    
}
