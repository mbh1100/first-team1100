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
public class CompressorSubsystem extends Subsystem {

    private static CompressorSubsystem instance;
    public boolean on = false;
    private Compressor compressor;

    public static CompressorSubsystem getInstance() {
        if (instance == null) {
            instance = new CompressorSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public CompressorSubsystem() {
        compressor = new Compressor(RobotMap.D_COMPRESSOR_SLOT, RobotMap.D_COMPRESSOR_PRESSURE_SWITCH_CHANNEL, RobotMap.D_COMPRESSOR_SLOT, RobotMap.D_COMPRESSOR_RELAY_CHANNEL);
        compressor.start();
        on = true;
    }

    public boolean getPressureSwitch() {
        return compressor.getPressureSwitchValue();
    }

    public void toggle() {
        if (on) {
            compressor.stop();
            on = false;
        } else {
            compressor.start();
            on = true;
        }
    }

    protected void initDefaultCommand() {

    }

}
