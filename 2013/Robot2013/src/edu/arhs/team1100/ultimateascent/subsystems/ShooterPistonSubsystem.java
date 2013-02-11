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
    
    public static ShooterPistonSubsystem getInstance() {
        if(instance == null) {
            instance = new ShooterPistonSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public void shootPiston() {
        shooterPiston.set(true);
        shooterPiston.set(false);
        frisbeeCount--;
    }
    
    public void shoot(int n  ) {
        for(int i = 0; i < n; i++){
            shootPiston();
        }
    }
    
    public void updateFrisbeeCount(){
        boolean limitState = limitSwitch.get();
        if(limitState && !lastLimitState){ //if switch is open, and was closed before
            frisbeeCount++;
        }
        lastLimitState = limitState;
        
    }


    public int getFrisbeeCount() {
        return frisbeeCount;
    }
    protected void initDefaultCommand() {
    }

    public void shoot() {
    }
}
