package edu.arhs.team1100.aerialassist.commands.net;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.NetSubsystem;


/**
 *
 * @author Team 1100
 */
public class ToggleNetCommand extends CommandBase {

    /**
     * Constructs a NetSubystem object
     */
    public ToggleNetCommand() {
        requires(NetSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        NetSubsystem.getInstance().toggleNet();
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
        
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
