package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.commands.drive.StopDriveCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.CameraTiltShooterCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.RapidFireCommandGroup;
import edu.arhs.team1100.ultimateascent.commands.shooter.SpinShooterCommand;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author akshay
 */
public class AutoAimAndShootCommandGroup extends CommandGroup {
    
    private final long WAIT_TIME = 5000;
    private final long FRISBEES = 5;
    
    private long sTime = 0;
    private int shots = 0;
    
    private boolean isFinished = false;
    
    private RapidFireCommandGroup shootCommand;
    private CameraTiltShooterCommand cameraTilter;
    private SpinShooterCommand spinShootCommand;
    
    /**
     * Constructs objects
     */
    public AutoAimAndShootCommandGroup() {
        shootCommand = new RapidFireCommandGroup();
        spinShootCommand = new SpinShooterCommand(ShooterWheelSubsystem.SHOOTING_SPEED);
        cameraTilter = new CameraTiltShooterCommand();
       // addParallel(new CameraPIDMecanumCommand());
        addParallel(cameraTilter);
        addParallel(new StopDriveCommand(15));
        //addParallel(new TiltShooterPositionPIDCommand(RobotMap.DS_SHOOTING_ANGLE_CH));
        addParallel(spinShootCommand); //replace with PID later if possible
    }
    
    public void initialize(){
        sTime = System.currentTimeMillis();
        shots = 0;
        isFinished = false;
    }
    
    /**
     * If Drive and Shooter is on target, shoot for as long as its on target
     */
    public void execute(){
        if(System.currentTimeMillis()-sTime <= WAIT_TIME || isFinished){            
            return;
        }
            
        if(!shootCommand.isRunning()){ //this should repeat shots as long as its on target
                shootCommand.start();  
                shots++;        
        }
        
        if(shots == FRISBEES){
            isFinished = true;
            cameraTilter.stopTracking();
            ShooterWheelSubsystem.getInstance().stop();
        }
       // }
    }
    
    protected boolean isFinished(){
        return isFinished;
    }
    
 
}