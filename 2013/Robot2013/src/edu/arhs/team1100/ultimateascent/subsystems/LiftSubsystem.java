/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.LiftCommand;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author akshay
 */
public class LiftSubsystem extends Subsystem{
    
    private static LiftSubsystem instance;
    
    private Victor left, right;
    /**
     * creates a new instance of lift
     * @return 
     */
    public static LiftSubsystem getInstance(){
        if(instance ==  null){
            instance = new LiftSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }


    /**
     * 
     */
    public LiftSubsystem(){
        left = new Victor(RobotMap.L_VICTOR_LEFT);
        right = new Victor(RobotMap.L_VICTOR_RIGHT);
    }
    
    public void doLift(){
        double speed = OI.getInstance().getXboxController().getAxis(AxisType.kZ)/2;
        left.set(speed);
        right.set(-speed);
    }
    
        
  
    protected void initDefaultCommand() {
        setDefaultCommand(new LiftCommand());
    }
    
}
