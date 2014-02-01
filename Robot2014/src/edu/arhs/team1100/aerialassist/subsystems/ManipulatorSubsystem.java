/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.subsystems;
import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 * @author Team 1100
 */
public class ManipulatorSubsystem extends Subsystem {
    
    static ManipulatorSubsystem instance;
    private Talon armMotorOne;
    private Talon armMotorTwo;
    private DoubleSolenoid clamp;
    private double wheelSpeed = .5;
    boolean isClamped = false;
    private Encoder ec;
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public ManipulatorSubsystem() {
        armMotorOne = new Talon(RobotMap.M_TALON_LEFT_WHEEL);
        armMotorTwo = new Talon(RobotMap.M_TALON_RIGHT_WHEEL);
        clamp = new DoubleSolenoid(RobotMap.M_CLAMP_IN, RobotMap.M_CLAMP_OUT);
        ec = new Encoder(RobotMap.M_EN_SLOT, RobotMap.M_EN_CNL);
        ec.start();
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


    public void moveArm()
    {
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kZ) / 1.5;
        armMotorOne.set(speed);
        armMotorTwo.set(-speed);
    }
    
    public void stopArm()
    {
        armMotorOne.set(0);
        armMotorTwo.set(0);
    }
    
    public double getEncoder()
    {
        return ec.get();
    }
    
    public void setCount(double count)
    {
        while(ec.get() > count+20 || ec.get() < count-20)
        {
            while(ec.get() <= count-10)
            {
               armMotorOne.set(.2);
            }
            while(ec.get() >= count+10)
            {
                armMotorTwo.set(.2);
            }
        }
    }
    
    /**
     * Toggles the state of the floor pickup.
     */
    public void toggleClamp() {
        if(isClamped)clamp.set(DoubleSolenoid.Value.kReverse);
        if(!isClamped)clamp.set(DoubleSolenoid.Value.kForward);
        isClamped = !isClamped;
    }


    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
        moveArm();
    }
}
