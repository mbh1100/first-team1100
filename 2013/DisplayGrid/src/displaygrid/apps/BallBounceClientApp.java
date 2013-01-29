/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ClientApp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Akshay
 */
public class BallBounceClientApp extends ClientApp {
    
    static final String APPNAME = BallBounceServerApp.APPNAME;
    static final long TARGET_DELTA = 1000*5; 
    
    public static final float MAX_X = BallBounceServerApp.MAX_X;
    public static final float MAX_Y = BallBounceServerApp.MAX_Y;
    public static final float MIN_X = BallBounceServerApp.MIN_X;
    public static final float MIN_Y = BallBounceServerApp.MIN_Y;
    
    private JFrame frame;
    private JPanel panel;
    
    private int index = 0;
    private int numClients = 1;
    private float x,y,dx, dy;
    private int radius;
    
    long lastFrame = 0;

    @Override
    public void init() {
        x = 0; 
        y = 0;
        dx = 0;
        dy = 0;
        
        frame = new JFrame();
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                paintPanel(g);
            }
        };
        frame.add(panel);
        frame.setResizable(false);
        frame.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        radius = d.width/20;
        frame.setSize(d);
        //frame.setSize(300,400);
        panel.setDoubleBuffered(true);
        frame.setVisible(true);
    }

    @Override
    public void update() {
        x += dx/numClients;
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
        
        frame.repaint();        
    }
    
    public void paintPanel(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        g.setColor(Color.WHITE);
        
        float windowSize = MAX_X/numClients;
        float minx = index*windowSize;
        float maxx = (index+1)*windowSize;
        float rx = (x-minx)/windowSize; //relative to this screen
        
        int screenX = (int)(rx*panel.getWidth());
        int screenY = (int)(y*panel.getHeight());
        g.fillOval(screenX-radius, screenY-radius, radius*2, radius*2);    
        
        //FPS
        
//        long elapsed = System.currentTimeMillis() - lastFrame;
//        int fps = (int) (1000/elapsed);
//        g.drawString("FPS: "+fps, 50, 80);
//        lastFrame = System.currentTimeMillis();
        
    }

    @Override
    public void commandRecieved(String command) {
        String[] coords = command.split(",");
        if(coords.length < 2) {
            return;
        }
        
        index = Integer.parseInt(coords[0]);
        numClients = Integer.parseInt(coords[1]);
        x = Float.parseFloat(coords[2]);
        y = Float.parseFloat(coords[3]);
        dx = Float.parseFloat(coords[4]);
        dy = Float.parseFloat(coords[5]);
    }

    @Override
    public String getCommand() {
        return null;
    }
    
    @Override
    public long getTargetDelta(){
        return TARGET_DELTA;
    }

    @Override
    public void end() {
        frame.setVisible(false);
        
    }

    @Override
    public String toString() {
        return APPNAME;
    }
    
}
