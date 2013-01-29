/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.apps;

import displaygrid.ServerApp;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Akshay
 */
public class TextBannerServerApp extends ServerApp implements ActionListener, ChangeListener {

    static final String APPNAME = "Text Banner";
    
    private String commonCmd;
    private ArrayList<String> commonCommandPending;
    
    private String message = "Go Team1100!";
    private Color bgColor;
    private Color textColor;
    
    private float x;
    private float speed = 0.01f;
    
    private TextBannerServerFrame frame;

    @Override
    public void init() {
        bgColor = new Color(150, 0, 0);
        textColor = new Color(255, 255, 255);        
        x = clients.size();
        
        commonCmd = "";
        commonCommandPending = new ArrayList<>();

        frame = new TextBannerServerFrame();
        frame.setPanelDisplay(message, bgColor, textColor);
        frame.bgcolorButton.addActionListener(this);
        frame.textcolorButton.addActionListener(this);
        frame.messageField.addActionListener(this);
        frame.speedSlider.addChangeListener(this);
        frame.setTitle(this.toString());
        
        updateCommonCommand();
    }

    @Override
    public void update() {        
        x -= speed;
        if(x < 0){
            x = 1;
            clients.add(0, clients.remove(clients.size()-1)); //moves client at back to front            
        }
        
        frame.repaint();
    }

    public void updateCommonCommand() {
        frame.setPanelDisplay(message, bgColor, textColor);
        commonCmd = "";
        commonCmd += "msg#" + message + ":";
        commonCmd += "bg#" + getColorString(bgColor) + ":";
        commonCmd += "txt#" + getColorString(textColor) + ":";
        commonCmd += "dx#" + speed/clients.size() + ":";

        for (String c : clients) {
            commonCommandPending.add(c);
        }
    }
    


    public String getColorString(Color c) {
        return c.getRed() + "," + c.getGreen() + "," + c.getBlue();
    }

    @Override
    public String getCommand(String id) {

        int i = clients.indexOf(id);
        if (i == -1) {
            return null;
        }
        
        String cmd = "";
        if (commonCommandPending.contains(id)) {
            commonCommandPending.remove(id);
            cmd += commonCmd;
        }
        
        float pos = x-i;

        cmd += "pos#" + pos+":";
        return cmd;
    }

    @Override
    public  void commandRecieved(String id, String command) {}

    @Override
    public void end() {
        frame.setVisible(false);
    }

    @Override
    public String getServerName() {
        return APPNAME;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.messageField) {
            message = frame.messageField.getText();
        } else if (e.getSource() == frame.textcolorButton) {
            Color newColor = JColorChooser.showDialog(new JFrame(), "Text Color", textColor);
            if (newColor != null) {
                textColor = newColor;
            }
        } else if (e.getSource() == frame.bgcolorButton) {
            Color newColor = JColorChooser.showDialog(new JFrame(), "Background Color", bgColor);
            if (newColor != null) {
                bgColor = newColor;
            }
        }
        updateCommonCommand();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == frame.speedSlider){
            speed = frame.speedSlider.getValue()/1000f;
        }
        updateCommonCommand();
    }
}