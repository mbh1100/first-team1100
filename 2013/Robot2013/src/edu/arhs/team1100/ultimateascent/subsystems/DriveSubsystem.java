/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.arhs.team1100.ultimateascent.OI;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.commands.JoystickMecanumCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Team 1100
 */
public class DriveSubsystem extends PIDSubsystem {
    
    public static final double DIRECTION_FORWARD = 0;
    public static final double DIRECTION_BACK    = 180;
    public static final double DIRECTION_LEFT    = 270;
    public static final double DIRECTION_RIGHT   = 90;

    private static final int P = 0;
    private static final int I = 0;
    private static final int D = 0;
    
    static DriveSubsystem instance;

    private RobotDrive drive;
    
    private Gyro driveGyro;

    private Talon frontLeftTalon;
    private Talon frontRightTalon;
    private Talon backLeftTalon;
    private Talon backRightTalon;

    public static DriveSubsystem getInstance(){
        if(instance == null){
            instance = new DriveSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }

    public DriveSubsystem() {
        super(P ,I ,D);//SUPER PID!!!!
        Log.log(this, "Constructor", Log.LEVEL_DEBUG);
        frontLeftTalon = new Talon(RobotMap.D_TALON_FRONT_LEFT_CHANNEL);
        frontRightTalon = new Talon(RobotMap.D_TALON_FRONT_RIGHT_CHANNEL);
        backLeftTalon = new Talon(RobotMap.D_TALON_BACK_LEFT_CHANNEL);
        backRightTalon = new Talon(RobotMap.D_TALON_BACK_RIGHT_CHANNEL);
        drive = new RobotDrive(
                frontLeftTalon,
                frontRightTalon,
                backLeftTalon,
                backRightTalon
        );
        driveGyro = new Gyro(RobotMap.D_GYRO_CHANNEL);

    }

    public void mecanumDrive(){
        //Log.log(this, "Gyro angle: "+Log.round(driveGyro.getAngle(), 2), Log.LEVEL_DEBUG);
        DSLog.log(1, "Gyro angle: "+Log.round(driveGyro.getAngle(), 2));
        double rotation = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        
        /*double degrees = Math.toDegrees(MathUtils.atan2(-controlX, controlY));
        double magnitude = Math.sqrt(((controlX)*(controlX)) + ((controlY)*(controlY)));       
        Log.log(this, "m, d, r" + magnitude + ", " + degrees + ", " + rotation, Log.LEVEL_DEBUG);
        drive.mecanumDrive_Polar(magnitude, degrees, rotation);*/
        
        drive.mecanumDrive_Cartesian(controlX, controlY, rotation, driveGyro.getAngle());
        Log.log(this, "SPEEDS:"+
                Log.round(frontLeftTalon.get() ,2) +", "+
                Log.round(frontRightTalon.get(),2) +", "+
                Log.round(backLeftTalon.get()  ,2) +", "+
                Log.round(backRightTalon.get() ,2) , 
                Log.LEVEL_DEBUG
        );
    }

    public void drive(double magnitude, double angle, double rotation) {  
        
        drive.mecanumDrive_Cartesian((Math.sin(Math.toRadians(angle)) * magnitude), (Math.cos(Math.toRadians(angle)) * magnitude), rotation, driveGyro.getAngle());
    }
    
    public void stop(){
        drive(0,0,0);    
    }
    
    
    protected double returnPIDInput() {
        //return smallest angle difference between gyro and joystick angle   
        double gyroAngle = driveGyro.getAngle()%360;
        if(gyroAngle < 0){
            gyroAngle += 360;
        }
        
        double controlX = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        double joystickAngle = Math.toDegrees(MathUtils.atan2(-controlX, controlY));
        
        double error = joystickAngle - gyroAngle;
        if(Math.abs(error) > 180){
            error = -1 * (360 - error);
        }
        
        Log.log(this, "gyro: "+Log.round(gyroAngle, 2)+"\njoystick: "+Log.round(joystickAngle, 2)+"\nerror: "+error+"\n", Log.LEVEL_DEBUG);
        
        return error;
        
    }

    protected void usePIDOutput(double rotationSpeed) {
        double controlX = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        
        drive.mecanumDrive_Cartesian(controlX, controlY, rotationSpeed, driveGyro.getAngle());
    }
    
    public void calibrateGyro(){
        driveGyro.reset();     
    }
    


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



    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickMecanumCommand());
    }


}
