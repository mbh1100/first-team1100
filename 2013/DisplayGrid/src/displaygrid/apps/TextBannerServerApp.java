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
import java.util.HashMap;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Akshay
 */
public class TextBannerServerApp extends ServerApp implements ActionListener {
    
    private final String DEFAULT_MESSAGE = "Go Team 1100!";
    private final Color DEFAULT_BGCOLOR = new Color(150,0,0);
    private final Color DEFAULT_TEXTCOLOR = new Color(255, 255, 255);
    
    private final float MIN_X = 0.0f;
    private final float MIN_Y = 0.0f;
    private final float MAX_X = 1.0f;
    private final float MAX_y = 1.0f;
    
    static final String APPNAME = "Text Banner";
    
    TextBannerServerFrame window;
    Graphics2D g;
    
    Font font;
    Font panelFont;
    
    private ArrayList<String> settingsUpdatePending;
    private HashMap<String, String> relativePositions;
    private boolean wrapText = false;
    
    private String commonCmd;
    
    private String message = DEFAULT_MESSAGE;
    
    private Color bgColor = DEFAULT_BGCOLOR;
    private Color textColor = DEFAULT_TEXTCOLOR;
    
    private float x,y;

    @Override
    public void init() {
        window = new TextBannerServerFrame();
        window.setTitle(this.toString());
        window.bgcolorButton.addActionListener(this);
        window.textcolorButton.addActionListener(this);
        window.messageField.addActionListener(this);
        g = (Graphics2D)window.panel.getGraphics();
        window.setVisible(true);
        
        relativePositions = new HashMap<>();
        for(String c:clients){
            relativePositions.put(c, "++");
        }
        
        font = new Font(Font.MONOSPACED, Font.PLAIN, 50);
        panelFont = new Font(Font.MONOSPACED, Font.PLAIN, window.panel.getHeight()/2);
        g.setFont(panelFont);
        
        settingsUpdatePending = new ArrayList();
        bgColor = new Color(150, 0, 0);
        textColor = new Color(255, 255, 255);
        x = 0f;
        y = 0f;
        updateCommonCommand();
    }

    @Override
    public void update() {
        x -= 0.01;
        if(x < -1.0f){
            x = 1.0f;
        }
        
        //left side of text is off display to the left
        if(relativePositions.get(clients.get(0)).charAt(0) == '-'){
            wrapText = true;
        }
        
        g.setColor(bgColor);
        g.fillRect(0, 0, window.panel.getWidth(), window.panel.getHeight());
        g.setColor(textColor);
        int panelHeight = window.panel.getHeight();
        Rectangle2D text = g.getFontMetrics().getStringBounds(message, g);
        int tx = (int)(x * window.panel.getWidth());
        int cy =  panelHeight - (int)(panelHeight-text.getHeight())/2 - panelHeight/5;
        g.drawString(message, tx, cy);
    }
    
    public String getColorString(Color c){
        return c.getRed()+","+c.getGreen()+","+c.getBlue();
    }
    
    public void updateCommonCommand(){        
        commonCmd = "";
        commonCmd += "msg#"+message+":";
        commonCmd += "bg#"+getColorString(bgColor)+":";
        commonCmd += "txt#"+getColorString(textColor)+":";        
        for(String c:clients){
            settingsUpdatePending.add(c);
        }
    }
    
    /**
     * Command Structure:
     * command send changed variables, split by ":"
     * vars: msg(string to display), bg(background color), txt(text color), pos(position, float relative to client)
     * each subcommand is formatted var# values
     * example:
     * msg|"go team1100!": bgcolor|255| 255| 255:txtcolor|163|0|255:pos|.63|.23
     * command will contain any combinations of commands in any order
     * @param id
     * @return 
     */
    @Override
    public String getCommand(String id) {          
        int i = clients.indexOf(id);
        if(i == -1) {
            return null;
        }        
        String cmd = "";
        if(settingsUpdatePending.contains(id)){
            cmd += commonCmd;
            settingsUpdatePending.remove(id);
        }        
        float windowSize = MAX_X/clients.size();
        float minx = i*windowSize;
        float maxx = (i+1)*windowSize;
        float relativeX = (x-minx)/(maxx-minx);        
        cmd += "pos#"+relativeX+","+y;
        return cmd;    
    }

    @Override
    public void commandRecieved(String id, String command) {
        if(clients.contains(id)){
            relativePositions.put(id, command);
        }
    }

    @Override
    public void end() {
        window.setVisible(false);
        window.dispose();
    }

    @Override
    public String getServerName() {
        return APPNAME;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == window.messageField){
            message = window.messageField.getText();
        }else if (e.getSource() == window.textcolorButton){
            Color newColor = JColorChooser.showDialog(new JFrame(), "Text Color", textColor);
            if(newColor != null){
                textColor = newColor;
            }
        }else if (e.getSource() == window.bgcolorButton){
            Color newColor = JColorChooser.showDialog(new JFrame(), "Background Color", bgColor);
            if(newColor != null){
                bgColor = newColor;
            }            
        }
        updateCommonCommand();
    }
    
}
