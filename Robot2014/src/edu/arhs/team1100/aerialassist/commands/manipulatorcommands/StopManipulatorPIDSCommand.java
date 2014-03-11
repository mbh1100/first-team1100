package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;


/**
 *
 * @author Team 1100
 */
public class StopManipulatorPIDSCommand extends CommandBase {
    private boolean finished = false;

    /**
     * Constructs a DriveSubsystem object
     */
    public StopManipulatorPIDSCommand() throws DriverStationEnhancedIO.EnhancedIOException {
        requires(ManipulatorSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        finished = false;
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
            ManipulatorSubsystem.getInstance().disable();
            finished = true;
        }
    

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return finished;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
         if (!finished) {
            execute();
        }
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
