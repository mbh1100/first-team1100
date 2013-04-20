/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;

/**
 *
 * @author Aditya
 */
public class CameraPIDTASTICTiltCommand extends CommandBase {

    private final double OFFSET = 0.3;
    private double setpoint = 0;
    private boolean tracking;

    public CameraPIDTASTICTiltCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().setCameraMode(false);
        setpoint = ShooterTiltSubsystem.getInstance().getAngle();
        ShooterTiltSubsystem.getInstance().setSetpoint(setpoint);
        ShooterTiltSubsystem.getInstance().enable();
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
        setpoint += error / 100;
        ShooterTiltSubsystem.getInstance().setSetpoint(setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        ShooterTiltSubsystem.getInstance().stop();
        ShooterTiltSubsystem.getInstance().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
