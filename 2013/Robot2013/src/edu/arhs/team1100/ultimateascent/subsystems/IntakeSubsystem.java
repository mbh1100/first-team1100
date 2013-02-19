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

    public IntakeSubsystem() {
        roller = new Victor(RobotMap.I_VICTOR_ROLLER);
    }

    public static IntakeSubsystem getInstance() {
        if (instance == null) {
            instance = new IntakeSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public void roll() {
        double speed = OI.getInstance().getXboxController().getAxis(Joystick.AxisType.kTwist);
        roller.set(speed);
    }
    
    public void stop() {
        roller.set(0);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeCommand());
    }
}
