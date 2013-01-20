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
public class RandomColorsClientApp extends ClientApp {
    
    static final String APPNAME = RandomColorsServerApp.APPNAME;
    
    private Color color; 
    
    private JFrame window;
    private JPanel panel;
    
           
    
    @Override
    public void init(){
        color = Color.BLACK;  
        
        window = new JFrame();
        panel = new JPanel();
        window.add(panel);
        window.setResizable(false);
        window.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(d.width, d.height);
        window.setVisible(true);
        
    }
    
    private void draw(){
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
    }
    
    @Override
    public void update() {
        draw();
    }
    
    @Override
    public void end(){
        window.setVisible(false);
    }

    @Override
    public void commandRecieved(String command) {
        //System.out.println(command);
        String[] components = command.split(",");
        int[] rgb = new int[3];
        for(int i = 0; i < rgb.length; i++){
            rgb[i] = Integer.parseInt(components[i]);
        }
        color = new Color(rgb[0], rgb[1], rgb[2]);
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public String toString() {
        return APPNAME;
    }    
}
