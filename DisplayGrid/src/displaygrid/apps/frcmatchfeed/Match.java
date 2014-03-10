package displaygrid.apps.frcmatchfeed;

class Match {

    private static final int P_EVENT = 0;
    private static final int P_TYPE = 2;
    private static final int P_MATCHNUMBER = 4;
    private static final int P_TOTAL_RED = 6;
    private static final int P_TOTAL_BLUE = 8;
    private static final int P_RED1 = 10;
    private static final int P_RED2 = 11;
    private static final int P_RED3 = 12;
    private static final int P_BLUE1 = 14;
    private static final int P_BLUE2 = 15;
    private static final int P_BLUE3 = 16;
    private static final int P_RED_FOUL = 18;
    private static final int P_BLUE_FOUL = 20;
    private static final int P_RED_AUTO = 22;
    private static final int P_BLUE_AUTO = 24;
    private static final int P_RED_TELEOP = 26;
    private static final int P_BLUE_TELEOP = 28;
    public String event;
    public String type;
    public int num;
    public int red_final;
    public int blue_final;
    public int red1;
    public int red2;
    public int red3;
    public int blue1;
    public int blue2;
    public int blue3;
    public int red_foul;
    public int blue_foul;
    public int red_auto;
    public int blue_auto;
    public int red_teleop;
    public int blue_teleop;

    public Match(String tweet) throws Exception {
        String[] parts = tweet.split(" ");

        event             =                  parts[P_EVENT];
        type              =                  parts[P_TYPE];
        
        num         = Integer.parseInt(parts[P_MATCHNUMBER]);
        red_final   = Integer.parseInt(parts[P_TOTAL_RED]);
        blue_final  = Integer.parseInt(parts[P_TOTAL_BLUE]);
        red1        = Integer.parseInt(parts[P_RED1]);
        red2        = Integer.parseInt(parts[P_RED2]);
        red3        = Integer.parseInt(parts[P_RED3]);
        blue1       = Integer.parseInt(parts[P_BLUE1]);
        blue2       = Integer.parseInt(parts[P_BLUE2]);
        blue3       = Integer.parseInt(parts[P_BLUE3]);
        red_foul    = Integer.parseInt(parts[P_RED_FOUL]);
        blue_foul   = Integer.parseInt(parts[P_BLUE_FOUL]);
        red_auto    = Integer.parseInt(parts[P_RED_AUTO]);
        blue_auto   = Integer.parseInt(parts[P_BLUE_AUTO]);
        red_teleop  = Integer.parseInt(parts[P_RED_TELEOP]);
        blue_teleop = Integer.parseInt(parts[P_BLUE_TELEOP]);
        
        switch(type){
            case "Q":
                type = "Qualification";
            case "P":
                type = "Practice";
            case "E":
                type = "Elimination";
            default:
                type = "Match";                      
        }

    }
}