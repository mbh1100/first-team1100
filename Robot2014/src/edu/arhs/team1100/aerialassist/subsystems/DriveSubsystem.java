package edu.arhs.team1100.aerialassist.subsystems;

import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.drive.UserDriveCommand;
import edu.arhs.team1100.aerialassist.util.Log;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

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
    public static final double P = 1;   //.2 before
    public static final double I = 0.0001;
    public static final double D = 0.000;
    private static final double ratio = 1;
    private static double offset = 0;
    public static boolean reverse = false;
    static DriveSubsystem instance;
    private DoubleSolenoid rightSolenoid;
    private DoubleSolenoid leftSolenoid;
    private DoubleSolenoid backRightSolenoid;
    private DoubleSolenoid backLeftSolenoid;
    private Talon frontLeftTalonOne;
    private Talon frontRightTalonOne;
    private Talon backLeftTalonOne;
    private Talon backRightTalonOne;
    private RobotDrive driveOne;
    private RobotDrive driveTwo;
    private Gyro driveGyro;
    private Encoder encoderWheels;
    private Encoder encoderFrontLeft;
    private Encoder encoderBackRight;
    private Encoder encoderBackLeft;
    private AnalogChannel ultra;
    private int driveMode = MODE_TANK;
    private boolean mecanumWheelsLowered = true;
    private boolean encoderDrive = false;
    private double[] ultraArray = new double[10];
    private AnalogChannel lightSensor;

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
        super(P, I, D);
        super.setAbsoluteTolerance(.05);
        lightSensor = new AnalogChannel(4);
        leftSolenoid = new DoubleSolenoid(RobotMap.D_LEFT_SOLENOID_A, RobotMap.D_LEFT_SOLENOID_B);
        rightSolenoid = new DoubleSolenoid(RobotMap.D_RIGHT_SOLENOID_A, RobotMap.D_RIGHT_SOLENOID_B);

        frontLeftTalonOne = new Talon(RobotMap.D_TALON_FRONT_LEFT);
        frontRightTalonOne = new Talon(RobotMap.D_TALON_FRONT_RIGHT);
        backLeftTalonOne = new Talon(RobotMap.D_TALON_BACK_LEFT);
        backRightTalonOne = new Talon(RobotMap.D_TALON_BACK_RIGHT);

        driveOne = new RobotDrive(
                frontLeftTalonOne,
                backLeftTalonOne,
                frontRightTalonOne,
                backRightTalonOne);

        driveOne.setInvertedMotor(MotorType.kFrontRight, true);
        driveOne.setInvertedMotor(MotorType.kRearRight, true);
        driveOne.setInvertedMotor(MotorType.kFrontLeft, false);
        driveOne.setInvertedMotor(MotorType.kRearLeft, false);

        driveGyro = new Gyro(RobotMap.S_GY_CNL);
        encoderWheels = new Encoder(RobotMap.S_EN_W_A, RobotMap.S_EN_W_B);
        ultra = new AnalogChannel(RobotMap.S_ULTRA_B);
        encoderWheels.start();
    }

    /**
     * Drives the robot using user input interpreted according to the current
     * drive mode (Polar, Cartesian, or Tank).
     */
    public void userDrive() throws DriverStationEnhancedIO.EnhancedIOException {
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
    
    public boolean getLightSensor()
    {
        if(lightSensor.getValue() == 2)
        {
            return true;
        }
        else return false;
    }

    /**
     * Defines values to drive Cartesian mode. Gets values from controllers.
     */
    private void userDriveCartesian() throws DriverStationEnhancedIO.EnhancedIOException {
        double rotation = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        driveOne.mecanumDrive_Cartesian(controlX, controlY, rotation, getGyroAngle()+180);
    }

    /**
     * Defines values to drive Polar mode. Gets values from controllers.
     */
    private void userDrivePolar() throws DriverStationEnhancedIO.EnhancedIOException {
        double rotation = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        driveOne.mecanumDrive_Cartesian(controlX, controlY, rotation, 0);

    }

    /**
     * Defines values to drive Tank mode. Gets values from joysticks.
     */
    private void userDriveTank() throws DriverStationEnhancedIO.EnhancedIOException {
        double leftValue = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        double rightValue = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);

        if (driveMode == MODE_TANK) {
            if (!reverse) {
                driveOne.tankDrive(leftValue, rightValue);
            } else if (reverse) {
                driveOne.tankDrive(rightValue, leftValue);
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
            leftSolenoid.set(DoubleSolenoid.Value.kForward);
            rightSolenoid.set(DoubleSolenoid.Value.kForward);
            mecanumWheelsLowered = true;
        }
    }

    /**
     * Raises mecanum wheels if they have been lowered
     */
    private void raiseMecWheels() {
        if (mecanumWheelsLowered) {
            leftSolenoid.set(DoubleSolenoid.Value.kReverse);
            rightSolenoid.set(DoubleSolenoid.Value.kReverse);
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
            driveOne.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, -driveGyro.getAngle());
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
            } else if (reverse) {
                driveOne.tankDrive(-rightValue, -leftValue);
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
    public double getEncoderValue() {
        return encoderWheels.getRate();
    }
    
    public double getEncoderTick()
    {
        return encoderWheels.get();
    }

    public double getUltrasonic() {
        return ultra.getVoltage();
    }
    
    public double getUltrasonicAverage()
    {
        int average =0;
        for(int a = 1; a<=10; a++)
        {
            average += getUltrasonic();
        }
        return average/10;
        
    }
    public double getInches() {
        return getUltrasonic() / 9.76;
    }
    
    public double getInchesAverage() {
        return getUltrasonicAverage() / 9.76;
    }

    /**
     * Toggles the front of the robot
     */
    public void toggleReverseDirection() {
        reverse = !reverse;
    }

    /**
     * Initialize default command.z
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new UserDriveCommand());
    }

    /**
     * Used for record playback.
     *
     * @param rotationSpeed
     */
    protected void usePIDOutput(double speed) {
        driveOne.mecanumDrive_Polar(speed/1.5, 0, 0);
    }

    public String getMotorControlerSpeeds() {
        return "FL: " + Math.floor(frontLeftTalonOne.getSpeed()) + "\nFR: " + Math.floor(frontRightTalonOne.getSpeed()) + "\nBL: " + Math.floor(backLeftTalonOne.getSpeed()) + "   BR: " + Math.floor(backRightTalonOne.getSpeed());
    }

    public void driveTankEncoderTicks(double speed, double ticks) {
        driveOne.tankDrive(speed, speed);
    }
    
    public void resetWheelEncoder()
    {
        encoderWheels.reset();
    }

    /**
     * Returns PID input
     *
     * @return 0
     */
    protected double returnPIDInput() {
        return getUltrasonic();
    }
}