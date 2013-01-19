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

/**
 *
 * @author Team 1100
 */
public class DriveSubsystem extends Subsystem {

    static DriveSubsystem instance;

    private RobotDrive drive;

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

    }

    public void mecanumDrive(){

        double rotation = -OI.getInstance().getLeftJoystick().getAxis(Joystick.AxisType.kX);
        double controlX = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kX);
        double controlY = OI.getInstance().getRightJoystick().getAxis(Joystick.AxisType.kY);
        double degrees = Math.toDegrees(MathUtils.atan2(-controlX, controlY));
        double magnitude = Math.sqrt(((controlX)*(controlX)) + ((controlY)*(controlY)));

        /*
        double magnitude = OI.getInstance().getLeftJoystick().getY();
        double degrees = 0;
        try
        {
            degrees = edu.wpi.first.wpilibj.DriverStation.getInstance().getEnhancedIO().getAnalogIn(1) * 125;
        }
        catch (DriverStationEnhancedIO.EnhancedIOException x)
        {
        }
        double rotation = 0;
        * */
        //Log.log(this, "mecanumDrive("+magnitude+", "+angle+", "+rotation+")", Log.LEVEL_DEBUG);
        if (magnitude != 0)
            System.out.println("m, d, r" + magnitude + ", " + degrees + ", " + rotation);
        drive.mecanumDrive_Polar(magnitude, degrees, rotation);
    }

    public void drive(int magnitude, int angle, int rotation)
    {
        drive.mecanumDrive_Polar(magnitude, angle, rotation);
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
