/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 *
 * @author akshay
 */
public class TiltShooterPIDCommand extends CommandBase {
    
    private final double LEVEL = 0.35;
    
    private double setpoint = 0;
    
    public TiltShooterPIDCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().setCameraMode(false);
        ShooterTiltSubsystem.getInstance().setInputRange(0.0, 5.0);
        ShooterTiltSubsystem.getInstance().setPercentTolerance(5.0);
        
        setpoint = ShooterTiltSubsystem.getInstance().getAngle();
        ShooterTiltSubsystem.getInstance().setSetpoint(setpoint);
        ShooterTiltSubsystem.getInstance().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double delta = -OI.getInstance().getXboxController().getAxis(AxisType.kY);
        setpoint += delta/100;
        Log.log(this, Log.round(setpoint, 3)+ ", " + Log.round(ShooterTiltSubsystem.getInstance().getAngle(), 3), Log.LEVEL_DEBUG);
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
