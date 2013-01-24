/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Akshay
 */
public class DriveInASquareCommandGroup extends CommandGroup {
    
    public DriveInASquareCommandGroup(double speed, double duration){
        addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_LEFT, duration/4));
        addSequential(new StopDriveCommand(0.5));
        addSequential(new DriveInALineCommand(speed, 0, duration/4));
        addSequential(new StopDriveCommand(0.5));
        addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration/4));
        addSequential(new StopDriveCommand(0.5));
        addSequential(new DriveInALineCommand(speed, 180, duration/4));
    }
    
}