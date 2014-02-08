package edu.arhs.team1100.aerialassist.input;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author Team 1100
 */
public class AttackThree extends Joystick {

    private JoystickButton button[] = new JoystickButton[11];
    private double joystickDeadband = 0.1;

    /**
     * Initializes joystick button
     *
     * @param channel
     * @param joystickDeadband
     */
    public AttackThree(int channel, double joystickDeadband) {
        super(channel);

        for (int i = 0; i < 11; i++) {
            button[i] = new JoystickButton(this, i + 1);
        }

        this.joystickDeadband = joystickDeadband;
    }

    /**
     * Gets the specified button on this controller
     *
     * @param N button number
     * @return JoystickButton N
     */
    public JoystickButton getButton(int N) {
        return button[N - 1];
    }

    /**
     * Gets position of axis
     *
     * @param axis
     * @return val
     */
    public double getAxis(AxisType axis) {
        double val = super.getAxis(axis);
        if (Math.abs(val) <= joystickDeadband) {
            val = 0.0;
        }
        return val;
    }

    /**
     * @return the angle formed by the joystick handle
     */
    public double getAngle() {
        double x = -getAxis(Joystick.AxisType.kX);
        double y = -getAxis(Joystick.AxisType.kY);
        double angle = Math.toDegrees(MathUtils.atan2(x, y));      //change x and y
        while (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    /**
     *
     * @return the magnitude of the joystick
     */
    public double getMagnitude() {
        double x = getAxis(Joystick.AxisType.kX);
        double y = getAxis(Joystick.AxisType.kY);
        return Math.sqrt((x * x) + (y * y));
    }
}
