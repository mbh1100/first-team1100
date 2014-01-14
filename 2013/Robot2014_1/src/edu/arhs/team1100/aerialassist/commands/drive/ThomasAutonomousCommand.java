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
 * @author Thomas
 */
public class ThomasAutonomousCommand extends CommandGroup {

    /**
     * WARNING!!!
     * THIS IS CODE BY THOMAS, WITH NO IDEA WHAT THE COMMANDS DO!!!!
     * WHATEVER YOU DO, DO NOT RUN THIS COMMAND WITHOUT SAFETY PRECAUTIONS
     * SAFTEY PRECAUTIONS INCLUDE: Safety glasses, Fire extinguisher, Anti-aircraft missiles,
     * Medics, fallout shelter, and any other supplies deemed necessary.
     */
    public ThomasAutonomousCommand(){
        for(int i = 0; i < 6; i++) {
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_LEFT, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_BACK, 10));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_RIGHT, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_FORWARD, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_RIGHT, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_FORWARD, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_LEFT, 5));
        }
        for(int i = 0; i < 6; i++) {
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_RIGHT, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_BACK, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_LEFT, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_BACK, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_LEFT, 5));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_FORWARD, 10));
            addSequential(new DriveInALineCommand(.6, DriveSubsystem.getInstance().DIRECTION_RIGHT, 5));
        }
    }
}
           
