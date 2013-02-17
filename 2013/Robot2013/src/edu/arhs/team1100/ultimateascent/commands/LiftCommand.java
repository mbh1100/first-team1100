
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.LiftSubsystem;

/**
 *
 * @author akshay
 */
public class LiftCommand extends CommandBase {
    
    public LiftCommand() {
        requires(LiftSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        LiftSubsystem.getInstance().doLift();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
