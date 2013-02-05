/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.arhs.team1100.ultimateascent;


import edu.arhs.team1100.ultimateascent.commands.CalibrateGyroCommand;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.commands.JoystickPIDMecanumCommand;
import edu.arhs.team1100.ultimateascent.commands.PlayRecordingCommand;
import edu.arhs.team1100.ultimateascent.commands.RecordCommand;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

    Command autonomousCommand;
    
    long lastTime = 0;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        //initialize the Log utility
        Log.init();
        Log.setMinLevel(Log.LEVEL_DEBUG);
        //add all logging classes
        Log.addClass(RobotMain.class, Log.LEVEL_DEBUG);
        //Log.addClass(DriveSubsystem.class, Log.LEVEL_DEBUG);
        Log.addClass(CalibrateGyroCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(JoystickPIDMecanumCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(RecordCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(PlayRecordingCommand.class, Log.LEVEL_DEBUG);
        // instantiate the command used for the autonomous period
        

        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        lastTime = System.currentTimeMillis();
        Scheduler.getInstance().enable();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        long curTime = System.currentTimeMillis();
        long fps = 1000/(curTime-lastTime);
        DSLog.log(3, "FPS: "+fps);
        lastTime = curTime;
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void disabledInit()
    {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().disable();
    }
}
