/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;

/**
 *
 * @author Aditya
 */
public class IntakePositionCommand extends CommandBase {
    
    private boolean position;
    private boolean isFinished;
    
    public IntakePositionCommand(boolean pos) {
        requires(IntakeSubsystem.getInstance());
        
        position = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        IntakeSubsystem.getInstance().setPosition(position);
        isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
        if(!isFinished){
            execute();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
