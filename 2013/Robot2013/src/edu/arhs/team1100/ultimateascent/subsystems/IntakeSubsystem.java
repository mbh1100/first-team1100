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

    static IntakeSubsystem instance;
    private Compressor compressor;
    private Solenoid intakePistonLeft;
    private Solenoid intakePistonRight;
    private Victor intakeMotorLeft;
    private Victor intakeMotorRight;

    /**
     * Constructs an IntakeSubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public IntakeSubsystem() {
        //compressor = new Compressor(RobotMap.S_COMPRESSOR_PRESSURE_SWITCH, RobotMap.S_COMPRESSOR_RELAY);

        intakePistonLeft = new Solenoid(RobotMap.FP_SOLENOID_LEFT);
        intakePistonRight = new Solenoid(RobotMap.FP_SOLENOID_RIGHT);

        intakePistonLeft.set(false);
        intakePistonRight.set(false);

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

    /**
     * Toggle the wheels on the left to move discs. If not moving, set to full
     * speed. If moving, set to neutral.
     */
    public void intakeRollLeft() {
//        if (intakeMotorLeft.getSpeed() > 0) {
//            intakeMotorLeft.set(0);
//        } else {
//            intakeMotorLeft.set(1);
//        }
        intakeMotorLeft.set(1);
    }

    /**
     * Toggle the wheels on the right to move discs. If not moving, set to full
     * speed. If moving, set to neutral.
     */
    public void intakeRollRight() {
//        if (intakeMotorRight.getSpeed() > 0) {
//            intakeMotorRight.set(0);
//        } else {
//            intakeMotorRight.set(1);
//        }
        intakeMotorRight.set(-1);
    }

    /**
     * Toggle floor pickup position. Reverses position from current position.
     */
    public void pistonLift() {
        intakePistonLeft.set(!intakePistonLeft.get());
        intakePistonRight.set(!intakePistonRight.get());
    }
    
    public void stopRollers()
    {
        intakeMotorRight.set(0);
        intakeMotorLeft.set(0);
    }

    /**
     * Initializes intake command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
