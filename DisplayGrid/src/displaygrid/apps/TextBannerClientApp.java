/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ClientApp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Akshay
 */
public class TextBannerClientApp extends ClientApp {

    static final String APPNAME = TextBannerServerApp.APPNAME;
    static final long TARGET_DELTA = 1000/20;
    
    private JFrame frame;
    private JPanel panel;
    
    private String message = "";
    private float posX = 0.0f;
    private float speed = 0;
    
    private Font font;
    private boolean fontSet = false;
    private Color bgColor = Color.BLACK;
    private Color textColor = Color.WHITE;

    @Override
    public void init() {
        frame = new JFrame();
        
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                paintPanel((Graphics2D) g);
            }
        };
        
        frame.add(panel);
        frame.setResizable(true);
        frame.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d);
        //frame.setSize(400, 200);
        frame.setTitle(getName());
        panel.setDoubleBuffered(true);
        frame.setVisible(true);
        
    }

    private void paintPanel(Graphics2D g) {
        
        if(!fontSet){
            font = new Font(Font.MONOSPACED, Font.BOLD, panel.getHeight()/2);
            g.setFont(font);
        }
        
        g.setColor(bgColor);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        g.setColor(textColor);

        Rectangle target = new Rectangle(0, 0, panel.getWidth(), panel.getHeight());
        Rectangle2D text = g.getFontMetrics().getStringBounds(message, g);
        
        int textX = (int)(posX * panel.getWidth());
        
        int centerY = (target.height) - (int) (target.height - text.getHeight()) / 2 - target.height / 5;
        g.drawString(message, textX, centerY);
    }

    @Override
    public void update() {
        posX -= speed;
        frame.repaint();
    }

    public Color stringToColor(String s) {
        try {
            String[] components = s.split(",");
            Color newColor = new Color(
                    Integer.parseInt(components[0]),
                    Integer.parseInt(components[1]),
                    Integer.parseInt(components[2]));
            return newColor;
        } catch (Exception e) {
        }
        return Color.BLACK;

    }

    public void setPosition(String s) {
        posX = Float.parseFloat(s);
    }
    
    public void setSpeed(String s){
        speed = Float.parseFloat(s);
    }

    @Override
    public void commandRecieved(String command) {
        //System.out.println("Command: " + command);
        String[] cmdTokens = command.split(":");
        for (int i = 0; i < cmdTokens.length; i++) {
            String[] cmdSegment = cmdTokens[i].split("#");
            if (cmdSegment.length < 2) {
                continue;
            }
            switch (cmdSegment[0]) {
                case "msg":
                    message = cmdSegment[1];
                    break;
                case "bg":
                    bgColor = stringToColor(cmdSegment[1]);
                    break;
                case "txt":
                    textColor = stringToColor(cmdSegment[1]);
                    break;
                case "pos":
                    setPosition(cmdSegment[1]);
                    break;
                case "dx":
                    setSpeed(cmdSegment[1]);
            }
        }
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