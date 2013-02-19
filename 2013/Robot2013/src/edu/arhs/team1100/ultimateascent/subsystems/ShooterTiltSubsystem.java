package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.shooter.TiltShooterCommand;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 * @author akshay
 */
public class ShooterTiltSubsystem extends PIDSubsystem {

    private static final double P = 0.7;
    private static final double I = 0.01;
    private static final double D = 0.05;
    private static ShooterTiltSubsystem instance;
    private Victor tiltMotor;

    public static ShooterTiltSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterTiltSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }
    // Initialize your subsystem here

    public ShooterTiltSubsystem() {
        super(P, I, D);
        tiltMotor = new Victor(RobotMap.S_VICTOR_SHOOTER_TILT);
    }

    public void doTilt() {
        
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kY);
        tiltMotor.set(speed);

    }
    
    public void stop(){
        tiltMotor.set(0.0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TiltShooterCommand());
    }

    protected double returnPIDInput() {
        return -Camera.getInstance().getCenterY();
    }

    protected void usePIDOutput(double output) {
        tiltMotor.set(output);
    }
}
