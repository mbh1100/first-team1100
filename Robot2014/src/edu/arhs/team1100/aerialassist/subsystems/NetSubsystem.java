/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 * @author Team 1100
 */
public class NetSubsystem extends Subsystem {
    
    static NetSubsystem instance;

    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public NetSubsystem() {

    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static NetSubsystem getInstance() {
        if (instance == null) {
            instance = new NetSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }


    public void openNet() {
        //Opens the net
    }

    public void closeNet() {
        //Closes the net
    }


    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
