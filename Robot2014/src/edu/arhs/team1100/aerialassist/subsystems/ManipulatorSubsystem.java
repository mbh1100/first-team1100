/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.subsystems;

import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.drive.UserDriveCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.MoveArmCommandRecur;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Team 1100
 */
public class ManipulatorSubsystem extends PIDSubsystem {

    static ManipulatorSubsystem instance;
    private final int FIRE_A_COUNT = 10000;
    private final int MIDDLE_COUNT = 0;
    private final int FIRE_B_COUNT = 0;
    private final int MAX_DISTANCE = 5000;
    private Talon armMotorOne;
    private Talon armMotorTwo;
    private DigitalInput LMSWTCHONE;
    private DigitalInput LMSWTCHTWO;
    boolean isClamped = false;
    private Encoder ec;
    public static final double P = .01;
    public static final double I = 0;
    public static final double D = 0;
    public static final double PMIN = -1;
    public static final double PMAX = 1;
    private boolean goingToMiddle;

   
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons, intake
     * motors. Starts compressor.
     */
    public ManipulatorSubsystem() {
        super(P, I, D);
        super.setInputRange(-5000, 5000);
        LMSWTCHONE = new DigitalInput(13);
        LMSWTCHTWO = new DigitalInput(14);

        armMotorOne = new Talon(RobotMap.M_TALON_LEFT_WHEEL);
        armMotorTwo = new Talon(RobotMap.M_TALON_RIGHT_WHEEL);
        ec = new Encoder(RobotMap.S_EN_ARM_A, RobotMap.S_EN_ARM_B);
        ec.start();
        ec.reset();
        super.setAbsoluteTolerance(20);
    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static ManipulatorSubsystem getInstance() {
        if (instance == null) {
            instance = new ManipulatorSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public void moveArm() throws DriverStationEnhancedIO.EnhancedIOException {
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kY);
        if (speed < 0 && getEncoder() > 3950 || speed > 0 && getEncoder() < -3950) {
            speed = 0;
        }
        if (Math.abs(speed) > .2) {   //&& Math.abs(getEncoder()) < MAX_DISTANCE
            if (/*getEncoder() > 3850*/LMSWTCHTWO.get() && speed > 0) {
                System.out.println("MovingWitchout one");
                super.disable();
                goingToMiddle = false;
                moveArmSet(-speed);
            }
            if (/*getEncoder() < -3950 */LMSWTCHONE.get() && speed < 0) {
                System.out.println("MovingWitchout two");
                super.disable();
                goingToMiddle = false;
                moveArmSet(-speed);
            }
            if (!LMSWTCHTWO.get() && !LMSWTCHONE.get() && getEncoder() < 3950 && getEncoder() > -3950) {
                System.out.println("MovingWitchout three");

                super.disable();
                goingToMiddle = false;
                moveArmSet(-speed);
            }
        } else {
            moveArmSet(0);
        }
    }

    public void stopArm() {
        moveArmSet(0);
    }

    public double getEncoder() {
        return ec.get();
    }

    public void EncoderReset() {
        ec.reset();
    }

    public boolean onTargetRemake() {
        if (Math.abs(super.getSetpoint() - getEncoder()) < 100) {
            return true;
        } else {
            return false;
        }
    }

    public void setCount(double count) {
        super.setSetpoint(count);
        super.enable();
    }

    public void moveArmSet(double speed) {
        armMotorOne.set(speed / 3);
        armMotorTwo.set(-speed / 3);
    }

    public void setFirePositionA() {
        setCount(FIRE_A_COUNT);
    }

    public void setFirePositionB() {
        setCount(FIRE_B_COUNT);
    }

    public void setMiddlePos() {
        setCount(MIDDLE_COUNT);
    }

    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveArmCommandRecur());
    }

    public String getEncoderValue() {
        return "" + ec.get();
    }

    protected double returnPIDInput() {
        return ec.get();
    }

    protected void usePIDOutput(double output) {
        if (this.getSetpoint() > 3500 || goingToMiddle) {
            armMotorOne.pidWrite((.5) * output);
            armMotorTwo.pidWrite((.5) * -output);
        } else {
            armMotorOne.pidWrite(output / 4);
            armMotorTwo.pidWrite(-output / 4);
        }
    }
    
     public void setGoingToMiddle(boolean goingToMiddle) {
        this.goingToMiddle = goingToMiddle;
    }


}
