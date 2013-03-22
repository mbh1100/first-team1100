package edu.arhs.team1100.ultimateascent.util;

import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;

/**
 * Gets PID values from DriverStation
 *
 * @author Akshay
 */
public class DSPID {

    public double getP() {
        return DriverStation.getInstance().getAnalogIn(RobotMap.DS_P);
    }

    public double getI() {
        return DriverStation.getInstance().getAnalogIn(RobotMap.DS_I);
    }
    
    public double getD() {
        return DriverStation.getInstance().getAnalogIn(RobotMap.DS_D);
    }
    
    public void setPIDFromDS(PIDController p){
        p.setPID(getP(), getI(), getD());
    }
}
