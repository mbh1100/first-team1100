/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.autonomous.StopDriveCommand;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author team1100
 */
public class SetDefaultMecanumCommand extends CommandBase{

    private boolean finished = false;
    private static boolean regularMecanum = true;
    
    protected void initialize() {      
        OI.getInstance();
        finished = false;
        regularMecanum = true;
    }

    protected void execute() {
        if(regularMecanum) {
           OI.getInstance().getLeftJoystick().getButton(RobotMap.D_TOGGLE_BUTTON_NUMBER).whenPressed(new JoystickPIDMecanumCommand());
           DriveSubsystem.getInstance().setDefaultMecanumCommand(new JoystickMecanumCommand());
        }
        else {
           OI.getInstance().getLeftJoystick().getButton(RobotMap.D_TOGGLE_BUTTON_NUMBER).whenPressed(new JoystickMecanumCommand());
           DriveSubsystem.getInstance().setDefaultMecanumCommand(new JoystickPIDMecanumCommand()); 
        }
        new StopDriveCommand(.01).start();
        finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }      
    
}
