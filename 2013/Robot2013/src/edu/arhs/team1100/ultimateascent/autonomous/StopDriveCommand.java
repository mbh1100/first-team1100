/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author ADITYA
 */
public class StopDriveCommand extends CommandBase {
    
    double duration;
    
    public StopDriveCommand(double duration){
        requires(DriveSubsystem.getInstance());
        this.duration = duration;
    }

    protected void initialize() {
        setTimeout(duration);
    }

    protected void execute() {
        DriveSubsystem.getInstance().stop();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();
    }

    protected void interrupted() {
        end();
    }
    
}
