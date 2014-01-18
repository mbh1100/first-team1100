/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.subsystems;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ryanfite
 */
public class CompressorSubsystem extends Subsystem{

    
    private static CompressorSubsystem instance;
    
    private Compressor compressor;

    public static CompressorSubsystem getInstance() {
        if (instance == null) {
            instance = new CompressorSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }
    
    public CompressorSubsystem()
    {
        compressor = new Compressor(RobotMap.D_COMPRESSOR_PRESSURE_SWITCH, RobotMap.D_COMPRESSOR_RELAY); 
        compressor.start();   
    }
    
    
    public boolean getPressureSwitch() {
        return compressor.getPressureSwitchValue();
    }
    
    
    protected void initDefaultCommand() {
        
    }
    
}
