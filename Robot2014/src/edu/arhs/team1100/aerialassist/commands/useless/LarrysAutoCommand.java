/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.commands.useless;

import edu.arhs.team1100.aerialassist.commands.drive.DriveInTankCommand;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Stupid command sample code to make robot do something.
 *
 * @author  Larry Tambascio
 */
public class LarrysAutoCommand extends CommandGroup
{
    
    /**
     * Constructor that initializes the steps.
     */
    public LarrysAutoCommand()
    {
        addSequential(new DriveInTankCommand(0.5, 0.5, 2));
        addSequential(new DriveInTankCommand(0.25, -0.25, 2));
        addSequential(new DriveInTankCommand(-0.5, -0.5, 2));
        addSequential(new StopDriveCommand());
    }
}
