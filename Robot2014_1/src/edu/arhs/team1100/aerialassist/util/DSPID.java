package edu.arhs.team1100.aerialassist.util;

import edu.arhs.team1100.aerialassist.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;

/**
 * Gets PID values from DriverStation
 *
 * @author Team 1100
 */
public class DSPID {

    public static double getP() {
        return DriverStation.getInstance().getAnalogIn(RobotMap.DS_P);
    }

    public static double getI() {
        return DriverStation.getInstance().getAnalogIn(RobotMap.DS_I);
    }

    public static double getD() {
        return DriverStation.getInstance().getAnalogIn(RobotMap.DS_D);
    }

    public static void setPIDFromDS(PIDController p) {
        p.setPID(getP(), getI(), getD());
        DSLog.log(6, Log.round(getP(), 2)+" , "+ Log.round(getI(), 2) +" , "+Log.round(getD(), 2));
    }
}
