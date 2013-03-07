package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.shooter.RapidFireCommandGroup;
import edu.arhs.team1100.ultimateascent.commands.shooter.SpinShooterCommand;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author akshay
 */
public class AutoAimAndShootCommandGroup extends CommandGroup {
    
    private final long WAIT_TIME = 3500;
    private final long FRISBEES = 5;
    
    private long sTime = 0;
    private int shots = 0;
    
    private RapidFireCommandGroup shootCommand;
    private SpinShooterCommand spinShootCommand;
    
    /**
     * Constructs objects
     */
    public AutoAimAndShootCommandGroup() {
        shootCommand = new RapidFireCommandGroup();
        spinShootCommand = new SpinShooterCommand(0.7);
       // addParallel(new CameraPIDMecanumCommand());
        //addParallel(new CameraPIDTiltShooterCommand());
        addParallel(new TiltShooterPositionPIDCommand());
        addParallel(spinShootCommand); //replace with PID later if possible
    }
    
    public void initialize(){
        sTime = System.currentTimeMillis();
        shots = 0;
    }
    
    /**
     * If Drive and Shooter is on target, shoot for as long as its on target
     */
    public void execute(){
        if(System.currentTimeMillis()-sTime <= WAIT_TIME || shots >= FRISBEES){
            
            return;
        }
        
       // if(DriveSubsystem.getInstance().onTarget() && ShooterTiltSubsystem.getInstance().onTarget()){
            
        if(!shootCommand.isRunning()){ //this should repeat shots as long as its on target
                shootCommand.start();  
                shots++;
                
            }
        
        if(shots == FRISBEES){
            spinShootCommand.cancel();
            ShooterWheelSubsystem.getInstance().stop();
        }
       // }
    }
    
 
}