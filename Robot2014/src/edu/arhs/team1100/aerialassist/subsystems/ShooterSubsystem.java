/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.subsystems;
import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 * @author Team 1100
 */
public class ShooterSubsystem extends Subsystem {
    
    static ShooterSubsystem instance;
    DoubleSolenoid firingCylinder;
    DoubleSolenoid latchCylinder;
    Victor rightInMotor;
    Victor leftInMotor;
    private boolean isClamped = false;  
    //Ball detector sensor
    private final double IN_MOTOR_SPEED = .5;

     
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public ShooterSubsystem() {
         //firingCylinder = new DoubleSolenoid(RobotMap.M_FIST_PORTA, RobotMap.M_FIST_PORTB);
         latchCylinder = new DoubleSolenoid(RobotMap.M_CLAMP_IN, RobotMap.M_CLAMP_OUT);
         //rightInMotor = new Victor(RobotMap.M_RIGHT_VECTOR_SLOT, RobotMap.M_RIGHT_VECTOR_CNL);
         //leftInMotor = new Victor(RobotMap.M_LEFT_VECTOR_SLOT, RobotMap.M_RIGHT_VECTOR_CNL);

    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static ShooterSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }


    public void ShootFireCylinder() {
        latchCylinder.set(DoubleSolenoid.Value.kForward);
        firingCylinder.set(DoubleSolenoid.Value.kForward);
        
        /*
        pull on the firing cylinder to stretch the elastic
        set the latch to hold the cylinder in place (if the latch is spring-loaded, this may occur before the previous step)
        push on the firing cylinder to help push the ball
        release the latch when directed by the operator
        */
        resetShooter();
    }
    
    public void resetShooter()
    {
        firingCylinder.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void rollIn()
    {
        rightInMotor.set(-IN_MOTOR_SPEED);
        leftInMotor.set(IN_MOTOR_SPEED);
    }
    
    public void rollOut()
    {
        rightInMotor.set(IN_MOTOR_SPEED);
        leftInMotor.set(-IN_MOTOR_SPEED);

    }
    
    /**
     * Toggles the state of the floor pickup.
     */
    public void toggleLatchCylinder() {
        if(isClamped)latchCylinder.set(DoubleSolenoid.Value.kReverse);
        if(!isClamped)latchCylinder.set(DoubleSolenoid.Value.kForward);
        isClamped = !isClamped;
    }


    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
    }

    public void setLatch(int i) {
        if(i == 1)latchCylinder.set(DoubleSolenoid.Value.kForward);
        if(i == 2)latchCylinder.set(DoubleSolenoid.Value.kReverse);
    }
}
