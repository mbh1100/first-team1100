package edu.arhs.team1100.ultimateascent.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Team 1100
 */
public class ShooterWheelSubsystem extends PIDSubsystem {

    private static final double P = 1.0;
    private static final double I = 0.05;
    private static final double D = 0.01;
    
    public static double SHOOTING_POWER = 0.7;
    public static double SHOOTING_RATE = 0;
   
    
    static ShooterWheelSubsystem instance;
    private Victor shooterWheel;
    private Encoder wheelEncoder;
    
    private double speed = 0.0;

    /**
     * declares a new motor and encoder
     */
    public ShooterWheelSubsystem() {
        super(P, I, D); //SUPER PID!!!
        shooterWheel = new Victor(RobotMap.S_VICTOR_SHOOTER_WHEEL_CHANNEL);
        wheelEncoder = new Encoder(RobotMap.S_ENCODER_CHANNEL_A, RobotMap.S_ENCODER_CHANNEL_B);
        
        wheelEncoder.setDistancePerPulse(1);
        wheelEncoder.start();
    }

    /**
     * creates a new instance of the shooter wheel
     * @return
     */
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
//    public void spin(double speed) {
//        shooterWheel.set(s);
//    }

    /**
     * stops the shooter wheel
     */
    public void stop() {
        speed = 0.0;
        shooterWheel.set(0.0);
    }
    
    /**
     *
     * @return the encoder rate on the shooter wheel
     */
    protected double returnPIDInput() {        
        return wheelEncoder.getRate();
    }

    /**
     * spins the shooter wheel at the shooting speed according to PID
     *
     * @param output
     */
    protected void usePIDOutput(double output) {
        shooterWheel.set(output);
    }
    
    public void changeSpeed(double d){
        speed += d;
        speed = (speed < 0.0)?0.0:((speed > 1.0)?1.0:speed);
        shooterWheel.set(-speed);
    }
    
    public double getSpeed(){
        return -shooterWheel.get();
    }
    
    public double getRate(){
       return wheelEncoder.getRate();
    }
    

    protected void initDefaultCommand() {
    }
}
