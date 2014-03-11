/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.commands.useless;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInALineCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInTankCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;

/**
 * @author Teamm 1100
 */
public class ThomasAutonomousCommand extends CommandGroup {
 
    /**
     * WARNING!!!
     * THIS IS CODE BY THOMAS, WITH NO IDEA WHAT THE COMMANDS DO!!!!
     * WHATEVER YOU DO, DO NOT RUN THIS COMMAND WITHOUT SAFETY PRECAUTIONS
     * SAFTEY PRECAUTIONS INCLUDE: Safety glasses, Fire extinguisher, Anti-aircraft missiles,
     * Medics, fallout shelter, and any other supplies deemed necessary. And the E-stop button.
     */
    public ThomasAutonomousCommand(double speed, double duration){
      /*  for(int i = 0; i < 6; i++) {
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_LEFT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_BACK, duration * 2));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_FORWARD, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_FORWARD, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_LEFT, duration));
		}
        for(int i = 0; i < 6; i++) {
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_BACK, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_LEFT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_BACK, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_LEFT, duration));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_FORWARD, duration * 2));
            addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration));
        } */
    }
}
           
