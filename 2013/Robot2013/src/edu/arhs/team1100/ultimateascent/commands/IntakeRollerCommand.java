/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;
import edu.arhs.team1100.ultimateascent.OI;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author akshay
 */
public class IntakeRollerCommand extends CommandBase {
    
    /**
     * Initializes IntakeSubsystem
     */
    public IntakeRollerCommand() {
        requires(IntakeSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        IntakeSubsystem.getInstance().intakeRollLeft();
        IntakeSubsystem.getInstance().intakeRollRight();
        setTimeout(1.0);
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {

    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     * @return false
     */
    protected boolean isFinished() {
        return isTimedOut();
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    }
  
    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
