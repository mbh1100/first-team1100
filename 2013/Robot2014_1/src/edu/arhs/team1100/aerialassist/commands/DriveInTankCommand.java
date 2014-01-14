package edu.arhs.team1100.aerialassist.commands;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

/**
 * @author Team 1100
 */
public class DriveInTankCommand extends CommandBase {

    private double leftValue = 0.0;
    private double rightValue = 0.0;
    private double direction = 0.0;
    private double duration = 0;

    /**
     * Drives robot in a line
     *
     * @param speed motor speed
     * @param direction direction in degrees to move
     * @param duration length in seconds of command
     */
    public DriveInTankCommand(double leftValue, double rightValue, double duration) {
        requires(DriveSubsystem.getInstance());
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.duration = duration;
    }

    /**
     * Initializes timeout to duration
     */
    protected void initialize() {
        setTimeout(duration);
    }

    protected void execute() {
        DriveSubsystem.getInstance().setDriveMode(DriveSubsystem.MODE_TANK);
        DriveSubsystem.getInstance().driveTank(leftValue, rightValue);
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
