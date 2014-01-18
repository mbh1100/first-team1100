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
public class RandomColorsServerApp extends ServerApp {
    
    static final String APPNAME = "Random Colors";
    
    private Color color;
    
    private long colorChangeTime = 1000;
    private long lastChange = 0;

    @Override
    public void init() {
        color = Color.BLACK;
    }

    @Override
    public void update() {
        long curTime = System.currentTimeMillis();
        if(curTime - lastChange > colorChangeTime){
            color = new Color(randComp(), randComp(), randComp());
            lastChange = curTime;
            //System.out.println("new color "+color.toString());
        }               
    }
    
    private int randComp(){
        return (int)(Math.random()*256);
    }

    @Override
    public String getCommand(String id) {
        if(color == null){
            return "0,0,0";
        }
        else {
            return color.getRed()+","+color.getGreen()+","+color.getBlue();
        }
    }

    @Override
    public void commandRecieved(String id, String command) {
        
    }
    
    @Override
    public void end(){};

    @Override
    public String getServerName() {
        return APPNAME;
    }
    
}
