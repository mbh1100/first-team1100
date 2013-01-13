/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Team 1100
 */
public class MecanumCommand extends CommandBase {
    
    public MecanumCommand(){
        System.out.println("MecanumCommand Constructor");
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
    }

    protected void interrupted() {
    }
    
}
