package edu.arhs.team1100.ultimateascent.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class AttackThree extends Joystick {

    private JoystickButton button1;
    private JoystickButton button2;
    private JoystickButton button3;
    private JoystickButton button4;
    private JoystickButton button5;
    private JoystickButton button6;
    private JoystickButton button7;
    private JoystickButton button8;
    private JoystickButton button9;
    private JoystickButton button10;
    private JoystickButton button11;
    
    private double joystickDeadband = 0.1;

    public AttackThree(int channel, double joystickDeadband) {
        super(channel);
        
        button1 = new JoystickButton(this, 1);
        button2 = new JoystickButton(this, 2);
        button3 = new JoystickButton(this, 3);
        button4 = new JoystickButton(this, 4);
        button5 = new JoystickButton(this, 5);
        button6 = new JoystickButton(this, 6);
        button7 = new JoystickButton(this, 7);
        button8 = new JoystickButton(this, 8);
        button9 = new JoystickButton(this, 9);
        button10 = new JoystickButton(this, 10);
        button11 = new JoystickButton(this, 11);
        
        this.joystickDeadband = joystickDeadband;
    }

    public JoystickButton getButton1() {
        return button1;
    }

    public JoystickButton getButton2() {
        return button2;
    }

    public JoystickButton getButton3() {
        return button3;
    }

    public JoystickButton getButton4() {
        return button4;
    }

    public JoystickButton getButton5() {
        return button5;
    }
    
    public JoystickButton getButton6(){
        return button6;
    }

    public JoystickButton getButton7() {
        return button7;
    }

    public JoystickButton getButton8() {
        return button8;
    }

    public JoystickButton getButton9() {
        return button9;
    }
    
    public JoystickButton getButton10() {
        return button10;
    }

    public JoystickButton getButton11() {
        return button11;
    }

    public double getAxis(AxisType axis) {
        double val = super.getAxis(axis);
        if(Math.abs(val) <= joystickDeadband) {
            val = 0.0;
        }        
        return val;
    }
}
