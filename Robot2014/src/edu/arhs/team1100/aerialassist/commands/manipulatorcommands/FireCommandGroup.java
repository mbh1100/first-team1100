/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.util.DSLog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author ryanfite
 */
public class FireCommandGroup extends CommandGroup {

    private double delayOne = .6; // 0.6 second delay before reseting shooter
    private double delayTwo = 8;
    private double delayThree = 0.3;  //1300 far back  //1pointgoal 840 //1behing 1270 //

    public FireCommandGroup() {
        DSLog.log(6, "Firing..");
        addSequential(new FireShooterCommand(), delayOne);
        DSLog.log(6, "Pulling Cylinders Back..");
        addSequential(new ResetCylindersPartACommand(), delayTwo);
        DSLog.log(6, "Clamping..");
        addSequential(new ResetHoldersCommand(), delayThree);
        DSLog.log(6, "Reseting Cylinder Pressure..");
        addSequential(new ResetCylindersPartBCommand());
        DSLog.log(6, "Shooter Reset");
    }
}
