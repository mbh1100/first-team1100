package edu.arhs.team1100.aerialassist.subsystems;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Team 1100
 */
public class IntakeSubsystem extends Subsystem {

    static IntakeSubsystem instance;

    /**
     * Constructs an IntakeSubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public IntakeSubsystem() {

    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static IntakeSubsystem getInstance() {
        if (instance == null) {
            instance = new IntakeSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public void stopRollers() {
        //stop motors
    }

    public void rollIn() {
        //set motors to roll in
    }

    public void rollout() {
        //set motors to roll out
    }

    public void setPostitionOut() {
        //set out postition
    }

    public void setPostitionIn() {
        //set in postition
    }

    /**
     * Initializes intake command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
