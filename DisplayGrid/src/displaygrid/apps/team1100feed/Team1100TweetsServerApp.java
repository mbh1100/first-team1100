/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displaygrid.apps.team1100feed;


import displaygrid.ServerApp;
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
 * @author Zach
 */
public class Team1100TweetsServerApp extends ServerApp implements UserStreamListener{ 
    static final String APPNAME = "Team 1100 Feed";
    private final String CONSUMER_KEY = "ckOOx2CghcjDKhzNk3hZA";
    private final String CONSUMER_SECRET = "HIG9WI2ISdf3Lau2aJfjmQH6MgI9q8dH5pQYr9Nztts";
    private final String ACCESS_TOKEN = "1260628040-2eWI6BDvlAKeP2RXLQzSaQ0nhYXVz1Nq1tTuY66";
    private final String ACCESS_TOKEN_SECRET = "qI6xDdYwv60beXcUALbicAJMEsizCUWJ7dxd2YD0";
    
    //team 1100 account
    //private final long FMS_USERID = 260902828;
    
    //Zach's account (for testing)
    private final long FMS_USERID = 1478604451;
    
    private TwitterStream streamTeam;
    
    private TeamTweets lastTweet;
    private String redCommand;
    private String blueCommand;
    private boolean redPending = false;
    private boolean bluePending = false;

    @Override
    public void init() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(CONSUMER_KEY);
        cb.setOAuthConsumerSecret(CONSUMER_SECRET);
        cb.setOAuthAccessToken(ACCESS_TOKEN);
        cb.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        streamTeam = new TwitterStreamFactory(cb.build()).getInstance();
        streamTeam.addListener(this);
        streamTeam.user();
        

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
        streamTeam.shutdown();
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
                TeamTweets m = new TeamTweets(status.getText());
                
                String header = "";    
                
                lastTweet = m;

                System.out.println(redCommand);
                System.out.println(blueCommand);


            } catch (Exception e) {
                //status could not be parsed
                System.out.println("BAD-ERER: STATUS COULD NOT BE PARSED");

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