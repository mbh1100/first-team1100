package displaygrid.apps;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TextBannerServerFrame extends javax.swing.JFrame {

    public TextBannerServerFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        initComponents();
        font = new Font(Font.MONOSPACED, Font.BOLD, panel.getHeight() / 2);
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new JPanel(){
            public void paint(Graphics g){
                paintPanel(g);
            }
        };
        bgcolorButton = new javax.swing.JButton();
        textcolorButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        speedSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        openButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageList = new javax.swing.JList();
        messageField = new javax.swing.JTextField();
        messageTextcolorButton = new javax.swing.JButton();
        messageBgcolorButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        bgcolorButton.setText("Background");
        bgcolorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgcolorButtonActionPerformed(evt);
            }
        });

        textcolorButton.setText("Text");

        jLabel1.setText("Messages:");

        jLabel2.setText("Default Color:");

        speedSlider.setMaximum(50);
        speedSlider.setValue(10);

        jLabel3.setText("Speed:");

        jLabel4.setText("Time:");

        timeField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel5.setText("seconds");

        openButton.setText("Open...");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");

        saveButton.setText("Save...");

        messageList.setModel(new DefaultListModel());
        messageList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        messageList.setCellRenderer(new ColorListCellRenderer());
        messageList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(messageList);

        messageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageFieldActionPerformed(evt);
            }
        });

        messageTextcolorButton.setText("Text");
        messageTextcolorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageTextcolorButtonActionPerformed(evt);
            }
        });

        messageBgcolorButton.setText("Background");
        messageBgcolorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageBgcolorButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Color:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textcolorButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bgcolorButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))))
                        .addGap(405, 405, 405))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(speedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(openButton)
                                    .addComponent(saveButton)
                                    .addComponent(updateButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(6, 6, 6)
                                        .addComponent(messageTextcolorButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(messageBgcolorButton))
                                    .addComponent(addButton))
                                .addGap(0, 131, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageTextcolorButton)
                            .addComponent(messageBgcolorButton)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)
                        .addGap(41, 41, 41)
                        .addComponent(updateButton))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textcolorButton)
                    .addComponent(bgcolorButton)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgcolorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgcolorButtonActionPerformed
    }//GEN-LAST:event_bgcolorButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
    }//GEN-LAST:event_openButtonActionPerformed

    private void messageBgcolorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageBgcolorButtonActionPerformed
        try {
            Message sel = (Message) messageList.getSelectedValue();
            sel.bgColor = JColorChooser.showDialog(new JFrame(), "Background Color", sel.bgColor);
            repaint();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_messageBgcolorButtonActionPerformed

    private void messageListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_messageListMouseClicked

    private void messageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageFieldActionPerformed
        try {
            ((Message) messageList.getSelectedValue()).text = messageField.getText();
            repaint();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_messageFieldActionPerformed

    private void messageTextcolorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageTextcolorButtonActionPerformed
        try {
            Message sel = (Message) messageList.getSelectedValue();
            sel.textColor = JColorChooser.showDialog(new JFrame(), "Text Color", sel.textColor);
            repaint();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_messageTextcolorButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String text = "New Message";
        Color bgColor = bgcolorButton.getBackground();
        Color txtColor = textcolorButton.getBackground();

        DefaultListModel model = ((DefaultListModel) messageList.getModel());
        model.addElement(new Message(text, txtColor, bgColor));
        repaint();
    }//GEN-LAST:event_addButtonActionPerformed

    public void paintPanel(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        g.setColor(textColor);
        g.setFont(font);
        Rectangle target = new Rectangle(0, 0, panel.getWidth(), panel.getHeight());
        Rectangle2D text = g.getFontMetrics().getStringBounds(message, g);

        int tx = (int) ((target.width - text.getWidth()) / 2);
        int cy = (target.height) - (int) (target.height - text.getHeight()) / 2 - target.height / 5;
        g.drawString(message, tx, cy);
    }

    public void setPanelDisplay(String m, Color text, Color bg) {
        message = m;
        font = scaleFont(message, panel.getBounds(), panel.getGraphics(), font);
        bgColor = bg;
        textColor = text;
    }

    public Font scaleFont(String text, Rectangle rect, Graphics g, Font pFont) {
        float fontSize = 2.0f;
        Font f = g.getFont().deriveFont(1);
        while (g.getFontMetrics(f).stringWidth(text) < rect.width && g.getFontMetrics(f).getHeight() < rect.getHeight()) {
            fontSize++;
            f = f.deriveFont(fontSize - 1);
        }
        return f.deriveFont(fontSize - 1);
    }

    public void setMessages(ArrayList<Message> msgs) {
        DefaultListModel newModel = new DefaultListModel();
        for (Message m : msgs) {
            newModel.addElement(m);
        }
        messageList.setModel(newModel);
    }

    public ArrayList<Message> getMessages() {
        Object[] items = ((DefaultListModel) messageList.getModel()).toArray();
        ArrayList<Message> msgs = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            msgs.add((Message) items[i]);
        }
        return msgs;
    }

    public void listSelected() {
        Message m = (Message) messageList.getSelectedValue();
        if(m.text != null){
        messageField.setText(m.text);
        } else {
            messageField.setText("");
        }
        messageTextcolorButton.setBackground(m.textColor);
        if (m.textColor != null) {
            messageTextcolorButton.setForeground(new Color(~m.textColor.getRGB()));
        } else {
            messageTextcolorButton.setForeground(null);
        }
        messageBgcolorButton.setBackground(m.bgColor);
        if (m.bgColor != null) {
            messageBgcolorButton.setForeground(new Color(~m.bgColor.getRGB()));
        } else {
            messageBgcolorButton.setForeground(null);
        }
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextBannerServerFrame().setVisible(true);
            }
        });
    }
    private String message = "";
    private Font font;
    private Color bgColor;
    private Color textColor;
    public boolean useFile = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    public javax.swing.JButton bgcolorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton messageBgcolorButton;
    private javax.swing.JTextField messageField;
    public javax.swing.JList messageList;
    private javax.swing.JButton messageTextcolorButton;
    public javax.swing.JButton openButton;
    public javax.swing.JPanel panel;
    public javax.swing.JButton saveButton;
    public javax.swing.JSlider speedSlider;
    public javax.swing.JButton textcolorButton;
    public javax.swing.JFormattedTextField timeField;
    public javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}

class ColorListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value != null && value instanceof Message) {
            setBackground(((Message) value).bgColor);
            setForeground(((Message) value).textColor);
        }
        return this;
    }
}