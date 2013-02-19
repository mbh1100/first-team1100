package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author akshay
 */
public class RapidFireCommandGroup extends CommandGroup {
    /**
     * Constructs a ShootFrisbeeCommand and WaitCommand objects
     */
    public RapidFireCommandGroup(){
            addSequential(new ShootFrisbeeCommand());
            addSequential(new WaitCommand(0.5));           
            this.setInterruptible(false);
    }

}
