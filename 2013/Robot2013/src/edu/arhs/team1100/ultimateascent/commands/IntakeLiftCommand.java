package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;

/**
 * @author Team 1100
 */
public class IntakeLiftCommand extends CommandBase {

    private boolean isFinished;
    /**
     * Constructs a IntakeLiftCommand
     */
    public IntakeLiftCommand() {
        requires(IntakeSubsystem.getInstance());
    }
    
   

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        isFinished = false;
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {  
        if(!isFinished){
            IntakeSubsystem.getInstance().pistonLift();
            isFinished = true;
        }
    }
    

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return isTimedOut()
     */
    protected boolean isFinished() {
        return isFinished;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
        if(!isFinished){
            execute();
        }
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
