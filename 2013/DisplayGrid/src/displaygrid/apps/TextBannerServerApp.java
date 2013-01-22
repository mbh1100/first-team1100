/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ServerApp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

/**
 *
 * @author Akshay
 */
public class TextBannerServerApp extends ServerApp implements ActionListener {

    static final String APPNAME = "Text Banner";
    private String commonCmd;
    private String message = "Go Team1100!";
    private Color bgColor;
    private Color textColor;
    private float x;
    private double messageWidth;
    private int lastClientWidth = 0;
    TextBannerServerFrame window;
    Graphics2D g;
    Font font;
    Font panelFont;
    private ArrayList<String> settingsUpdatePending;

    @Override
    public void init() {
        //window = new TextBannerServerFrame();   <---THIS LINE BREAKS CODE!!!!
//        window.setTitle(this.toString());
//        window.bgcolorButton.addActionListener(this);
//        window.textcolorButton.addActionListener(this);
//        window.messageField.addActionListener(this);
//        g = (Graphics2D) window.panel.getGraphics();
//
//        window.setVisible(true);
//
//        font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
//        panelFont = new Font(Font.MONOSPACED, Font.PLAIN, window.panel.getHeight() / 2);
//        g.setFont(panelFont);
//        messageWidth = g.getFontMetrics().getStringBounds(message, g).getWidth();

        settingsUpdatePending = new ArrayList<>();

        bgColor = new Color(150, 0, 0);
        textColor = new Color(255, 255, 255);
        x = 0f;
        commonCmd = "";

        
    }

    @Override
    public void update() {
        x += 0.01;
        if (x > (clients.size()) + (messageWidth / lastClientWidth)) {
            x = 0.0f;
        }

//        g.setColor(bgColor);
//        g.fillRect(0, 0, window.panel.getWidth(), window.panel.getHeight());
//        g.setColor(textColor);
//        int panelHeight = window.panel.getHeight();
//        Rectangle2D text = g.getFontMetrics().getStringBounds(message, g);
//        int tx = (int) ((x % 2) * window.panel.getHeight());
//        int ty = panelHeight - (int) (panelHeight - text.getHeight()) / 2 - panelHeight / 5;
//        g.drawString(message, tx, ty);
        
        updateCommonCommand();
    }

    public void updateCommonCommand() {
        commonCmd = "";
        commonCmd += "msg#" + message + ":";
        commonCmd += "bg#" + getColorString(bgColor) + ":";
        commonCmd += "txt#" + getColorString(textColor) + ":";
        for (String c : clients) {
            settingsUpdatePending.add(c);
        }
    }

    public String getColorString(Color c) {
        return c.getRed() + "," + c.getGreen() + "," + c.getBlue();
    }

    @Override
    public String getCommand(String id) {
        System.out.println("Client Size: " + clients.size());
        int i = clients.indexOf(id);
        if (i == -1) {
            return null;
        }

        String cmd = "";

        if (settingsUpdatePending.contains(id)) {
            cmd += commonCmd;
            settingsUpdatePending.remove(id);
        }

        cmd += "pos#" + x + ":";
        cmd += "clientID#" + clients.indexOf(id) + ":";
        System.out.println("Command: " + cmd);
        return cmd;
    }

    @Override
    public void commandRecieved(String id, String command) {
        if (clients.indexOf(id) == clients.size() - 1) //If last Client
        {
            String[] cmdSegment = command.split("#");
            switch (cmdSegment[0]) {
                case "resX":
                    lastClientWidth = Integer.parseInt(cmdSegment[1]);
                    break;
            }
        }
    }

    @Override
    public void end() {
//        window.setVisible(false);
//        window.dispose();
    }

    @Override
    public String getServerName() {
        return APPNAME;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == window.messageField) {
//            message = window.messageField.getText();
//        } else if (e.getSource() == window.textcolorButton) {
//            Color newColor = JColorChooser.showDialog(new JFrame(), "Text Color", textColor);
//            if (newColor != null) {
//                textColor = newColor;
//            }
//        } else if (e.getSource() == window.bgcolorButton) {
//            Color newColor = JColorChooser.showDialog(new JFrame(), "Background Color", bgColor);
//            if (newColor != null) {
//                bgColor = newColor;
//            }
//        }
//
//        updateCommonCommand();
    }
}
