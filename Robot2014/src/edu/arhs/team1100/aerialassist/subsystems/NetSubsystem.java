/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.aerialassist.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author Team 1100
 */
public class NetSubsystem extends Subsystem {

    private DoubleSolenoid frontRightSolenoid;
    private DoubleSolenoid frontLeftSolenoid;
    private DoubleSolenoid backRightSolenoid;
    private DoubleSolenoid backLeftSolenoid;

    static NetSubsystem instance;
    private boolean isOpen = false;

    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons, intake
     * motors. Starts compressor.
     */
    public NetSubsystem() {

    }

    /**
     * Creates a NetSubsystem if not already created
     *
     * @return instance
     */
    public static NetSubsystem getInstance() {
        if (instance == null) {
            instance = new NetSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public void openNet() {
        //Opens the net
       
        frontLeftSolenoid.set(DoubleSolenoid.Value.kForward);
        frontRightSolenoid.set(DoubleSolenoid.Value.kForward);
        backLeftSolenoid.set(DoubleSolenoid.Value.kForward);
        backRightSolenoid.set(DoubleSolenoid.Value.kForward);
        
        isOpen = true;
    }

    public void closeNet() {
        //Closes the net

        frontLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
        frontRightSolenoid.set(DoubleSolenoid.Value.kReverse);
        backLeftSolenoid.set(DoubleSolenoid.Value.kReverse);
        backRightSolenoid.set(DoubleSolenoid.Value.kReverse);

        isOpen = false;
    }

    public void toggleNet() {
        if (isOpen) {
            this.closeNet();
        } else {
            this.openNet();
        }
    }

    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
