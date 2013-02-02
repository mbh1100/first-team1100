/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author Team 1100
 */
public class JoystickMecanumCommand extends CommandBase {
    
    public JoystickMecanumCommand(){
        requires(DriveSubsystem.getInstance());
    }

    protected void initialize() {
    }

    protected void execute() {
        DriveSubsystem.getInstance().userDrive();        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();
    }

    protected void interrupted() {
        end();
    }
    
}
