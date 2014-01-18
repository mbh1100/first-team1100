package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;

/**
 *
 * @author Team 1100
 */
public class StopShooterCommand extends CommandBase {

    private boolean finished = false;

    /**
     * Constructs a ShooterWheelSubsystem object
     */
    public StopShooterCommand() {
        requires(ShooterWheelSubsystem.getInstance());
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
        ShooterWheelSubsystem.getInstance().stop();
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
