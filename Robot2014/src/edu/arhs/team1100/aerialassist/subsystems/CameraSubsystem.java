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
public class CameraSubsystem extends Subsystem {
    
    static CameraSubsystem instance;
    private Talon armMotor;
    private Talon wheelMotorA;
    private Talon wheelMotorB;
    private double wheelSpeed = .5;
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public CameraSubsystem() {
        armMotor = new Talon(RobotMap.M_ARM);
        wheelMotorA = new Talon(RobotMap.M_RIGHT_WHEEL);
        wheelMotorB = new Talon(RobotMap.M_LEFT_WHEEL);
    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static CameraSubsystem getInstance() {
        if (instance == null) {
            instance = new CameraSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }


    public boolean seeHotGoal(){
        return true;
    }
    
    public boolean seeReflectiveTape(){
        return true;
    }
    
    
    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
        seeHotGoal();
    }
}