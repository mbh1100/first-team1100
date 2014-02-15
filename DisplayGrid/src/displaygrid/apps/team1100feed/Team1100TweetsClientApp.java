/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displaygrid.apps.team1100feed;

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
import displaygrid.apps.team1100feed.TeamTweets;
/**
 *
 * @author Zach
 */
public class Team1100TweetsClientApp extends ClientApp {

    static final String APPNAME = Team1100TweetsServerApp.APPNAME;
    static final long TARGET_DELTA = 1000 * 5;
    private final Color RED = new Color(180, 0, 0);
    private final Color BLUE = new Color(50, 50, 255);
    private final String scorePlaceholder = "####### : ###";
    private JFrame frame;
    private JComponent panel;
    private ArrayList<String> scoreText;
    private Font font;
    private Font titleFont;
    private Font finalFont;
    private Rectangle titleRect;
    private Rectangle finalRect;
    private boolean newInfo = false;
    private boolean got = false;
    private String titleText;
    

    @Override
    public void init() {
        font = new Font(Font.MONOSPACED, Font.BOLD, 10);
        
        scoreText = new ArrayList<>();


        frame = new JFrame();
        //frame.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d);
        frame.setSize(600,400);
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
    }

    @Override
    public void update() {
        try {
            if (newInfo) {
                newInfo = false;
                createRectangles();
                titleText = " ";
                //titleRect = new Rectangle(0, 0, panel.getWidth(), panel.getHeight() / 7);
                titleFont = scaleFont(titleText, titleRect, panel.getGraphics(), font);
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
        
        theme = RED;
        
        g.setColor(theme);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        Rectangle titleR = center(g.getFontMetrics().getStringBounds(titleText, g).getBounds(), titleRect);
        g.drawString(titleText, titleR.x, titleR.y);

       
        g.setColor(Color.WHITE);
        
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
        final Team1100TweetsServerApp app = new Team1100TweetsServerApp();
        app.init();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    app.commandRecieved("temp", sc.nextLine());
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