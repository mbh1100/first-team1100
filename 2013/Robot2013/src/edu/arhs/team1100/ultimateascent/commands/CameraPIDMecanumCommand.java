/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author markbh
 */
public class CameraPIDMecanumCommand extends CommandBase {

    public CameraPIDMecanumCommand() {
        requires(DriveSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        DriveSubsystem.getInstance().setCameraMode(true);
        DriveSubsystem.getInstance().setSetpoint(0);
        DriveSubsystem.getInstance().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        DriveSubsystem.getInstance().disable();
        DriveSubsystem.getInstance().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
