/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Akshay
 */
public class JoystickPIDMecanumCommand extends CommandBase {

    private static final double MAGNITUDE_DEADBAND = 0.3;

    public JoystickPIDMecanumCommand(){
        requires(DriveSubsystem.getInstance());
    }

    protected void initialize() {
        DriveSubsystem.getInstance().setSetpoint(0.0); //desired difference between desired and actual angle
        DriveSubsystem.getInstance().enable(); //PID enable
    }

    protected void execute() {
        //nothing to do

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().disable(); // PID disable
    }

    protected void interrupted() {
        end();
    }


}
