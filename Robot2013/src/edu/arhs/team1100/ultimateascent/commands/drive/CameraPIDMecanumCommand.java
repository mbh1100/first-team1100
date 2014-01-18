/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands.drive;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.DSPID;

/**
 *
 * @author Team 1100
 */
public class CameraPIDMecanumCommand extends CommandBase {

    /**
     *
     */
    public CameraPIDMecanumCommand() {
        requires(DriveSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        DriveSubsystem.getInstance().setCameraMode(true);
        DriveSubsystem.getInstance().setInputRange(-1.0, 1.0);
        DriveSubsystem.getInstance().setPercentTolerance(5.0); //10 percent tolerance
        DriveSubsystem.getInstance().setSetpoint(0.0);
        DriveSubsystem.getInstance().enable();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        DSPID.setPIDFromDS(DriveSubsystem.getInstance().getPIDController());
        DSLog.log(5, "Camera PID");
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return false
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        DriveSubsystem.getInstance().disable();
        DriveSubsystem.getInstance().stop();
        Camera.getInstance().free();
        DSLog.log(5, "");
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
