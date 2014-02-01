package scoutingdatabase;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoseDisplay frame = new ChoseDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChoseDisplay() {
                setResizable(false);
                setTitle("Scouting Database 2014");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 345, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JLabel lblWhatTypeOf = new JLabel("What type of entry would you like to enter?");
		lblWhatTypeOf.setBounds(10, 11, 249, 14);
		contentPane.add(lblWhatTypeOf);
		
		JButton btnPitEntry = new JButton("Pit Entry");
		btnPitEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code for pit entry
				JOptionPane.showMessageDialog(Main.frame2, "This option is currently unavaliable", "Scouting Database 2014", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnPitEntry.setBounds(10, 36, 148, 55);
		contentPane.add(btnPitEntry);
		
		JButton btnMatchEntry = new JButton("Match Entry");
		btnMatchEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code for match entry
				Main.frame2SetVisible(false);
				Main.frameSetVisible(true);
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
