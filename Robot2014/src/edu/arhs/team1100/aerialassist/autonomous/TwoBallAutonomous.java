/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.autonomous;

import edu.arhs.team1100.aerialassist.commands.drive.DriveInMecCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.RollInCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Thomas
 */
public class TwoBallAutonomous extends CommandGroup {
    public TwoBallAutonomous() {
        /*
         * 
         * Detect hot goal
         * Orientate towards the hot goal
         * Shoot first ball towards hot goal
         * Pick up second ball
         * Shot second ball towards hot goal
         * Move forwards
         * 
         */
        
        //True will be replace with camera detection method
        boolean hotInFront = true;
       /** 
        if(hotInFront) {
            addSequential(new FireShooterCommand());
            addSequential(new DriveInMecCommand(0.5, DriveSubsystem.DIRECTION_BACK, 1.5, 0));
            addSequential(new RollInCommand());
            addSequential(new DriveInMecCommand(0.5, 0, 1.5, 1));
            addSequential(new FireShooterCommand());
            addSequential(new DriveInMecCommand(0.5, DriveSubsystem.DIRECTION_FORWARD, 3, 0));
        } else {
            addSequential(new DriveInMecCommand(0.5, 0, 1.5, 1));
            addSequential(new FireShooterCommand());
            addSequential(new DriveInMecCommand(0.5, 0, 1.5, -1));
            addSequential(new DriveInMecCommand(0.5, DriveSubsystem.DIRECTION_BACK, 1.5, 0));
            addSequential(new RollInCommand());
            addSequential(new FireShooterCommand());
            addSequential(new DriveInMecCommand(0.5, DriveSubsystem.DIRECTION_FORWARD, 3, 0));
        }
        * */
    }
}
