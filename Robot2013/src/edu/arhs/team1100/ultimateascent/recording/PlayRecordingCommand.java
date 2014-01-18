package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;
import java.util.Vector;

/**
 * @author Team 1100
 */
public class PlayRecordingCommand extends CommandBase {

    static RecordCommand recorder = null;
    private Vector states;
    private ControllerState currentState;
    private int index = 0;
    private boolean finished = false;
    private long last = 0;
    private long interval = 0;

    /**
     * Starts recording
     *
     * @param r
     */
    public PlayRecordingCommand(RecordCommand r) {
        recorder = r;
        requires(DriveSubsystem.getInstance());
    }

    /**
     * Declares variables for recording video
     */
    protected void initialize() {
        index = 0;
        finished = false;

        states = recorder.getRecording();
        currentState = new ControllerState();

        interval = recorder.getInterval();
        last = System.currentTimeMillis();

        Log.log(this, "Playback START: " + states.size() + " commands, interval " + interval, Log.LEVEL_DEBUG);
    }

    /**
     * decides if the recording is finished or not
     */
    protected void execute() {
        long t = System.currentTimeMillis();

        if (!finished && index < states.size() && t - last >= interval) {
            last = t;
            currentState = (ControllerState) states.elementAt(index);
            index++;
            //Log.log(this, currentState.toString(), Log.LEVEL_DEBUG);
        } else if (index >= states.size()) {
            finished = true;
        }
        DriveSubsystem.getInstance().driveSimulate(currentState.X, currentState.Y, currentState.R, currentState.mode);
    }

    /**
     * @return finished
     */
    protected boolean isFinished() {
        return finished;
    }

    /**
     * Stops recording
     */
    protected void end() {
        DriveSubsystem.getInstance().stop();
        Log.log(this, "Playback END", Log.LEVEL_DEBUG);
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
        end();
    }
}
