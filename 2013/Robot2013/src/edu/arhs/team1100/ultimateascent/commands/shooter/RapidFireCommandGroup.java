package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author Team 1100
 */
public class RapidFireCommandGroup extends CommandGroup {

    /**
     * Constructs a ShootFrisbeeCommand and WaitCommand objects
     */
    public RapidFireCommandGroup() {
        addSequential(new ShootFrisbeeCommand());
        addSequential(new WaitCommand(0.7));
        this.setInterruptible(false);
    }
}
