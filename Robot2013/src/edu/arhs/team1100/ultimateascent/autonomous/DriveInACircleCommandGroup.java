package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.drive.StopDriveCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Team1100
 */
public class DriveInACircleCommandGroup extends CommandGroup {

    /**
     * Makes the robot move in a circle
     *
     * @param speed speed of wheels
     * @param duration total duration of entire movement in second
     * @param rotations number of how many times the angle moves e.g. input 8
     * would make a octagon
     */
    public DriveInACircleCommandGroup(double speed, double duration, double rotations) {

        for (int angle = 0; angle <= 360; angle += 360 / rotations) {
            addSequential(new DriveInALineCommand(speed, angle, duration / rotations));
        }
        addSequential(new StopDriveCommand(0.5));

    }
}