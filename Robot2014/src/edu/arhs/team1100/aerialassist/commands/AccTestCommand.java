package edu.arhs.team1100.aerialassist.commands;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.SensorTestSubsystem;

/**
 *
 * @author Team 1100
 */
public class AccTestCommand extends CommandBase {

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
        SensorTestSubsystem.getInstance().acTest();
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
