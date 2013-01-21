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
public class MecanumCommand extends CommandBase {
    
    public MecanumCommand(){
        requires(DriveSubsystem.getInstance());
    }

    protected void initialize() {
       // requires(DriveSubsystem.getInstance());     
    }

    protected void execute() {
        DriveSubsystem.getInstance().mecanumDrive();        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();
    }

    protected void interrupted() {
        end();
    }
    
}
