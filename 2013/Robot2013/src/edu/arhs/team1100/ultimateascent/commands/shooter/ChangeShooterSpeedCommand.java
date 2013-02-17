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
public class ChangeShooterSpeedCommand extends CommandBase {
    
    private double delta = 0.0;    
    private boolean finished = false;
    
    public ChangeShooterSpeedCommand(double d) {
        requires(ShooterWheelSubsystem.getInstance());
        delta = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ShooterWheelSubsystem.getInstance().changeSpeed(delta);
        finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        if(!finished){
            execute();
        }
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
