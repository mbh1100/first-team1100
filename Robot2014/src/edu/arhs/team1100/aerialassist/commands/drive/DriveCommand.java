package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

/**
 * @author Team 1100
 */
public class DriveCommand extends CommandBase {

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
    public DriveCommand(double speed) {
        requires(DriveSubsystem.getInstance());
        this.speed = speed;
    }

    
    /**
     * Initializes timeout to duration
     */
    protected void initialize() {
    }

    protected void execute() {
        DriveSubsystem.getInstance().setDriveMode(DriveSubsystem.MODE_CARTESIAN);
        DriveSubsystem.getInstance().driveMecanum(speed, DriveSubsystem.DIRECTION_FORWARD, 0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();
        DriveSubsystem.getInstance().setDriveMode(DriveSubsystem.MODE_POLAR);
    }

    protected void interrupted() {
        end();
    }
}
