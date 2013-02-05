package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;
import edu.arhs.team1100.ultimateascent.commands.FrisbeeCountCommand;
/**
 *
 * @author Team 1100
 */
public class ShootAllFrisbeesCommand extends CommandBase {
    
    private boolean finished;
    
    public ShootAllFrisbeesCommand() {
        requires(ShooterPistonSubsystem.getInstance());
    }

    protected void initialize() {
        ShooterPistonSubsystem.getInstance();
        finished = false;
    }

    protected void execute(int numberOfFrisbees) {
        ShooterPistonSubsystem.getInstance().shoot(ShooterPistonSubsystem.getInstance().getNumberFrisbees());
        finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        
        if(!finished) {
            execute();
        }
    }

    protected void interrupted() {
        end();
    }

    protected void execute() {
    }
}
