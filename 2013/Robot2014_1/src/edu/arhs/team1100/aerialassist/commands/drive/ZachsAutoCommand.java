/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.commands.drive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.arhs.team1100.aerialassist.commands.DriveInALineCommand;
import edu.arhs.team1100.aerialassist.commands.DriveInTankCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.commands.StopDriveCommand;

/**
 * @author Team 1100's Resident Soon to be no Afro (Zach)
 */
public class ZachsAutoCommand extends CommandGroup {

    /**
     * Drives to the left, then in a circle, then un-does its actions.
     * Then, it will drive in 5 boxes.
     * AFter, it will do some spazzy tank drive.
     */
    public ZachsAutoCommand(double speed, double duration){
        addSequential(new DriveInALineCommand(speed, DriveSubsystem.getInstance().DIRECTION_LEFT, duration));
        addSequential(new DriveInTankCommand(speed, -speed, duration));
        addSequential(new StopDriveCommand(1));
        addSequential(new DriveInTankCommand(-speed, speed, duration));
        addSequential(new DriveInALineCommand(speed, DriveSubsystem.getInstance().DIRECTION_RIGHT, duration));
        for(int i=0; i<5; i++){
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.getInstance().DIRECTION_FORWARD, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.getInstance().DIRECTION_RIGHT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.getInstance().DIRECTION_BACK, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.getInstance().DIRECTION_LEFT, duration));
        }
        for(int i=0; i<2; i++){
        addSequential(new DriveInTankCommand(speed, speed/2, duration));
        addSequential(new DriveInTankCommand(-speed, -speed/2, duration));
        }
        addSequential(new StopDriveCommand(1));
        for(int i=0; i<2; i++){
        addSequential(new DriveInTankCommand(-speed, -speed/2, duration));
        addSequential(new DriveInTankCommand(speed, speed/2, duration));
        }
        addSequential(new DriveInTankCommand(speed, -speed, duration));
        
    }
}
           
