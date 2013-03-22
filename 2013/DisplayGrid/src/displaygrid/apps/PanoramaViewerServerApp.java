/*NOTES
 * -use a library like wget-java and send a lan url to the client
 * -client downloads the file needed independently of the DisplayGrid loop
 * -host a server on any computer with the files needed
 * -user provides urls to the gui
 */
package displaygrid.apps;

import displaygrid.ServerApp;
import javax.swing.JFrame;

/**
 *
 * @author akshay
 */
public class PanoramaViewerServerApp extends ServerApp{
    
    public static final String APPNAME = "Panorama Viewer";
    
    private PanoramaViewerServerFrame frame;

    @Override
    public void init() {
        frame = new PanoramaViewerServerFrame();
        frame.setVisible(true);
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
    public void end() {
    }

    @Override
    public String getServerName() {
        return APPNAME;
    }
    
}
