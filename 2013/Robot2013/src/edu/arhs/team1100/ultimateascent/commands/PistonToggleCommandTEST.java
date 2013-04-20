package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;

/**
 * @author Team 1100
 */
public class PistonToggleCommandTEST extends CommandBase {

    private boolean state = false;
    private boolean finished = false;

    /**
     * Constructs a PistonToggleCommandTEST
     */
    public PistonToggleCommandTEST() {
        requires(ShooterPistonSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        finished = false;
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        ShooterPistonSubsystem.getInstance().set(!state);
        state = !state;
        finished = true;
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return finished
     */
    protected boolean isFinished() {
        return finished;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        if (!finished) {
            execute();
        }
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
