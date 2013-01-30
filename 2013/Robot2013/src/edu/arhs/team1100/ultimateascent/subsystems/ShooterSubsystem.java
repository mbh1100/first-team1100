/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
                                                                                            import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Jason
 */
public class ShooterSubsystem extends PIDSubsystem {

    public static final double P = 0.002;
    public static final double I = 0.0001;//1;
    public static final double D = 0.0005;
    
    private static final double SHOOT_SPEED = 0; //Encoder value for coreect shooting speed
    
    static ShooterSubsystem instance;
    
    private Talon shooterControl;
    private Encoder shooterWheelEncoder;

    public static ShooterSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public ShooterSubsystem() {
        super(P, I, D);//SUPER PID!!!!
        shooterControl = new Talon(RobotMap.S_TALON_SHOOTER_WHEEL_CHANNEL);
        shooterWheelEncoder = new Encoder(RobotMap.S_ENCODER_CHANNEL_A, RobotMap.S_ENCODER_CHANNEL_B);
    }

    private void spinWheel() {
    }

    private void tryShot() {
    }

    protected double returnPIDInput() {
        return 0.0;
    }

    protected void usePIDOutput(double rotationSpeed) {
    }

    public Talon getShooterController() {
        return shooterControl;
    }

    protected void initDefaultCommand() {
    }
}
