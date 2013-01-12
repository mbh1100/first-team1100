/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.MecanumCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.sun.squawk.util.MathUtils;

/**
 *
 * @author Team 1100
 */
public class DriveSubsystem extends Subsystem {
    
    static DriveSubsystem instance;
    
    private RobotDrive drive;
    
    /*private Talon frontLeftTalon;
    private Talon frontRightTalon;
    private Talon backLeftTalon;
    private Talon backRightTalon;*/
    
    public static DriveSubsystem getInstance(){
        if(instance == null){
            instance = new DriveSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }
    
    public DriveSubsystem(){
        drive = new RobotDrive(
                RobotMap.D_TALON_FRONT_LEFT_CHANNEL,
                RobotMap.D_TALON_FRONT_RIGHT_CHANNEL,
                RobotMap.D_TALON_BACK_LEFT_SLOT,
                RobotMap.D_TALON_BACK_RIGHT_SLOT
        );
        /*
        frontLeftTalon = new Talon(RobotMap.D_TALON_FRONT_LEFT_SLOT, RobotMap.D_TALON_FRONT_LEFT_CHANNEL);
        frontRightTalon = new Talon(RobotMap.D_TALON_FRONT_RIGHT_SLOT, RobotMap.D_TALON_FRONT_RIGHT_CHANNEL);
        backLeftTalon = new Talon(RobotMap.D_TALON_BACK_LEFT_SLOT, RobotMap.D_TALON_BACK_LEFT_CHANNEL);
        backRightTalon = new Talon(RobotMap.D_TALON_BACK_RIGHT_SLOT, RobotMap.D_TALON_BACK_RIGHT_CHANNEL);      
    */
    }
    
    public void mecanumDrive(){
        double controlM = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        double controlX = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);
        double angle = Math.toDegrees(MathUtils.atan2(controlY, controlX));
        drive.mecanumDrive_Polar(controlM, angle, 0);
    }
    
    /*
    public Talon getFrontLeftTalon(){
        return frontLeftTalon;
    }
    
    public Talon getFrontRightTalon(){
        return frontRightTalon;
    }
    
    public Talon getBackLeftTalon(){
        return backLeftTalon;
    }
    
    public Talon getBackRightTalon(){
        return backRightTalon;
    }
   
    */
    
    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumCommand());
    }
    
}
