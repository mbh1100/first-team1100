package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Team 1100
 */
public class TiltShooterPIDBrakeCommand extends CommandBase {

    private double DEAD = 0.1;
    private boolean isBrakeOn = false;
    private double setpoint = 0.0;

    public TiltShooterPIDBrakeCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().setCameraMode(false);
        ShooterTiltSubsystem.getInstance().setInputRange(0.0, 5.0);
        ShooterTiltSubsystem.getInstance().setPercentTolerance(5.0);
        setpoint = ShooterTiltSubsystem.getInstance().getAngle();
        ShooterTiltSubsystem.getInstance().setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kY);
        if (Math.abs(speed) <= DEAD && !isBrakeOn) { //depends on deadband set in OI
            isBrakeOn = true;
            setpoint = ShooterTiltSubsystem.getInstance().getAngle();
            ShooterTiltSubsystem.getInstance().setSetpoint(setpoint);
            ShooterTiltSubsystem.getInstance().enable();
            Log.log(this, "Brake enabled at setpoint " + setpoint, Log.LEVEL_DEBUG);
        } else { // regular movemnt
            if (isBrakeOn) {
                isBrakeOn = false;
                ShooterTiltSubsystem.getInstance().disable();
                ShooterTiltSubsystem.getInstance().stop();
                Log.log(this, "Brake disabled, operator control", Log.LEVEL_DEBUG);
            }
            ShooterTiltSubsystem.getInstance().doTilt();
        }
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