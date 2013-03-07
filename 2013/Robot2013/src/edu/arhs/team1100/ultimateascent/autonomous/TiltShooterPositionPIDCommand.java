/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 * @author Aditya
 */
public class TiltShooterPositionPIDCommand extends CommandBase {

    private double targetAngle = ShooterTiltSubsystem.FLAT_ANGLE;

    public TiltShooterPositionPIDCommand() {
        requires(ShooterTiltSubsystem.getInstance());
        targetAngle = getDSSetpoint();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        targetAngle = getDSSetpoint();
        ShooterTiltSubsystem.getInstance().disable();
        ShooterTiltSubsystem.getInstance().setCameraMode(false);
        ShooterTiltSubsystem.getInstance().setInputRange(0.0, 5.0);
        ShooterTiltSubsystem.getInstance().setPercentTolerance(5.0);
        ShooterTiltSubsystem.getInstance().setSetpoint(targetAngle);
        ShooterTiltSubsystem.getInstance().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        targetAngle = getDSSetpoint();
        ShooterTiltSubsystem.getInstance().setSetpoint(targetAngle);
        DSLog.log(5, "Setpoint value : " + targetAngle);
    }
    
    double getDSSetpoint(){        
        double s = DriverStation.getInstance().getAnalogIn(1);        
        return Math.min(3.5, Math.max(1.0, s));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        ShooterTiltSubsystem.getInstance().disable();
        ShooterTiltSubsystem.getInstance().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
