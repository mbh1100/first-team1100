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

    /**
     * Constructs a ShooterSubsystem object
     */
    public ShootFrisbeeCommand() {
        requires(ShooterPistonSubsystem.getInstance());
        this.setInterruptible(false);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        startTime = System.currentTimeMillis();
        finished = false;
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        ShooterPistonSubsystem.getInstance().unShoot();
        if (System.currentTimeMillis() - startTime >= TIME) {
            ShooterPistonSubsystem.getInstance().shoot();
            finished = true;
        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return finished
     */
    protected boolean isFinished() {
        return finished;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        ShooterPistonSubsystem.getInstance().shoot();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
