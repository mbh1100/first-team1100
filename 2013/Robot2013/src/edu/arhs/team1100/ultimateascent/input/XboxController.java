package edu.arhs.team1100.ultimateascent.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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

    public JoystickButton getButtonA() {
        return buttonA;
    }

    public JoystickButton getButtonB() {
        return buttonB;
    }

    public JoystickButton getButtonX() {
        return buttonX;
    }

    public JoystickButton getButtonY() {
        return buttonY;
    }

    public JoystickButton getButtonLeftBumper() {
        return buttonLeftBumper;
    }

    public JoystickButton getButtonRightBumper() {
        return buttonRightBumper;
    }

    public JoystickButton getButtonBack() {
        return buttonBack;
    }

    public JoystickButton getButtonStart() {
        return buttonStart;
    }
    
    public JoystickButton getButtonLeftStick() {
        return buttonLeftStick;
    }

    public JoystickButton getButtonRightStick() {
        return buttonRightStick;
    }

    public double getAxis(Joystick.AxisType axis) {
        double val = super.getAxis(axis);
        if(Math.abs(val) <= joystickDeadband) {
            val = 0.0;
        }        
        return val;
    }
}
