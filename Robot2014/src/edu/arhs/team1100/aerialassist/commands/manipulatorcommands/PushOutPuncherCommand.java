package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;

/**
 *
 * @author Team 1100
 */
public class PushOutPuncherCommand extends CommandBase {

    private boolean finished = false;

    /**
     * Initializes the shooter
     */
    protected void initialize() {
        finished = false;
    }

    /**
     * Toggles drive mode and turns finish to true
     */
    protected void execute() {
        try {
            ShooterSubsystem.getInstance().resetCylindersPartB();
        } catch (DriverStationEnhancedIO.EnhancedIOException ex) {
            ex.printStackTrace();
        }
        finished = true;
    }

    /**
     * Returns whether toggling has occurred
     *
     * @return finished
     */
    protected boolean isFinished() {
        return finished;
    }

    /**
     * Toggles drive mode if it has not finished
     */
    protected void end() {
        if (!finished) {
            execute();
        }
    }

    /**
     * Toggles drive mode if interrupted
     */
    protected void interrupted() {
        end();
    }
}
