/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ClientApp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    
    private JFrame frame;
    private JPanel panel;
    
    private String message = "";
    private float posX = 0.0f;
    private float posY = 0.0f;
    private Font font;
    
    private Color bgColor = Color.BLACK;
    private Color textColor = Color.WHITE;
    
    private long lastFrame = 0;
    
    private char leftEnd = ' ';
    private char rightEnd = ' ';

    @Override
    public void init() {
        frame = new JFrame();
        panel = new JPanel();
        frame.add(panel);
        //frame.setResizable(false);
       // frame.setUndecorated(true);
       // Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
       // frame.setSize(d);
        frame.setSize(200,200);
        panel.setDoubleBuffered(true);
        
        //init font
        //font = new Font(Font.MONOSPACED, Font.PLAIN, d.height/2);
        
        frame.setVisible(true);
    }

    @Override
    public void update() {
        //draw
        
        font = new Font(Font.MONOSPACED, Font.PLAIN, panel.getHeight()/2);
        Graphics2D g = (Graphics2D)panel.getGraphics();
        g.setFont(font);
        g.setColor(bgColor);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        g.setColor(textColor);
        
        Rectangle target = new Rectangle(0,0,panel.getWidth(), panel.getHeight());
        Rectangle2D text = g.getFontMetrics().getStringBounds(message, g);
        int tx = (int)(posX * panel.getWidth());
        int cy =  (target.height) - (int)(target.height-text.getHeight())/2 - target.height/5;
        g.drawString(message,tx, cy );
        
        leftEnd = (tx < 0)?'-':'+';
        rightEnd = (tx+text.getWidth() < 0)?'-':'+';
        
    }
    
    public Color stringToColor(String s){
        try{
            String[] components = s.split(",");
            Color newColor = new Color(
                    Integer.parseInt(components[0]),
                    Integer.parseInt(components[1]),
                    Integer.parseInt(components[2])
            );
            return newColor;
        } catch(Exception e){}
        return Color.BLACK;
        
    }
    
    public void setPosition(String s){
        String[] components = s.split(",");
        posX = Float.parseFloat(components[0]);
        posY = Float.parseFloat(components[1]);
    }

    @Override
    public void commandRecieved(String command) {
        String[] cmdTokens = command.split(":");
        for(int i = 0; i < cmdTokens.length; i++){
            String[] cmdSegment = cmdTokens[i].split("#");
            if(cmdSegment.length < 2)continue;
            switch(cmdSegment[0]){
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
            }
        }
    }

    @Override
    public String getCommand() {
        return leftEnd+""+rightEnd;
    }

    @Override
    public void end() {
        frame.setVisible(false);
        frame.dispose();
    }

    @Override
    public String toString() {
        return APPNAME;
    }
    
}
