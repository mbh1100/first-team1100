package edu.arhs.team1100.ultimateascent;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //[C]ONTROLS
    public static final int C_LEFT_JOYSTICK_CHANNEL = 1;
    public static final int C_RIGHT_JOYSTICK_CHANNEL = 2;
    public static final int C_XBOX_CONTROLLER_CHANNEL = 3;

    public static final int C_TOGGLE_DRIVE = 2;
    public static final int C_CALIBRATE_GYRO = 3;
    public static final int C_DRIVE_PID = 1; //trigger
    public static final int C_STOP_DRIVE = 4;
    public static final int C_DRIVE_CAMERA = 1; // on the left stick

    public static final int C_RECORD = 5;
    public static final int C_PLAY_RECORDING = 2;
    public static final int C_PRINT_RECORDING = 6;

    public static final int C_CAMERATEST = 7;

    //[D]RIVE
    public static final int D_TOGGLE_BUTTON_NUMBER = 8;

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

    //[S]HOOTER
    public static final int S_TALON_SHOOTER_WHEEL_SLOT = 1;
    public static final int S_TALON_SHOOTER_WHEEL_CHANNEL = 5;

    public static final int S_ENCODER_CHANNEL_A = 1;
    public static final int S_ENCODER_CHANNEL_B = 2;

    public static final int S_SOLENOID_SHOOTER_PISTON = 1;
    public static final int S_FRISBEE_LIMIT_SWITCH = 2;
}
