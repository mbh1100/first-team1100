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
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.subsystems.CameraSubsystem;


/**
 *
 * @author Team 1100
 */
public class OneBallAutonomous extends CommandGroup {

    /**
     * Fires one ball. WIll test first to see if drive mode is mechanum or tank,
     * then will test/wait for hot goal, then fire.
     *
     * @param speed = speed of wheels from -1 to 1
     * @param duration = duration of movement
     */
    public void OneBallCommand(double speed, double duration) {

        //Tests drive mode, then moves forward
        if (DriveSubsystem.getInstance().getDriveMode() == DriveSubsystem.MODE_TANK) {
            addSequential(new DriveInTankCommand(speed, speed, duration));
        }//else: run same thing for mehcanum

        //Put camera code here after, instead of true ;)
        if (CameraSubsystem.getInstance().seeHotGoal()){
            addSequential(new FireShooterCommand());
        } else {
            addSequential(new WaitCommand(5000));
            addSequential(new FireShooterCommand());
        }
    }
}
