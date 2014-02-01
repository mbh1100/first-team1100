package edu.arhs.team1100.aerialassist;

import edu.arhs.team1100.aerialassist.commands.useless.OliviasCommandGroup;
import edu.arhs.team1100.aerialassist.commands.AccTestCommand;
import edu.arhs.team1100.aerialassist.commands.EncoderTestCommand;
import edu.arhs.team1100.aerialassist.commands.drive.ToggleMecModeCommand;
import edu.arhs.team1100.aerialassist.commands.drive.CalibrateGyroCommand;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;
import edu.arhs.team1100.aerialassist.commands.drive.ToggleDriveModeCommand;
import edu.arhs.team1100.aerialassist.commands.net.ToggleNetCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.FireShooterCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.RollInCommand;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.RollOutCommand;
import edu.arhs.team1100.aerialassist.input.AttackThree;
import edu.arhs.team1100.aerialassist.input.XboxController;
import edu.arhs.team1100.aerialassist.subsystems.ManipulatorSubsystem;
import edu.arhs.team1100.aerialassist.subsystems.ShooterSubsystem;
import edu.arhs.team1100.aerialassist.commands.manipulatorcommands.ToggleClampCommand;
import edu.arhs.team1100.aerialassist.commands.cameracommands.AutoAimCommand;
import edu.arhs.team1100.aerialassist.commands.drive.ReverseDirectionCommand;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    /**
     * SETTINGS
     */
    //Right STICK BUTTON SETTINGS
    private static final int TOGGLE_MEC = 2;
    private static final int TOGGLE_DRIVE = 5;
    //left STICK BUTTON SETTINGS
    private static final int CALIBRATE_GYRO = 3;
    private static final int LEG = 1;//trigger
    private static final int STOP_DRIVE = 4;
    //Recording
    private static OI instance;
    private AttackThree rightStick;
    private AttackThree leftStick;
    private XboxController xbox;

    /**
     * Creates an OI if not already created
     *
     * @return instance
     */
    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    /**
     * Constructs an OI Initializes control scheme
     */
    public OI() {
        //Initialize controllers
        rightStick = new AttackThree(RobotMap.C_RIGHT_JOYSTICK, 0.1);
        leftStick = new AttackThree(RobotMap.C_LEFT_JOYSTICK, 0.1);
        xbox = new XboxController(RobotMap.C_XBOX_CONTROLLER, 0.1);

        //CONTROL ASSIGNMENTS       
        xbox.getButtonX().whenPressed(new FireShooterCommand());
        xbox.getButtonY().whenPressed(new AutoAimCommand());
        xbox.getButtonA().whenPressed(new RollInCommand());
        xbox.getButtonB().whenPressed(new RollOutCommand()); 
        
        xbox.getButtonRightBumper().whenPressed(new ToggleClampCommand());
        
        
        rightStick.getButton(TOGGLE_MEC).whenPressed(new ToggleMecModeCommand());
        rightStick.getButton(TOGGLE_DRIVE).whenPressed(new ToggleDriveModeCommand());
        rightStick.getButton(CALIBRATE_GYRO).whenPressed(new CalibrateGyroCommand());
        leftStick.getButton(STOP_DRIVE).whenPressed(new StopDriveCommand(0.1));
        
        if(rightStick.getTrigger()){
        /** reverse direction command
         * not quiet sure how to do this, 
         * but i figured out the trigger is a boolean, not a button...
         */
        }

    }

    /**
     * Get the left joystick
     *
     * @return left AttackThree object
     */
    public AttackThree getRightJoystick() {
        return rightStick;
    }

    /**
     * Get right joystick
     *
     * @return right AttackThree
     */
    public AttackThree getLeftJoystick() {
        return leftStick;
    }

    /**
     * Get Xbox controller
     *
     * @return XboxController object
     */
    public XboxController getXboxController() {
        return xbox;
    }
}
