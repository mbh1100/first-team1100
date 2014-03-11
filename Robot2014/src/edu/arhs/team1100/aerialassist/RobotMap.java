package edu.arhs.team1100.aerialassist;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //[C]ONTROLS
    public static final int C_LEFT_JOYSTICK = 2;
    public static final int C_RIGHT_JOYSTICK = 1;
    public static final int C_XBOX_CONTROLLER = 3;
    public static int DS_P = 1;
    public static int DS_I = 2;
    public static int DS_D = 3;

    //[D]RIVE
    public static final int D_TALON_FRONT_LEFT = 2;
    public static final int D_TALON_FRONT_RIGHT = 1;
    public static final int D_TALON_BACK_LEFT = 4;
    public static final int D_TALON_BACK_RIGHT = 3;
    public static int D_RIGHT_SOLENOID_A = 1;
    public static int D_RIGHT_SOLENOID_B = 2;
    public static int D_LEFT_SOLENOID_A = 3;
    public static int D_LEFT_SOLENOID_B = 4;
    public static int D_COMPRESSOR_SLOT = 1;
    public static int D_COMPRESSOR_RELAY_CHANNEL = 1;
    public static int D_COMPRESSOR_PRESSURE_SWITCH_CHANNEL = 3;

    //[M]anipulator
    public static int M_LATCH_IN = 6;
    public static int M_LATCH_OUT = 5;
    public static int M_PUNCH_IN = 3;
    public static int M_PUNCH_OUT = 4;
    public static int M_PUNCHTWO_IN = 1;
    public static int M_PUNCHTWO_OUT = 2;
    public static int M_CLAMP_OUT = 8;
    public static int M_CLAMP_IN = 7;
    
    public static int M_TALON_RIGHT_WHEEL = 5;
    public static int M_TALON_LEFT_WHEEL = 6;
    public static int M_RIN_MODULE = 1;   //fix
    public static int M_LIN_MODULE = 1;   //fix
    public static int M_RIN_CHANNEL = 7;
    public static int M_LIN_CHANNEL = 8;

    //[S]ensor
    public static int S_AC_1q = 10;
    public static int S_EN_W_A = 1;
    public static int S_EN_W_B = 2;
    public static int S_EN_ARM_A = 7;
    public static int S_EN_ARM_B = 8;
    public static int S_GY_CNL = 1;
    public static int S_ULTRA_B =  3;

}
