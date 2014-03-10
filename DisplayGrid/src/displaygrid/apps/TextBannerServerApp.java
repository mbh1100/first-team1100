package displaygrid.apps;

import displaygrid.ServerApp;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Akshay
 */
public class TextBannerServerApp extends ServerApp implements ActionListener, ChangeListener {

    static final String APPNAME = "Text Banner";
    static final String SPLIT_BRACKET = "[\\[\\]]+";
    static final String DEFAULT_MESSAGE = "Go Team1100!";
    private final String HEX = "0123456789abcdef";
    private String commonCmd;
    private ArrayList<String> commonCommandPending;
    private ArrayList<TextBannerMessage> messages;
    private int messageIndex = 0;
    private long time = 10000;
    private long lastSwitchTime = 0;
    private Color bgColor;
    private Color textColor;
    private float x;
    private float speed = 0.01f;
    private TextBannerServerPanel panel;

    @Override
    public void init() {
        bgColor = new Color(150, 0, 0);
        textColor = new Color(255, 255, 255);
        x = clients.size();

        messages = new ArrayList<>();
        messages.add(new TextBannerMessage(DEFAULT_MESSAGE, null, null));
        messageIndex = 0;

        commonCmd = "";
        commonCommandPending = new ArrayList<>();

        panel = new TextBannerServerPanel();        
        setTabPanel(panel);
        panel.setPanelDisplay(DEFAULT_MESSAGE, textColor, bgColor);
        panel.setMessages(messages);
        panel.messageList.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                panel.listSelected();
            }
        });

        panel.bgcolorButton.addActionListener(this);
        panel.bgcolorButton.setBackground(bgColor);
        panel.bgcolorButton.setForeground(new Color(~bgColor.getRGB()));

        panel.textcolorButton.addActionListener(this);
        panel.textcolorButton.setBackground(textColor);        
        panel.textcolorButton.setForeground(new Color(~textColor.getRGB()));

        panel.timeField.addActionListener(this);
        panel.speedSlider.addChangeListener(this);
        panel.updateButton.addActionListener(this);

        panel.openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        panel.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        
        
        updateCommonCommand();
    }

    @Override
    public void update() {
        x -= speed;
        //#
        if (x < 0) {
            x = 1;
            clients.add(0, clients.remove(clients.size() - 1)); //moves client at back to front            
        }
        /*if(x < -clients.size()){
            x = 0;
        }*/

        long curTime = System.currentTimeMillis();
        if (curTime - lastSwitchTime > time) {
            lastSwitchTime = curTime;
            messageIndex++;
            if (messageIndex == messages.size()) {
                messageIndex = 0;
            }
            updateCommonCommand();
        }
        panel.repaint();
    }

    public void updateCommonCommand() {
        TextBannerMessage m = messages.get(messageIndex);
        Color tmpText = (m.textColor == null) ? textColor : m.textColor;
        Color tmpBg = (m.bgColor == null) ? bgColor : m.bgColor;
        panel.setPanelDisplay(m.text, tmpText, tmpBg);
        commonCmd = "";
        commonCmd += "msg#" + m.text + ":";
        commonCmd += "bg#" + getColorString(tmpBg) + ":";
        commonCmd += "txt#" + getColorString(tmpText) + ":";
        commonCmd += "dx#" + speed / clients.size() + ":";

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

        float pos = x - i;

        cmd += "pos#" + pos + ":";
        return cmd;
    }

    @Override
    public void commandRecieved(String id, String command) {
    }

    @Override
    public void end() {
        panel.setVisible(false);
    }

    @Override
    public String getServerName() {
        return APPNAME;
    }

    public void openFile() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fc.showOpenDialog(new JFrame());
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File f = fc.getSelectedFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            messages = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(SPLIT_BRACKET);
                String msg = tokens[0];
                Color fg = null;
                Color bg = null;
                if (tokens.length > 1) {
                    String[] colorStr = tokens[1].split(":");
                    if (colorStr.length >= 2) {
                        fg = new Color(HEXToRGB(colorStr[0]));
                        bg = new Color(HEXToRGB(colorStr[1]));
                    }

                }
                messages.add(new TextBannerMessage(msg, fg, bg));
            }
            reader.close();
            panel.setMessages(messages);
            messageIndex = 0;            
            lastSwitchTime = System.currentTimeMillis();
            updateCommonCommand();
        } catch (Exception e) {
        }
    }

    public void saveFile() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fc.showSaveDialog(new JFrame());
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File f = fc.getSelectedFile();
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            ArrayList<TextBannerMessage> msgs = panel.getMessages();
            for (TextBannerMessage m : msgs) {
                writer.write(m.getSaveString() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.textcolorButton) {
            Color newColor = JColorChooser.showDialog(new JFrame(), "Text Color", textColor);
            if (newColor != null) {
                textColor = newColor;
            }

            panel.textcolorButton.setBackground(textColor);
            panel.textcolorButton.setForeground(new Color(~textColor.getRGB()));
        } else if (e.getSource() == panel.bgcolorButton) {
            Color newColor = JColorChooser.showDialog(new JFrame(), "Background Color", bgColor);
            if (newColor != null) {
                bgColor = newColor;
            }

            panel.bgcolorButton.setBackground(bgColor);
            panel.bgcolorButton.setForeground(new Color(~bgColor.getRGB()));

        } else if (e.getSource() == panel.timeField) {
            time = (Long) panel.timeField.getValue() * 1000;

        } else if(e.getSource() == panel.updateButton){
            messageIndex = 0;
            messages = panel.getMessages();
            lastSwitchTime = System.currentTimeMillis();
        }

        updateCommonCommand();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == panel.speedSlider) {
            speed = panel.speedSlider.getValue() / 1000f;
        }
        updateCommonCommand();
    }

    private int HEXToRGB(String hex) {
        hex = hex.toLowerCase();
        int rgb = 0;
        for (int i = 1; i <= hex.length(); i++) {
            rgb += Math.pow(16, hex.length() - i) * HEX.indexOf(hex.charAt(i - 1) + "");
        }
        return rgb;
    }
}

class TextBannerMessage {

    public String text = "";
    public Color textColor = null;
    public Color bgColor = null;

    public TextBannerMessage(String t, Color tc, Color bg) {
        text = t;
        textColor = tc;
        bgColor = bg;
    }

    @Override
    public String toString() {
        return text;
    }

    private String hexString(Color c) {
        return String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
    }

    public String getSaveString() {
        String sav = text;
        if (textColor != null && bgColor != null) {
            sav += "[" + hexString(textColor) + ":" + hexString(bgColor) + "]";
        }
        return sav;

    }
}