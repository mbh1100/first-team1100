package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Ryan
 */
public class ShooterPistonSubsystem extends Subsystem {

    private Solenoid shooterPiston;
    static ShooterPistonSubsystem instance;
    
    private int numberOfFrisbees = 0;
    
    public ShooterPistonSubsystem() {
        shooterPiston = new Solenoid(RobotMap.S_SOLENOID_SHOOTER_PISTON);

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
        this.incrementNumberFrisbees(-1);
    }
    
    public void shoot(int n  ) {
        for(int i = 0; i < n; i++){
            shootPiston();
        }
    }
    
    public void incrementNumberFrisbees(int number){
        numberOfFrisbees+= number;
    }

    public int getNumberFrisbees() {
        return numberOfFrisbees;
    }
    protected void initDefaultCommand() {
    }

    public void shoot() {
    }
}
