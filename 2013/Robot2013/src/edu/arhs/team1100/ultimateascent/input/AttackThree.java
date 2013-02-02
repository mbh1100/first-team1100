package edu.arhs.team1100.ultimateascent.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class AttackThree extends Joystick {

    private JoystickButton button[] = new JoystickButton[11];
    
    private double joystickDeadband = 0.1;

    public AttackThree(int channel, double joystickDeadband) {
        super(channel);
        
        for(int counter = 0; counter < 12; counter++) {
            button[counter] = new JoystickButton(this, counter);
        }
        
        this.joystickDeadband = joystickDeadband;
    }

    /**
     * AttackThree Trigger Button
     * @return trigger button
     */
    public JoystickButton getButton(int buttonNumber) {
        return button[buttonNumber];
    }

    public double getAxis(AxisType axis) {
        double val = super.getAxis(axis);
        if(Math.abs(val) <= joystickDeadband) {
            val = 0.0;
        }        
        return val;
    }
}

