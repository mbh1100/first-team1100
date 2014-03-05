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

/**
 *
 * @author Team 1100
 */
public class ManipulatorSubsystem extends PIDSubsystem {
    
    static ManipulatorSubsystem instance;
    private final int FIRE_A_COUNT = 0;
    private final int MIDDLE_COUNT = 24000;
    private final int FIRE_B_COUNT = 0;
    private Talon armMotorOne;
    private Talon armMotorTwo;
    boolean isClamped = false;
    private Encoder ec;
    private static final double P = 0.6187523487145693102;
    private static final double I = 0.178695554768894223459;
    private static final double D = 0.2;

    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons, intake
     * motors. Starts compressor.
     */
    public ManipulatorSubsystem() {
        super(P, I, D);
        armMotorOne = new Talon(RobotMap.M_TALON_LEFT_WHEEL);
        armMotorTwo = new Talon(RobotMap.M_TALON_RIGHT_WHEEL);
        ec = new Encoder(RobotMap.S_EN_ARM_A, RobotMap.S_EN_ARM_B);
        ec.start();
        ec.reset();
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
        if (Math.abs(speed) > .2) {
            moveArmSet(-speed);
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
    
    public void setCount(double count) {
        super.setSetpoint(count);
        /*while (ec.get() > count + 20 || ec.get() < count - 20) {
         while (ec.get() <= count - 10) {
         armMotorOne.set(.2);
         }
         while (ec.get() >= count + 10) {
         armMotorTwo.set(.2);
         }
         }
         stopArm();*/
    }
    
    public void moveArmSet(double speed) {
        armMotorOne.set(speed);
        armMotorTwo.set(-speed);
    }
    
    public void setFirePositionA()
    {
        setCount(FIRE_A_COUNT);
    }
    
    public void setFirePositionB()
    {
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
        armMotorOne.pidWrite(output);
        armMotorTwo.pidWrite(-output);
    }
    
}
