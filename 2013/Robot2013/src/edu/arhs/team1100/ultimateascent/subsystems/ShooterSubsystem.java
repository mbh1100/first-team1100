/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.JoystickMecanumCommand;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Jason
 */
public class ShooterSubsystem extends PIDSubsystem
{
    public static final double P = 0.002;
    public static final double I = 0.0001;//1;
    public static final double D = 0.0005;
    
    static ShooterSubsystem instance;
    
    private RobotDrive drive;
    
    private Talon shooterControl;

    public static ShooterSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public ShooterSubsystem() {
        super(P, I, D);//SUPER PID!!!!
        shooterControl = new Talon(RobotMap.S_SHOOTER_CONTROLLER_CHANNEL);
    }
    
    private void spinWheel()
    {
        
    }
    
    private void tryShot()
    {
        
    }

    protected double returnPIDInput() {
       return 0.0;
    }

    protected void usePIDOutput(double rotationSpeed) {
    }


    public Talon getShooterController() {
        return shooterControl;
    }

    protected void initDefaultCommand() {
    }    
}
