/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterWheelSubsystem;
/**
 *
 * @author Jason
 */
public class SpinShooterCommand  extends CommandBase{
    public SpinShooterCommand(){
        requires(ShooterWheelSubsystem.getInstance());
    }

    protected void initialize() {
        ShooterWheelSubsystem.getInstance();
    }

    protected void execute() {
       ShooterWheelSubsystem.getInstance().SpinWheel();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        DriveSubsystem.getInstance().disable();
    }

    protected void interrupted() {
        end();
    }
}
