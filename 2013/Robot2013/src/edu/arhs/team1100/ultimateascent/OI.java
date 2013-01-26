
package edu.arhs.team1100.ultimateascent;

import edu.arhs.team1100.ultimateascent.autonomous.DriveInALineCommand;
import edu.arhs.team1100.ultimateascent.autonomous.DriveInASquareCommandGroup;
import edu.arhs.team1100.ultimateascent.commands.CalibrateDirectionCommand;
import edu.arhs.team1100.ultimateascent.commands.JoystickPIDMecanumCommand;
import edu.arhs.team1100.ultimateascent.input.AttackThree;
import edu.arhs.team1100.ultimateascent.input.XboxController;
import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private final int LEFT_JOYSTICK_CHANNEL = 1;
    private final int RIGHT_JOYSTICK_CHANNEL = 2;
    private final int XBOX_CONTROLLER_CHANNEL = 3;
    
    private static OI instance;
    
    private AttackThree leftJoystick;
    private AttackThree rightJoystick;
    private XboxController xbox;
       
    public static OI getInstance(){
        if(instance == null){
            instance = new OI();
        }
        return instance;
    }
    
    public OI(){
        leftJoystick = new AttackThree(LEFT_JOYSTICK_CHANNEL, 0.1);
        rightJoystick = new AttackThree(RIGHT_JOYSTICK_CHANNEL, 0.1);
        xbox = new XboxController(XBOX_CONTROLLER_CHANNEL, 0.1);
        
        //bind buttons to commands HERE
        leftJoystick.getButton3().whenPressed(new DriveInASquareCommandGroup(1-leftJoystick.getAxis(Joystick.AxisType.kZ), 8));
        leftJoystick.getButton2().whenPressed(new DriveInALineCommand(1-leftJoystick.getAxis(Joystick.AxisType.kZ), DriveSubsystem.DIRECTION_FORWARD, 2.0));
        rightJoystick.getButton3().whenPressed(new CalibrateDirectionCommand());
        rightJoystick.getButton1().whileHeld(new JoystickPIDMecanumCommand());
    }
    
    public AttackThree getLeftJoystick(){
        return leftJoystick;
    }
    
    public AttackThree getRightJoystick(){
        return rightJoystick;        
    }
    
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
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

