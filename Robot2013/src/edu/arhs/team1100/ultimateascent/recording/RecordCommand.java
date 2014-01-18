package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick;
import java.util.Vector;

/**
 * Records robot movements for later replay
 *
 * @author Team 1100
 */
public class RecordCommand extends CommandBase {

    private Vector recording;
    private int interval = 0;
    private long last = 0;

    /**
     * Sets a new recording and interval
     *
     * @param hz
     */
    public RecordCommand(int hz) {
        recording = new Vector();
        interval = 1000 / hz;
    }

    /**
     * Starts a new recording
     */
    protected void initialize() {
        Log.log(this, "Recording START", Log.LEVEL_DEBUG);
        recording = new Vector();
        last = System.currentTimeMillis();

    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        long t = System.currentTimeMillis();
        if (t - last >= interval) {
            double X = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
            double Y = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);
            double R = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
            int mode = DriveSubsystem.getInstance().getDriveMode();
            recording.addElement(new ControllerState(X, Y, R, mode));
            last = t;
        }
    }

    /**
     * @return the last recording by this recorded
     */
    public Vector getRecording() {
        return recording;
    }

    /**
     * @return the frequency at which recordings are made
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     *
     * @return finished
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
