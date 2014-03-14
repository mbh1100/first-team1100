/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.commands.useless;

import edu.arhs.team1100.aerialassist.commands.useless.ThomasAutonomousCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInALineCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInTankCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;

/**
 * @author Team 1100's Resident Soon to be no Afro (Zach)
 */
public class ZachsAutoCommand extends CommandGroup {

    /**
     * Drives to the left, then in a circle, then un-does its actions. Then, it
     * will drive in 5 boxes. After, it will do some spazzy tank drive.
     * @param speed Motor speed, from -1 to 1 (0 is stop)
     * @param duration Length in seconds each sequence will run (The full command will run 33 times the duration, or 61 times if running thomasScript)
     * @param thomasScript Whether or not to run Thomas|AutonomousCommand after running the ZachAutoCommand (adds 28 times the duration in seconds to runtime)
     */
    public ZachsAutoCommand(double speed, double duration, boolean thomasScript) {
        //addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_LEFT, duration));
        addSequential(new DriveInTankCommand(speed, -speed, duration));
        addSequential(new StopDriveCommand());
        addSequential(new DriveInTankCommand(-speed, speed, duration));
    //    addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration));
        
        for (int i = 0; i < 5; i++) {
            /*addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_FORWARD, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_BACK, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_LEFT, duration));*/
        }
        
        for (int i = 0; i < 2; i++) {
            addSequential(new DriveInTankCommand(speed, speed / 2, duration));
            addSequential(new DriveInTankCommand(-speed, -speed / 2, duration));
        }
        addSequential(new StopDriveCommand());
        
        for (int i = 0; i < 2; i++) {
            addSequential(new DriveInTankCommand(-speed, -speed / 2, duration));
            addSequential(new DriveInTankCommand(speed, speed / 2, duration));
        }
        addSequential(new DriveInTankCommand(speed, -speed, duration));
		
		if(thomasScript){
			addSequential(new ThomasAutonomousCommand(speed, duration));
		}
    }
}
