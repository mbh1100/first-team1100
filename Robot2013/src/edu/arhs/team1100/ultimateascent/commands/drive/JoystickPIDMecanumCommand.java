package edu.arhs.team1100.ultimateascent.commands.drive;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Team 1100
 */
public class JoystickPIDMecanumCommand extends CommandBase {

    private static final double MAGNITUDE_DEADBAND = 0.3;

    /**
     * Creates a DriveSubsystem object
     */
    public JoystickPIDMecanumCommand() {
        requires(DriveSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        DriveSubsystem.getInstance().setCameraMode(false);
        DriveSubsystem.getInstance().setSetpoint(DriveSubsystem.getInstance().getGyroAngle());
        DriveSubsystem.getInstance().enable(); //PID enable
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        double joystickAngle = OI.getInstance().getLeftJoystick().getAngle();
        double joystickMagnitude = OI.getInstance().getLeftJoystick().getMagnitude();

        double gyroAngle = DriveSubsystem.getInstance().getGyroAngle();
        double normalizedGyroAngle = gyroAngle % 360;

        double difference = joystickAngle - normalizedGyroAngle;
        if (difference > 180) {
            difference -= 360;
        }
        if (difference < -180) {
            difference += 360;
        }

        if (Math.abs(joystickMagnitude) < MAGNITUDE_DEADBAND) {
            difference = 0;
        }

        DriveSubsystem.getInstance().setSetpoint(gyroAngle + difference);
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        DriveSubsystem.getInstance().disable(); // PID disable
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
