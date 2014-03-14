package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

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
    public StopDriveCommand() {
        requires(DriveSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        DriveSubsystem.getInstance().disable();
        DriveSubsystem.getInstance().stop();
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
        return false;
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
