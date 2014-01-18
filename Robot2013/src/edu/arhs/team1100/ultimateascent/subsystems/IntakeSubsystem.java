package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Team 1100
 */
public class IntakeSubsystem extends Subsystem {
    
    public static final boolean UP = false;
    public static final boolean DOWN = true;

    static IntakeSubsystem instance;
    private Compressor compressor;
    private Solenoid intakePistonLeft;
    //private Solenoid intakePistonRight;
    private PWM intakeMotorLeft;
    private PWM intakeMotorRight;

    /**
     * Constructs an IntakeSubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public IntakeSubsystem() {
        //compressor = new Compressor(RobotMap.S_COMPRESSOR_PRESSURE_SWITCH, RobotMap.S_COMPRESSOR_RELAY);

        intakePistonLeft = new Solenoid(RobotMap.FP_SOLENOID_LEFT);
        //intakePistonRight = new Solenoid(RobotMap.FP_SOLENOID_RIGHT);

        intakePistonLeft.set(false);
        //intakePistonRight.set(false);

        intakeMotorLeft = new Victor(RobotMap.FP_PWM_INTAKE_LEFT);
        intakeMotorRight = new Victor(RobotMap.FP_PWM_INTAKE_RIGHT);

        //compressor.start();
    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static IntakeSubsystem getInstance() {
        if (instance == null) {
            instance = new IntakeSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }


    public void roll(boolean back){

        intakeMotorLeft.setRaw(back?0:255);
        intakeMotorRight.setRaw(back?255:0);
    }
    
    public void setPosition(boolean p){
        System.out.println("set to"+p);
        intakePistonLeft.set(p);
    }
    

    /**
     * Toggle floor pickup position. Reverses position from current position.
     */
    public void pistonLift() {
        intakePistonLeft.set(!intakePistonLeft.get());
        //intakePistonRight.set(!intakePistonRight.get());
    }

    public void stopRollers()
    {
        intakeMotorRight.setRaw(128);
        intakeMotorLeft.setRaw(128);
    }


    /**
     * Initializes intake command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
