package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;

/**
 * @author Team 1100
 */
public class IntakeRollerCommand extends CommandBase {
    
    private boolean useTime = false;
    private float time;
    boolean started;
    /**
     * Constructs a IntakeRollerCommand
     */
    public IntakeRollerCommand() {
        useTime = false;
        
        requires(IntakeSubsystem.getInstance());
    }
    
    public IntakeRollerCommand(float t){
        this();
        useTime = true;
        time = t;
        
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        boolean isReverse = OI.getInstance().getXboxController().getButtonBack().get();
       if(!useTime){
            IntakeSubsystem.getInstance().roll(isReverse);
       } else {       
           started = false;
            setTimeout(time);
        }
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        
        if (useTime && !started && timeSinceInitialized() > 1.0) {
            started = true;
            IntakeSubsystem.getInstance().roll(false);            
        }        
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return isTimedOut()
     */
    protected boolean isFinished() {
        if(useTime){
            return isTimedOut();
        } else {
            return false;
        }
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        IntakeSubsystem.getInstance().stopRollers();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
