package edu.arhs.team1100.aerialassist;

import edu.arhs.team1100.aerialassist.commands.drive.ToggleDriveModeCommand;
import edu.arhs.team1100.aerialassist.commands.drive.CalibrateGyroCommand;
import edu.arhs.team1100.aerialassist.commands.drive.StopDriveCommand;
import edu.arhs.team1100.aerialassist.commands.drive.TankModeCommand;
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
    private static final int TOGGLE_DRIVE = 2;
    private static final int SET_TANK = 5;
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
        rightStick = new AttackThree(RobotMap.C_LEFT_JOYSTICK, 0.1);
        leftStick = new AttackThree(RobotMap.C_RIGHT_JOYSTICK, 0.1);
        xbox = new XboxController(RobotMap.C_XBOX_CONTROLLER, 0.1);

        //CONTROL ASSIGNMENTS
        rightStick.getButton(TOGGLE_DRIVE).whenPressed(new ToggleDriveModeCommand());
        rightStick.getButton(SET_TANK).whenPressed(new TankModeCommand());
        leftStick.getButton(CALIBRATE_GYRO).whenPressed(new CalibrateGyroCommand());
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
