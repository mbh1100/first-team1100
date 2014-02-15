/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.input;

import edu.arhs.team1100.aerialassist.handlers.TeamEventMatchHandler;
import java.awt.Component;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Eddie
 */
public class TeamEventMatchInput extends javax.swing.JFrame {

    boolean inputData = false;

    public TeamEventMatchInput() {
        initComponents();
    }

    public int getAssists() {
        return (Integer) assistsSpinner.getValue();
    }

    public boolean canAutoBallHigh() {
        return autoBallHighCheckBox.isSelected();
    }

    public boolean canAutoBallLow() {
        return autoBallLowCheckBox.isSelected();
    }

    public String getBallShielding() {
        return ballShiledingTextArea.getText();
    }

    public boolean canCatch() {
        return catchesCheckBox.isSelected();
    }

    public String getComments() {
        return commentsTextArea.getText();
    }

    public int getCycles() {
        return (Integer) cyclesSpinner.getValue();
    }

    public int getDefensive() {
        return defensiveSlider.getValue();
    }

    public int getFloorPickup() {
        return floorPickupSlider.getValue();
    }

    public int getHighGoalsAttempted() {
        return (Integer) highGoalsAttemptedSpinner.getValue();
    }

    public int getHighGoalsScored() {
        return (Integer) highGoalsScoredSpinner.getValue();
    }

    public int getLowGoalsAttempted() {
        return (Integer) lowGoalsAttemptedSpinner.getValue();
    }

    public int getLowGoalsScored() {
        return (Integer) lowGoalsScoredSpinner.getValue();
    }

    public int getMatchNumber() {
        return (Integer) matchNumberSpinner.getValue();
    }

    public int getPasses() {
        return (Integer) passesSpinner.getValue();
    }

    public boolean canPreloadBall() {
        return preloadBallCheckBox.isSelected();
    }

    public int getRegularFouls() {
        return (Integer) regularFoulsSpinner.getValue();
    }

    public String getScouter() {
        return scouterTextField.getText();
    }

    public String getStability() {
        return stabilityTextArea.getText();
    }

    public int getStartingPosition() {
        return startingPositionSlider.getValue();
    }

    public int getTeamNumber() {
        return (Integer) teamNumberSpinner.getValue();
    }

    public int getTechFouls() {
        return (Integer) techFoulsSpinner.getValue();
    }

    public boolean canTrussCatch() {
        return trussCatchCheckBox.isSelected();
    }

    public boolean canTrussToss() {
        return trussTossCheckBox.isSelected();
    }

    public boolean isUnableToUnloadAutoBall() {
        return unableToUnloadAutoBallCheckBox.isSelected();
    }

