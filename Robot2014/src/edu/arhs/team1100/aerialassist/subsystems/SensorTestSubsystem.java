/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.subsystems;

import edu.arhs.team1100.aerialassist.util.DSLog;
import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.commands.drive.GyroTestCommand;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Team 1100
 */
public class SensorTestSubsystem extends Subsystem {

    static SensorTestSubsystem instance;
    Gyro gy;
    Accelerometer ac;
    Encoder ec;
    DSLog ds;
    private double wheelSpeed = .5;

    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons, intake
     * motors. Starts compressor.
     */
    public SensorTestSubsystem() {
       // ac = new Accelerometer(RobotMap.S_AC_1q);
        gy = new Gyro(1, RobotMap.S_GY_CNL);
        //ec = new Encoder(RobotMap.S_EN_FL_SLOT, RobotMap.S_EN_FL_CNL);
        // ec.start();
    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static SensorTestSubsystem getInstance() {
        if (instance == null) {
            instance = new SensorTestSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public void encoderTest() {
        System.out.println(ec.getRate());

        DSLog.log(1, Double.toString(ec.getRate()));

    }

    public void acTest() {
        //  DSLog.log(1, Double.toString(ac.getAcceleration()));
    }

    public void gyroTest() {
        DSLog.log(1, Double.toString(gy.getAngle()));

        System.out.println(gy.getAngle());

    }

    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new GyroTestCommand());
    }
}
