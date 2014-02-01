import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;


public class Display extends JFrame {

	private JPanel contentPane;
	private JTextField scouterField;
        
	/**
	 * Create the frame.
	 */
	public Display() {
            try {
		Display frame = new Display();
		frame.setVisible(true);
		} catch (Exception e) {
                    e.printStackTrace();
                }
		setResizable(false);
		setTitle("Scouting Database 2014");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 844);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 478, 798);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Team Number");
		label.setBounds(138, 72, 81, 14);
		panel.add(label);
		
		final JSpinner teamSpinner = new JSpinner();
		teamSpinner.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		teamSpinner.setBounds(224, 69, 49, 20);
		panel.add(teamSpinner);
		
		JLabel label_1 = new JLabel("Match Number");
		label_1.setBounds(0, 72, 122, 14);
		panel.add(label_1);
		
		final JSpinner matchSpinner = new JSpinner();
		matchSpinner.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		matchSpinner.setBounds(88, 69, 49, 20);
		panel.add(matchSpinner);
		
		final JSlider startSlider = new JSlider();
		startSlider.setValue(1);
		startSlider.setPaintTicks(true);
		startSlider.setMinorTickSpacing(1);
		startSlider.setMinimum(1);
		startSlider.setMaximum(6);
		startSlider.setMajorTickSpacing(1);
		startSlider.setBounds(92, 3, 324, 45);
		panel.add(startSlider);
		
		JLabel label_2 = new JLabel("Starting Position");
		label_2.setBounds(0, 3, 104, 14);
		panel.add(label_2);
		
		JEditorPane commentsField = new JEditorPane();
		commentsField.setBounds(0, 668, 349, 67);
		panel.add(commentsField);
		
		JLabel label_3 = new JLabel("Comments");
		label_3.setBounds(0, 643, 97, 14);
		panel.add(label_3);
		
		scouterField = new JTextField();
		scouterField.setBounds(330, 69, 138, 20);
		panel.add(scouterField);
		scouterField.setColumns(10);
		
		JLabel lblLeft = new JLabel("Red 1");
		lblLeft.setBounds(102, 49, 46, 14);
		panel.add(lblLeft);
		
		JLabel lblMiddle = new JLabel("Red 2");
		lblMiddle.setBounds(158, 49, 46, 14);
		panel.add(lblMiddle);
		
		JLabel lblRight = new JLabel("Red 3");
		lblRight.setBounds(214, 49, 46, 14);
		panel.add(lblRight);
		
		JLabel lblScouter = new JLabel("Scouter:");
		lblScouter.setBounds(274, 72, 63, 14);
		panel.add(lblScouter);
		
		JLabel lblBlue_2 = new JLabel("Blue 3");
		lblBlue_2.setBounds(376, 49, 46, 14);
		panel.add(lblBlue_2);
		
		JLabel lblBlue_1 = new JLabel("Blue 2");
		lblBlue_1.setBounds(320, 49, 46, 14);
		panel.add(lblBlue_1);
		
		JLabel lblBlue = new JLabel("Blue 1");
		lblBlue.setBounds(264, 49, 46, 14);
		panel.add(lblBlue);
		
		final JCheckBox preloadAutoBallBox = new JCheckBox("Preloaded Ball in Auto");
		preloadAutoBallBox.setBounds(0, 93, 210, 23);
		panel.add(preloadAutoBallBox);
		
		final JCheckBox zoneChangeBox = new JCheckBox("Changes Zone Bonus");
		zoneChangeBox.setBounds(0, 119, 210, 23);
		panel.add(zoneChangeBox);
		
		final JCheckBox lowAutoBox = new JCheckBox("Auto Ball Low");
		lowAutoBox.setBounds(0, 145, 210, 23);
		panel.add(lowAutoBox);
		
		final JCheckBox highAutoBox = new JCheckBox("Auto Ball High");
		highAutoBox.setBounds(0, 171, 210, 23);
		panel.add(highAutoBox);
		
		final JCheckBox noAutoUnload = new JCheckBox("Unable to Unload Auto Ball");
		noAutoUnload.setBounds(0, 195, 210, 23);
		panel.add(noAutoUnload);
		
		final JCheckBox trussTossBox = new JCheckBox("Truss Toss");
		trussTossBox.setBounds(0, 219, 210, 23);
		panel.add(trussTossBox);
		
		final JCheckBox trussCatchBox = new JCheckBox("Truss Catch");
		trussCatchBox.setBounds(0, 241, 210, 23);
		panel.add(trussCatchBox);
		
		JSlider floorPickupSlider = new JSlider();
		floorPickupSlider.setMinorTickSpacing(1);
		floorPickupSlider.setValue(0);
		floorPickupSlider.setPaintTicks(true);
		floorPickupSlider.setMaximum(5);
		floorPickupSlider.setBounds(0, 293, 210, 31);
		panel.add(floorPickupSlider);
		
		JLabel lblNone = new JLabel("None");
		lblNone.setBounds(0, 335, 46, 14);
		panel.add(lblNone);
		
		JLabel label_4 = new JLabel("1");
		label_4.setBounds(46, 335, 17, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("2");
		label_5.setBounds(80, 335, 17, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("3");
		label_6.setBounds(120, 335, 17, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("4");
		label_7.setBounds(162, 335, 17, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("5");
		label_8.setBounds(202, 335, 17, 14);
		panel.add(label_8);
		
		JLabel lblFloorPickupspeed = new JLabel("Floor Pickup? (+Speed)");
		lblFloorPickupspeed.setBounds(0, 268, 210, 14);
		panel.add(lblFloorPickupspeed);
		
		JCheckBox catchInAirBox = new JCheckBox("Catches Ball In Air");
		catchInAirBox.setBounds(0, 356, 210, 23);
		panel.add(catchInAirBox);
		
		JSlider defenceSlider = new JSlider();
		defenceSlider.setValue(0);
		defenceSlider.setPaintTicks(true);
		defenceSlider.setMinorTickSpacing(1);
		defenceSlider.setMaximum(4);
		defenceSlider.setBounds(0, 411, 210, 31);
		panel.add(defenceSlider);
		
		JLabel label_10 = new JLabel("1");
		label_10.setBounds(10, 453, 17, 14);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("2");
		label_11.setBounds(56, 453, 17, 14);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("3");
		label_12.setBounds(105, 453, 17, 14);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("4");
		label_13.setBounds(151, 453, 17, 14);
		panel.add(label_13);
		
		JLabel lblDefensiveCapabilities = new JLabel("Defensive Capabilities\r\n");
		lblDefensiveCapabilities.setBounds(0, 386, 210, 14);
		panel.add(lblDefensiveCapabilities);
		
		JLabel label_15 = new JLabel("5");
		label_15.setBounds(202, 453, 17, 14);
		panel.add(label_15);
		
		JLabel lblPassesInTeleop = new JLabel("Passes in Tele-op");
		lblPassesInTeleop.setBounds(220, 250, 143, 23);
		panel.add(lblPassesInTeleop);
		
		JSpinner passTeleSpin = new JSpinner();
		passTeleSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		passTeleSpin.setBounds(373, 251, 49, 20);
		panel.add(passTeleSpin);
		
		JSpinner numAssistSpin = new JSpinner();
		numAssistSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		numAssistSpin.setBounds(373, 275, 49, 20);
		panel.add(numAssistSpin);
		
		JLabel lblNumberOfAssists = new JLabel("Number of assists");
		lblNumberOfAssists.setBounds(220, 275, 143, 23);
		panel.add(lblNumberOfAssists);
		
		JSpinner highScoreSpin = new JSpinner();
		highScoreSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		highScoreSpin.setBounds(373, 301, 49, 20);
		panel.add(highScoreSpin);
		
		JLabel lblHighGoalsScored = new JLabel("High goals scored");
		lblHighGoalsScored.setBounds(220, 304, 143, 14);
		panel.add(lblHighGoalsScored);
		
		JLabel lblHighGoalsAttempted = new JLabel("High goals attempted");
		lblHighGoalsAttempted.setBounds(220, 326, 143, 23);
		panel.add(lblHighGoalsAttempted);
		
		JLabel lblLowGoalsScored = new JLabel("Low goals scored");
		lblLowGoalsScored.setBounds(220, 351, 143, 23);
		panel.add(lblLowGoalsScored);
		
		JLabel lblLowGoalsAttempted = new JLabel("Low goals attempted");
		lblLowGoalsAttempted.setBounds(220, 380, 143, 14);
		panel.add(lblLowGoalsAttempted);
		
		JSpinner lowScoreAttemptSpin = new JSpinner();
		lowScoreAttemptSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		lowScoreAttemptSpin.setBounds(373, 377, 49, 20);
		panel.add(lowScoreAttemptSpin);
		
		JSpinner lowScoreSpin = new JSpinner();
		lowScoreSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		lowScoreSpin.setBounds(373, 351, 49, 20);
		panel.add(lowScoreSpin);
		
		JSpinner highScoreAttemptSpin = new JSpinner();
		highScoreAttemptSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		highScoreAttemptSpin.setBounds(373, 327, 49, 20);
		panel.add(highScoreAttemptSpin);
		
		JLabel lblNumberOfTech = new JLabel("Number of tech fouls");
		lblNumberOfTech.setBounds(220, 450, 143, 14);
		panel.add(lblNumberOfTech);
		
		JSpinner techFoulSpin = new JSpinner();
		techFoulSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		techFoulSpin.setBounds(373, 447, 49, 20);
		panel.add(techFoulSpin);
		
		JSpinner foulSpin = new JSpinner();
		foulSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		foulSpin.setBounds(373, 421, 49, 20);
		panel.add(foulSpin);
		
		JLabel lblNumberOfRegular = new JLabel("Number of regular fouls");
		lblNumberOfRegular.setBounds(220, 421, 143, 23);
		panel.add(lblNumberOfRegular);
		
		JLabel lblScoringCyclesCompleted = new JLabel("Scoring cycles completed");
		lblScoringCyclesCompleted.setBounds(220, 398, 196, 23);
		panel.add(lblScoringCyclesCompleted);
		
		JSpinner scoreCycleSpin = new JSpinner();
		scoreCycleSpin.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		scoreCycleSpin.setBounds(373, 399, 49, 20);
		panel.add(scoreCycleSpin);
		
		JLabel lblDescribeTheRobots = new JLabel("Describe the robot's speed and stability");
		lblDescribeTheRobots.setBounds(1, 478, 348, 14);
		panel.add(lblDescribeTheRobots);
		
		JEditorPane speedAndStabilityField = new JEditorPane();
		speedAndStabilityField.setBounds(1, 503, 348, 45);
		panel.add(speedAndStabilityField);
		
		JLabel lblAreTheyAble = new JLabel("Are they able to shield themselves from/eject opposing ");
		lblAreTheyAble.setBounds(1, 551, 348, 14);
		panel.add(lblAreTheyAble);
		
		JEditorPane ballShieldField = new JEditorPane();
		ballShieldField.setBounds(1, 587, 348, 45);
		panel.add(ballShieldField);
		
		JLabel lblOpposingAlliancesBalls = new JLabel("alliance's balls?");
		lblOpposingAlliancesBalls.setBounds(0, 570, 349, 14);
		panel.add(lblOpposingAlliancesBalls);
		
		JButton enterDataButton = new JButton("Enter Data");
		enterDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				//Called when input data is pressed
				int startPositionIn = startSlider.getValue();
				int matchNumIn = (int) matchSpinner.getValue();
				int teamNumIn = (int) teamSpinner.getValue();
				String scouterIn = scouterField.getText();
				boolean preloadBallInAutoIn = preloadAutoBallBox.isSelected();
				boolean changeZoneIn = zoneChangeBox.isSelected();
				boolean autoLowIn = lowAutoBox.isSelected();
				boolean autoHighIn = highAutoBox.isSelected();
				boolean noUnloadAutoIn = noAutoUnload.isSelected();
				boolean trussTossIn = trussTossBox.isSelected();
				boolean trussCatchIn = trussCatchBox.isSelected();
				int floorPickupIn;
				boolean catchInAirIn;
				int defenceAbilityIn;
				int passesTeleOpIn;
				int numAssistsIn;
				int highGoalIn;
				int highGoalAttemptIn;
				int lowGoalIn;
				int lowGoalAttemptIn;
				int scoreCycleIn;
				int regFoulIn;
				int techFoulIn;
				String speedStabilityIn;
				String shildFromBallsIn;
				String commentsIn;
				*/
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to enter all the data?");
				if(option == 1) {
					//Do entering things
				} else {
					
				}
			}
		});
		enterDataButton.setBounds(0, 746, 422, 43);
		panel.add(enterDataButton);
	}
}
