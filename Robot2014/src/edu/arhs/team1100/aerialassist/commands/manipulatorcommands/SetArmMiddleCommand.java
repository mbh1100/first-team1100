package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Team 1100
 */
public class SetArmMiddleCommand extends CommandBase {

    boolean canceled = false;

    /**
     * Constructs a DriveSubsystem object
     */
    public SetArmMiddleCommand() {
        requires(ManipulatorSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        ManipulatorSubsystem.getInstance().disable();
        ManipulatorSubsystem.getInstance().setSetpoint(0);
        ManipulatorSubsystem.getInstance().setGoingToMiddle(true);
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
        ManipulatorSubsystem.getInstance().setGoingToMiddle(false);
        // ManipulatorSubsystem.getInstance().disable();
        // ManipulatorSubsystem.getInstance().stopArm();
        canceled = false;
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
