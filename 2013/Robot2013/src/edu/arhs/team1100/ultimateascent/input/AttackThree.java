package edu.arhs.team1100.ultimateascent.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class AttackThree extends Joystick {

    private JoystickButton button[] = new JoystickButton[11];
    
    private double joystickDeadband = 0.1;

    public AttackThree(int channel, double joystickDeadband) {
        super(channel);
        
        for(int i = 0; i < 11; i++) {
            button[i] = new JoystickButton(this, i+1);
        }
        
        this.joystickDeadband = joystickDeadband;
    }

    /**
     * AttackThree Trigger Button
     * @return trigger button
     */
    public JoystickButton getButton(int buttonNumber) {
        return button[buttonNumber-1];
    }

    public double getAxis(AxisType axis) {
        double val = super.getAxis(axis);
        if(Math.abs(val) <= joystickDeadband) {
            val = 0.0;
        }        
        return val;
    }
}

