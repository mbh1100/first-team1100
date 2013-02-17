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
     *
     * @param duration duration of stop moving in seconds
     */
    /**
     * Stops the robot
     *
     * @param duration
     */
    public StopDriveCommand(double duration) {
        requires(DriveSubsystem.getInstance());
        this.duration = duration;
    }

    protected void initialize() {
        setTimeout(duration);
    }

    protected void execute() {
        DriveSubsystem.getInstance().stop();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();
    }

    protected void interrupted() {
        end();
    }
}
