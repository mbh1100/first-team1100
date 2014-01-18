package edu.arhs.team1100.aerialassist.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author Team 1100
 */
public class XboxController extends Joystick {

    private JoystickButton buttonA;
    private JoystickButton buttonB;
    private JoystickButton buttonX;
    private JoystickButton buttonY;
    private JoystickButton buttonLeftBumper;
    private JoystickButton buttonRightBumper;
    private JoystickButton buttonBack;
    private JoystickButton buttonStart;
    private JoystickButton buttonLeftStick;
    private JoystickButton buttonRightStick;
    private double joystickDeadband = 0.1;

    /**
     * Maps the layout of the Xbox Controller
     *
     * @param channel
     * @param joystickDeadband
     */
    public XboxController(int channel, double joystickDeadband) {
        super(channel);

        buttonA = new JoystickButton(this, 1);
        buttonB = new JoystickButton(this, 2);
        buttonX = new JoystickButton(this, 3);
        buttonY = new JoystickButton(this, 4);
        buttonLeftBumper = new JoystickButton(this, 5);
        buttonRightBumper = new JoystickButton(this, 6);
        buttonBack = new JoystickButton(this, 7);
        buttonStart = new JoystickButton(this, 8);
        buttonLeftStick = new JoystickButton(this, 9);
        buttonRightStick = new JoystickButton(this, 10);

        this.joystickDeadband = joystickDeadband;
    }

    /**
     * @return buttonA
     */
    public JoystickButton getButtonA() {
        return buttonA;
    }

    /**
     * @return buttonB
     */
    public JoystickButton getButtonB() {
        return buttonB;
    }

    /**
     * @return buttonX
     */
    public JoystickButton getButtonX() {
        return buttonX;
    }

    /**
     * @return buttonY
     */
    public JoystickButton getButtonY() {
        return buttonY;
    }

    /**
     * @return buttonLeftBumper
     */
    public JoystickButton getButtonLeftBumper() {
        return buttonLeftBumper;
    }

    /**
     * @return buttonRightBumper
     */
    public JoystickButton getButtonRightBumper() {
        return buttonRightBumper;
    }

    /**
     * @return buttonBack
     */
    public JoystickButton getButtonBack() {
        return buttonBack;
    }

    /**
     * @return buttonStart
     */
    public JoystickButton getButtonStart() {
        return buttonStart;
    }

    /**
     * @return buttonLeftStick
     */
    public JoystickButton getButtonLeftStick() {
        return buttonLeftStick;
    }

    /**
     * @return buttonRightStick
     */
    public JoystickButton getButtonRightStick() {
        return buttonRightStick;
    }

    /**
     * Finds the position of the axis
     *
     * @param axis
     * @return val
     */
    public double getAxis(Joystick.AxisType axis) {
        double val = super.getAxis(axis);
        if (Math.abs(val) <= joystickDeadband) {
            val = 0.0;
        }
        return val;
    }
}
