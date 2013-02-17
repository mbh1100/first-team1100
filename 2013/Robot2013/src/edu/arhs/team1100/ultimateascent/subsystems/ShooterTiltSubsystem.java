package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.shooter.TiltShooterCommand;
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

    public void initDefaultCommand() {
        setDefaultCommand(new TiltShooterCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
