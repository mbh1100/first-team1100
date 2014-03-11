package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

/**
 * @author Team 1100
 */
public class DriveInALineCommand extends CommandBase {

   private double setPoint;

    /**
     * Drives robot in a line
     *
     * @param speed motor speed
     * @param direction direction in degrees to move
     * @param duration length in seconds of command
     */
    public DriveInALineCommand(double asetPoint) {
        requires(DriveSubsystem.getInstance());
        this.setPoint = asetPoint;
    }

  
    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        DriveSubsystem.getInstance().setSetpoint(setPoint);
        DriveSubsystem.getInstance().enable();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        System.out.println(DriveSubsystem.getInstance().getEncoderTick());
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return DriveSubsystem.getInstance().onTarget();
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        DriveSubsystem.getInstance().disable();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
