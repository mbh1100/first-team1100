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
    static final long TARGET_DELTA = 1000/5;
    
    private Color color; 
    
    private JFrame frame;
    private JPanel panel;
    
           
    
    @Override
    public void init(){
        color = Color.BLACK;  
        
        frame = new JFrame();
        frame.setTitle(this.getName());
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
        frame.setSize(d.width, d.height);
        frame.setVisible(true);
        
    }
    
    public void paintPanel(Graphics g){
        g.setColor(color);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
    }
    
    @Override
    public void update() {
        frame.repaint();
    }
    
    @Override
    public void end(){
        frame.setVisible(false);
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
    public long getTargetDelta(){
        return TARGET_DELTA;
    }
    
    @Override
    public String toString() {
        return APPNAME;
    }    
}
