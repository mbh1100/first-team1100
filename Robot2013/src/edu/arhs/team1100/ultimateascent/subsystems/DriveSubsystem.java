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
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * @author Team 1100
 */
public class DriveSubsystem extends PIDSubsystem {

    public static final double DIRECTION_FORWARD = 0;
    public static final double DIRECTION_BACK = 180;
    public static final double DIRECTION_LEFT = 270;
    public static final double DIRECTION_RIGHT = 90;
    public static final int MODE_CARTESIAN = 0;
    public static final int MODE_POLAR = 1;
    public static final int MODE_TANK = 2;
    public static final double kJoystickP = 0.02;
    public static final double kJoystickI = 0.0001;
    public static final double kJoystickD = 0.0005;
    public static final double kCameraP = 0.6;
    public static final double kCameraI = 0.01;
    public static final double kCameraD = 0.2;
    static DriveSubsystem instance;
//    static { getInstance(); }
    private RobotDrive drive;
    private Gyro driveGyro;
    private Talon frontLeftTalon;
    private Talon frontRightTalon;
    private Talon backLeftTalon;
    private Talon backRightTalon;
    private final int driveMode = MODE_TANK;
    private boolean isCameraMode = false;

    /**
     * Creates a DriveSubsystem if not already created
     *
     * @return instance
     */
    public static DriveSubsystem getInstance() {
        if (instance == null) {
            instance = new DriveSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    /**
     * Constructs a DriveSubsystem. Initialize PID values, drive Talons, drive
     * system, and gyro.
     */
    public DriveSubsystem() {
        super(kJoystickP, kJoystickI, kJoystickD);

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
     * drive mode (Polar or Cartesian).
     */
    public void userDrive() {
        userDriveTank();
        /*
         if (driveMode == MODE_CARTESIAN) {
         userDriveCartesian();
         } else if (driveMode == MODE_POLAR) {
         userDrivePolar();
         } else {
         Log.log(this, "404: DRIVE MODE NOT FOUND. [W]hat a [T]errible [F]ailure.", driveMode);
         //driveMode = MODE_TANK;
         userDriveCartesian();
         }*/

    }

    private void userDriveTank() {
        double leftValue = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        double rightValue = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);
        drive.tankDrive(leftValue, rightValue);
    }

    /**
     * Defines values to drive Cartesian mode. Gets values from controllers.
     */
    private void userDriveCartesian() {
        double rotation = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);
        drive.mecanumDrive_Cartesian(controlX, controlY, rotation, driveGyro.getAngle());
    }

    /**
     * Defines values to drive Polar mode. Gets values from controllers.
     */
    private void userDrivePolar() {
        double magnitude = -OI.getInstance().getRightJoystick().getMagnitude();
        double angle = -OI.getInstance().getRightJoystick().getAngle();
        double rotation = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        drive.mecanumDrive_Polar(magnitude, angle, rotation);
    }

    public void drive(double leftValue, double rightValue) {
        drive.tankDrive(leftValue, rightValue);
    }

    /**
     * Drives using given values. Default is Cartesian mode.
     *
     * @param magnitude speed of the robot
     * @param angle direction of the robot
     * @param rotation rate of rotation
     */
    public void drive(double magnitude, double angle, double rotation) {
        drive.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, driveGyro.getAngle());
    }

    /**
     * Drives using values as if they were joystick values. Used for recording
     * playback.
     *
     * @param x x magnitude
     * @param y y magnitude
     * @param rot rotation
     * @param mode drive mode to use
     */
    public void driveSimulate(double x, double y, double rot, int mode) {
        if (mode == MODE_TANK) {
            return;
        } else {
            if (mode == MODE_POLAR) {
                double magnitude = Math.sqrt(x * x + y * y); // --------------------------------- Negative did not work, drives the wrong way
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
    }

    /**
     * Stops the drive movement.
     */
    public void stop() {
        drive(0, 0);
        //drive(0, 0, 0);
    }

    /**
     * Returns result of camera or gyro PID.
     *
     * @return pCenter or getGyroAngle()
     */
    protected double returnPIDInput() {
        if (isCameraMode) {
            double pCenter = Camera.getInstance().getCenterX();
            Log.log(this, "pCenter:     " + pCenter, Log.LEVEL_DEBUG);
            return pCenter;
        } else {
            return getGyroAngle();
        }
    }

    /**
     * Used for record playback.
     *
     * @param rotationSpeed
     */
    protected void usePIDOutput(double rotationSpeed) {
        double controlX = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);
        drive.mecanumDrive_Cartesian(controlX, controlY, rotationSpeed, driveGyro.getAngle());
    }

    /**
     * Drive rotation tracking. NOT USED.
     *
     * @param setpoint
     */
    public void setSetpoint(double setpoint) {
        if (!isCameraMode) {
            super.setSetpoint(setpoint);
        } else {
            super.setSetpoint(0.0);
        }
    }

    /**
     * Switches the drive mode between Polar and Cartesian.
     */
    public void toggleDriveMode() {
        DSLog.log(5, "Tank");/*
         driveMode = (driveMode == MODE_CARTESIAN) ? MODE_POLAR : MODE_CARTESIAN;
         DSLog.log(5, (driveMode == MODE_CARTESIAN) ? "Cartesian" : "Polar");
         */

    }

    /**
     *
     * @return the current drive mode, DriveSubsystem.MODE_POLAR or
     * DriveSubsystem.MODE_CARTESIAN.
     */
    public int getDriveMode() {
        return driveMode;
    }

    /**
     * Gets raw gyro angle.
     *
     * @return the un-normalized gyro angle
     */
    public double getGyroAngle() {
        return -driveGyro.getAngle();
    }

    /**
     * Calibrates the gyro to use the current direction as zero.
     */
    public void calibrateGyro() {
        driveGyro.reset();
    }

    /**
     * Initialize default command.
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickMecanumCommand());
    }

    /**
     * Sets the PID mode to either camera or joystick.
     *
     * @param mode Whether or not to use camera PID mode (true), if false, uses
     * joystick PID
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
     * Return if camera PID is being used.
     *
     * @return whether the drive is using camera PID mode
     */
    public boolean getCameraMode() {
        return isCameraMode;
    }
}
