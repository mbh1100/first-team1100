package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author akshay
 */
public class ControllerState {

    public double X, Y, R;
    public int mode;
       
    /**
     * Creates a DriveSubsystem object
     */
    public ControllerState() {
        this(0, 0, 0, DriveSubsystem.getInstance().getDriveMode());
    }
    /**
     * Setter method for params
     * @param x
     * @param y
     * @param r
     * @param m 
     */
    public ControllerState(double x, double y, double r, int m) {
        X = x;
        Y = y;
        R = r;
        mode = m;
    }
    
    /**
     * Converts variables to a string
     * @return String
     */
    public String toString() {
        return "new ControllerState(" + X + "," + Y + "," + R + "," + mode + "),";
    }
}