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
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Team 1100
 */
public class DriveSubsystem extends Subsystem {

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
            //instance.initDefaultCommand();
        }
        return instance;
    }

    public DriveSubsystem() {
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
        Log.log(this, "Gyro angle: "+Log.round(driveGyro.getAngle(), 2)+"", Log.LEVEL_DEBUG);
        double rotation = -OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kY);
        
        /*double degrees = Math.toDegrees(MathUtils.atan2(-controlX, controlY));
        double magnitude = Math.sqrt(((controlX)*(controlX)) + ((controlY)*(controlY)));       
        Log.log(this, "m, d, r" + magnitude + ", " + degrees + ", " + rotation, Log.LEVEL_DEBUG);
        drive.mecanumDrive_Polar(magnitude, degrees, rotation);*/
        
        drive.mecanumDrive_Cartesian(controlX, controlY, rotation, driveGyro.getAngle());
    }

    public void drive(int magnitude, int angle, int rotation) {
        drive.mecanumDrive_Polar(magnitude, angle, rotation);
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
        setDefaultCommand(new MecanumCommand());
    }

}
