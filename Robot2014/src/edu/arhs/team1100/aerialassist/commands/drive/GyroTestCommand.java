package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.SensorTestSubsystem;

/**
 *
 * @author Team 1100
 */
public class GyroTestCommand extends CommandBase {

    /**
     * Constructs a DriveSubsystem object
     */
    public GyroTestCommand() {
        requires(SensorTestSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        SensorTestSubsystem.getInstance().gyroTest();
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return false;
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
        end();
    }
}
