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
    
    private JFrame screenWindow;
    private JPanel screen;
    
    private int x,y, radius;
    
    long lastFrame = 0;

    @Override
    public void init() {
        x = 0; 
        y = 0;
        
        screenWindow = new JFrame();
        screen = new JPanel();
        screenWindow.add(screen);
        screenWindow.setResizable(false);
        screenWindow.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        radius = d.width/20;
        screenWindow.setSize(d);
        screen.setDoubleBuffered(true);
        screenWindow.setVisible(true);
    }

    @Override
    public void update() {
        Graphics g = screen.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
        g.setColor(Color.WHITE);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
        
        //FPS
        /*
        long elapsed = System.currentTimeMillis() - lastFrame;
        int fps = (int) (1000/elapsed);
        g.drawString("FPS: "+fps, 50, 80);
        lastFrame = System.currentTimeMillis();
        */
    }

    @Override
    public void commandRecieved(String command) {
        String[] coords = command.split(",");
        if(coords.length < 2) return;
        x = (int)(screen.getWidth()*Float.parseFloat(coords[0]));
        y = (int)(screen.getHeight()*Float.parseFloat(coords[1]));
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public void end() {
        screenWindow.setVisible(false);
        
    }

    @Override
    public String toString() {
        return APPNAME;
    }
    
}
