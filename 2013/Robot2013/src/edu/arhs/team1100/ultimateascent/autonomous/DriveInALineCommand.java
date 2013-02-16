package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Team 1100
 */
public class DriveInALineCommand extends CommandBase {

    private double speed = 0.0;
    private double direction = 0.0;
    private double duration = 0;

    /**
     *
     * @param speed motor speed
     * @param direction direction in degrees to move
     * @param duration length in seconds of command
     */
    /**
     * drives robot in a line
     *
     * @param speed
     * @param direction
     * @param duration
     */
    public DriveInALineCommand(double speed, double direction, double duration) {
        requires(DriveSubsystem.getInstance());
        this.speed = speed;
        this.direction = direction;
        this.duration = duration;
    }

    protected void initialize() {
        setTimeout(duration);
    }

    protected void execute() {
        DriveSubsystem.getInstance().drive(speed, direction, 0.0);
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
