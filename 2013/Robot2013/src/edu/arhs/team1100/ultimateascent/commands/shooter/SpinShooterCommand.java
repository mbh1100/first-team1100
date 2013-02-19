/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;

/**
 *
 * @author akshay
 */
public class SpinShooterCommand extends CommandBase {
    
    private double speed = 0.0;
    
    public SpinShooterCommand(double speed) {
        requires(ShooterWheelSubsystem.getInstance());
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ShooterWheelSubsystem.getInstance().setSpeed(speed);
                
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        ShooterWheelSubsystem.getInstance().setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
