package edu.arhs.team1100.ultimateascent;

import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //DRIVE
    public static final int D_TALON_FRONT_LEFT_SLOT = 1;
    public static final int D_TALON_FRONT_LEFT_CHANNEL = 1;
    
    public static final int D_TALON_FRONT_RIGHT_SLOT = 1;
    public static final int D_TALON_FRONT_RIGHT_CHANNEL = 2;
    
    public static final int D_TALON_BACK_LEFT_SLOT = 1;
    public static final int D_TALON_BACK_LEFT_CHANNEL = 3;
    
    public static final int D_TALON_BACK_RIGHT_SLOT = 1;
    public static final int D_TALON_BACK_RIGHT_CHANNEL = 4;
       
    public static final int D_GYRO_SLOT = 1;
    public static final int D_GYRO_CHANNEL = 1;
    
    public static final int S_TALON_SHOOTER_WHEEL_SLOT = 1;
    public static final int S_TALON_SHOOTER_WHEEL_CHANNEL = 5;
    
    public static final int S_ENCODER_CHANNEL_A = 1;
    public static final int S_ENCODER_CHANNEL_B = 2;
 
    public static final int S_SOLENOID_SHOOTER_PISTON = 1;
}