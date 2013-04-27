/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Aditya
 */
public class CompressorSubsystem extends Subsystem {

    private static CompressorSubsystem instance;
    
    private Compressor compressor;

    public static CompressorSubsystem getInstance() {
        if (instance == null) {
            instance = new CompressorSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public CompressorSubsystem(){        
        compressor = new Compressor(RobotMap.S_COMPRESSOR_PRESSURE_SWITCH, RobotMap.S_COMPRESSOR_RELAY); 
        compressor.start();
    }
    
    
    /**
     * Gets pressure from switch.
     *
     * @return
     */
    public boolean getPressureSwitch() {
        return compressor.getPressureSwitchValue();
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
