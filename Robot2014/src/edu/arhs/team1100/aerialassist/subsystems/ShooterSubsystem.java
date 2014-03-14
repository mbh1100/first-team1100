/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.subsystems;
import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Team 1100
 */
public class ShooterSubsystem extends Subsystem {
    
    static ShooterSubsystem instance;
    DoubleSolenoid firingCylinderOne;
    DoubleSolenoid firingCylinderTwo;
    DoubleSolenoid holdingCylinder;
    DoubleSolenoid clampCylinder;
    DigitalInput hotGoalSensor;
    double startTime;
    Victor rightInMotor;
    Victor leftInMotor;
    private boolean isClamped = false;  
    private boolean isHeld = false;
    private boolean isPunched = false;
    //Ball detector sensor
    private final double IN_MOTOR_SPEED = .5;
    private double delay;

     
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public ShooterSubsystem() throws DriverStationEnhancedIO.EnhancedIOException {
         firingCylinderOne = new DoubleSolenoid(2, RobotMap.M_PUNCH_IN, RobotMap.M_PUNCH_OUT);
         firingCylinderTwo = new DoubleSolenoid(2, RobotMap.M_PUNCHTWO_IN, RobotMap.M_PUNCHTWO_OUT);
         holdingCylinder = new DoubleSolenoid(2, RobotMap.M_LATCH_IN, RobotMap.M_LATCH_OUT);
         clampCylinder = new DoubleSolenoid(2, RobotMap.M_CLAMP_IN, RobotMap.M_CLAMP_OUT);
         rightInMotor = new Victor(RobotMap.M_RIN_MODULE, RobotMap.M_RIN_CHANNEL);
         leftInMotor = new Victor(RobotMap.M_LIN_MODULE, RobotMap.M_LIN_CHANNEL);
         clampCylinder.set(DoubleSolenoid.Value.kForward);
         holdingCylinder.set(DoubleSolenoid.Value.kForward);
       //  hotGoalSensor = new DigitalInput();
         
      //   firingCylinderOne.set(DoubleSolenoid.Value.kForward);
      //   firingCylinderTwo.set(DoubleSolenoid.Value.kForward);
     }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static ShooterSubsystem getInstance() throws DriverStationEnhancedIO.EnhancedIOException {
        if (instance == null) {
            instance = new ShooterSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }
    
    public boolean getIsHot()
    {
        return hotGoalSensor.get();
    }

    public void Shoot() {
        clampCylinder.set(DoubleSolenoid.Value.kReverse);
        holdingCylinder.set(DoubleSolenoid.Value.kReverse);     
    }
    
    public void ResetCylindersPartA()
    {
        firingCylinderOne.set(DoubleSolenoid.Value.kReverse);
        firingCylinderTwo.set(DoubleSolenoid.Value.kReverse);    
    }
    
    public void resetHolders()
    {
        holdingCylinder.set(DoubleSolenoid.Value.kForward);
        clampCylinder.set(DoubleSolenoid.Value.kForward);   
    }
    
    public void resetCylindersPartB()
    {
        firingCylinderOne.set(DoubleSolenoid.Value.kForward);
        firingCylinderTwo.set(DoubleSolenoid.Value.kForward); 
    }
    
    public void rollIn()
    {
        rightInMotor.set(.7);
        leftInMotor.set(.7);
    }
    
    public void rollOut()
    {
        rightInMotor.set(-.7);
        leftInMotor.set(-.7);

    }
    
    public void rollStop()
    {
        rightInMotor.set(0);
        leftInMotor.set(0);
    }
    /**
     * Toggles the state of the floor pickup.
     */
    public void toggleClampCylinder() {
        if(isClamped)clampCylinder.set(DoubleSolenoid.Value.kReverse);
        if(!isClamped)clampCylinder.set(DoubleSolenoid.Value.kForward);
        isClamped = !isClamped;
    }
    
    public void togglePuncherCylinder()
    {
        if(isPunched)
        {
            firingCylinderOne.set(DoubleSolenoid.Value.kReverse);
            firingCylinderTwo.set(DoubleSolenoid.Value.kReverse);
        }
        if(!isPunched)
        {
            firingCylinderOne.set(DoubleSolenoid.Value.kForward);
            firingCylinderTwo.set(DoubleSolenoid.Value.kForward);
        }
        isPunched = !isPunched;
    }
    
    public void toggleHolderClyinder()
    {
        if(isHeld)holdingCylinder.set(DoubleSolenoid.Value.kReverse);
        if(!isHeld)holdingCylinder.set(DoubleSolenoid.Value.kForward);
        isHeld = !isHeld;
    }

    public void openLatch()
    {
        clampCylinder.set(DoubleSolenoid.Value.kReverse);
        isClamped = true;
    }

    public void closeLatch()
    {
        clampCylinder.set(DoubleSolenoid.Value.kForward);
        isClamped = false;
    }
    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
    }

    public void setLatch(int i) {
        if(i == 1)clampCylinder.set(DoubleSolenoid.Value.kForward);
        if(i == 2)clampCylinder.set(DoubleSolenoid.Value.kReverse);
    }
}
