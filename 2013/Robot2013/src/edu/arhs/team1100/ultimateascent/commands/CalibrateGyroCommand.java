package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author Team 1100
 */
public class CalibrateGyroCommand extends CommandBase {
    
    private boolean finished = false;

    protected void initialize() {
    }

    protected void execute() {
        DriveSubsystem.getInstance().calibrateGyro();
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
