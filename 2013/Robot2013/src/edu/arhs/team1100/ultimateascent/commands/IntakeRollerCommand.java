package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;

/**
 *
 * @author Team 1100
 */
public class IntakeRollerCommand extends CommandBase {

    private long startTime = 0;

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
        startTime = System.currentTimeMillis();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        IntakeSubsystem.getInstance().intakeRollLeft();

        if (System.currentTimeMillis() - startTime >= 1000) {
            IntakeSubsystem.getInstance().intakeRollRight();
        }

        if (System.currentTimeMillis() - startTime >= 3000) {
            setTimeout(1.0);
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
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
