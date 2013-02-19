package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author akshay
 */
public class RapidFireFrisbeesCommandGroup extends CommandGroup {
    
    public RapidFireFrisbeesCommandGroup(){
            addSequential(new ShootFrisbeeCommand());
            addSequential(new WaitCommand(0.5));           
            this.setInterruptible(false);
    }

}
