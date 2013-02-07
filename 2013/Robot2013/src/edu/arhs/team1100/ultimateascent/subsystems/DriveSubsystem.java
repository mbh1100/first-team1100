package edu.arhs.team1100.ultimateascent.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.JoystickMecanumCommand;
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
    private static final int MODE_CARTESIAN = 0;
    private static final int MODE_POLAR = 1;
    public static final double P = 0.02;
    public static final double I = 0.0001;
    public static final double D = 0.0005;
    static DriveSubsystem instance;
    private RobotDrive drive;
    private Gyro driveGyro;
    private Talon frontLeftTalon;
    private Talon frontRightTalon;
    private Talon backLeftTalon;
    private Talon backRightTalon;
    private int driveMode = MODE_CARTESIAN;

    public static DriveSubsystem getInstance() {
        if (instance == null) {
            instance = new DriveSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public DriveSubsystem() {
        super(P, I, D);//SUPER PID!!!!
        Log.log(this, "Constructor", Log.LEVEL_DEBUG);

        frontLeftTalon = new Talon(RobotMap.D_TALON_FRONT_LEFT_CHANNEL);
        frontRightTalon = new Talon(RobotMap.D_TALON_FRONT_RIGHT_CHANNEL);
        backLeftTalon = new Talon(RobotMap.D_TALON_BACK_LEFT_CHANNEL);
        backRightTalon = new Talon(RobotMap.D_TALON_BACK_RIGHT_CHANNEL);
        drive = new RobotDrive(
                frontLeftTalon,
                frontRightTalon,
                backLeftTalon,
                backRightTalon);
        driveGyro = new Gyro(RobotMap.D_GYRO_CHANNEL);

    }

    public void userDrive() {
        DSLog.log(1, "Drive Mode: " + ((driveMode == MODE_POLAR) ? "POLAR" : "CARTESIAN"));
        DSLog.log(2, "Gyro angle: " + Log.round(driveGyro.getAngle(), 2));

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
        double magnitude = OI.getInstance().getLeftJoystick().getMagnitude();
        double angle = -OI.getInstance().getLeftJoystick().getAngle();
        double rotation = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        drive.mecanumDrive_Polar(magnitude, angle, rotation);
    }

    public void drive(double magnitude, double angle, double rotation) {
        drive.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, driveGyro.getAngle());
    }

    public void driveSimulate(double x, double y, double rot, int mode) {
        if (mode == MODE_POLAR) {
            double magnitude = -Math.sqrt(x * x + y * y);
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

    public void stop() {
        drive(0, 0, 0);
    }

    protected double returnPIDInput() {
        return getGyroAngle();
    }

    protected void usePIDOutput(double rotationSpeed) {
        double controlX = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);

        drive.mecanumDrive_Cartesian(controlX, controlY, rotationSpeed, driveGyro.getAngle());
    }

    public void toggleDriveMode() {
        driveMode = (driveMode == MODE_CARTESIAN) ? MODE_POLAR : MODE_CARTESIAN;
    }

    public int getDriveMode() {
        return driveMode;
    }

    public double getGyroAngle() {
        return -driveGyro.getAngle();
    }

    public void calibrateGyro() {
        driveGyro.reset();
    }

    public Talon getFrontLeftTalon() {
        return frontLeftTalon;
    }

    public Talon getFrontRightTalon() {
        return frontRightTalon;
    }

    public Talon getBackLeftTalon() {
        return backLeftTalon;
    }

    public Talon getBackRightTalon() {
        return backRightTalon;
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickMecanumCommand());
    }

    public void setDefaultMecanumCommand(Command command) {
        setDefaultCommand(command);
    }
}