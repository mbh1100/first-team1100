/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.util.ControllerState;

/**
 *
 * @author akshay
 */
public class PlayRecordedStateCommand extends CommandBase{
    
    private ControllerState[] state;
    private int index = 0;
    private long last = 0;
    private long interval = 0;
    
    public PlayRecordedStateCommand(ControllerState[] s, long interval){
        requires(DriveSubsystem.getInstance());
        state = s;        
        this.interval = interval;
    }

    protected void initialize() {
        index = 0;
        last = System.currentTimeMillis();
    }

    protected void execute() {
        long t = System.currentTimeMillis();
        if(index < state.length && t-last >= interval){
            last = t;
            DriveSubsystem.getInstance().mecanumDrive_Cartesian(state[index].X, state[index].Y, state[index].R);
            index++;
        } else {
            index = -1;
        }
        
    }

    protected boolean isFinished() {
        return index == -1;
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();
    }

    protected void interrupted() {
        end();
    }
    
    
    
}
