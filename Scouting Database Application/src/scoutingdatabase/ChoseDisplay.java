package scoutingdatabase;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


public class ChoseDisplay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ChoseDisplay() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 345, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhatTypeOf = new JLabel("What type of entry would you like to enter?");
		lblWhatTypeOf.setBounds(10, 11, 249, 14);
		contentPane.add(lblWhatTypeOf);
		
		JButton btnPitEntry = new JButton("Pit Entry");
		btnPitEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code for pit entry
				JOptionPane.showMessageDialog(null, "This option is currently unavaliable");
			}
		});
		btnPitEntry.setBounds(10, 36, 148, 55);
		contentPane.add(btnPitEntry);
		
		JButton btnMatchEntry = new JButton("Match Entry");
		btnMatchEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Display();
			}
		});
		btnMatchEntry.setBounds(168, 36, 148, 55);
		contentPane.add(btnMatchEntry);
		
		JTextPane txtpnChooseThisIf = new JTextPane();
		txtpnChooseThisIf.setEditable(false);
		txtpnChooseThisIf.setText("Choose this if you want to enter information on one of the pits. This includes pictures of the robots.");
		txtpnChooseThisIf.setBounds(10, 102, 148, 90);
		contentPane.add(txtpnChooseThisIf);
		
		JTextPane txtpnChooseThisIf_1 = new JTextPane();
		txtpnChooseThisIf_1.setText("Choose this if you want to enter data on one of the matches. This includes how the robot did.");
		txtpnChooseThisIf_1.setEditable(false);
		txtpnChooseThisIf_1.setBounds(168, 102, 148, 90);
		contentPane.add(txtpnChooseThisIf_1);
	}
}
