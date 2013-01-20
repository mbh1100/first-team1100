/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author Akshay
 */
public class CalibrateDirectionCommand extends CommandBase {
    
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
    }

    protected void interrupted() {
    }
    
}
