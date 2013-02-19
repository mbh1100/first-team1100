package edu.arhs.team1100.ultimateascent.commands.shooter;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;

/**
 *
 * @author akshay
 */
public class TiltShooterCameraPIDCommand extends CommandBase {
    
     /**
     * Constructs a ShooterWheelSubsystem object
     */
    public TiltShooterCameraPIDCommand() {
        requires(ShooterTiltSubsystem.getInstance());
    }

    /**
    * Called just before this Command runs the first time
    */
    protected void initialize() {
        ShooterTiltSubsystem.getInstance().setInputRange(-1.0, 1.0);
        ShooterTiltSubsystem.getInstance().setAbsoluteTolerance(10.0);//10 %
        ShooterTiltSubsystem.getInstance().setSetpoint(0.0);        
        ShooterTiltSubsystem.getInstance().enable();
    }

   /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
    }

     /**
     * Make this return true when this Command no longer needs to run execute()
     * @return false
     */
    protected boolean isFinished() {
        return false;
    }

   /**
     * Called once after isFinished returns true
     */
    protected void end() {
        ShooterTiltSubsystem.getInstance().stop();
        ShooterTiltSubsystem.getInstance().disable();
    }

    /**
     * Called when another command which requires one or more of the same 
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
