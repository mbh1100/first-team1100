package edu.arhs.team1100.aerialassist.input;

import edu.arhs.team1100.aerialassist.handlers.EventHandler;
import edu.arhs.team1100.aerialassist.handlers.TeamEventMatchHandler;
import edu.arhs.team1100.aerialassist.scouting.objects.TeamEventMatch;
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

    boolean newMatch;
    TeamEventMatch parsedMatch;

    public TeamEventMatchInput() {
        initComponents();
        newMatch = true;
    }

    public TeamEventMatchInput(TeamEventMatch match) {
        initComponents();
        parsedMatch = match;

        setMatchNumber(match.getMatchNumber());
        setTeamNumber(match.getTeamNumber());
        setAssists(match.getAssists());
        setBallShielding(match.getBallShielding());
        setAbleToCatch(match.isAbleToCatch());
        setComments(match.getComments());
        setCycles(match.getCycles());
        setDefensive(match.getDefensive());
        setFloorPickup(match.getFloorPickup());
        setHighGoalsAttempted(match.getHighGoalsAttempted());
        setHighGoalsScored(match.getHighGoalsScored());
        setLowGoalsAttempted(match.getLowGoalsAttempted());
        setLowGoalsScored(match.getLowGoalsScored());
        setScouter(match.getScouter());
        setStability(match.getStability());
        setStartingPosition(match.getStartingPosition());
        setAbleToTrussCatch(match.isAbleToTrussCatch());
        setAbleToTrussToss(match.isAbleToTrussToss());
        setAbleToUnloadAutoBall(match.isAbleToUnloadAutoBall());
        setZoneChange(match.isZoneChange());
        setAutoBallCount(match.getAutoBallCount());
        setAutoBallGoal(match.getAutoBallGoal());
        setBallsCaughtFromHP(match.getBallsCaughtFromHP());
        setAttemptedCatchesFromHP(match.getAttemptedCatchesFromHP());

        newMatch = false;

        matchNumberSpinner.setEnabled(false);
        teamNumberSpinner.setEnabled(false);

        setTitle("Match " + match.getMatchNumber() + " for Team " + match.getTeamNumber());
    }

    public int getAssists() {
        return (Integer) assistsSpinner.getValue();
    }

    private void setAssists(int assists) {
        assistsSpinner.setValue(assists);
    }

    public int getAutoBallCount() {
        return (Integer) autoBallsSpinner.getValue();
    }

    private void setAutoBallCount(int autoBalls) {
        autoBallsSpinner.setValue(autoBalls);
    }

    public int getAutoBallGoal() {
        return autoBallGoalSlider.getValue();
    }

    private void setAutoBallGoal(int autoBallGoal) {
        autoBallGoalSlider.setValue(autoBallGoal);
    }

    public String getBallShielding() {
        return ballShieldingTextArea.getText();
    }

    private void setBallShielding(String ballShielding) {
        ballShieldingTextArea.setText(ballShielding);
    }

    public boolean isAbleToCatch() {
        return catchesCheckBox.isSelected();
    }

    private void setAbleToCatch(boolean ableToCatch) {
        catchesCheckBox.setSelected(ableToCatch);
    }

    public String getComments() {
        return commentsTextArea.getText();
    }

    private void setComments(String comments) {
        commentsTextArea.setText(comments);
    }

    public int getCycles() {
        return (Integer) cyclesSpinner.getValue();
    }

    private void setCycles(int cycles) {
        cyclesSpinner.setValue(cycles);
    }

    public int getDefensive() {
        return defensiveSlider.getValue();
    }

    private void setDefensive(int defensive) {
        defensiveSlider.setValue(defensive);
    }

    public int getFloorPickup() {
        return floorPickupSlider.getValue();
    }

    private void setFloorPickup(int floorPickup) {
        floorPickupSlider.setValue(floorPickup);
    }

    public int getHighGoalsAttempted() {
        return (Integer) highGoalsAttemptedSpinner.getValue();
    }

    private void setHighGoalsAttempted(int highGoalsAttempted) {
        highGoalsAttemptedSpinner.setValue(highGoalsAttempted);
    }

    public int getHighGoalsScored() {
        return (Integer) highGoalsScoredSpinner.getValue();
    }

    private void setHighGoalsScored(int highGoalsScored) {
        highGoalsScoredSpinner.setValue(highGoalsScored);
    }

    public int getLowGoalsAttempted() {
        return (Integer) lowGoalsAttemptedSpinner.getValue();
    }

    private void setLowGoalsAttempted(int lowGoalsAttempted) {
        lowGoalsAttemptedSpinner.setValue(lowGoalsAttempted);
    }

    public int getLowGoalsScored() {
        return (Integer) lowGoalsScoredSpinner.getValue();
    }

    private void setLowGoalsScored(int lowGoalsScored) {
        lowGoalsScoredSpinner.setValue(lowGoalsScored);
    }

    public int getMatchNumber() {
        return (Integer) matchNumberSpinner.getValue();
    }

    private void setMatchNumber(int matchNumber) {
        matchNumberSpinner.setValue(matchNumber);
    }

    public int getBallsCaughtFromHP() {
        return (Integer) ballsCaughtHPSpinner.getValue();
    }

    private void setBallsCaughtFromHP(int ballsCaughtFromHP) {
        ballsCaughtHPSpinner.setValue(ballsCaughtFromHP);
    }

    public int getAttemptedCatchesFromHP() {
        return (Integer) attemptedBallsHPSpinner.getValue();
    }

    private void setAttemptedCatchesFromHP(int attemptedBallsFromHP) {
        attemptedBallsHPSpinner.setValue(attemptedBallsFromHP);
    }

    public String getScouter() {
        return scouterTextField.getText();
    }

    private void setScouter(String scouter) {
        scouterTextField.setText(scouter);
    }

    public String getStability() {
        return stabilityTextArea.getText();
    }

    private void setStability(String stability) {
        stabilityTextArea.setText(stability);
    }

    public int getStartingPosition() {
        return startingPositionSlider.getValue();
    }

    private void setStartingPosition(int startingPosition) {
        startingPositionSlider.setValue(startingPosition);
    }

    public int getTeamNumber() {
        return (Integer) teamNumberSpinner.getValue();
    }

    private void setTeamNumber(int teamNumber) {
        teamNumberSpinner.setValue(teamNumber);
    }

    public boolean isAbleToTrussCatch() {
        return trussCatchCheckBox.isSelected();
    }

    private void setAbleToTrussCatch(boolean ableToTrussCatch) {
        trussCatchCheckBox.setSelected(ableToTrussCatch);
    }

    public boolean isAbleToTrussToss() {
        return trussTossCheckBox.isSelected();
    }

    private void setAbleToTrussToss(boolean ableToTrussToss) {
        trussTossCheckBox.setSelected(ableToTrussToss);
    }

    public boolean isAbleToUnloadAutoBall() {
        return ableToUnloadAutoBallCheckBox.isSelected();
    }

    private void setAbleToUnloadAutoBall(boolean unableToUnloadAutoBall) {
        ableToUnloadAutoBallCheckBox.setSelected(unableToUnloadAutoBall);
    }

    public boolean getZoneChange() {
        return zoneChangeCheckBox.isSelected();
    }

    private void setZoneChange(boolean zoneChange) {
        zoneChangeCheckBox.setSelected(zoneChange);
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
        zoneChangeCheckBox = new javax.swing.JCheckBox();
        ableToUnloadAutoBallCheckBox = new javax.swing.JCheckBox();
        trussTossCheckBox = new javax.swing.JCheckBox();
        trussCatchCheckBox = new javax.swing.JCheckBox();
        catchesCheckBox = new javax.swing.JCheckBox();
        floorPickupSlider = new javax.swing.JSlider();
        floorPickupLabel = new javax.swing.JLabel();
        defensiveLabel = new javax.swing.JLabel();
        defensiveSlider = new javax.swing.JSlider();
        stabilitiyLabel = new javax.swing.JLabel();
        stabilityScrollPane = new javax.swing.JScrollPane();
        stabilityTextArea = new javax.swing.JTextArea();
        ballShieldingLabel = new javax.swing.JLabel();
        ballShieldingScrollPane = new javax.swing.JScrollPane();
        ballShieldingTextArea = new javax.swing.JTextArea();
        commentsLabel = new javax.swing.JLabel();
        commentsScrollPane = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        autoBallCountLabel = new javax.swing.JLabel();
        autoBallsSpinner = new javax.swing.JSpinner();
        autoBallGoalSlider = new javax.swing.JSlider();
        autoBallGoalLabel = new javax.swing.JLabel();
        spinnersPanel = new javax.swing.JPanel();
        ballsCaughtHPSpinner = new javax.swing.JSpinner();
        ballsCaughtFromHPLabel = new javax.swing.JLabel();
        attemptedCatchesFromHPLabel = new javax.swing.JLabel();
        attemptedBallsHPSpinner = new javax.swing.JSpinner();
        assistsLabel = new javax.swing.JLabel();
        assistsSpinner = new javax.swing.JSpinner();
        highGoalsScoredLabel = new javax.swing.JLabel();
        highGoalsScoredSpinner = new javax.swing.JSpinner();
        highGoalsAttemptedLabel = new javax.swing.JLabel();
        highGoalsAttemptedSpinner = new javax.swing.JSpinner();
        lowGoalsScoredLabel = new javax.swing.JLabel();
        lowGoalsScoredSpinner = new javax.swing.JSpinner();
        lowGoalsAttemptedLabel = new javax.swing.JLabel();
        lowGoalsAttemptedSpinner = new javax.swing.JSpinner();
        cyclesLabel = new javax.swing.JLabel();
        cyclesSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Match Input");
        setResizable(false);

        matcnNumberLabel.setText("Match Numer");

        matchNumberSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1));
        matchNumberSpinner.setNextFocusableComponent(teamNumberSpinner);

        teamNumberLabel.setText("Team Number");

        teamNumberSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
        teamNumberSpinner.setToolTipText("");
        teamNumberSpinner.setNextFocusableComponent(scouterTextField);

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

        zoneChangeCheckBox.setText("Zone Change Bonus");

        ableToUnloadAutoBallCheckBox.setText("Able to Unload Auto Ball");

        trussTossCheckBox.setText("Truss Toss");

        trussCatchCheckBox.setText("Truss Catch");

        catchesCheckBox.setText("Catches Ball In Air");
        catchesCheckBox.setToolTipText("");

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
        defensiveSlider.setMinorTickSpacing(1);
        defensiveSlider.setPaintLabels(true);
        defensiveSlider.setPaintTicks(true);
        defensiveSlider.setSnapToTicks(true);
        defensiveSlider.setValue(0);

        stabilitiyLabel.setText("Speed and Stability of Robot");

        stabilityTextArea.setColumns(20);
        stabilityTextArea.setRows(5);
        stabilityTextArea.setNextFocusableComponent(ballShieldingTextArea);
        stabilityScrollPane.setViewportView(stabilityTextArea);

        ballShieldingLabel.setText("Can they shield against opposing balls?");

        ballShieldingTextArea.setColumns(20);
        ballShieldingTextArea.setRows(5);
        ballShieldingTextArea.setNextFocusableComponent(commentsTextArea);
        ballShieldingScrollPane.setViewportView(ballShieldingTextArea);

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

        autoBallCountLabel.setText("Number of Auto Balls");

        autoBallsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));

        autoBallGoalSlider.setMajorTickSpacing(1);
        autoBallGoalSlider.setMaximum(2);
        autoBallGoalSlider.setMinorTickSpacing(1);
        autoBallGoalSlider.setPaintLabels(true);
        autoBallGoalSlider.setPaintTicks(true);
        autoBallGoalSlider.setSnapToTicks(true);
        autoBallGoalSlider.setValue(0);
        Dictionary<Integer, Component> labelTablePos2 = new Hashtable<Integer, Component>();
        labelTablePos2.put(0, new JLabel("None"));
        labelTablePos2.put(1, new JLabel("Low"));
        labelTablePos2.put(2, new JLabel("High"));
        autoBallGoalSlider.setLabelTable(labelTablePos2);

        autoBallGoalLabel.setText("Auto Ball Goal");

        ballsCaughtHPSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        ballsCaughtFromHPLabel.setText("Balls Caught From HP");

        attemptedCatchesFromHPLabel.setText("Attempts to Catch From HP");

        attemptedBallsHPSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        assistsLabel.setText("Number of Assists");

        assistsSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        highGoalsScoredLabel.setText("High Goals Scored");

        highGoalsScoredSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        highGoalsAttemptedLabel.setText("High Goals Attempted");

        highGoalsAttemptedSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        lowGoalsScoredLabel.setText("Low Goals Scored");

        lowGoalsScoredSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        lowGoalsAttemptedLabel.setText("Low Goals Attempted");

        lowGoalsAttemptedSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        cyclesLabel.setText("Scoring Cycles");

        cyclesSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout spinnersPanelLayout = new javax.swing.GroupLayout(spinnersPanel);
        spinnersPanel.setLayout(spinnersPanelLayout);
        spinnersPanelLayout.setHorizontalGroup(
            spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spinnersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spinnersPanelLayout.createSequentialGroup()
                        .addComponent(ballsCaughtFromHPLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ballsCaughtHPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(spinnersPanelLayout.createSequentialGroup()
                        .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attemptedCatchesFromHPLabel)
                            .addComponent(assistsLabel)
                            .addComponent(highGoalsScoredLabel)
                            .addComponent(highGoalsAttemptedLabel)
                            .addComponent(lowGoalsScoredLabel)
                            .addComponent(lowGoalsAttemptedLabel)
                            .addComponent(cyclesLabel))
                        .addGap(18, 18, 18)
                        .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assistsSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(highGoalsScoredSpinner)
                            .addComponent(highGoalsAttemptedSpinner)
                            .addComponent(lowGoalsScoredSpinner)
                            .addComponent(lowGoalsAttemptedSpinner)
                            .addComponent(cyclesSpinner)
                            .addComponent(attemptedBallsHPSpinner, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(32, 32, 32))
        );
        spinnersPanelLayout.setVerticalGroup(
            spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spinnersPanelLayout.createSequentialGroup()
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ballsCaughtHPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ballsCaughtFromHPLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attemptedCatchesFromHPLabel)
                    .addComponent(attemptedBallsHPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assistsLabel)
                    .addComponent(assistsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(highGoalsScoredLabel)
                    .addComponent(highGoalsScoredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(highGoalsAttemptedLabel)
                    .addComponent(highGoalsAttemptedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowGoalsScoredLabel)
                    .addComponent(lowGoalsScoredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowGoalsAttemptedLabel)
                    .addComponent(lowGoalsAttemptedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(spinnersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cyclesLabel)
                    .addComponent(cyclesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commentsLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(catchesCheckBox)
                                    .addComponent(trussCatchCheckBox)
                                    .addComponent(trussTossCheckBox)
                                    .addComponent(ableToUnloadAutoBallCheckBox)
                                    .addComponent(floorPickupLabel)
                                    .addComponent(floorPickupSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stabilitiyLabel)
                                    .addComponent(stabilityScrollPane)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(autoBallsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(autoBallCountLabel))
                                    .addComponent(zoneChangeCheckBox)
                                    .addComponent(autoBallGoalLabel)
                                    .addComponent(autoBallGoalSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(defensiveLabel)
                                    .addComponent(defensiveSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addComponent(ballShieldingLabel)
                                    .addComponent(ballShieldingScrollPane)
                                    .addComponent(spinnersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autoBallCountLabel)
                            .addComponent(autoBallsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoneChangeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoBallGoalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoBallGoalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ableToUnloadAutoBallCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trussTossCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trussCatchCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(catchesCheckBox))
                    .addComponent(spinnersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
        if (newMatch) {
            TeamEventMatch match = new TeamEventMatch();
            match.setEventID(EventHandler.getCurrentEvent().getEventID());
            match.setMatchNumber(getMatchNumber());
            match.setTeamNumber(getTeamNumber());
            match.setAttemptedCatchesFromHP(getAttemptedCatchesFromHP());
            match.setAutoBallCount(getAutoBallCount());
            match.setAutoBallGoal(getAutoBallGoal());
            match.setBallsCaughtFromHP(getBallsCaughtFromHP());
            match.setAssists(getAssists());
            match.setBallShielding(getBallShielding());
            match.setComments(getComments());
            match.setCycles(getCycles());
            match.setDefensive(getDefensive());
            match.setFloorPickup(getFloorPickup());
            match.setHighGoalsAttempted(getHighGoalsAttempted());
            match.setHighGoalsScored(getHighGoalsScored());
            match.setLowGoalsAttempted(getLowGoalsAttempted());
            match.setLowGoalsScored(getLowGoalsScored());
            match.setScouter(getScouter());
            match.setStability(getStability());
            match.setStartingPosition(getStartingPosition());
            match.setAbleToTrussCatch(isAbleToTrussCatch());
            match.setAbleToTrussToss(isAbleToTrussToss());
            match.setAbleToUnloadAutoBall(isAbleToUnloadAutoBall());
            match.setZoneChange(getZoneChange());

            if (!TeamEventMatchHandler.addMatch(match)) {
                JOptionPane.showMessageDialog(this,
                        "A match with this team number and event has already "
                        + "been entered \nor could not find team with specified number.",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                dispose();
            }
        } else {

            parsedMatch.setAssists(getAssists());
            parsedMatch.setBallShielding(getBallShielding());
            parsedMatch.setComments(getComments());
            parsedMatch.setCycles(getCycles());
            parsedMatch.setDefensive(getDefensive());
            parsedMatch.setFloorPickup(getFloorPickup());
            parsedMatch.setHighGoalsAttempted(getHighGoalsAttempted());
            parsedMatch.setHighGoalsScored(getHighGoalsScored());
            parsedMatch.setLowGoalsAttempted(getLowGoalsAttempted());
            parsedMatch.setLowGoalsScored(getLowGoalsScored());
            parsedMatch.setScouter(getScouter());
            parsedMatch.setStability(getStability());
            parsedMatch.setStartingPosition(getStartingPosition());
            parsedMatch.setAbleToTrussCatch(isAbleToTrussCatch());
            parsedMatch.setAbleToTrussToss(isAbleToTrussToss());
            parsedMatch.setAbleToUnloadAutoBall(isAbleToUnloadAutoBall());
            parsedMatch.setZoneChange(getZoneChange());
            parsedMatch.setAbleToCatch(isAbleToCatch());
            parsedMatch.setAttemptedCatchesFromHP(getAttemptedCatchesFromHP());
            parsedMatch.setAutoBallCount(getAutoBallCount());
            parsedMatch.setAutoBallGoal(getAutoBallGoal());
            parsedMatch.setBallsCaughtFromHP(getBallsCaughtFromHP());

            TeamEventMatchHandler.updateMatch(parsedMatch);

            dispose();

        }
    }//GEN-LAST:event_submitButtonActionPerformed

    public TeamEventMatchInput display(){
        setVisible(true);
        return this;
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ableToUnloadAutoBallCheckBox;
    private javax.swing.JLabel assistsLabel;
    private javax.swing.JSpinner assistsSpinner;
    private javax.swing.JSpinner attemptedBallsHPSpinner;
    private javax.swing.JLabel attemptedCatchesFromHPLabel;
    private javax.swing.JLabel autoBallCountLabel;
    private javax.swing.JLabel autoBallGoalLabel;
    private javax.swing.JSlider autoBallGoalSlider;
    private javax.swing.JSpinner autoBallsSpinner;
    private javax.swing.JLabel ballShieldingLabel;
    private javax.swing.JScrollPane ballShieldingScrollPane;
    private javax.swing.JTextArea ballShieldingTextArea;
    private javax.swing.JLabel ballsCaughtFromHPLabel;
    private javax.swing.JSpinner ballsCaughtHPSpinner;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox catchesCheckBox;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JScrollPane commentsScrollPane;
    private javax.swing.JTextArea commentsTextArea;
    private javax.swing.JLabel cyclesLabel;
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
    private javax.swing.JLabel scouterLabel;
    private javax.swing.JTextField scouterTextField;
    private javax.swing.JPanel spinnersPanel;
    private javax.swing.JLabel stabilitiyLabel;
    private javax.swing.JScrollPane stabilityScrollPane;
    private javax.swing.JTextArea stabilityTextArea;
    private javax.swing.JLabel startingPositionLabel;
    private javax.swing.JSlider startingPositionSlider;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel teamNumberLabel;
    private javax.swing.JSpinner teamNumberSpinner;
    private javax.swing.JCheckBox trussCatchCheckBox;
    private javax.swing.JCheckBox trussTossCheckBox;
    private javax.swing.JCheckBox zoneChangeCheckBox;
    // End of variables declaration//GEN-END:variables
}
