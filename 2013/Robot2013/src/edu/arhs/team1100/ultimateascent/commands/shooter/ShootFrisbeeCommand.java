package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;

/**
 *
 * @author Team 1100
 */
public class ShootFrisbeeCommand extends CommandBase {
    
    private static final long TIME = 200;
            
    
    private long startTime = 0;
    private boolean finished;

    public ShootFrisbeeCommand() {
        requires(ShooterPistonSubsystem.getInstance());        
        this.setInterruptible(false);        
    }

    protected void initialize() {
        Log.log(this, "SHOOT!!!", Log.LEVEL_DEBUG);
        startTime = System.currentTimeMillis();
        finished = false;
    }

    protected void execute() {
        ShooterPistonSubsystem.getInstance().unShoot();
        
        if(System.currentTimeMillis() - startTime > TIME){
            Log.log(this, "UN-SHOOT!!!", Log.LEVEL_DEBUG);
            ShooterPistonSubsystem.getInstance().shoot();
            finished = true;
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        ShooterPistonSubsystem.getInstance().shoot();        
    }

    protected void interrupted() {
        end();
    }
}
