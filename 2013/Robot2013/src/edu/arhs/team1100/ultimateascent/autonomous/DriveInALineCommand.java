/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.autonomous;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Akshay
 */
public class DriveInALineCommand extends CommandBase {   
    
    private double speed = 0.0;
    private double direction = 0.0;
    private double duration = 0;
    
    public DriveInALineCommand(double speed, double direction, double duration){
        requires(DriveSubsystem.getInstance());  
        System.out.println("line speed "+speed);
        this.speed = speed;
        this.direction = direction;    
        this.duration = duration;
    }  

    protected void initialize() {        
        setTimeout(duration);  
    }

    protected void execute() {
        DriveSubsystem.getInstance().drive(speed, direction, 0.0);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        DriveSubsystem.getInstance().stop();        
    }

    protected void interrupted() {
        end();
    }
    
}
