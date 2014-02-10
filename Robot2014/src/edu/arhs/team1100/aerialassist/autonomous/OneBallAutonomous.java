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
import edu.wpi.first.wpilibj.Timer;



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

        if (CameraSubsystem.getInstance().isHot()){
            addSequential(new FireShooterCommand());
        }
        else
        {
            Timer.delay(5);
            addSequential(new FireShooterCommand());
        }
        
        //drive forward into point zone
    }
}
