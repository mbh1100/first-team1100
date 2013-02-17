package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.drive.StopDriveCommand;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Akshay
 */
public class DriveInASquareCommandGroup extends CommandGroup {

    /**
     *
     * @param speed speed of wheels
     * @param duration length in second for entire command
     */
    /**
     * drives robot in a square
     *
     * @param speed
     * @param duration
     */
    public DriveInASquareCommandGroup(double speed, double duration) {
        addSequential(new DriveInALineCommand((speed * 2), DriveSubsystem.DIRECTION_LEFT, duration / 4));
        addSequential(new StopDriveCommand(0.5));
        addSequential(new DriveInALineCommand(speed, 0, duration / 4));
        addSequential(new StopDriveCommand(0.5));
        addSequential(new DriveInALineCommand(speed, DriveSubsystem.DIRECTION_RIGHT, duration / 4));
        addSequential(new StopDriveCommand(0.5));
        addSequential(new DriveInALineCommand((speed * 2), 180, duration / 4));
    }
}
