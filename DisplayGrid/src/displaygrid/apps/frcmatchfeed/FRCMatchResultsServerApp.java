package displaygrid.apps.frcmatchfeed;

import displaygrid.ServerApp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import twitter4j.DirectMessage;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.UserStreamListener;
import twitter4j.conf.ConfigurationBuilder;
 
/**
 *
 * @author akshay
 */
public class FRCMatchResultsServerApp extends ServerApp implements UserStreamListener {

    static final String APPNAME = "FRC Match Feed";
    private final String CONSUMER_KEY = "ckOOx2CghcjDKhzNk3hZA";
    private final String CONSUMER_SECRET = "HIG9WI2ISdf3Lau2aJfjmQH6MgI9q8dH5pQYr9Nztts";
    private final String ACCESS_TOKEN = "1260628040-2eWI6BDvlAKeP2RXLQzSaQ0nhYXVz1Nq1tTuY66";
    private final String ACCESS_TOKEN_SECRET = "qI6xDdYwv60beXcUALbicAJMEsizCUWJ7dxd2YD0";
    private final long FMS_USERID = 20603824;
    //private final long FMS_USERID = 1260704491;
    private TwitterStream frcStream;
   
    private Match lastMatch;
    private String redCommand;
    private String blueCommand;
    private boolean redPending = false;
    private boolean bluePending = false;
    
    private String filter = null;
    
    private FRCMatchResultsServerPanel panel;

    @Override
    public void init() {
        
        panel = new FRCMatchResultsServerPanel();
        panel.eventFilter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(panel.eventFilter.getText() == null || panel.eventFilter.getText().isEmpty()){
                    filter = null;
                } else {
                    filter = "#FRC"+panel.eventFilter.getText();
                    filter = filter.toUpperCase();
                }
            }
        });
        setTabPanel(panel);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(CONSUMER_KEY);
        cb.setOAuthConsumerSecret(CONSUMER_SECRET);
        cb.setOAuthAccessToken(ACCESS_TOKEN);
        cb.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        frcStream = new TwitterStreamFactory(cb.build()).getInstance();
        frcStream.addListener(this);
        frcStream.user();
        

    }

    @Override
    public void update() {
        //nothin todo
    }

    @Override
    public String getCommand(String id) {
        if(clients.size() < 2)return null;
        
        if(redPending && clients.indexOf(id) == 0){
            redPending = false;
            
            return redCommand;
        } else if(bluePending && clients.indexOf(id) == clients.size()-1){
            bluePending = false;
            return blueCommand;
        }
        return null;
    }

    @Override
    public void commandRecieved(String id, String command) {
        //nothin here
    }

    @Override
    public void end() {
       
        frcStream.shutdown();
    }

    @Override
    public String getServerName() {
        return APPNAME;
    }

    @Override
    public void onStatus(Status status) {
        if (status.getUser().getId() == FMS_USERID) {
            System.out.println(status.getText());
            try {
                Match m = new Match(status.getText());
                
                String header = "";    
                header += "event:"+m.event.substring(1)+"#";
                
               if(filter != null &&! m.event.equalsIgnoreCase(filter)){
                   return;
               }
               
                header += "type:"+m.type+"#";
                
                header += "num:"+m.num+"#";
                
                redCommand = "";
                redCommand += header;
                redCommand += "alliance:red#";
                redCommand += "teams:"+m.red1+","+m.red2+","+m.red3+"#";
                redCommand += "final:"+m.red_final+"#";
                redCommand += "auto:"+m.red_auto+"#";
                redCommand += "teleop:"+m.red_teleop+"#";
                redCommand += "foul:"+m.red_foul;           
                
                blueCommand = "";
                blueCommand += header;
                blueCommand += "alliance:blue#";
                blueCommand += "teams:"+m.blue1+","+m.blue2+","+m.blue3+"#";
                blueCommand += "final:"+m.blue_final+"#";
                blueCommand += "auto:"+m.blue_auto+"#";
                blueCommand += "teleop:"+m.blue_teleop+"#";
                blueCommand += "foul:"+m.blue_foul;
                
                redPending = true;
                bluePending = true;
                
                lastMatch = m;
                
                /*String s = "\n\n";
                s += m.event + ", " + m.type + "\n";
                s += "[RED]" + m.red1 + ", " + m.red2 + ", " + m.red3 + "\n";
                s += "final:" + m.red_final +"\n";
                s += "auto:" + m.red_auto +"\n";
                s += "teleop:" + m.red_teleop +"\n";
                s += "climb:" + m.red_climb +"\n";
                s += "foul:" + m.red_foul +"\n";

                s += "[BLUE]" + m.blue1 + ", " + m.blue2 + ", " + m.blue3 + "\n";
                s += "final:" + m.blue_final +"\n";
                s += "auto:" + m.blue_auto +"\n";
                s += "teleop:" + m.blue_teleop +"\n";
                s += "climb:" + m.blue_climb +"\n";
                s += "foul:" + m.blue_foul +"\n\n";*/

                System.out.println(redCommand);
                System.out.println(blueCommand);


            } catch (Exception e) {
                //status could not be parsed
                e.printStackTrace();
                System.out.println("BAD");

            }
        }
    }

    //UN IMPLEMENTED ----------------------------------------------------------
    @Override
    public void onDeletionNotice(long l, long l1) {
    }

    @Override
    public void onFriendList(long[] longs) {
    }

    @Override
    public void onFavorite(User user, User user1, Status status) {
    }

    @Override
    public void onUnfavorite(User user, User user1, Status status) {
    }

    @Override
    public void onFollow(User user, User user1) {
    }

    @Override
    public void onDirectMessage(DirectMessage dm) {
    }

    @Override
    public void onUserListMemberAddition(User user, User user1, UserList ul) {
    }

    @Override
    public void onUserListMemberDeletion(User user, User user1, UserList ul) {
    }

    @Override
    public void onUserListSubscription(User user, User user1, UserList ul) {
    }

    @Override
    public void onUserListUnsubscription(User user, User user1, UserList ul) {
    }

    @Override
    public void onUserListCreation(User user, UserList ul) {
    }

    @Override
    public void onUserListUpdate(User user, UserList ul) {
    }

    @Override
    public void onUserListDeletion(User user, UserList ul) {
    }

    @Override
    public void onUserProfileUpdate(User user) {
    }

    @Override
    public void onBlock(User user, User user1) {
    }

    @Override
    public void onUnblock(User user, User user1) {
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice sdn) {
    }

    @Override
    public void onTrackLimitationNotice(int i) {
    }

    @Override
    public void onScrubGeo(long l, long l1) {
    }

    @Override
    public void onStallWarning(StallWarning sw) {
    }

    @Override
    public void onException(Exception excptn) {
    }
}
