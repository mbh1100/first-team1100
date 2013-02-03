/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.util.ControllerState;
import edu.arhs.team1100.ultimateascent.util.Log;
import java.util.Vector;

/**
 *
 * @author akshay
 */
public class PlayRecordedStateCommand extends CommandBase{
    
    static RecordStateCommand recorder = null;
    
    private Vector states;
    private int index = 0;
    private long last = 0;
    private long interval = 0;
    private ControllerState currentState;
    
    public PlayRecordedStateCommand(RecordStateCommand r){
        recorder = r;
        requires(DriveSubsystem.getInstance());
    }

    protected void initialize() {
        index = 0;        
        states = recorder.getRecording();        
        interval = recorder.getInterval();
        last = System.currentTimeMillis();
        currentState = new ControllerState();
        Log.log(this, "PLAY RECORDING: "+states.size()+" commands, interval "+interval, Log.LEVEL_DEBUG);
    }

    protected void execute() {
        long t = System.currentTimeMillis();        
        
        if((index >= 0 && index < states.size()) && t-last >= interval) {
            last = t;            
            currentState = (ControllerState)states.elementAt(index); 
            index++;                       
            //Log.log(this, currentState.toString(), Log.LEVEL_DEBUG);
        }  else if(index >= states.size()){
            index = -1;
        }
        DriveSubsystem.getInstance().driveSimulate(currentState.X, currentState.Y, currentState.R, currentState.mode);
 
        
    }

    protected boolean isFinished() {
        return index == -1;
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();
        Log.log(this, "Playback END", Log.LEVEL_DEBUG);
    }

    protected void interrupted() {
        end();
    }
    
    
    
}
