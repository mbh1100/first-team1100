package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.shooter.TiltShooterCommand;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 * @author akshay
 */
public class ShooterTiltSubsystem extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
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
        super(Kp, Ki, Kd);
        tiltMotor = new Victor(RobotMap.S_VICTOR_SHOOTER_TILT_CHANNEL);
    }

    public void tilt(double speed) {
        tiltMotor.set(speed / 2);

    }
    
    public void stop(){
        tiltMotor.set(0.0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TiltShooterCommand());
    }

    protected double returnPIDInput() {
        return Camera.getInstance().getCenterY();
    }

    protected void usePIDOutput(double output) {
        tiltMotor.set(output);
    }
}
