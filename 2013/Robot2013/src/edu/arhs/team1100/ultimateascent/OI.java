
package edu.arhs.team1100.ultimateascent;

import edu.arhs.team1100.ultimateascent.recording.RecordCommand;
import edu.arhs.team1100.ultimateascent.recording.PlayRecordingCommand;
import edu.arhs.team1100.ultimateascent.autonomous.StopDriveCommand;
import edu.arhs.team1100.ultimateascent.commands.*;
import edu.arhs.team1100.ultimateascent.input.AttackThree;
import edu.arhs.team1100.ultimateascent.input.XboxController;
import edu.arhs.team1100.ultimateascent.recording.PrintRecordingCodeCommand;
import edu.arhs.team1100.ultimateascent.recording.SquareWeaveRoutine;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
        
    private static OI instance;
    
    private AttackThree leftStick;
    private AttackThree rightStick;
    private XboxController xbox;
    
    RecordCommand recorder;
    
    /**
     * Gets the current instance. 
     * @return instance of OI
     */
    public static OI getInstance(){
        if(instance == null){
            instance = new OI();
        }
        return instance;
    }
    
    /**
     * Constructor
     */
    public OI(){
        leftStick = new AttackThree(RobotMap.C_LEFT_JOYSTICK_CHANNEL, 0.1);
        rightStick = new AttackThree(RobotMap.C_RIGHT_JOYSTICK_CHANNEL, 0.1);
        xbox = new XboxController(RobotMap.C_XBOX_CONTROLLER_CHANNEL, 0.1);        
        //drive controls
        leftStick.getButton(RobotMap.C_TOGGLE_DRIVE).whenPressed(new ToggleDriveModeCommand());
        leftStick.getButton(RobotMap.C_CAMERATEST).whileHeld(new CameraTestCommand());
        
        rightStick.getButton(RobotMap.C_CALIBRATE_GYRO).whenPressed(new CalibrateGyroCommand());
        rightStick.getButton(RobotMap.C_DRIVE_PID).whileHeld(new JoystickPIDMecanumCommand());
        rightStick.getButton(RobotMap.C_STOP_DRIVE).whenPressed(new StopDriveCommand(0.1));
        
        //Recording Command Stuff
        recorder = new RecordCommand(20); //interval is 20 ms
        rightStick.getButton(RobotMap.C_RECORD).whileHeld(recorder);
        rightStick.getButton(RobotMap.C_PLAY_RECORDING).whenPressed(new PlayRecordingCommand(recorder));
        rightStick.getButton(RobotMap.C_PRINT_RECORDING).whenPressed(new PrintRecordingCodeCommand(recorder));
        
        rightStick.getButton(8).whenPressed(new SquareWeaveRoutine());
        //xbox Stuff
        xbox.getButtonRightBumper().whileHeld(new ShootFrisbeeCommand());
        xbox.getButtonLeftBumper().whileHeld(new ShootAllFrisbeesCommand());
        
        
        
    }
    
    /**
     * Get the left joystick
     * @return left AttackThree object
     */
    public AttackThree getLeftJoystick(){
        return leftStick;
    }
    
    /**
     * Get right joystick
     * @return right AttackThree
     */
    public AttackThree getRightJoystick(){
        return rightStick;        
    }
    
    /**
     * Get xbox controller
     * @return XboxController object
     */
    public XboxController getXboxController(){
        return xbox;
    }
        
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

