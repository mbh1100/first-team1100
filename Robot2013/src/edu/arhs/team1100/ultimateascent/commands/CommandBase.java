package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.subsystems.CompressorSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.LegSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.LiftSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
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
    public static void init() {

        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.

        DriveSubsystem.getInstance();
        LiftSubsystem.getInstance();
        ShooterWheelSubsystem.getInstance();
        ShooterTiltSubsystem.getInstance();
        CompressorSubsystem.getInstance();
        ShooterPistonSubsystem.getInstance();
        //IntakeSubsystem.getInstance();
        LegSubsystem.getInstance();
        OI.getInstance();


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
