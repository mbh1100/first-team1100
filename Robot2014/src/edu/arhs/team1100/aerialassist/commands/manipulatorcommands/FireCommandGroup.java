/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.commands.manipulatorcommands;

import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author ryanfite
 */
public class FireCommandGroup extends CommandGroup {
    private double delayOne = .6; // 0.6 second delay before reseting shooter
    private double delayTwo = 1.7;
    private double delayThree = 0.3;
    
        
    public FireCommandGroup() {
        addSequential(new FireShooterCommand(), delayOne);
        addSequential(new ResetCylindersPartACommand(), delayTwo);
        addSequential(new ResetHolders(), delayThree);
        addSequential(new ResetCylindersPartBCommand());
    }
}
