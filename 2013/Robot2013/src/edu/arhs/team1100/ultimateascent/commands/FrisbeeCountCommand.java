/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;
import edu.arhs.team1100.ultimateascent.RobotMap;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterPistonSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 *
 * @author team 1100
 */
public class FrisbeeCountCommand extends CommandBase {
    
    private boolean lastLimitInput;
    private DigitalInput limitSwitch;
    
    protected void initialize() {
        limitSwitch = new DigitalInput(RobotMap.S_FRISBEE_LIMIT_SWITCH);
        lastLimitInput = false;
    }

    protected void execute() {
        if(limitSwitch.get() && !lastLimitInput){
            lastLimitInput = true;
            ShooterPistonSubsystem.getInstance().incrimentNumberFrisbees(1);
        }
        else { 
            lastLimitInput = false;
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
