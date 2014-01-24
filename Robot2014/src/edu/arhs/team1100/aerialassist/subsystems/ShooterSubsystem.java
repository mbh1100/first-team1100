/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.subsystems;
import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 * @author Team 1100
 */
public class ShooterSubsystem extends Subsystem {
    
    static ShooterSubsystem instance;
    private Talon armMotor;
    private Talon wheelMotor;
    private double wheelSpeed = .5;
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public ShooterSubsystem() {
        armMotor = new Talon(RobotMap.M_ARM);
        wheelMotor = new Talon(RobotMap.M_WHEEL);
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


    public void moveArm()
    {
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kY) / 1.5;
        armMotor.set(speed);
    }

    public void fireShooter() {
        armMotor.set(1);
        //wait for encoders
        //set wheel speed for spin
        this.stopArm();
    }
    
    public void stopArm()
    {
        armMotor.set(0);
    }
    

    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
        moveArm();
    }
}
