/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ServerApp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Akshay
 */
public class TextBannerServerApp extends ServerApp {
    
    static final String APPNAME = "Text Banner";
    
    private String commonCmd;
    
    private String message = "Go Team1100!";
    
    private Color bgColor;
    private Color textColor;

    private float x;
    
    private double messageWidth;
    
    private int lastClientWidth = 0;

    @Override
    public void init() {
        bgColor = new Color(150, 0, 0);
        textColor = new Color(255, 255, 255);
        x = 0f;
        commonCmd = "";
        
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 50));
        messageWidth = g.getFontMetrics().getStringBounds(message, g).getWidth();
    }

    @Override
    public void update() {
        x += 0.01;  
        if(x > (clients.size()) + (messageWidth / lastClientWidth)){
            x = 0.0f;
        }
        commonCmd = "";
        commonCmd += "msg#"+message+":";
        commonCmd += "bg#"+getColorString(bgColor)+":";
        commonCmd += "txt#"+getColorString(textColor)+":";
    }
    
    public String getColorString(Color c){
        return c.getRed()+","+c.getGreen()+","+c.getBlue();
    }
    
    @Override
    public String getCommand(String id) {      
        
        int i = clients.indexOf(id);
        if(i == -1) {
            return null;
        }
        
        String cmd = commonCmd;
        
        cmd += "pos#"+x+":";
        cmd += "clientID#"+clients.indexOf(id) + ":";
        return cmd;    
    }

    @Override
    public void commandRecieved(String id, String command) {
        if(clients.indexOf(id) == clients.size()-1) //If last Client
        {
            String[] cmdSegment = command.split("#");
            switch(cmdSegment[0]){
                case "resX":
                    lastClientWidth = Integer.parseInt(cmdSegment[1]);
                    break;
            }
        }
    }

    @Override
    public void end() {
        return;
    }

    @Override
    public String getServerName() {
        return APPNAME;
    }
}