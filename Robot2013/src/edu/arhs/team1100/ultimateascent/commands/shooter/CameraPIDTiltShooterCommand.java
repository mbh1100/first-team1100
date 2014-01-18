package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.arhs.team1100.ultimateascent.util.DSPID;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 * @author Team 1100
 */
public class CameraPIDTiltShooterCommand extends CommandBase {

    private double offset = 0.074;//ds = 0.074
    private boolean tracking;
    
    public CameraPIDTiltShooterCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        tracking = true;
        ShooterTiltSubsystem.getInstance().setCameraMode(true);
        ShooterTiltSubsystem.getInstance().setInputRange(-1.0, 1.0);
        ShooterTiltSubsystem.getInstance().setPercentTolerance(5.0);//5 %
      //  DSPID.setPIDFromDS(ShooterTiltSubsystem.getInstance().getPIDController());
       // offset = DriverStation.getInstance().getAnalogIn(4);
        ShooterTiltSubsystem.getInstance().setSetpoint(0.0);
        ShooterTiltSubsystem.getInstance().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(!tracking){
            return;
        }
        DSLog.log(5, "");
        Log.log(this, "PID", Log.LEVEL_DEBUG);
        //DSPID.setPIDFromDS(ShooterTiltSubsystem.getInstance().getPIDController());
        //offset = DriverStation.getInstance().getAnalogIn(4);
        ShooterTiltSubsystem.getInstance().setSetpoint(-offset);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        ShooterTiltSubsystem.getInstance().getPIDController().reset();
        ShooterTiltSubsystem.getInstance().stop();
        ShooterTiltSubsystem.getInstance().disable();
        ShooterTiltSubsystem.getInstance().setCameraMode(false);
    }
    
        public void stopTracking() {
        tracking = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
