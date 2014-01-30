package edu.arhs.team1100.aerialassist;

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
    public static int DS_P = 1;
    public static int DS_I = 2;
    public static int DS_D = 3;

    
    //[D]RIVE
    public static final int D_TALON_FRONT_LEFT = 1;
    public static final int D_TALON_FRONT_RIGHT = 2;
    public static final int D_TALON_BACK_LEFT = 3;
    public static final int D_TALON_BACK_RIGHT = 4;
    public static final int D_GYRO = 1;
    public static int D_FRONT_LEFT_SOLENOID_PORTA;
    public static int D_FRONT_LEFT_SOLENOID_PORTB;
    public static int D_FRONT_RIGHT_SOLENOID_PORTA;
    public static int D_FRONT_RIGHT_SOLENOID_PORTB;
    public static int D_BACK_LEFT_SOLENOID_PORTA;
    public static int D_BACK_LEFT_SOLENOID_PORTB;
    public static int D_BACK_RIGHT_SOLENOID_PORTA;
    public static int D_BACK_RIGHT_SOLENOID_PORTB;
    public static int D_COMPRESSOR_RELAY;
    public static int D_COMPRESSOR_PRESSURE_SWITCH;
   

    //[M]anipulator
    public static int M_WHEEL;
    public static int M_ARM;
    public static int M_RIGHT_WHEEL;
    public static int M_LEFT_WHEEL;
    public static int M_FIST_PORTA;
    public static int M_FIST_PORTB;
    
    //[S]ensor
    public static int S_AC_1q;
    public static int S_EN_FR_CNL;
    public static int S_EN_FL_CNL;
    public static int S_EN_BR_CNL;
    public static int S_EN_BL_CNL;
    public static int S_EN_FR_SLOT;
    public static int S_EN_FL_SLOT;
    public static int S_EN_BR_SLOT;
    public static int S_EN_BL_SLOT;
    public static int S_GY_CNL;
   
}
