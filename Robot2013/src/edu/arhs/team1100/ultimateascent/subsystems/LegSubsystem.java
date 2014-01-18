package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Team 1100
 */
public class LegSubsystem extends Subsystem {

    static LegSubsystem instance;
    private Solenoid legLeft;
    private Solenoid legRight;

    /**
     * Constructs an IntakeSubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public LegSubsystem() {
        //compressor = new Compressor(RobotMap.S_COMPRESSOR_PRESSURE_SWITCH, RobotMap.S_COMPRESSOR_RELAY);

        legLeft = new Solenoid(RobotMap.LEG_LEFT);
        //legRight = new Solenoid(RobotMap.LEG_RIGHT);

        //unDeploy();
        //compressor.start();
    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static LegSubsystem getInstance() {
        if (instance == null) {
            instance = new LegSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }


    public void unDeploy(){
        legLeft.set(false);
        //legRight.set(false);
    }

    public boolean isDeployed(){
        return false;//legLeft.get();
    }

    /**
     * Toggle floor pickup position. Reverses position from current position.
     */
    public void toggle() {
        legLeft.set(!legLeft.get());
        //legRight.set(!legRight.get());
        Log.log(this, "toggle()", Log.LEVEL_DEBUG);
    }

    /**
     * Initializes intake command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
