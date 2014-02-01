package edu.arhs.team1100.aerialassist.commands.drive;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;

/**
 * @author Team 1100
 */
public class ReverseDirectionCommand extends CommandBase {


    /**
     * Auto Aims the robot
     */
    public ReverseDirectionCommand() {
        requires(DriveSubsystem.getInstance());
        DriveSubsystem.getInstance().toggleReverseDirection();
    }

    /**
     * Initializes timeout to duration
     */
    protected void initialize() {
       
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        
    }

    protected void interrupted() {
        end();
    }
}
