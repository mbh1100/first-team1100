package edu.arhs.team1100.ultimateascent.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.IntakeCommand;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author akshay
 */
public class IntakeSubsystem extends Subsystem {

    private static IntakeSubsystem instance;
    private Victor roller;

    /**
     * Constructs a Vector of I_VICTOR_ROLLER
     */
    public IntakeSubsystem() {
        roller = new Victor(RobotMap.I_VICTOR_ROLLER);
    }
    /**
     * Creates a IntakeSubsystem if not already
     * @return instance
     */
    public static IntakeSubsystem getInstance() {
        if (instance == null) {
            instance = new IntakeSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    /**
     * Set speed for xbox controller
     */
    public void roll() {
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kTwist);
        roller.set(speed);
    }
    /**
     * Stops the rolling
     */
    public void stop() {
        roller.set(0);
    }
    
    /**
     * Initializes Intake Command
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeCommand());
    }
}
