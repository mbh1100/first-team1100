package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;

/**
 *
 * @author Team 1100
 */
public class SpinShooterCommand extends CommandBase {

    public SpinShooterCommand() {
        requires(ShooterWheelSubsystem.getInstance());
    }

    protected void initialize() {
    }

    protected void execute() {
        ShooterWheelSubsystem.getInstance().spinWheel();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().disable();
    }

    protected void interrupted() {
        end();
    }
}
