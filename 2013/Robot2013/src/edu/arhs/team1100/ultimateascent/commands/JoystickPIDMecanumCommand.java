/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author Akshay
 */
public class JoystickPIDMecanumCommand extends CommandBase {

    public JoystickPIDMecanumCommand(){
        requires(DriveSubsystem.getInstance());
    }
    
    protected void initialize() {
        DriveSubsystem.getInstance().setSetpoint(0.0); //desired difference between desired and actual angle
        DriveSubsystem.getInstance().enable(); //PID enable        
    }

    protected void execute() {
        //nothing to do here
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().disable(); // PID disable        
    }

    protected void interrupted() {
        end();
    }
    
    
}
