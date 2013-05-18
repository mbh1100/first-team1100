/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.util.*;

/**
 *
 * @author Team 1100
 */
public class CameraTiltShooterCommand extends CommandBase {

    private final double OFFSET = 0.0;
    private final double RATIO = .50;
    private boolean tracking;

    public CameraTiltShooterCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().disable();
        ShooterTiltSubsystem.getInstance().stop();
        tracking = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!tracking) {
            ShooterTiltSubsystem.getInstance().stop();
            return;
        }
        double y = Camera.getInstance().getCenterY();
        double error = y - OFFSET;
        error = Math.min(1.0, Math.max(-1.0, error));
        //DSLog.log(5, "Err*rat: " + error * RATIO);
        ShooterTiltSubsystem.getInstance().tilt(error * RATIO);

    }

    public void stopTracking() {
        tracking = false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
