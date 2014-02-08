package edu.arhs.team1100.aerialassist.subsystems;

import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.drive.UserDriveCommand;
import edu.arhs.team1100.aerialassist.util.Log;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Encoder;
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
    private static final double ratio = 1;
    private static double offset = 0;
    private static boolean reverse = false;
    static DriveSubsystem instance;
    private DoubleSolenoid frontRightSolenoid;
    private DoubleSolenoid frontLeftSolenoid;
    private DoubleSolenoid backRightSolenoid;
    private DoubleSolenoid backLeftSolenoid;
    private Talon frontLeftTalonOne;
    private Talon frontRightTalonOne;
    private Talon backLeftTalonOne;
    private Talon backRightTalonOne;
    private Talon frontLeftTalonTwo;
    private Talon frontRightTalonTwo;
    private Talon backLeftTalonTwo;
    private Talon backRightTalonTwo;
    private RobotDrive driveOne;
    private RobotDrive driveTwo;
    private Gyro driveGyro;
    private Encoder encoderFrontRight;
    private Encoder encoderFrontLeft;
    private Encoder encoderBackRight;
    private Encoder encoderBackLeft;
    private int driveMode = MODE_TANK;
    private boolean mecanumWheelsLowered = true;
    private boolean encoderDrive = false;

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
     * Constructs a DriveSubsystem. Initialize drive Talons, drive encoders,
     * drive solenoids and gyro.
     */
    public DriveSubsystem() {
        super(kJoystickP, kJoystickI, kJoystickD);

        frontLeftSolenoid = new DoubleSolenoid(RobotMap.D_FRONT_LEFT_SOLENOID_PORTA, RobotMap.D_FRONT_LEFT_SOLENOID_PORTB);
        frontRightSolenoid = new DoubleSolenoid(RobotMap.D_FRONT_RIGHT_SOLENOID_PORTA, RobotMap.D_FRONT_RIGHT_SOLENOID_PORTB);
        backLeftSolenoid = new DoubleSolenoid(RobotMap.D_BACK_LEFT_SOLENOID_PORTA, RobotMap.D_BACK_LEFT_SOLENOID_PORTB);
        backRightSolenoid = new DoubleSolenoid(RobotMap.D_BACK_RIGHT_SOLENOID_PORTA, RobotMap.D_BACK_RIGHT_SOLENOID_PORTB);

        frontLeftTalonOne = new Talon(RobotMap.D_TALON_FRONT_LEFT);
        frontRightTalonOne = new Talon(RobotMap.D_TALON_FRONT_RIGHT);
        backLeftTalonOne = new Talon(RobotMap.D_TALON_BACK_LEFT);
        backRightTalonOne = new Talon(RobotMap.D_TALON_BACK_RIGHT);

        frontLeftTalonTwo = new Talon(RobotMap.D_TALON_FRONT_LEFT_TWO);
        frontRightTalonTwo = new Talon(RobotMap.D_TALON_FRONT_RIGHT_TWO);
        backLeftTalonTwo = new Talon(RobotMap.D_TALON_BACK_LEFT_TWO);
        backRightTalonTwo = new Talon(RobotMap.D_TALON_BACK_RIGHT_TWO);

        driveOne = new RobotDrive(
                frontLeftTalonOne,
                backLeftTalonOne,
                frontRightTalonOne,
                backRightTalonOne);

        driveTwo = new RobotDrive(
                frontLeftTalonTwo,
                backLeftTalonTwo,
                frontRightTalonTwo,
                backRightTalonTwo);
//
//        driveGyro = new Gyro(RobotMap.D_GYRO);
//        
//         encoderFrontRight.start();
//         encoderFrontLeft.start();
//         encoderBackRight.start();
//         encoderBackLeft.start();
//
//         encoderFrontRight = new Encoder(RobotMap.S_EN_FR_CNL, RobotMap.S_EN_FR_SLOT);
//         encoderFrontLeft = new Encoder(RobotMap.S_EN_FL_CNL, RobotMap.S_EN_FL_SLOT);
//         encoderBackRight = new Encoder(RobotMap.S_EN_BR_CNL, RobotMap.S_EN_BR_SLOT);
//         encoderBackLeft = new Encoder(RobotMap.S_EN_BL_CNL, RobotMap.S_EN_BL_SLOT);
//         
    }

    /**
     * Drives the robot using user input interpreted according to the current
     * drive mode (Polar, Cartesian, or Tank).
     */
    public void userDrive() {
        if (driveMode == MODE_CARTESIAN) {
            userDriveCartesian();
        } else if (driveMode == MODE_POLAR) {
            userDrivePolar();
        } else if (driveMode == MODE_TANK) {
            userDriveTank();
        } else {
            Log.log(this, "404: DRIVE MODE NOT FOUND. [W]hat a [T]errible [F]ailure.", driveMode);
            driveMode = MODE_TANK;
            userDriveTank();
        }
    }

    /**
     * Defines values to drive Cartesian mode. Gets values from controllers.
     */
    private void userDriveCartesian() {
        double rotation = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        driveOne.mecanumDrive_Cartesian(controlX, controlY, rotation, 0);
        driveTwo.mecanumDrive_Cartesian(controlX, controlY, rotation, 0);
    }

    /**
     * Defines values to drive Polar mode. Gets values from controllers.
     */
    private void userDrivePolar() {
        double magnitude = -OI.getInstance().getLeftJoystick().getMagnitude();
        double angle = -OI.getInstance().getLeftJoystick().getAngle();
        double rotation = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        driveOne.mecanumDrive_Polar(magnitude, angle, rotation);
        driveTwo.mecanumDrive_Polar(magnitude, angle, rotation);
    }

    /**
     * Defines values to drive Tank mode. Gets values from joysticks.
     */
    private void userDriveTank() {
        double leftValue = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        double rightValue = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);

        if (driveMode == MODE_TANK) {
            if (!reverse) {
                driveOne.tankDrive(leftValue, rightValue);
                driveTwo.tankDrive(leftValue, rightValue);
            } else if (reverse) {
                driveOne.tankDrive(-rightValue, -leftValue);
                driveTwo.tankDrive(-rightValue, -leftValue);
            }
        }
        if (encoderDrive) {
            //   driveTankEncoder(leftValue, rightValue);
        }
    }

    /**
     * Switches the drive mode to the value given. Lowers or raises wheels.
     *
     * @param driveMode = driveMode to set.
     */
    public void setDriveMode(int driveMode) {
        if (driveMode == MODE_TANK) {
            raiseMecWheels();
            this.driveMode = MODE_TANK;
        } else if (driveMode == MODE_CARTESIAN) {
            lowerMecWheels();
            this.driveMode = MODE_CARTESIAN;
        } else if (driveMode == MODE_POLAR) {
            lowerMecWheels();
            this.driveMode = MODE_POLAR;
        }
    }

    /**
     * Lowers mecanum wheels if they have been raised
     */
    private void lowerMecWheels() {
        if (!mecanumWheelsLowered) {
            frontLeftSolenoid.set(DoubleSolenoid.Value.kForward);
            frontRightSolenoid.set(DoubleSolenoid.Value.kForward);
            backLeftSolenoid.set(DoubleSolenoid.Value.kForward);
            backRightSolenoid.set(DoubleSolenoid.Value.kForward);
            mecanumWheelsLowered = true;
        }
    }

    /**
     * Raises mecanum wheels if they have been lowered
     */
    private void raiseMecWheels() {
        if (mecanumWheelsLowered) {
            frontLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
            frontRightSolenoid.set(DoubleSolenoid.Value.kReverse);
            backLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
            backRightSolenoid.set(DoubleSolenoid.Value.kReverse);
            mecanumWheelsLowered = false;
        }
    }

    /**
     * Drives using mecanum (if enabled) using given values. Default is
     * Cartesian mode.
     *
     * @param magnitude speed of the robot
     * @param angle direction of the robot
     * @param rotation rate of rotation
     */
    public void driveMecanum(double magnitude, double angle, double rotation) {
        if (driveMode == MODE_CARTESIAN || driveMode == MODE_POLAR) {
            driveOne.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, driveGyro.getAngle());
            driveTwo.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, driveGyro.getAngle());
        }
    }

    /**
     * Drives using tank (if enabled) using given values.
     *
     * @param leftValue speed of the left wheels
     * @param rightValue speed of the right wheels
     */
    public void driveTank(double leftValue, double rightValue) {
        if (driveMode == MODE_TANK) {
            if (!reverse) {
                driveOne.tankDrive(leftValue, rightValue);
                driveTwo.tankDrive(leftValue, rightValue);
            } else if (reverse) {
                driveOne.tankDrive(-rightValue, -leftValue);
                driveTwo.tankDrive(-rightValue, -leftValue);
            }
        }
        if (encoderDrive) {
            //   driveTankEncoder(leftValue, rightValue);
        }
    }

    /**
     * Drives using tank and encoders (if enabled) using given values.
     *
     * @param leftValue speed of the left wheels
     * @param rightValue speed of the right wheels
     */
    private void driveTankEncoder(double leftValue, double rightValue) {
//        if (driveMode == MODE_TANK) {
//            fixMotorSpeed(frontLeftTalonOne, frontLeftTalonTwo, encoderFrontLeft, leftValue);
//            fixMotorSpeed(backLeftTalonOne, backLeftTalonTwo, encoderBackLeft, leftValue);
//            fixMotorSpeed(frontRightTalonOne, frontRightTalonTwo, encoderFrontRight, rightValue);
//            fixMotorSpeed(backRightTalonOne, backRightTalonTwo, encoderBackRight, rightValue);
//        }
    }

    /**
     * Adds more power to the two wheels if the encoders do not a proper value
     * in the deadband
     *
     * @param wheelOne Talon of one of the wheels
     * @param wheelTwo Talon of the other wheel
     * @param ec Encoder used it read data
     * @param speed Speed that the motor should move
     */
    private void fixMotorSpeed(Talon wheelOne, Talon wheelTwo, Encoder ec, double speed) {
        speed = speed * ratio;
        while (ec.getRate() < speed - 50 || ec.getRate() > speed + 50) {
            if (ec.getRate() < speed - 50) {
                wheelOne.set(wheelOne.getRaw() + .01);
                wheelTwo.set(wheelTwo.getRaw() + .01);
            }
            if (ec.getRate() > speed + 50) {
                wheelOne.set(wheelOne.getRaw() - .01);
                wheelTwo.set(wheelTwo.getRaw() - .01);
            }
        }
    }

    /**
     * Switches the drive mode between Polar and Cartesian. If the user is in
     * tank mode, cartesian is activated.
     */
    public void toggleMecDriveMode() {
        if (driveMode == MODE_CARTESIAN) {
            setDriveMode(MODE_POLAR);
        } else {
            setDriveMode(MODE_CARTESIAN);
        }
    }

    /**
     * Toggles between tank drive mode and mecanum drive mode. Default mecanum
     * drive is cartesian
     */
    public void toggleDriveMode() {
        if (driveMode == MODE_CARTESIAN || driveMode == MODE_POLAR) {
            setDriveMode(MODE_TANK);
            System.out.println("Set To Tank");
        } else {
            setDriveMode(MODE_POLAR);
            System.out.println("Set To Mec");
        }
    }

    /**
     * Toggles EncoderDrive
     */
    public void toggleEncoderDrive() {
        encoderDrive = !encoderDrive;
    }

    /**
     * Stops the drive movement.
     */
    public void stop() {
        if (driveMode == MODE_CARTESIAN || driveMode == MODE_POLAR) {
            driveMecanum(0, 0, 0);
        } else if (driveMode == MODE_TANK) {
            driveTank(0, 0);
        }
    }

    /**
     * @return the current drive mode, DriveSubsystem.MODE_POLAR or
     * DriveSubsystem.MODE_CARTESIAN or DriveSubsystem.MODE_TANK.
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
     * Gets whether encoder drive has been enabled, in String form
     *
     * @return Enabled or Disabled as a String
     */
    public String getEncoderDrive() {
        String output;
        if (encoderDrive) {
            output = "Enabled";
        } else {
            output = "Disabled";
        }
        return output;
    }

    /**
     * Get the value of a specific encoder
     *
     * @param encoder Integer between 1-4,
     * @return rate of specific encoder
     */
    public double getEncoderValue(int encoder) {
        switch (encoder) {
            case 1:
                return encoderFrontLeft.getRate();
            case 2:
                return encoderFrontRight.getRate();
            case 3:
                return encoderBackLeft.getRate();
            case 4:
                return encoderBackRight.getRate();
        }
        return 0;

    }

    /**
     * Toggles the front of the robot
     */
    public void toggleReverseDirection() {
        offset += 180;
        reverse = !reverse;
    }

    /**
     * Initialize default command.
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new UserDriveCommand());
    }

    /**
     * Used for record playback.
     *
     * @param rotationSpeed
     */
    protected void usePIDOutput(double rotationSpeed) {
        double controlX = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);
        driveOne.mecanumDrive_Cartesian(controlX, controlY, rotationSpeed, driveGyro.getAngle());
        driveTwo.mecanumDrive_Cartesian(controlX, controlY, rotationSpeed, driveGyro.getAngle());
    }

    /**
     * Returns PID input
     *
     * @return 0
     */
    protected double returnPIDInput() {
        return 0;
    }
}
