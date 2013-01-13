/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.ultimateascent.PIDs;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDOutput;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * @author FITE
 */


public class drivePID extends PIDController implements PIDOutput, PIDSource
{
    static private final double P = 1;
    static private final double I = 0.0;
    static private final double D = 0.0;

    public drivePID()
    {
	super(P, I, D, new SteerSource(), new SteerOutput());
    }

    // this class exposes all the methods of PIDController, such as enable(), disable(), setSetpoint(), etc.

    public void pidWrite(double d) {
    }

    public double pidGet() {
        return 0;