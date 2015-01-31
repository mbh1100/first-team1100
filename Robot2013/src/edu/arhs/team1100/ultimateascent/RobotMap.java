package edu.arhs.team1100.ultimateascent;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //[C]ONTROLS
    public static final int C_LEFT_JOYSTICK = 1;
    public static final int C_RIGHT_JOYSTICK = 2;
    public static final int C_XBOX_CONTROLLER = 3;
    public static int DS_SHOOTING_ANGLE_CH = 1;
    public static int DS_FEEDER_ANGLE_CH = 2;
    public static int DS_FLAT_ANGLE_CH = 3;
    public static int DS_SETPOINT_TOGGLE = 7;
    public static int DS_P = 1;
    public static int DS_I = 2;
    public static int DS_D = 3;
    //[D]RIVE
    public static final int D_TALON_FRONT_LEFT = 1;
    public static final int D_TALON_FRONT_RIGHT = 2;
    public static final int D_TALON_BACK_LEFT = 3;
    public static final int D_TALON_BACK_RIGHT = 4;
    public static final int D_GYRO = 1;
    //[S]HOOTER
    public static final int S_VICTOR_SHOOTER_WHEEL = 10;
    public static final int S_VICTOR_SHOOTER_TILT = 9;
    public static final int S_POTENTIOMETER_TILT = 2;
    public static final int S_ENCODER_A = 1;
    public static final int S_ENCODER_B = 2;
    public static final int S_COMPRESSOR_PRESSURE_SWITCH = 5;
    public static final int S_COMPRESSOR_RELAY = 8;
    public static final int S_SOLENOID_SHOOTER_PISTON = 1;
    public static final int S_FRISBEE_LIMIT_SWITCH = 2;
    public static final int S_RELAY_SHOOTER_PISTON = 1;
    //[L]IFT
    public static final int L_VICTOR_LEFT = 6;
    public static final int L_VICTOR_RIGHT = 5;
    public static final int L_LIMIT_TOP = 9;
    public static final int L_POTENTIOMETER = 4;
    //[F]loor [P]ickup
    public static final int FP_SOLENOID_LEFT = 2;
    public static final int FP_SOLENOID_RIGHT = 2;
    public static final int FP_PWM_INTAKE_LEFT = 7;
    public static final int FP_PWM_INTAKE_RIGHT = 8;
    
    public static final int LEG_LEFT = 3;
    public static final int LEG_RIGHT = 3;
}
