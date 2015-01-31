/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.arhs.team1100.ultimateascent;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.ultimateascent.autonomous.AutonomousCommandGroup;
import edu.arhs.team1100.ultimateascent.autonomous.TiltShooterPositionPIDCommand;
import edu.arhs.team1100.ultimateascent.commands.drive.CalibrateGyroCommand;
import edu.arhs.team1100.ultimateascent.commands.CommandBase;
import edu.arhs.team1100.ultimateascent.commands.IntakeRollerCommand;
import edu.arhs.team1100.ultimateascent.commands.drive.JoystickPIDMecanumCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.CameraTiltShooterCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.ShootFrisbeeCommand;
import edu.arhs.team1100.ultimateascent.commands.shooter.TiltShooterPIDCommand;
import edu.arhs.team1100.ultimateascent.recording.PlayRecordingCommand;
import edu.arhs.team1100.ultimateascent.recording.RecordCommand;
import edu.arhs.team1100.ultimateascent.input.Camera;
import edu.arhs.team1100.ultimateascent.subsystems.CompressorSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.IntakeSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterTiltSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
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

    private CommandGroup autoCommand;
    private long lastTime = 0;
    private long totalTime = 0;
    private long cycles = 0;
    private long rate = 0;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        //Initialize the Log utility
        Log.init();
        Log.setMinLevel(Log.LEVEL_DEBUG);

        //Add all logging classes
        Log.addClass(RobotMain.class, Log.LEVEL_DEBUG);
        Log.addClass(DriveSubsystem.class, Log.LEVEL_DEBUG);
        Log.addClass(CalibrateGyroCommand.class, Log.LEVEL_OFF);
        Log.addClass(JoystickPIDMecanumCommand.class, Log.LEVEL_OFF);
        Log.addClass(RecordCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(PlayRecordingCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(Camera.class, Log.LEVEL_DEBUG);
        Log.addClass(ShootFrisbeeCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(ShooterTiltSubsystem.class, Log.LEVEL_DEBUG);
        Log.addClass(TiltShooterPIDCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(CameraTiltShooterCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(TiltShooterPositionPIDCommand.class, Log.LEVEL_DEBUG);
        Log.addClass(IntakeSubsystem.class, Log.LEVEL_DEBUG);
        Log.addClass(IntakeRollerCommand.class, Log.LEVEL_DEBUG);

        // Instantiate the command used for the autonomous period
        // Initialize all subsystems
        CommandBase.init();

        autoCommand = new AutonomousCommandGroup();
        //autoCommand = new AutoShootAndReloadCommandGroup();

        //Initialize the camera
        //Camera.getInstance().getCenterX();

    }

    /**
     * Initializes Autonomous
     */
    public void autonomousInit() {
        //Schedule the autonomous command (example)
        //autonomous.start();
        //autoCommand.start();

        Scheduler.getInstance().enable();
        //DSLog.log(5, "auto init");
        //autonomous.start();
    }

    /**
     * Called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //autonomous.execute();
        Scheduler.getInstance().run();
    }

    /*
     * Initializes teleop mode
     */
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //ShooterWheelSubsystem.getInstance().setSpeed(ShooterWheelSubsystem.SHOOTING_SPEED);
        lastTime = System.currentTimeMillis();
        Scheduler.getInstance().enable();
    }

    /**
     * Called periodically during operator control
     */
    public void teleopPeriodic() {
        IntakeSubsystem.getInstance().roll(false);
        Scheduler.getInstance().run();
        //trackRate();
        updateDriverStationLog();


    }

    private void updateDriverStationLog() {
        DSLog.log(2, "Pressure: " + CompressorSubsystem.getInstance().getPressureSwitch());
        //DSLog.log(1, "Drive Mode: TANK");
        //DSLog.log(1, "Drive Mode: " + ((DriveSubsystem.getInstance().getDriveMode() == DriveSubsystem.MODE_POLAR) ? "POLAR" : "CARTESIAN"));
        //DSLog.log(2, "Gyro Angle: " + Log.round(DriveSubsystem.getInstance().getGyroAngle(), 2));
        //DSLog.log(3, "Rate      : " + rate);
        DSLog.log(1, "Shooter Speed: " + MathUtils.round(ShooterWheelSubsystem.getInstance().getSpeed() * 10));
//        if (DriveSubsystem.getInstance().getPIDController().isEnable()) {
//            DSLog.log(4, DriveSubsystem.getInstance().getCameraMode() ? "Camera PID Mode" : "Gyro PID Mode");
//        } else {
//            DSLog.log(4, "pot:" + Log.round(ShooterTiltSubsystem.getInstance().getAngle(), 3));
//        }
        //DSLog.log(4,"Legs: " + (LegSubsystem.getInstance().isDeployed()?"DEPLOYED":"OFF"));

        //DSLog.log(5, "Setpoint value : " + LiftSubsystem.);

        //DSLog.log(6, (Runtime.getRuntime().freeMemory()/1024)+"/"+(Runtime.getRuntime().totalMemory()/1000));
        //DSLog.log(6, "Lift: " + Log.round(LiftSubsystem.getInstance().getPosition(), 3));

        //DSLog.log(5, "ENCODER : "+ ShooterWheelSubsystem.getInstance().getRate());



        /* if(Camera.getInstance().isEnabled() && Camera.getInstance().hasParticle()){
         DSLog.log(6, "PARTICLE: (" + Log.round(Camera.getInstance().getCenterX(), 2) + "," + Log.round(Camera.getInstance().getCenterY(), 2) + ")");
         } else {
         DSLog.log(6, "NO PARTICLE");
         }*/

    }

    /**
     * Prints out the refresh rate of program
     */
    private void trackRate() {

        long curTime = System.currentTimeMillis();
        long d = curTime - lastTime;
        totalTime += d;
        cycles++;

        if (totalTime >= 1000) {
            rate = cycles / (totalTime / 1000);
            cycles = 0;
            totalTime = 0;
        }

        lastTime = curTime;

    }

    /**
     * Called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    /**
     * Removes all instances declared
     */
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().disable();
    }
}
