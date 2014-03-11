/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.autonomous;

import edu.arhs.team1100.aerialassist.commands.drive.DriveInALineCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInMecCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireCommandGroup;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.RollInCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Thomas
 */
public class TwoBallAutonomous extends CommandGroup {
    public TwoBallAutonomous() {
        //one ball auto
    //   addSequential(new DriveInALineCommand(.5, DriveSubsystem.DIRECTION_FORWARD, 1));
       addParallel(new SetArmFirePositionA());
       addSequential(new FireCommandGroup());
    }
}
