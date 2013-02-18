package edu.arhs.team1100.ultimateascent.commands.drive;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author Team 1100
 */
public class ToggleDriveModeCommand extends CommandBase {

    private boolean finished = false;

    //initializes the command
    protected void initialize() {
        finished = false;
    }
    //toggles drive modes
    protected void execute() {
        DriveSubsystem.getInstance().toggleDriveMode();
        finished = true;
    }
    
    //returns whether toggling has orrucred
    protected boolean isFinished() {
        return finished;
    }
    //toggles drive mode if it has no finished
    protected void end() {
        if (!finished) {
            execute();
        }
    }
    
    protected void interrupted() {
        end();
    }
}
