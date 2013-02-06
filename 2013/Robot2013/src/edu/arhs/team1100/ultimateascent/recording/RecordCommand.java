package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick;
import java.util.Vector;

/**
 *
 * @author Team 1100
 */
public class RecordCommand extends CommandBase {

    private Vector recording;
    private int interval = 0;
    private long last = 0;

    public RecordCommand(int hz) {
        recording = new Vector();
        interval = 1000 / hz;
    }

    protected void initialize() {
        Log.log(this, "START RECORD", Log.LEVEL_DEBUG);
        recording = new Vector();
        last = System.currentTimeMillis();

    }

    protected void execute() {
        long t = System.currentTimeMillis();
        if (t - last >= interval) {
            double X = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
            double Y = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
            double R = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
            int mode = DriveSubsystem.getInstance().getDriveMode();
            recording.addElement(new ControllerState(X, Y, R, mode));
            last = t;
        }
    }

    public Vector getRecording() {
        return recording;
    }

    public int getInterval() {
        return interval;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
