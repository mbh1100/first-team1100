package edu.arhs.team1100.ultimateascent.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.PIDController;

/**
 *
 * @author Ryan
 */
public class ShooterWheelSubsystem extends PIDSubsystem {
    
    private static final double P = 1.0;
    private static final double I = 0.05;
    private static final double D = 0.01;
    
    final static int ORIGONAL_SHOOTING_POWER = 9000;
    static int SHOOTING_POWER = 9000;
    final static int OFF = 0;

    static ShooterWheelSubsystem instance;
    private Talon shooterWheel;
    private Encoder wheelEncoder;

    public ShooterWheelSubsystem() {
        super(P, I, D); //SUPER PID!!!
        shooterWheel = new Talon(RobotMap.S_TALON_SHOOTER_WHEEL_CHANNEL);
        wheelEncoder = new Encoder(RobotMap.S_ENCODER_CHANNEL_A, RobotMap.S_ENCODER_CHANNEL_B);
    }

    public static ShooterWheelSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterWheelSubsystem();
            instance.initDefaultCommand();
        }
        return instance;

    }
    
    /**
     * spin wheel at preset shooting speed
     */
    public void spinWheel() {
        shooterWheel.set(SHOOTING_POWER);
    }

    /**
     * stops the shooter wheel
     */
    public void StopSpinning() {
        shooterWheel.set(OFF);
    }
    
    /**
     * we might not need this
     * @param shooterSpeed 
     */
    public void setShootingSpeed(int shooterSpeed)
    {
        SHOOTING_POWER = shooterSpeed;
    }
    
    /**
     * might not need this
     */
    public void resetShootingSpeed()
    {
        SHOOTING_POWER = ORIGONAL_SHOOTING_POWER;
    }
    
    /**
     * 
     * @return the encoder rate on the shooter wheel
     */
    protected double returnPIDInput() {
        return wheelEncoder.getRate();
    }

    /**
     * spins the shooter wheel at the shooting speed acording to PID
     * @param output 
     */
    protected void usePIDOutput(double output) {
        shooterWheel.set(output);
    }

    protected void initDefaultCommand() {
    }
}
