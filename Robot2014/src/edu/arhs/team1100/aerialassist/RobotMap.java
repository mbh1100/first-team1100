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
    public static final int D_TALON_FRONT_LEFT = 4;
    public static final int D_TALON_FRONT_RIGHT = 8;
    public static final int D_TALON_BACK_LEFT = 1;
    public static final int D_TALON_BACK_RIGHT = 2;
    public static final int D_TALON_FRONT_LEFT_TWO = 3;
    public static final int D_TALON_FRONT_RIGHT_TWO = 7;
    public static final int D_TALON_BACK_LEFT_TWO = 5;
    public static final int D_TALON_BACK_RIGHT_TWO = 6;
    public static final int D_GYRO = 1;
    public static int D_BACK_LEFT_SOLENOID_PORTA = 1;
    public static int D_BACK_LEFT_SOLENOID_PORTB = 2;
    public static int D_FRONT_LEFT_SOLENOID_PORTA = 3;
    public static int D_FRONT_LEFT_SOLENOID_PORTB = 4;
    public static int D_BACK_RIGHT_SOLENOID_PORTA = 5;
    public static int D_BACK_RIGHT_SOLENOID_PORTB = 6;
    public static int D_FRONT_RIGHT_SOLENOID_PORTA = 7;
    public static int D_FRONT_RIGHT_SOLENOID_PORTB = 8;
    public static int D_COMPRESSOR_SLOT = 2;
    public static int D_COMPRESSOR_RELAY_CHANNEL = 1;
    public static int D_COMPRESSOR_PRESSURE_SWITCH_CHANNEL = 1;

    //[M]anipulator
    public static int M_STOPER_IN = 8;
    public static int M_STOPER_OUT = 7;
    public static int M_PUNCH_IN = 6;
    public static int M_PUNCHTWO_IN = 4;
    public static int M_PUNCHTWO_OUT= 3;
    public static int M_PUNCH_OUT = 5;

    public static int M_CLAMP_OUT = 5;
    public static int M_CLAMP_IN = 6;
    public static int M_TALON_RIGHT_WHEEL = 10;
    public static int M_TALON_LEFT_WHEEL = 9;
    public static int M_RIN_MODULE = 2;   //fix
    public static int M_LIN_MODULE = 2;  //fix
    public static int M_RIN_CHANNEL = 2;
    public static int M_LIN_CHANNEL = 3;

    //[S]ensor
    public static int S_AC_1q = 10;
    public static int S_EN_FR_A = 1;
    public static int S_EN_FL_A = 3;
    public static int S_EN_BR_A = 5;
    public static int S_EN_BL_A = 7;
    public static int S_EN_FR_B = 2;
    public static int S_EN_FL_B = 4;
    public static int S_EN_BR_B = 6;
    public static int S_EN_BL_B = 8;
    public static int S_EN_ARM = 1;
    public static int S_GY_CNL = 2;

}
