package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 * Base Class for recording output Recordings should EXTEND this class
 *
 * @author Team 1100
 */
public abstract class RecordedRoutine extends CommandBase {

    private int interval = 0;
    private ControllerState[] recording;
    private ControllerState currentState;
    private int index = 0;
    private boolean finished = false;
    private long last = 0;

    /**
     * Creates a DriveSubsystem object
     */
    public RecordedRoutine() {
        requires(DriveSubsystem.getInstance());
    }

    /**
     * Called just before this Command runs the first time
     */
    protected final void initialize() {
        index = 0;
        finished = false;

        interval = getInterval();
        recording = getRecording();

        currentState = new ControllerState();
        last = System.currentTimeMillis();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected final void execute() {
        long t = System.currentTimeMillis();

        if (!finished && index < recording.length && t - last >= interval) {
            last = t;
            currentState = recording[index];
            index++;
        } else if (index >= recording.length) {
            finished = true;
        }

        DriveSubsystem.getInstance().driveSimulate(currentState.X, currentState.Y, currentState.R, currentState.mode);

    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return finished
     */
    protected final boolean isFinished() {
        return finished;
    }

    /**
     * Called once after isFinished returns true
     */
    protected final void end() {
        DriveSubsystem.getInstance().stop();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected final void interrupted() {
        end();
    }

    /**
     * @return null
     */
    protected abstract int getInterval();

    /**
     * @return null
     */
    protected abstract ControllerState[] getRecording();
}
