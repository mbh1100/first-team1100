package edu.arhs.team1100.ultimateascent.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.drive.JoystickMecanumCommand;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Team 1100
 */
public class DriveSubsystem extends PIDSubsystem {

    public static final double DIRECTION_FORWARD = 0;
    public static final double DIRECTION_BACK = 180;
    public static final double DIRECTION_LEFT = 270;
    public static final double DIRECTION_RIGHT = 90;
    
    public static final int MODE_CARTESIAN = 0;
    public static final int MODE_POLAR = 1;
    
    public static final double kJoystickP = 0.02;
    public static final double kJoystickI = 0.0001;
    public static final double kJoystickD = 0.0005;
    
    public static final double kCameraP = 0.6;
    public static final double kCameraI = 0.01;
    public static final double kCameraD = 0.2;
    
    static DriveSubsystem instance;
    
    private RobotDrive drive;
    private Gyro driveGyro;
    
    private Talon frontLeftTalon;
    private Talon frontRightTalon;
    private Talon backLeftTalon;
    private Talon backRightTalon;
    
    private int driveMode = MODE_CARTESIAN;
    private boolean isCameraMode = false;

    public static DriveSubsystem getInstance() {
        if (instance == null) {
            instance = new DriveSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public DriveSubsystem() {
        super(kJoystickP, kJoystickI, kJoystickD);//SUPER PID!!!!
        Log.log(this, "Constructor", Log.LEVEL_DEBUG);

        frontLeftTalon = new Talon(RobotMap.D_TALON_FRONT_LEFT);
        frontRightTalon = new Talon(RobotMap.D_TALON_FRONT_RIGHT);
        backLeftTalon = new Talon(RobotMap.D_TALON_BACK_LEFT);
        backRightTalon = new Talon(RobotMap.D_TALON_BACK_RIGHT);
        drive = new RobotDrive(
                frontLeftTalon,
                frontRightTalon,
                backLeftTalon,
                backRightTalon);
        driveGyro = new Gyro(RobotMap.D_GYRO);

    }

    /**
     * Drives the robot using user input interpreted according to the current
     * drive mode (Polar or cartesian).
     */
    public void userDrive() {
        if (driveMode == MODE_CARTESIAN) {
            userDriveCartesian();
        } else if (driveMode == MODE_POLAR) {
            userDrivePolar();
        } else {
            Log.log(this, "404: DRIVE MODE NOT FOUND. [W]hat a [T]errible [F]ailure.", driveMode);
            driveMode = MODE_CARTESIAN;
            userDriveCartesian();
        }
    }

    private void userDriveCartesian() {
        double rotation = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        drive.mecanumDrive_Cartesian(controlX, controlY, rotation, driveGyro.getAngle());
    }

    private void userDrivePolar() {
        double magnitude = -OI.getInstance().getLeftJoystick().getMagnitude();
        double angle =  -OI.getInstance().getLeftJoystick().getAngle();
        double rotation = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        drive.mecanumDrive_Polar(magnitude, angle, rotation);
    }

    /**
     * Drives using given values
     *
     * @param magnitude speed of the robot
     * @param angle direction of the robot
     * @param rotation rate of rotation
     */
    public void drive(double magnitude, double angle, double rotation) {
        drive.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, driveGyro.getAngle());
    }

    /**
     * Drives using values as if they were joystick values
     *
     * @param x
     * @param y
     * @param rot rotation
     * @param mode drive mode to use
     */
    public void driveSimulate(double x, double y, double rot, int mode) {
        if (mode == MODE_POLAR) {
            double magnitude = Math.sqrt(x * x + y * y);
            double angle = Math.toDegrees(MathUtils.atan2(x, y));
            while (angle < 0) {
                angle += 360;
            }
            drive.mecanumDrive_Polar(magnitude, angle, rot);
        } else if (mode == MODE_CARTESIAN) {
            drive.mecanumDrive_Cartesian(-x, -y, -rot, driveGyro.getAngle());
        } else {
            stop();
        }
    }
    /**
     * Stops the drive
     */
    public void stop() {
        drive(0, 0, 0);
    }

    protected double returnPIDInput() {
        if (isCameraMode) {
            double pCenter = Camera.getInstance().getCenterX();
            //Log.log(this, "pCenter:     "+pCenter, Log.LEVEL_DEBUG);      
            return pCenter;
        } else {
            return getGyroAngle();
        }
    }

    protected void usePIDOutput(double rotationSpeed) {
        double controlX = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
 
        drive.mecanumDrive_Cartesian(controlX, controlY, rotationSpeed, driveGyro.getAngle());
    }

    
    public void setSetpoint(double setpoint) {
        if (!isCameraMode) {
            super.setSetpoint(setpoint);
        } else {
            super.setSetpoint(0.0);
        }
    }

    /**
     * Switches the drive mode between polar and cartesian
     */
    public void toggleDriveMode() {
        driveMode = (driveMode == MODE_CARTESIAN) ? MODE_POLAR : MODE_CARTESIAN;
    }

    /**
     * 
     * @return the current drive mode, DriveSubsystem.MODE_POLAR or DriveSubsystem.MODE_CARTESIAN
     */
    public int getDriveMode() {
        return driveMode;
    }

    /**
     * 
     * @return the un-normalized gyro angle
     */
    public double getGyroAngle() {
        return -driveGyro.getAngle();
    }

    /**
     * Calibrates the gyro to use the current direction as zero
     */
    public void calibrateGyro() {
        driveGyro.reset();
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickMecanumCommand());
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
            getPIDController().setPID(kJoystickP, kJoystickI, kJoystickD);
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