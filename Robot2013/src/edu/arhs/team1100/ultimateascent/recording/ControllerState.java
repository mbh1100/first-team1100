package edu.arhs.team1100.ultimateascent.recording;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 * @author Team 1100
 */
public class ControllerState {

    public double X, Y, R;
    public int mode;

    /**
     * Constructs a ControllerState
     */
    public ControllerState() {
        this(0, 0, 0, DriveSubsystem.getInstance().getDriveMode());
    }

    /**
     * Constructs a ControllerState with values Setter method for parameters
     *
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
     *
     * @return String
     */
    public String toString() {
        return "new ControllerState(" + X + "," + Y + "," + R + "," + mode + "),";
    }
}