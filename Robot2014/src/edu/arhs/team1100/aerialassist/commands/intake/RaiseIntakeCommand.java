package edu.arhs.team1100.aerialassist.commands.intake;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.IntakeSubsystem;

/**
 *
 * @author Team 1100
 */
public class RaiseIntakeCommand extends CommandBase {

    /**
     * Constructs a DriveSubsystem object
     */
    public RaiseIntakeCommand() {
        requires(IntakeSubsystem.getInstance());
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
        IntakeSubsystem.getInstance().setPostitionIn();
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
