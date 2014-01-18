package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.LiftCommand;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Team 1100
 */
public class LiftSubsystem extends Subsystem {

    private static LiftSubsystem instance;
    private Victor left, right;
    private AnalogChannel potentiometer;
    private DigitalInput topSwtich;

    /**
     * Creates a LiftSubsystem if not already created
     *
     * @return instance
     */
    public static LiftSubsystem getInstance() {
        if (instance == null) {
            instance = new LiftSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    /**
     * Constructs a LiftSubsystem. Initialize left and right lift motors,
     * potentiometer, and limit switch.
     */
    public LiftSubsystem() {
        left = new Victor(RobotMap.L_VICTOR_LEFT);
        right = new Victor(RobotMap.L_VICTOR_RIGHT);
        potentiometer = new AnalogChannel(RobotMap.L_POTENTIOMETER);
        topSwtich = new DigitalInput(RobotMap.L_LIMIT_TOP);
    }

    /**
     * Lifts the lift and shooter.
     */
    public void doLift() {
        double speed = OI.getInstance().getXboxController().getAxis(AxisType.kZ) / 1.5;
        left.set(speed);
        right.set(-speed);
    }

    /**
     * Gets position of potentiometer. NOT USED.
     *
     * @return voltage of potentiometer
     */
    public double getPosition() {
        return potentiometer.getVoltage();
    }

    /**
     * Initializes default command
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new LiftCommand());
    }
}
