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

/**
 *
 * @author Akshay
 */
public class BlackScreenClientApp extends ClientApp{

    static final String APPNAME = "Black Screen";
    static final long TARGET_DELTA = 1000;
    
    private JFrame blackScreen;
    
    @Override
    public void init() {
        blackScreen = new JFrame();
        blackScreen.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        blackScreen.setSize(d);
        blackScreen.setVisible(true);
    }
    
    private void draw(){
        Graphics g = blackScreen.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, blackScreen.getWidth(), blackScreen.getHeight());
        
    }

    @Override
    public void update() {
        draw();
    }

    @Override
    public void commandRecieved(String command) {
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
        blackScreen.setVisible(false);
    }

    @Override
    public String toString() {
        return APPNAME;
    }
    
}
