package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;

/**
 *
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
        // Need to add delay betweens the roller runs so frisbees fall correctly
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
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
