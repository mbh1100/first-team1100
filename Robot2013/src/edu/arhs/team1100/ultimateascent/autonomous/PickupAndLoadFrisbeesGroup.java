package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.IntakeLiftCommand;
import edu.arhs.team1100.ultimateascent.commands.IntakeRollerCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Team 1100
 */
public class PickupAndLoadFrisbeesGroup extends CommandGroup {

    public PickupAndLoadFrisbeesGroup(double speed, double direction, double duration) {
        addSequential(new IntakeLiftCommand());
        addSequential(new DriveInALineCommand(speed, direction, duration));
        addSequential(new IntakeLiftCommand());
        addSequential(new IntakeRollerCommand(4));
    }
}
