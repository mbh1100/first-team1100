package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

/**
 *
 * @author Team 1100
 */
public class CalibrateGyroCommand extends CommandBase {

    private boolean finished = false;

    /**
     * Initializes the class
     */
    protected void initialize() {
    }

    /**
     * Calibrates Gyro
     */
    protected void execute() {
        DriveSubsystem.getInstance().calibrateGyro();
        finished = true;
    }

    /**
     * @return finished
     */
    protected boolean isFinished() {
        return finished;
    }

    /**
     * If finished = false, calibrate Gyro
     */
    protected void end() {
        if (!finished) {
            execute();
        }
    }

    /**
     * Calibrates Gyro if interupted
     */
    protected void interrupted() {
        end();
    }
}
