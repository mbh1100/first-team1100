package edu.arhs.team1100.aerialassist.input;

import edu.arhs.team1100.aerialassist.handlers.TeamHandler;
import edu.arhs.team1100.aerialassist.scouting.objects.Team;
import javax.swing.JOptionPane;

/**
 *
 * @author Eddie
 */
public class TeamInput extends javax.swing.JFrame {

    Team parsedTeam;

    /**
     * Creates new blank form TeamInput
     */
    public TeamInput() {
        initComponents();
    }

    /**
     * Creates a new form TeamInput with fields filled with the parsed event's
     * data
     *
     * @param team Team to edit
     */
    public TeamInput(Team team) {
        this.parsedTeam = team;
        initComponents();
        setTeamNumber(team.getTeamNumber());
        setTeamName(team.getName());
        setTeamLocation(team.getLocation());
        teamNumberSpinner.setEnabled(false);

        setTitle("Edit Team " + team.getTeamNumber());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teamNumberLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        locationTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        teamNumberSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Team");
        setResizable(false);

        teamNumberLabel.setText("Team Number");

        nameLabel.setText("Name");

        locationLabel.setText("Location");

        locationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teamNumberLabel)
                            .addComponent(nameLabel)
                            .addComponent(locationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(locationTextField)
                            .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(teamNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamNumberLabel)
                    .addComponent(teamNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationLabel)
                    .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        setTeam();
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void locationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationTextFieldActionPerformed
        setTeam();
    }//GEN-LAST:event_locationTextFieldActionPerformed

    private void setTeam(){
                if (parsedTeam == null) {
            Team team = new Team();
            team.setTeamNumber(getTeamNumber());
            team.setName(getTeamName());
            team.setLocation(getTeamLocation());

            if (!TeamHandler.addTeam(team)) {
                JOptionPane.showMessageDialog(this,
                        "Team " + getTeamNumber() + " already exists.",
                        "Error",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                dispose();
            }
        } else {
            parsedTeam.setTeamNumber(getTeamNumber());
            parsedTeam.setName(getTeamName());
            parsedTeam.setLocation(getTeamLocation());
            TeamHandler.updateTeam(parsedTeam);
            dispose();
        }
    }
    
    /**
     * Displays TeamInput and returns the instance 
     * @return TeamInput instance
     */
    public TeamInput display() {
        setVisible(true);
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel teamNumberLabel;
    private javax.swing.JSpinner teamNumberSpinner;
    // End of variables declaration//GEN-END:variables

    public int getTeamNumber() {
        return (Integer) teamNumberSpinner.getValue();
    }

    private void setTeamNumber(int number) {
        teamNumberSpinner.setValue(number);
    }

    public String getTeamName() {
        return nameTextField.getText();
    }

    private void setTeamName(String name) {
        nameTextField.setText(name);
    }

    public String getTeamLocation() {
        return locationTextField.getText();
    }

    private void setTeamLocation(String location) {
        locationTextField.setText(location);
    }
}