package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.drive.CameraPIDMecanumCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.RapidFireCommandGroup;
import edu.arhs.team1100.ultimateascent.commands.shooter.SpinShooterCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.CameraPIDTiltShooterCommand;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author akshay
 */
public class AutoAimAndShootCommandGroup extends CommandGroup {
    
    private RapidFireCommandGroup shootCommand;
    
    /**
     * Constructs objects
     */
    public AutoAimAndShootCommandGroup() {
            
        shootCommand = new RapidFireCommandGroup();
        addParallel(new CameraPIDMecanumCommand());
        addParallel(new CameraPIDTiltShooterCommand());
        addParallel(new SpinShooterCommand(0.7)); //replace with PID later if possible
    }
    
    /**
     * If Drive and Shooter is on targer, shoot for as long as its on target
     */
    public void execute(){
        if(DriveSubsystem.getInstance().onTarget() && ShooterTiltSubsystem.getInstance().onTarget()){
            if(!shootCommand.isRunning()){ //this should repeat shots as long as its on target
                shootCommand.start();
            }                       
        }
    }
}