package edu.arhs.team1100.aerialassist.commands;

import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.subsystems.CompressorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.DriveSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.NetSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.SensorTestSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Team 1100
 */
public abstract class CommandBase extends Command {

    /**
     * Creates instances for the subsystems
     */
    public static void init() throws DriverStationEnhancedIO.EnhancedIOException {

        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        DriveSubsystem.getInstance();
        ManipulatorSubsystem.getInstance();
        OI.getInstance();
        //NetSubsystem.getInstance();
        ShooterSubsystem.getInstance();
        CompressorSubsystem.getInstance();
        //SensorTestSubsystem.getInstance();

        // Show what command your subsystem is running on the SmartDashboard
        // SmartDashboard.putData(exampleSubsystem);
    }

    /**
     * Constructs CommandBase with name
     *
     * @param name
     */
    public CommandBase(String name) {
        super(name);
    }

    /**
     * Constructs a CommandBase
     */
    public CommandBase() {
        super();
    }
}
