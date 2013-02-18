/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author akshay
 */
public class ShootAllFrisbeesCommandGroup extends CommandGroup {
    
    public ShootAllFrisbeesCommandGroup(){
        for(int i = 0; i < 4 /*NUMBEr OF FRISBEES*/; i++){
            addSequential(new ShootFrisbeeCommand());
            addSequential(new WaitCommand(0.5));
            
        }
    }

}
