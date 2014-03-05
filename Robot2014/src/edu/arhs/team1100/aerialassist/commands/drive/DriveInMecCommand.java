package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

/**
 * @author Team 1100
 */
public class DriveInMecCommand extends CommandBase {

    private double speed = 0.0;
    private double direction = 0.0;
    private double duration = 0.0;
    private double rotation = 0.0;

    /**
     * Drives robot in a line
     *
     * @param speed motor speed
     * @param direction direction in degrees to move
     * @param duration length in seconds of command
     */
    public DriveInMecCommand(double speed, double direction, double rotation, double duration) {
        requires(DriveSubsystem.getInstance());
        this.speed = speed;
        this.direction = direction;
        this.duration = duration;
        this.rotation = rotation;
    }

    /**
     * Initializes timeout to duration
     */
    protected void initialize() {
        setTimeout(duration);
    }

    protected void execute() {
        DriveSubsystem.getInstance().setDriveMode(DriveSubsystem.MODE_CARTESIAN);
        DriveSubsystem.getInstance().driveMecanum(speed, direction, rotation);
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
