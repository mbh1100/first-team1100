package displaygrid;

import displaygrid.apps.BallBounceClientApp;
import displaygrid.apps.BallBounceServerApp;
import displaygrid.apps.BallBounceVerticleClientApp;
import displaygrid.apps.BallBounceVerticleServerApp;
import displaygrid.apps.BlackScreenClientApp;
import displaygrid.apps.BlackScreenServerApp;
import displaygrid.apps.PanoramaViewerClientApp;
import displaygrid.apps.PanoramaViewerServerApp;
import displaygrid.apps.RandomColorsClientApp;
import displaygrid.apps.RandomColorsServerApp;
import displaygrid.apps.TextBannerClientApp;
import displaygrid.apps.TextBannerServerApp;
import displaygrid.apps.frcmatchfeed.FRCMatchResultsClientApp;
import displaygrid.apps.frcmatchfeed.FRCMatchResultsServerApp;

/**
 *
 * @author Akshay
 */
public class Config {
    
    static final int TARGET_FPS = 30;
    static final int TARGET_DELTA = 1000/TARGET_FPS;   
    
    static final int PORT = 1980;
    
    static String appNames[];
    
    static final Class[] clientAppClasses = {
        BlackScreenClientApp.class,
        RandomColorsClientApp.class,
        BallBounceClientApp.class,
        BallBounceVerticleClientApp.class,
        TextBannerClientApp.class,
        PanoramaViewerClientApp.class,
        FRCMatchResultsClientApp.class,
    };
    
    static final Class[] serverAppClasses = {
        BlackScreenServerApp.class,
        RandomColorsServerApp.class,
        BallBounceServerApp.class,
        BallBounceVerticleServerApp.class,
        TextBannerServerApp.class,
        PanoramaViewerServerApp.class,
        FRCMatchResultsServerApp.class,
    };
    
}
