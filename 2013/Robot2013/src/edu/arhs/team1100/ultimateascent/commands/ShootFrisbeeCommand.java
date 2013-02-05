package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;

/**
 *
 * @author Team 1100
 */
public class ShootFrisbeeCommand extends CommandBase {
    
    private boolean finished;

    public ShootFrisbeeCommand() {
        requires(ShooterPistonSubsystem.getInstance());
    }

    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        ShooterPistonSubsystem.getInstance().shoot(1);
        finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        if(!finished){
            execute();
        }
    }

    protected void interrupted() {
        end();
    }
}
