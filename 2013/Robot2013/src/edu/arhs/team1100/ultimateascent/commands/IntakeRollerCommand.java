package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;

/**
 * @author Team 1100
 */
public class IntakeRollerCommand extends CommandBase {
    
    /**
     * Constructs a IntakeRollerCommand
     */
    public IntakeRollerCommand() {
        requires(IntakeSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        setTimeout(4);
        IntakeSubsystem.getInstance().intakeRollRight();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        if (this.timeSinceInitialized() > 1.0) {
            IntakeSubsystem.getInstance().intakeRollLeft();
        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return isTimedOut()
     */
    protected boolean isFinished() {
        return isTimedOut();
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        IntakeSubsystem.getInstance().stopRollers();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
