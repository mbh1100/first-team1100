package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.IntakeLiftCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.CameraTiltShooterCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.SpinShooterCommand;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author Team 1100
 */
public class AutoShootAndReloadCommandGroup extends CommandGroup {
    
    private SpinShooterCommand spinCommand;

    public AutoShootAndReloadCommandGroup() {
        
        addSequential(new IntakeLiftCommand());
        spinCommand = new SpinShooterCommand(ShooterWheelSubsystem.MAX_SPEED);
        addParallel(new CameraTiltShooterCommand());
        addParallel(spinCommand);
        spinCommand.setSpeed(ShooterWheelSubsystem.SHOOTING_SPEED);
        addSequential(new AutoAimAndShootCommandGroup(3, 2.5f, false));
        addSequential(new DriveInALineCommand(0.5, 0, 1));
        addSequential(new IntakeLiftCommand());
        addSequential(new WaitCommand(3));
        addSequential(new IntakeLiftCommand());
        addSequential(new AutoAimAndShootCommandGroup(2, 2.5f, false));
        
//        addSequential(new DriveInALineCommand(0.5, 0, 3));
//        addSequential(new IntakeLiftCommand());
//        addSequential(new IntakeRollerCommand(4));
//        addSequential(new IntakeLiftCommand());
//        addSequential(new AutoAimAndShootCommandGroup(2, 2.5f, false));
        
        
    }
}
