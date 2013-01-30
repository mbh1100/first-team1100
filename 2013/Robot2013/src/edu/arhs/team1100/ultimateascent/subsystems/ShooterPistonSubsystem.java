/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author team1100
 */
public class ShooterPistonSubsystem extends Subsystem {

    private Solenoid shooterPiston;

    static ShooterPistonSubsystem instance;
    
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
        //Extend and retract piston
    }

    protected void initDefaultCommand() {
    }
}
