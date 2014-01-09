package edu.arhs.team1100.aerialassist.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.drive.JoystickMecanumCommand;
import edu.arhs.team1100.aerialassist.util.DSLog;
import edu.arhs.team1100.aerialassist.util.Log;
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
    static DriveSubsystem instance;
    private RobotDrive drive;
    private Gyro driveGyro;
    private int driveMode = MODE_CARTESIAN;

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

                
    }

    /**
     * Drives the robot using user input interpreted according to the current
     * drive mode (Polar or Cartesian).
     */
    public void userDrive() {
        if (driveMode == MODE_CARTESIAN) {
            userDriveCartesian();
        } else if (driveMode == MODE_POLAR) {
            userDrivePolar();
        } else if(driveMode == MODE_TANK) {
            userDriveTank();
        } else {
            Log.log(this, "404: DRIVE MODE NOT FOUND. [W]hat a [T]errible [F]ailure.", driveMode);
            driveMode = MODE_TANK;
            userDriveTank();
        }
      
    }

    /**
     * Defines values to drive Tank mode. Gets values from joysticks.
     * 
     */
    private void userDriveTank()
    {
        double leftSpeed = -OI.getInstance().getLeftJoystick().getMagnitude();
        double rightSpeed = -OI.getInstance().getRightJoystick().getMagnitude();
        
        drive.tankDrive(leftSpeed, rightSpeed);
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

    /**
     * Drives using mecanum (if enabled) using given values. Default is Cartesian mode.
     *
     * @param magnitude speed of the robot
     * @param angle direction of the robot
     * @param rotation rate of rotation
     */
    public void driveMecanum(double magnitude, double angle, double rotation) {
        if(driveMode == MODE_CARTESIAN || driveMode == MODE_POLAR){
            drive.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, driveGyro.getAngle());
        }
    }
    
    /**
     * Drives using tank (if enabled) using given values.
     *
     * @param leftValue speed of the left wheels
     * @param rightValue speed of the right wheels
     */
    public void driveTank(double leftValue, double rightValue ){
        if (driveMode == MODE_TANK){
            drive.tankDrive(leftValue, rightValue);
        }
    }

    /**
     * Stops the drive movement.
     */
    public void stop() {
        if(driveMode == MODE_CARTESIAN || driveMode == MODE_POLAR){
            driveMecanum(0, 0, 0);
        } else if (driveMode == MODE_TANK){
            drive.tankDrive(0, 0); 
        }
    }

    /**
     * Returns result of camera or gyro PID.
     *
     * @return pCenter or getGyroAngle()
     */
    

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
     * Switches the drive mode between Polar and Cartesian.
     */
    public void toggleDriveMode() {
        if(driveMode == MODE_CARTESIAN)
        {
            setDriveMode("POLAR");
        }
        else
        {
            setDriveMode("CARTESIAN");
        }
        DSLog.log(5, (driveMode == MODE_CARTESIAN) ? "Cartesian" : "Polar");
    }
    
    /**
     * Switches the drive mode to the value given. Lowers or Raises wheels if octaconem drive is used.
     * @param driveMode = driveMode to set.
     */
    public void setDriveMode(String driveMode)
    {
        if(driveMode.equals("TANK"))
        {
            //Lower Tank Wheels
            this.driveMode = MODE_TANK;
        }
        if(driveMode.equals("CARTESIAN"))
        {
            //If tank wheels are lowered, raise them.
            this.driveMode = MODE_CARTESIAN;
        }
        if(driveMode.equals("POLAR"))
        {
            //if tank wheels are lowered, raise them.
            this.driveMode = MODE_POLAR;
        }
            
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

    protected double returnPIDInput() {
        return 0;
    }


}