package edu.arhs.team1100.aerialassist.commands.cameracommands;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.commands.CommandBase;
import edu.arhs.team1100.aerialassist.subsystems.CameraSubsystem;

/**
 * @author Team 1100
 */
public class AutoAimCommand extends CommandBase {


    /**
     * Auto Aims the robot
     */
    public AutoAimCommand() {
        requires(CameraSubsystem.getInstance());
        CameraSubsystem.getInstance().autoAim();
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
