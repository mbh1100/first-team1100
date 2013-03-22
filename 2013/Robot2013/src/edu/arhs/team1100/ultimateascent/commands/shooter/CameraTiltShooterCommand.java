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
 * @author Akshay
 */
public class CameraTiltShooterCommand extends CommandBase {
    
    private final double SETPOINT = 0.1;
    
    public CameraTiltShooterCommand() {
       requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().disable();
        ShooterTiltSubsystem.getInstance().stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double y = Camera.getInstance().getCenterY();
        double error = y - SETPOINT;
        if(error > 0){
            ShooterTiltSubsystem.getInstance().tilt(error/2);
        } else if(error < 0){
            ShooterTiltSubsystem.getInstance().tilt(error/2);
        }
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
