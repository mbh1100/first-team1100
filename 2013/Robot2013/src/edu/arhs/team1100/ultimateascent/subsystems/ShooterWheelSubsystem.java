/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.PIDController;

/**
 *
 * @author team1100
 */
public class ShooterWheelSubsystem extends PIDSubsystem {
    
    private static final double P = 0;
    private static final double I = 0;
    private static final double D = 0;

    static ShooterWheelSubsystem instance;
    private Talon shooterWheel;
    private Encoder wheelEncoder;

    public ShooterWheelSubsystem() {
        super(P, I, D);
        shooterWheel = new Talon(RobotMap.S_TALON_SHOOTER_WHEEL_CHANNEL);
        wheelEncoder = new Encoder(RobotMap.S_ENCODER_CHANNEL_A, RobotMap.S_ENCODER_CHANNEL_B);
    }

    public ShooterWheelSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterWheelSubsystem();
            instance.initDefaultCommand();
        }
        return instance;

    }

    public void SpinWheel() {
        
    }

    public void StopSpinning() {
        shooterWheel.set(0);
    }

    protected double returnPIDInput() {
        return 0;
    }

    protected void usePIDOutput(double output) {
    }

    protected void initDefaultCommand() {
    }
}
