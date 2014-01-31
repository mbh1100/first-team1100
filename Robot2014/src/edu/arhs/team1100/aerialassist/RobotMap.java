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
    public static final int D_TALON_FRONT_RIGHT = 9;
    public static final int D_TALON_BACK_LEFT = 3;
    public static final int D_TALON_BACK_RIGHT = 4;
    public static final int D_TALON_FRONT_LEFT_TWO = 1;
    public static final int D_TALON_FRONT_RIGHT_TWO = 9;
    public static final int D_TALON_BACK_LEFT_TWO = 3;
    public static final int D_TALON_BACK_RIGHT_TWO = 4;
    public static final int D_GYRO = 1;
    public static int D_FRONT_LEFT_SOLENOID_PORTA = 8;
    public static int D_FRONT_LEFT_SOLENOID_PORTB = 1;
    public static int D_FRONT_RIGHT_SOLENOID_PORTA = 5;
    public static int D_FRONT_RIGHT_SOLENOID_PORTB = 3;
    public static int D_BACK_LEFT_SOLENOID_PORTA = 4;
    public static int D_BACK_LEFT_SOLENOID_PORTB = 5;
    public static int D_BACK_RIGHT_SOLENOID_PORTA = 6;
    public static int D_BACK_RIGHT_SOLENOID_PORTB = 7;
    public static int D_COMPRESSOR_RELAY = 8;
    public static int D_COMPRESSOR_PRESSURE_SWITCH = 9;
   

    //[M]anipulator
    public static int M_CLAMP_OUT = 5;
    public static int M_ARM = 6;
    public static int M_CLAMP_IN = 7;
    public static int M_FIST_PORTA;
    public static int M_FIST_PORTB;
    public static int M_RIGHT_VECTOR_SLOT;
    public static int M_RIGHT_VECTOR_CNL;
    public static int M_LEFT_VECTOR_SLOT;
    public static int M_LEFT_VECTOR_CNL;
    
    //[S]ensor
    public static int S_AC_1q = 10;
    public static int S_EN_FR_CNL = 1;
    public static int S_EN_FL_CNL = 8;
    public static int S_EN_BR_CNL = 3;
    public static int S_EN_BL_CNL = 4;
    public static int S_EN_FR_SLOT = 5;
    public static int S_EN_FL_SLOT = 6;
    public static int S_EN_BR_SLOT = 7;
    public static int S_EN_BL_SLOT;
    public static int S_GY_CNL = 2;
   
}
