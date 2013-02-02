/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ClientApp;

/**
 *
 * @author akshay
 */
public class PanoramaViewerClientApp extends ClientApp {
    
    public static final String APPNAME = PanoramaViewerServerApp.APPNAME;

    @Override
    public void init() {
    }

    @Override
    public void update() {
    }

    @Override
    public void commandRecieved(String command) {
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public void end() {
    }

    @Override
    public String toString() {
        return APPNAME;
    }
    
}