    public boolean getZoneChange() {
        return zoneChangeCheckBox.isSelected();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matcnNumberLabel = new javax.swing.JLabel();
        matchNumberSpinner = new javax.swing.JSpinner();
        teamNumberLabel = new javax.swing.JLabel();
        teamNumberSpinner = new javax.swing.JSpinner();
        scouterLabel = new javax.swing.JLabel();
        scouterTextField = new javax.swing.JTextField();
        startingPositionLabel = new javax.swing.JLabel();
        startingPositionSlider = new javax.swing.JSlider();
        preloadBallCheckBox = new javax.swing.JCheckBox();
        zoneChangeCheckBox = new javax.swing.JCheckBox();
        autoBallLowCheckBox = new javax.swing.JCheckBox();
        autoBallHighCheckBox = new javax.swing.JCheckBox();
        unableToUnloadAutoBallCheckBox = new javax.swing.JCheckBox();
        trussTossCheckBox = new javax.swing.JCheckBox();
        trussCatchCheckBox = new javax.swing.JCheckBox();
        catchesCheckBox = new javax.swing.JCheckBox();
        passesLabel = new javax.swing.JLabel();
        assistLabel = new javax.swing.JLabel();
        highGoalsScoredLabel = new javax.swing.JLabel();
        highGoalsAttemptedLabel = new javax.swing.JLabel();
        lowGoalsScoredLabel = new javax.swing.JLabel();
        lowGoalsAttemptedLabel = new javax.swing.JLabel();
        scoringCyclesLabel = new javax.swing.JLabel();
        regularFoulsLabel = new javax.swing.JLabel();
        techFoulsLabel = new javax.swing.JLabel();
        passesSpinner = new javax.swing.JSpinner();
        assistsSpinner = new javax.swing.JSpinner();
        highGoalsScoredSpinner = new javax.swing.JSpinner();
        highGoalsAttemptedSpinner = new javax.swing.JSpinner();
        lowGoalsScoredSpinner = new javax.swing.JSpinner();
        lowGoalsAttemptedSpinner = new javax.swing.JSpinner();
        cyclesSpinner = new javax.swing.JSpinner();
        regularFoulsSpinner = new javax.swing.JSpinner();
        techFoulsSpinner = new javax.swing.JSpinner();
        floorPickupSlider = new javax.swing.JSlider();
        floorPickupLabel = new javax.swing.JLabel();
        defensiveLabel = new javax.swing.JLabel();
        defensiveSlider = new javax.swing.JSlider();
        stabilitiyLabel = new javax.swing.JLabel();
        stabilityScrollPane = new javax.swing.JScrollPane();
        stabilityTextArea = new javax.swing.JTextArea();
        ballShieldingLabel = new javax.swing.JLabel();
        ballShieldingScrollPane = new javax.swing.JScrollPane();
        ballShiledingTextArea = new javax.swing.JTextArea();
        commentsLabel = new javax.swing.JLabel();
        commentsScrollPane = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Match Input");

        matcnNumberLabel.setText("Match Numer");

        matchNumberSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1));

        teamNumberLabel.setText("Team Number");

        teamNumberSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));

        scouterLabel.setText("Scouter");

        startingPositionLabel.setText("Starting Position");

        startingPositionSlider.setMaximum(5);
        startingPositionSlider.setMinorTickSpacing(1);
        startingPositionSlider.setPaintLabels(true);
        startingPositionSlider.setPaintTicks(true);
        startingPositionSlider.setSnapToTicks(true);
        startingPositionSlider.setToolTipText("");
        startingPositionSlider.setValue(0);
        startingPositionSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        startingPositionSlider.setName("Starting Position"); // NOI18N
        Dictionary<Integer, Component> labelTablePos = new Hashtable<Integer, Component>();
        labelTablePos.put(0, new JLabel("Red 1"));
        labelTablePos.put(1, new JLabel("Red 2"));
        labelTablePos.put(2, new JLabel("Red 3"));
        labelTablePos.put(3, new JLabel("Blue 1"));
        labelTablePos.put(4, new JLabel("Blue 2"));
        labelTablePos.put(5, new JLabel("Blue 3"));
        startingPositionSlider.setLabelTable(labelTablePos);

        preloadBallCheckBox.setText("Preloads Ball");

        zoneChangeCheckBox.setText("Zone Change Bonus");

        autoBallLowCheckBox.setText("Auto Ball Low");

        autoBallHighCheckBox.setText("Auto Ball High");

        unableToUnloadAutoBallCheckBox.setText("Unalbe to Unload Auto Ball");

        trussTossCheckBox.setText("Truss Toss");

        trussCatchCheckBox.setText("Truss Catch");

        catchesCheckBox.setText("Catches Ball In Air");
        catchesCheckBox.setToolTipText("");

        passesLabel.setText("Passes in Tele-op");

        assistLabel.setText("Assists");

        highGoalsScoredLabel.setText("High Goals Scored");

        highGoalsAttemptedLabel.setText("High Goals Attempted");

        lowGoalsScoredLabel.setText("Low Goals Scored");

        lowGoalsAttemptedLabel.setText("Low Goals Attempted");

        scoringCyclesLabel.setText("Scoring Cycles Completed");

        regularFoulsLabel.setText("Regualr Fouls");

        techFoulsLabel.setText("Tech Fouls");

        passesSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        assistsSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        highGoalsScoredSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        highGoalsAttemptedSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        lowGoalsScoredSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        lowGoalsAttemptedSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        cyclesSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        regularFoulsSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        techFoulsSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        floorPickupSlider.setMajorTickSpacing(1);
        floorPickupSlider.setMaximum(5);
        floorPickupSlider.setMinorTickSpacing(1);
        floorPickupSlider.setPaintLabels(true);
        floorPickupSlider.setPaintTicks(true);
        floorPickupSlider.setSnapToTicks(true);
        floorPickupSlider.setValue(0);
        Dictionary<Integer, Component> labelTableFloor = new Hashtable<Integer, Component>();
        labelTableFloor.put(0, new JLabel("None"));
        labelTableFloor.put(1, new JLabel("1"));
        labelTableFloor.put(2, new JLabel("2"));
        labelTableFloor.put(3, new JLabel("3"));
        labelTableFloor.put(4, new JLabel("4"));
        labelTableFloor.put(5, new JLabel("5"));
        floorPickupSlider.setLabelTable(labelTableFloor);

        floorPickupLabel.setText("Floor Pickup Ability/Speed");

        defensiveLabel.setText("Defensive Capabilities");

        defensiveSlider.setMajorTickSpacing(1);
        defensiveSlider.setMaximum(5);
        defensiveSlider.setMinimum(1);
        defensiveSlider.setMinorTickSpacing(1);
        defensiveSlider.setPaintLabels(true);
        defensiveSlider.setPaintTicks(true);
        defensiveSlider.setSnapToTicks(true);
        defensiveSlider.setValue(1);

        stabilitiyLabel.setText("Speed and Stability of Robot");

        stabilityTextArea.setColumns(20);
        stabilityTextArea.setRows(5);
        stabilityScrollPane.setViewportView(stabilityTextArea);

        ballShieldingLabel.setText("Can they shield against opposing balls?");

        ballShiledingTextArea.setColumns(20);
        ballShiledingTextArea.setRows(5);
        ballShieldingScrollPane.setViewportView(ballShiledingTextArea);

        commentsLabel.setText("Comments");

        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        commentsScrollPane.setViewportView(commentsTextArea);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(preloadBallCheckBox)
                            .addComponent(catchesCheckBox)
                            .addComponent(trussCatchCheckBox)
                            .addComponent(trussTossCheckBox)
                            .addComponent(unableToUnloadAutoBallCheckBox)
                            .addComponent(autoBallHighCheckBox)
                            .addComponent(autoBallLowCheckBox)
                            .addComponent(zoneChangeCheckBox)
                            .addComponent(floorPickupLabel)
                            .addComponent(floorPickupSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stabilitiyLabel)
                            .addComponent(stabilityScrollPane))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passesLabel)
                                    .addComponent(assistLabel)
                                    .addComponent(highGoalsScoredLabel)
                                    .addComponent(highGoalsAttemptedLabel)
                                    .addComponent(lowGoalsScoredLabel)
                                    .addComponent(lowGoalsAttemptedLabel)
                                    .addComponent(scoringCyclesLabel)
                                    .addComponent(regularFoulsLabel)
                                    .addComponent(techFoulsLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assistsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(highGoalsScoredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(highGoalsAttemptedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lowGoalsScoredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lowGoalsAttemptedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cyclesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(regularFoulsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(techFoulsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(defensiveLabel)
                                    .addComponent(defensiveSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ballShieldingLabel)
                                    .addComponent(ballShieldingScrollPane))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commentsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startingPositionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startingPositionSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(matcnNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(matchNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(teamNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scouterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scouterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(commentsScrollPane)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(submitButton)
                                    .addComponent(cancelButton))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matcnNumberLabel)
                    .addComponent(matchNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamNumberLabel)
                    .addComponent(teamNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scouterLabel)
                    .addComponent(scouterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startingPositionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(startingPositionLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preloadBallCheckBox)
                    .addComponent(passesLabel)
                    .addComponent(passesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zoneChangeCheckBox)
                    .addComponent(assistLabel)
                    .addComponent(assistsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoBallLowCheckBox)
                    .addComponent(highGoalsScoredLabel)
                    .addComponent(highGoalsScoredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoBallHighCheckBox)
                    .addComponent(highGoalsAttemptedLabel)
                    .addComponent(highGoalsAttemptedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unableToUnloadAutoBallCheckBox)
                    .addComponent(lowGoalsScoredLabel)
                    .addComponent(lowGoalsScoredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trussTossCheckBox)
                    .addComponent(lowGoalsAttemptedLabel)
                    .addComponent(lowGoalsAttemptedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trussCatchCheckBox)
                    .addComponent(scoringCyclesLabel)
                    .addComponent(cyclesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catchesCheckBox)
                    .addComponent(regularFoulsLabel)
                    .addComponent(regularFoulsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(techFoulsLabel)
                    .addComponent(techFoulsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defensiveLabel)
                    .addComponent(floorPickupLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(floorPickupSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defensiveSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stabilitiyLabel)
                    .addComponent(ballShieldingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stabilityScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ballShieldingScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(commentsLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        if (!new TeamEventMatchHandler(this).addTeam()) {
            JOptionPane.showMessageDialog(this,
                    "A match with this team number and event has already been entered \nor could not find team with specified number.",
                    "Error",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            dispose();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assistLabel;
    private javax.swing.JSpinner assistsSpinner;
    private javax.swing.JCheckBox autoBallHighCheckBox;
    private javax.swing.JCheckBox autoBallLowCheckBox;
    private javax.swing.JLabel ballShieldingLabel;
    private javax.swing.JScrollPane ballShieldingScrollPane;
    private javax.swing.JTextArea ballShiledingTextArea;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox catchesCheckBox;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JScrollPane commentsScrollPane;
    private javax.swing.JTextArea commentsTextArea;
    private javax.swing.JSpinner cyclesSpinner;
    private javax.swing.JLabel defensiveLabel;
    private javax.swing.JSlider defensiveSlider;
    private javax.swing.JLabel floorPickupLabel;
    private javax.swing.JSlider floorPickupSlider;
    private javax.swing.JLabel highGoalsAttemptedLabel;
    private javax.swing.JSpinner highGoalsAttemptedSpinner;
    private javax.swing.JLabel highGoalsScoredLabel;
    private javax.swing.JSpinner highGoalsScoredSpinner;
    private javax.swing.JLabel lowGoalsAttemptedLabel;
    private javax.swing.JSpinner lowGoalsAttemptedSpinner;
    private javax.swing.JLabel lowGoalsScoredLabel;
    private javax.swing.JSpinner lowGoalsScoredSpinner;
    private javax.swing.JSpinner matchNumberSpinner;
    private javax.swing.JLabel matcnNumberLabel;
    private javax.swing.JLabel passesLabel;
    private javax.swing.JSpinner passesSpinner;
    private javax.swing.JCheckBox preloadBallCheckBox;
    private javax.swing.JLabel regularFoulsLabel;
    private javax.swing.JSpinner regularFoulsSpinner;
    private javax.swing.JLabel scoringCyclesLabel;
    private javax.swing.JLabel scouterLabel;
    private javax.swing.JTextField scouterTextField;
    private javax.swing.JLabel stabilitiyLabel;
    private javax.swing.JScrollPane stabilityScrollPane;
    private javax.swing.JTextArea stabilityTextArea;
    private javax.swing.JLabel startingPositionLabel;
    private javax.swing.JSlider startingPositionSlider;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel teamNumberLabel;
    private javax.swing.JSpinner teamNumberSpinner;
    private javax.swing.JLabel techFoulsLabel;
    private javax.swing.JSpinner techFoulsSpinner;
    private javax.swing.JCheckBox trussCatchCheckBox;
    private javax.swing.JCheckBox trussTossCheckBox;
    private javax.swing.JCheckBox unableToUnloadAutoBallCheckBox;
    private javax.swing.JCheckBox zoneChangeCheckBox;
    // End of variables declaration//GEN-END:variables

    public boolean getInputData() {
        return inputData;
    }

}
