package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 * Base Class for recording output
 * Recordings should EXTEND this class 
 * @author akshay
 */
public abstract class RecordedRoutine extends CommandBase {
    
    private int interval = 0;
    private ControllerState[] recording;
    private ControllerState currentState;
    
    private int index = 0;
    private boolean finished = false;
    private long last = 0;
    
    public RecordedRoutine(){
        requires(DriveSubsystem.getInstance());
    }
    
    protected final void initialize() {
        index = 0;
        finished = false;
        
        interval = getInterval();
        recording = getRecording();
        
        currentState = new ControllerState();
        last = System.currentTimeMillis();
    }

    protected final void execute() {
        long t = System.currentTimeMillis();
        
        if(!finished && index < recording.length && t-last >= interval){
            last = t;
            currentState = recording[index];
            index++;
        } else if (index >= recording.length){
            finished = true;
        }
        
        DriveSubsystem.getInstance().driveSimulate(currentState.X, currentState.Y, currentState.R, currentState.mode);        

    }

    protected final boolean isFinished() {
        return finished;
    }

    protected final void end() {
        DriveSubsystem.getInstance().stop();
    }

    protected final void interrupted() {
        end();
    }
    
    protected abstract int getInterval();
    protected abstract ControllerState[] getRecording();
    
}
