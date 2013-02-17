package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;

/**
 *
 * @author Team 1100
 */
public class FrisbeeCountCommand extends CommandBase {

    protected void initialize() {
    }


    protected void execute() {
        ShooterPistonSubsystem.getInstance().updateFrisbeeCount();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
