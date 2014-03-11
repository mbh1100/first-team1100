package displaygrid.apps.frcmatchfeed;

import displaygrid.ClientApp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author akshay
 */
public class FRCMatchResultsClientApp extends ClientApp {

    static final String APPNAME = FRCMatchResultsServerApp.APPNAME;
    static final long TARGET_DELTA = 1000 * 5;
    private final Color RED = new Color(180, 0, 0);
    private final Color BLUE = new Color(50, 50, 255);
    private final String scorePlaceholder = "####### : ###";
    private JFrame frame;
    private JComponent panel;
    private String alliance;
    private String[] teams;
    private String num;
    private String event;
    private String type;
    private String finalScore, autoScore, teleopScore, climbScore, foulScore;
    private String titleText;
    private String teamText;
    private ArrayList<String> scoreText;
    private Font font;
    private Font titleFont;
    private Font teamFont;
    private Font scoreFont;
    private Font finalFont;
    private Rectangle titleRect;
    private Rectangle teamRect;
    private Rectangle scoreRect;
    private Rectangle finalRect;
    private boolean newInfo = false;
    private boolean got = false;

    @Override
    public void init() {
        font = new Font(Font.MONOSPACED, Font.BOLD, 10);
        alliance = "";
        teams = new String[3];
        num = "";
        event = "";
        type = "";
        finalScore = "";
        autoScore = "";
        teleopScore = "";
        climbScore = "";
        foulScore = "";

        titleText = "";
        teamText = "";
        scoreText = new ArrayList<>();


        frame = new JFrame();
        frame.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d);
        //frame.setSize(600,400);
        panel = new JComponent() {
            @Override
            public void paint(Graphics g) {
                paintPanel(g);
            }
        };
        frame.add(panel);
        frame.setVisible(true);
        ((Graphics2D) panel.getGraphics()).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        createRectangles();
    }
    
    private void createRectangles(){
        titleRect = new Rectangle(0, 0, panel.getWidth(), panel.getHeight()*2 / 10);
        teamRect = new Rectangle(0, (int)titleRect.getMaxY(), panel.getWidth(), panel.getHeight()*1 / 10);
        scoreRect = new Rectangle(0, (int)teamRect.getMaxY(), panel.getWidth(), panel.getHeight()*1 / 8);
        finalRect = new Rectangle(0,scoreRect.y+3*scoreRect.height, panel.getWidth(), panel.getHeight()*3 / 10);
    }

    @Override
    public void update() {
        
        try {
            if (newInfo) {
                newInfo = false;
                createRectangles();
                titleText = type + " #" + num;
                //titleRect = new Rectangle(0, 0, panel.getWidth(), panel.getHeight() / 7);
                titleFont = scaleFont(titleText, titleRect, panel.getGraphics(), font);

                teamText = teams[0] + " | " + teams[1] + " | " + teams[2];
                //teamRect = new Rectangle(0, titleRect.y + titleRect.height, panel.getWidth(), panel.getHeight() / 10);
                teamFont = scaleFont(teamText, teamRect, panel.getGraphics(), font);

                scoreText.clear();
                scoreText.add("Auto   : " + autoScore);
                scoreText.add("Teleop : " + teleopScore);
                scoreText.add("Foul   : " + foulScore);
                
                //scoreRect = new Rectangle(0, teamRect.y + teamRect.height + panel.getHeight() / 20, panel.getWidth(), panel.getHeight() / 12);
                scoreFont = scaleFont("###### : ###", scoreRect, panel.getGraphics(), font);

                //finalRect = finalRect = new Rectangle(0, (panel.getHeight() * 2) / 3, panel.getWidth(), panel.getHeight() / 3);

                finalFont = scaleFont(finalScore, finalRect, panel.getGraphics(), font);
                System.out.println(scoreFont.getName());
            }
        } catch (Exception e) {
        }
        frame.repaint();
    }

    public void paintPanel(Graphics g1) {
        if(!got){
            g1.setColor(new Color(150,0,0));
            g1.fillRect(0, 0, panel.getWidth(), panel.getHeight());
            return;
        }
        Graphics2D g = (Graphics2D) g1;
        Color theme = Color.DARK_GRAY;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        if (alliance.equals("red")) {
            theme = RED;
        } else if (alliance.equals("blue")) {
            theme = BLUE;
        }
        g.setColor(theme);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        Rectangle titleR = center(g.getFontMetrics().getStringBounds(titleText, g).getBounds(), titleRect);
        g.drawString(titleText, titleR.x, titleR.y);

        g.setFont(teamFont);
        Rectangle teamR = center(g.getFontMetrics().getStringBounds(teamText, g).getBounds(), teamRect);
        g.drawString(teamText, teamR.x, teamR.y);

        g.setFont(scoreFont);
        Rectangle scoreR = center(g.getFontMetrics().getStringBounds(scorePlaceholder, g).getBounds(), scoreRect);
        for (String s : scoreText) {
            g.drawString(s, scoreR.x, scoreR.y);
            scoreR.y += scoreR.height + 1;
        }
        g.setColor(Color.WHITE);
        //g.draw(titleRect);
        //g.draw(teamRect);
        //g.draw(finalRect);
        g.setFont(finalFont);
        Rectangle finalR = center(g.getFontMetrics().getStringBounds(finalScore, g).getBounds(), finalRect);
        
        g.drawString(finalScore, finalR.x, finalR.y);
    }

    private Rectangle center(Rectangle a, Rectangle b) {
        int tx = (int) ((b.width - a.getWidth()) / 2) + b.x;
        int cy = (b.height) - (int) (b.height - a.getHeight()) / 2 - b.height / 5 + b.y;
        return new Rectangle(tx, cy, a.width, b.height);
    }

    @Override
    public void commandRecieved(String command) {
        if(command.length() < 10)return;
        String[] info = command.split("#");
        System.out.println("commandRecieved "+command);
        try {
            event = getProperty("event", info);
            type = getProperty("type", info);
            num = getProperty("num", info);
            alliance = getProperty("alliance", info);
            teams = getProperty("teams", info).split(",");
            finalScore = getProperty("final", info);
            autoScore = getProperty("auto", info);
            teleopScore = getProperty("teleop", info);
            foulScore = getProperty("foul", info);
            newInfo = true;
            got = true;
        } catch (Exception e) {
        }

    }

    private String getProperty(String k, String[] cmd) {
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].startsWith(k)) {
                return cmd[i].split(":")[1];
            }
        }
        return "";
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

    @Override
    public long getTargetDelta() {
        return TARGET_DELTA;
    }

    private Font scaleFont(String text, Rectangle rect, Graphics g, Font pFont) {
        float fontSize = 1.0f;
        Font f = pFont.deriveFont(fontSize);
        while (g.getFontMetrics(f).stringWidth(text) < rect.width && g.getFontMetrics(f).getHeight() < rect.getHeight()) {
            fontSize++;
            f = f.deriveFont(fontSize);
        }
        return f;
    }

    //Tester main to fake the DisplayGrid loop
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final FRCMatchResultsClientApp app = new FRCMatchResultsClientApp();
        app.init();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    app.commandRecieved(sc.nextLine());
                }
            }
        }.start();

        while (true) {
            app.update();
            try {
                Thread.sleep(1000 / 30);
            } catch (Exception e) {
            }
        }
    }
}
