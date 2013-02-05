package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;
import edu.arhs.team1100.ultimateascent.commands.FrisbeeCountCommand;
/**
 *
 * @author Team 1100
 */
public class ShootAllFrisbeesCommand extends CommandBase {
    
    public ShootAllFrisbeesCommand() {
        requires(ShooterPistonSubsystem.getInstance());
    }

    protected void initialize() {
        ShooterPistonSubsystem.getInstance();
    }

    protected void execute(int numberOfFrisbees) {
        ShooterPistonSubsystem.getInstance().shoot(ShooterPistonSubsystem.getInstance().getNumberFrisbees());
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

    protected void execute() {
    }
}
