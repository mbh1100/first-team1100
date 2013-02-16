package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Team 1100
 */
public class ShooterPistonSubsystem extends Subsystem {

    private Solenoid shooterPiston;
    static ShooterPistonSubsystem instance;
    
    
    private DigitalInput limitSwitch;
    private boolean lastLimitState;
    
    private int frisbeeCount = 0;
    
    public ShooterPistonSubsystem() {
        shooterPiston = new Solenoid(RobotMap.S_SOLENOID_SHOOTER_PISTON);
        
        limitSwitch = new DigitalInput(RobotMap.S_FRISBEE_LIMIT_SWITCH);

    }
    /**
     * creates a new instance of the shooter
     * @return 
     */
    public static ShooterPistonSubsystem getInstance() {
        if(instance == null) {
            instance = new ShooterPistonSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    /**
     * Shoots one frisbee
     */
    public void shoot() {
        shooterPiston.set(true);
        shooterPiston.set(false);
        frisbeeCount--;
    }
    
    public void shootAll()
    {
        for(int counter = 1; counter <= frisbeeCount; counter++)
        {
            this.shoot();
        }
    }
    
    /**
     * Counts frisbees
     */
    public void updateFrisbeeCount(){
        boolean limitState = limitSwitch.get();
        if(limitState && !lastLimitState){ //if switch is open, and was closed before
            frisbeeCount++;
        }
        lastLimitState = limitState;
        
    }

    /**
     * 
     * @return number of frisbees being carried
     */
    public int getFrisbeeCount() {
        return frisbeeCount;
    }
    protected void initDefaultCommand() {
    }

}
