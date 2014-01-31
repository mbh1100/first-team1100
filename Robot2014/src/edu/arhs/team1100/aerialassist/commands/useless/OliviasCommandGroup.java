package edu.arhs.team1100.aerialassist.commands.useless;


import edu.arhs.team1100.aerialassist.commands.drive.DriveInMecCommand;
import edu.arhs.team1100.aerialassist.commands.drive.DriveInTankCommand;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team 1100
 */
public class OliviasCommandGroup extends CommandGroup {

    /**
     * Drives robot in a square
     *
     * @param speed speed of wheels
     * @param duration length in second for entire command
     */
    public OliviasCommandGroup() {
        DriveSubsystem.getInstance().setDriveMode(DriveSubsystem.MODE_TANK);
        addSequential(new DriveInTankCommand(.5, .5, 0.5));
        addSequential(new DriveInTankCommand(.25, .5, 0.25));
        addSequential(new DriveInTankCommand(.5, .25, .5));
        DriveSubsystem.getInstance().setDriveMode(DriveSubsystem.MODE_CARTESIAN);
        addSequential(new DriveInMecCommand(.7, DriveSubsystem.DIRECTION_RIGHT, .5, 0));
        
    }
}
