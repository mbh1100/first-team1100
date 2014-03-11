/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInALineCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInTankCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireCommandGroup;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.ResetCylindersPartBCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.SetArmFirePositionOneRobotBehindOnePointGoal;
import edu.arhs.team1100.aerialassist.subsystems.CameraSubsystem;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;



/**
 *
 * @author Team 1100
 */
public class OneBallAutonomous extends CommandGroup {

    /**
     * Fires one ball. WIll test first to see if drive mode is mechanum or tank,
     * then will test/wait for hot goal, then fire.
     *
     */
    public void OneBallCommand() throws DriverStationEnhancedIO.EnhancedIOException {
         System.out.println("Auto go");
         addSequential(new ResetCylindersPartBCommand(), .1);
         addParallel(new DriveInALineCommand(8000));
         addParallel(new SetArmFirePositionOneRobotBehindOnePointGoal());
         addSequential(new FireCommandGroup());
      }
}
    