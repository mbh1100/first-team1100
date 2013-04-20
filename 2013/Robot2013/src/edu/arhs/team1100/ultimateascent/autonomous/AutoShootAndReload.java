package edu.arhs.team1100.ultimateascent.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Team 1100
 */
public class AutoShootAndReload extends CommandGroup {

    public AutoShootAndReload() {
        addSequential(new AutoAimAndShootCommandGroup(3, 4));
        addSequential(new PickupAndLoadFrisbeesGroup(0.5, 0.0, 5));
        addSequential(new AutoAimAndShootCommandGroup(2, 4));
        addSequential(new PickupAndLoadFrisbeesGroup(0.5, 0.0, 5));
        addSequential(new AutoAimAndShootCommandGroup(2, 4));
    }
}
