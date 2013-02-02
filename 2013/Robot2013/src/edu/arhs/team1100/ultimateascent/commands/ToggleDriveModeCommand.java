/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author Team 1100
 */
public class ToggleDriveModeCommand extends CommandBase {
    
    private boolean finished = false;

    protected void initialize() {
        finished = false;
    }

    protected void execute() {
        DriveSubsystem.getInstance().toggleDriveMode();
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
