package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Team 1100
 */
public class ShooterPistonSubsystem extends Subsystem {

    static ShooterPistonSubsystem instance;
    //private Compressor compressor;
    //private Solenoid shooterPiston;
    private Relay shooterPiston;
    private DigitalInput limitSwitch;
    private boolean lastLimitState;
    private int frisbeeCount = 0;

    /**
     * Constructs a ShooterPistonSubsystem. Constructs Compressor and Solenoid
     * and starts compressor.
     */
    public ShooterPistonSubsystem() {
        //compressor = new Compressor(RobotMap.S_COMPRESSOR_PRESSURE_SWITCH, RobotMap.S_COMPRESSOR_RELAY);
        //shooterPiston = new Solenoid(RobotMap.S_SOLENOID_SHOOTER_PISTON);
        //limitSwitch = new DigitalInput(RobotMap.S_FRISBEE_LIMIT_SWITCH);
        //compressor.start();

        shooterPiston = new Relay(RobotMap.S_RELAY_SHOOTER_PISTON);
    }

    /**
     * Creates a ShooterPistonSubsystem if not already created
     *
     * @return instance
     */
    public static ShooterPistonSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterPistonSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    /**
     * Pulls back piston to shoot a disc.
     */
    public void unShoot() {
        shooterPiston.set(Relay.Value.kReverse);
    }

    /**
     * Shoots a disc.
     */
    public void shoot() {
        shooterPiston.set(Relay.Value.kOn);
        frisbeeCount--;
    }

    /**
     * Turns piston on or off.
     *
     * @param state
     */
    public void set(boolean state) {
        if (state) {
            shooterPiston.set(Relay.Value.kReverse);
        } else {
            shooterPiston.set(Relay.Value.kOn);
        }
    }

    /**
     * Counts discs. NOT USED.
     */
    public void updateFrisbeeCount() {
        boolean limitState = limitSwitch.get();
        if (limitState && !lastLimitState) { //if switch is open, and was closed before
            frisbeeCount++;
        }
        lastLimitState = limitState;

    }

    /**
     * Gets discs being held.
     *
     * @return number of discs being carried
     */
    public int getFrisbeeCount() {
        return frisbeeCount;
    }

    /**
     * Initializes default command
     */
    protected void initDefaultCommand() {
    }
}
