package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Team 1100
 */
public class SetArmPositionFloorPickupCommand extends CommandBase {

    boolean mod = false;
    boolean canceled = false;

    /**
     * Constructs a DriveSubsystem object
     */
    public SetArmPositionFloorPickupCommand() throws DriverStationEnhancedIO.EnhancedIOException {
        requires(ManipulatorSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        try {
            if (OI.getInstance().getXboxController().getButtonLeftBumper().get()) {
                mod = true;
            }
        } catch (DriverStationEnhancedIO.EnhancedIOException ex) {
            ex.printStackTrace();
        }
        if (mod) {
            ManipulatorSubsystem.getInstance().setSetpoint(4000);
        } else {
            ManipulatorSubsystem.getInstance().setSetpoint(-4000);
        }
        ManipulatorSubsystem.getInstance().enable();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        try {
            if (OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kY) != 0) {
                canceled = true;
            }
        } catch (Exception e) {

        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        if (canceled) {
            return true;
        } else {
            return ManipulatorSubsystem.getInstance().onTarget();
        }
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        mod = false;
        canceled = false;
        ManipulatorSubsystem.getInstance().disable();
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
