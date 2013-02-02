/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.util.ControllerState;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick;
import java.util.Vector;

/**
 *
 * @author akshay
 */
public class RecordStateCommand extends CommandBase {
    
    private Vector recording;
    private int interval = 0;
    private long last = 0;
    
    
    public RecordStateCommand(int hz){
        recording = new Vector();
        interval = 1000/hz;
    }

    protected void initialize() {
        Log.log(this, "START RECORD", Log.LEVEL_DEBUG);
        recording = new Vector();
        last = System.currentTimeMillis();
      
    }

    protected void execute() {
        //Log.log(this, "EXECUTE", Log.LEVEL_DEBUG);
        long t = System.currentTimeMillis();
            if(t-last >= interval){
            double X = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
            double Y = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
            double R = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
            //Log.log(this, "new ControllerState("+X+","+Y+","+R+"),", Log.LEVEL_DEBUG);
            recording.addElement(new ControllerState(X, Y, R));
            Log.log(this, recording.elementAt(recording.size()-1).toString(), Log.LEVEL_DEBUG);
            last = t;
        }
    }
    
    public Vector getRecording(){
        return recording;
    }
    
    
    public int getInterval(){
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
