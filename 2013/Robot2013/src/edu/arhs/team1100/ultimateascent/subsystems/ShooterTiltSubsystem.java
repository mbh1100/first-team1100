package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.shooter.TiltShooterPIDCommand;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 * @author akshay
 */
public class ShooterTiltSubsystem extends PIDSubsystem {

    public static final double FLAT_ANGLE = 1.3;
    public static final double AUTONOMOUS_ANGLE = 1.7;
    public static final double SHOOTING_ANGLE = 1.7;
    public static final double FEEDER_ANGLE = 1.96;
    
    
    
    private static final double kCameraP = .5;
    private static final double kCameraI = 0.0;
    private static final double kCameraD = -0.25;
    
    private static final double kTiltP = 1.0;
    private static final double kTiltI = 0.20;
    private static final double kTiltD = 0.05;
    
    private static ShooterTiltSubsystem instance;
    private Victor tiltMotor;
    private AnalogChannel potentiometer;   
    
    
    private boolean isCameraMode = false;

    
    /**
     * Creates a ShooterTilitSubsystem object, if not already
     * @return 
     */
    public static ShooterTiltSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterTiltSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }
    // Initialize your subsystem here
    /**
     * Sets PID for tilt
     */
    public ShooterTiltSubsystem() {
        super(kTiltP, kTiltI, kTiltD);
        tiltMotor = new Victor(RobotMap.S_VICTOR_SHOOTER_TILT);
        potentiometer = new AnalogChannel(RobotMap.S_POTENTIOMETER_TILT);
        
    }

    /**
     * Tilts the shooter
     */
    public void doTilt() {
        
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kY);
        tiltMotor.set(speed);

    }
    
    public void tilt(double speed){
        tiltMotor.set(speed);
    }
    /**
     * returns the voltage of the angle potentiometer
     */
    public double getAngle(){
        return potentiometer.getVoltage();
    }
    
    public void stop(){
        tiltMotor.set(0.0);
    }
    /**
     * Initializes TiltShooterCommand
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TiltShooterPIDCommand());
    }
    /**
     * @return Center Y
     */
    protected double returnPIDInput() {
        //Log.log(this, "Y :  "+(-Camera.getInstance().getCenterY()), Log.LEVEL_DEBUG);
        Log.log(this, "tilt pidGet()", Log.LEVEL_DEBUG);
        if(isCameraMode){
            return -Camera.getInstance().getCenterY();
        } else {
            return potentiometer.getVoltage();
        }
    }
    /**
     * Sets output
     * @param output 
     */
    protected void usePIDOutput(double output) {
        Log.log(this, "usePidOutput()", Log.LEVEL_DEBUG);
        if(isCameraMode){
        tiltMotor.set(output);
        } else {
            tiltMotor.set(-output);
        }
    }
    
        /**
     * Sets the PID mode to either camera or joystick 
     * @param mode Whether or not to use camera pid mode (true), if false, uses joystick PID
     */
    public void setCameraMode(boolean mode) {
        isCameraMode = mode;
        if (isCameraMode) {
            getPIDController().setPID(kCameraP, kCameraI, kCameraD);
        } else {
            getPIDController().setPID(kTiltP, kTiltI, kTiltD);
        }
    }

    /**
     * 
     * @return whether the drive is using camera pid mode
     */
    public boolean getCameraMode() {
        return isCameraMode;
    }
}
