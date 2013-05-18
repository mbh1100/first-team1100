package edu.arhs.team1100.ultimateascent.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.shooter.SpinShooterCommand;
import edu.wpi.first.wpilibj.Victor;

/**
 * @author Team 1100
 */
public class ShooterWheelSubsystem extends PIDSubsystem {
    public static final double MAX_SPEED = 1f;
    public static final double SHOOTING_SPEED = 0.8;
    private static final double P = 1.0;
    private static final double I = 0.05;
    private static final double D = 0.01;
    static ShooterWheelSubsystem instance;
    private Victor shooterWheel;
    private Encoder wheelEncoder;
    private double speed = 0.0;

    /**
     * Constructs a ShooterWheelSubsystem. Declares a new motor and encoder.
     */
    public ShooterWheelSubsystem() {
        super(P, I, D);
        shooterWheel = new Victor(RobotMap.S_VICTOR_SHOOTER_WHEEL);
        wheelEncoder = new Encoder(RobotMap.S_ENCODER_A, RobotMap.S_ENCODER_B);
        wheelEncoder.setDistancePerPulse(1);
        wheelEncoder.start();
    }

    /**
     * Creates a ShooterWheelSubsystem if not already created
     *
     * @return instance
     */
    public static ShooterWheelSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterWheelSubsystem();
            instance.initDefaultCommand();
        }
        return instance;

    }

    /**
     * Spin wheel at preset shooting speed
     */
//    public void spin(double speed) {
//        shooterWheel.set(s);
//    }
    /**
     * Stops the shooter wheel
     */
    public void stop() {
        speed = 0.0;
        shooterWheel.set(0.0);
    }

    /**
     * Gets encoder rate of shooter wheel. NOT USED.
     *
     * @return the encoder rate on the shooter wheel
     */
    protected double returnPIDInput() {
        return wheelEncoder.getRate();
    }

    /**
     * Spins the shooter wheel at the shooting speed according to PID.
     *
     * @param output
     */
    protected void usePIDOutput(double output) {
        shooterWheel.set(output);
    }

    /**
     * Changes speed, in a range of 0-1.
     *
     * @param d
     */
    public void changeSpeed(double d) {
        speed += d;
        speed = (speed < 0.0) ? 0.0 : ((speed > 1.0) ? 1.0 : speed);
        shooterWheel.set(-speed);
    }

    /**
     * Sets speed to s.
     *
     * @param s
     */
    public void setSpeed(double s) {
        double n = (s > 1.0) ? (1.0) : (s < 0.0 ? 0.0 : s);
        shooterWheel.set(-n);

    }

    /**
     * Get speed of shooter.
     *
     * @return speed of shooter wheel
     */
    public double getSpeed() {
        return -shooterWheel.get();
    }

    /**
     * Gets rate of encoder. NOT USED.
     *
     * @return rate of movement on shooter wheel
     */
    public double getRate() {
        return wheelEncoder.getRate();
    }

    /**
     * Initializes default command
     */
    protected void initDefaultCommand() {
        //setDefaultCommand(new SpinShooterCommand(ShooterWheelSubsystem.SHOOTING_SPEED));
    }
}
