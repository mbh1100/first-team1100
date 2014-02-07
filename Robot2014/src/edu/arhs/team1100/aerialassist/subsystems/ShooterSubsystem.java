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
    DoubleSolenoid shooterSolenoid;
    Victor rightInMotor;
    Victor leftInMotor;
    //Ball detector sensor
    private final double IN_MOTOR_SPEED = .5;

     
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public ShooterSubsystem() {
         shooterSolenoid = new DoubleSolenoid(RobotMap.M_FIST_PORTA, RobotMap.M_FIST_PORTB);
         rightInMotor = new Victor(RobotMap.M_RIGHT_VECTOR_SLOT, RobotMap.M_RIGHT_VECTOR_CNL);
         leftInMotor = new Victor(RobotMap.M_LEFT_VECTOR_SLOT, RobotMap.M_RIGHT_VECTOR_CNL);

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


    public void fireShooter() {
        shooterSolenoid.set(DoubleSolenoid.Value.kForward);
        resetShooter();
    }
    
    public void resetShooter()
    {
        shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
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
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
