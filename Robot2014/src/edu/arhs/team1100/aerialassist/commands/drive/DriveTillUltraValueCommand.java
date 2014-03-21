package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

/**
 * @author Team 1100
 */
public class DriveTillUltraValueCommand extends CommandBase {

    private double setPoint;
    private boolean finished = false;

    /**
     * Drives robot in a line
     *
     * @param speed motor speed
     * @param direction direction in degrees to move
     * @param duration length in seconds of command
     */
    public DriveTillUltraValueCommand(double asetPoint) {
        requires(DriveSubsystem.getInstance());
        setPoint = asetPoint;
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
        DriveSubsystem.getInstance().driveMecanum(.15, DriveSubsystem.DIRECTION_FORWARD, 0);
        if (DriveSubsystem.getInstance().getUltrasonic() <= 2.8) {
            finished = true;
        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return finished;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        System.out.println("Ultrasonic stoped drive at: " + DriveSubsystem.getInstance().getUltrasonic());
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
