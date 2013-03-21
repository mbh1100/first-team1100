/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 *
 * @author akshay
 */
public class TiltShooterPIDCommand extends CommandBase {
    
    private final double LEVEL = 0.35; //potentiometer value at which tilt is straight
    
    private double setpoint = 0;
    
    public TiltShooterPIDCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().setCameraMode(false);
            //ShooterTiltSubsystem.getInstance().setInputRange(0.0, 5.0);
        ShooterTiltSubsystem.getInstance().setPercentTolerance(5.0);
        
        setpoint = ShooterTiltSubsystem.getInstance().getAngle();
        ShooterTiltSubsystem.getInstance().setSetpoint(setpoint);
        ShooterTiltSubsystem.getInstance().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double delta = -OI.getInstance().getXboxController().getAxis(AxisType.kY);
        
        setpoint += delta/100;
        if(setpoint > 3.5){
            setpoint = 3.5;
            
        } else if(setpoint < 1.0){
            setpoint = 1.0;
        }
        ShooterTiltSubsystem.getInstance().setSetpoint(setpoint);
        Log.log(this, "tilting.." + setpoint, Log.LEVEL_DEBUG);
        DSLog.log(5, "Tilting..." + setpoint);
                 
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
