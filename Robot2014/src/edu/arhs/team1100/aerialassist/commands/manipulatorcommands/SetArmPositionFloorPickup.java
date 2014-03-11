package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;

/**
 *
 * @author Team 1100
 */
public class SetArmPositionFloorPickup extends CommandBase {
    int mod = 1;
    /**
     * Constructs a DriveSubsystem object
     */
    public SetArmPositionFloorPickup() throws DriverStationEnhancedIO.EnhancedIOException {
        requires(ManipulatorSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        try {
            if(OI.getInstance().getXboxController().getButtonLeftBumper().equals(this))mod = -1;
        } catch (DriverStationEnhancedIO.EnhancedIOException ex) {
            ex.printStackTrace();
        }
        ManipulatorSubsystem.getInstance().setSetpoint(mod*4400);
        ManipulatorSubsystem.getInstance().enable();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return ManipulatorSubsystem.getInstance().onTarget();
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        //ManipulatorSubsystem.getInstance().disable();
        //ManipulatorSubsystem.getInstance().stopArm();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
