package edu.arhs.team1100.ultimateascent.commands.drive;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author Team1100
 */
public class StopDriveCommand extends CommandBase {

    double duration;

    /**
     * Constructs a DriveSubsystem object
     *
     * @param duration
     */
    public StopDriveCommand(double duration) {
        requires(DriveSubsystem.getInstance());
        this.duration = duration;
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        setTimeout(duration);
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        DriveSubsystem.getInstance().stop();
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
        DriveSubsystem.getInstance().stop();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
