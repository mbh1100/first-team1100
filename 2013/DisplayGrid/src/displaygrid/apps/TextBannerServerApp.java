/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ServerApp;
import java.awt.Color;

/**
 *
 * @author Akshay
 */
public class TextBannerServerApp extends ServerApp {
    
    private final float MIN_X = 0.0f;
    private final float MIN_Y = 0.0f;
    private final float MAX_X = 1.0f;
    private final float MAX_y = 1.0f;
    
    static final String APPNAME = "Text Banner";
    
    private String commonCmd;
    
    private String message = "Go Team1100!";
    
    private Color bgColor;
    private Color textColor;
    
    private float x,y;

    @Override
    public void init() {
        bgColor = new Color(150, 0, 0);
        textColor = new Color(255, 255, 255);
        x = 0f;
        y = 0f;
        commonCmd = "";
    }

    @Override
    public void update() {
        x -= 0.01;
        if(x < -1.0f){
            x = 1.0f;
        }
        commonCmd = "";
        commonCmd += "msg#"+message+":";
        commonCmd += "bg#"+getColorString(bgColor)+":";
        commonCmd += "txt#"+getColorString(textColor)+":";
    }
    
    public String getColorString(Color c){
        return c.getRed()+","+c.getGreen()+","+c.getBlue();
    }
    
    /**
     * Command Structure:
     * command send changed variables, split by ":"
     * vars: msg(string to display), bg(background color), txt(text color), pos(position, float relative to client)
     * each subcommand is formatted var| values
     * example:
     * msg|"go team1100!": bgcolor|255| 255| 255:txtcolor|163|0|255:pos|.63|.23
     * command will contain any combinations of commands in any order
     * @param id
     * @return 
     */
    @Override
    public String getCommand(String id) {      
        
        int i = clients.indexOf(id);
        if(i == -1) {
            return null;
        }
        
        String cmd = commonCmd;
        
        float windowSize = MAX_X/clients.size();
        float minx = i*windowSize;
        float maxx = (i+1)*windowSize;
        float relativeX = (x-minx)/(maxx-minx);        
        cmd += "pos#"+relativeX+","+y;
        return cmd;    
    }

    @Override
    public void commandRecieved(String id, String command) {
        return;
    }

    @Override
    public void end() {
        return;
    }

    @Override
    public String toString() {
        return APPNAME;
    }
}