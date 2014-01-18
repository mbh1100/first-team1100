package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.shooter.TiltShooterCommand;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * @author Team 1100
 */
public class ShooterTiltSubsystem extends PIDSubsystem {

    public static final double FLAT_ANGLE = 1.3;
    public static final double AUTONOMOUS_ANGLE = 1.7;
    public static final double SHOOTING_ANGLE = 1.7;
    public static final double FEEDER_ANGLE = 1.96;
    private static final double kCameraP = .531; //hardcoded from DSPID
    private static final double kCameraI = 0.112;
    private static final double kCameraD = .140;
    private static final double kTiltP = 1.0;
    private static final double kTiltI = 0.20;
    private static final double kTiltD = 0.05;
    private static ShooterTiltSubsystem instance;
    private Victor tiltMotor;
    private AnalogChannel potentiometer;
    private boolean isCameraMode = false;

    /**
     * Creates a ShooterTilitSubsystem object if not already created
     *
     * @return instance
     */
    public static ShooterTiltSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterTiltSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    /**
     * Constructs a ShooterTiltSubsystem. Sets PID for tilt.
     */
    public ShooterTiltSubsystem() {
        super(kTiltP, kTiltI, kTiltD);
        tiltMotor = new Victor(RobotMap.S_VICTOR_SHOOTER_TILT);
        potentiometer = new AnalogChannel(RobotMap.S_POTENTIOMETER_TILT);

    }

    /**
     * Tilts the shooter.
     */
    public void doTilt() {

        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kY);
        tiltMotor.set(speed);

    }

    /**
     * Gives tilt motor speed to tilt.
     *
     * @param speed
     */
    public void tilt(double speed) {
        tiltMotor.set(speed);
    }

    /**
     * Gets potentiometer angle.
     *
     * @returns the voltage of the angle potentiometer
     */
    public double getAngle() {
        return potentiometer.getVoltage();
    }

    /**
     * Stops the tilt from moving.
     */
    public void stop() {
        tiltMotor.set(0.0);
    }

    /**
     * Initializes default command
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TiltShooterCommand());
    }

    /**
     * @return Center Y
     */
    protected double returnPIDInput() {
        try {
            //Log.log(this, "Y :  "+(-Camera.getInstance().getCenterY()), Log.LEVEL_DEBUG);
           
            if (isCameraMode) {
                
            //     Log.log(this, "PIDGet()"+Log.round( -Camera.getInstance().getCenterY(), 3)  , Log.LEVEL_DEBUG);
                return -Camera.getInstance().getCenterY();
            } else {
                return potentiometer.getVoltage();
            }
        } catch (Exception x) {
            Log.log(this, "exception PIDInput: " + x, Log.LEVEL_DEBUG);
            return 0;
        }
    }

    /**
     * Sets output.
     *
     * @param output
     */
    protected void usePIDOutput(double output) {
        try {
          //  Log.log(this, "usePIDOutput()" + output, Log.LEVEL_DEBUG);
            if (isCameraMode) {
                tiltMotor.set(output);
                //Log.log(instance, "                    out: "+Log.round(output, 3), Log.LEVEL_DEBUG);
            } else {
                tiltMotor.set(-output);
            }
        } catch (Exception x) {
            Log.log(this, "exception PIDOutput " + x, Log.LEVEL_DEBUG);
        }
    }

    /**
     * Sets the PID mode to either camera or joystick
     *
     * @param mode Whether or not to use camera PID mode (true), if false, uses
     * joystick PID
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
     * Get if camera PID is being used or not.
     *
     * @return whether the drive is using camera PID mode
     */
    public boolean getCameraMode() {
        return isCameraMode;
    }
}
