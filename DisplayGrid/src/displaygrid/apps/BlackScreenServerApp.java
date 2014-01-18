/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ServerApp;

/**
 *
 * @author Akshay
 */
public class BlackScreenServerApp extends ServerApp {
    
    static final String APPNAME = "Black Screen";

    @Override
    public void init() {
    }

    @Override
    public void update() {
    }

    @Override
    public String getCommand(String id) {
        return null;
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
