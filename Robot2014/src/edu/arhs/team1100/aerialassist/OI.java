package edu.arhs.team1100.aerialassist;

import edu.arhs.team1100.aerialassist.autonomous.OliviasCommandGroup;
import edu.arhs.team1100.aerialassist.commands.drive.ToggleMecModeCommand;
import edu.arhs.team1100.aerialassist.commands.drive.CalibrateGyroCommand;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;
import edu.arhs.team1100.aerialassist.commands.drive.ToggleDriveModeCommand;
import edu.arhs.team1100.aerialassist.commands.intake.LowerIntakeCommand;
import edu.arhs.team1100.aerialassist.commands.intake.RaiseIntakeCommand;
import edu.arhs.team1100.aerialassist.commands.intake.RollInCommand;
import edu.arhs.team1100.aerialassist.commands.intake.RollOutCommand;
import edu.arhs.team1100.aerialassist.commands.net.CloseNetCommand;
import edu.arhs.team1100.aerialassist.commands.net.OpenNetCommand;
import edu.arhs.team1100.aerialassist.commands.shooter.FireCatapultCommand;
import edu.arhs.team1100.aerialassist.commands.shooter.LowerCatapultCommand;
import edu.arhs.team1100.aerialassist.input.AttackThree;
import edu.arhs.team1100.aerialassist.input.XboxController;
import edu.arhs.team1100.aerialassist.subsystems.IntakeSubsystem;

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
        xbox.getButtonA().whenPressed(new LowerIntakeCommand());
        xbox.getButtonB().whenPressed(new RaiseIntakeCommand());
        xbox.getButtonX().whenPressed(new FireCatapultCommand());
        xbox.getButtonY().whenPressed(new LowerCatapultCommand());
        xbox.getButtonRightBumper().whenPressed(new OpenNetCommand());
        xbox.getButtonLeftBumper().whenPressed(new CloseNetCommand());
        xbox.getButtonRightStick().whenPressed(new RollInCommand());
        xbox.getButtonLeftStick().whenPressed(new RollOutCommand());
        
        
        rightStick.getButton(TOGGLE_MEC).whenPressed(new ToggleMecModeCommand());
        rightStick.getButton(TOGGLE_DRIVE).whenPressed(new ToggleDriveModeCommand());
        rightStick.getButton(CALIBRATE_GYRO).whenPressed(new CalibrateGyroCommand());
        leftStick.getButton(STOP_DRIVE).whenPressed(new StopDriveCommand(0.1));

        //xbox.getButtonBack().whenPressed(new IntakePositionCommand(IntakeSubsystem.UP));
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