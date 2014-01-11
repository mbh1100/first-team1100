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

/**
 * @author Team 1100's Resident Afro (Zach)
 */
public class ZachsAutoCommand extends CommandGroup {

    /**
     * Drives to the left, then in a circle, then un-does its actions.
     * Then, it will drive in 5 boxes.
     */
    public ZachsAutoCommand(){
        addSequential(new DriveInALineCommand(.4, DriveSubsystem.getInstance().DIRECTION_LEFT, 5));
        addSequential(new DriveInTankCommand(.4, -.4, 5));
        addSequential(new DriveInTankCommand(-.4, .4, 5));
        addSequential(new DriveInALineCommand(.4, DriveSubsystem.getInstance().DIRECTION_RIGHT, 5));
        for(int i=0; i<5; i++){
        addSequential(new DriveInALineCommand(.4, DriveSubsystem.getInstance().DIRECTION_FORWARD, 5));
        addSequential(new DriveInALineCommand(.4, DriveSubsystem.getInstance().DIRECTION_RIGHT, 5));
        addSequential(new DriveInALineCommand(.4, DriveSubsystem.getInstance().DIRECTION_BACK, 5));
        addSequential(new DriveInALineCommand(.4, DriveSubsystem.getInstance().DIRECTION_LEFT, 5));
    }
    }
}
           
