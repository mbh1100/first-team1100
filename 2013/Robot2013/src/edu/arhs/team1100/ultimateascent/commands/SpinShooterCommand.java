/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.subsystems.ShooterSubsystem;

/**
 *
 * @author Jason
 */
public class SpinShooterCommand  extends CommandBase{
    public SpinShooterCommand(){
        requires(ShooterSubsystem.getInstance());
    }

    protected void initialize() {
        ShooterSubsystem.getInstance().setSetpoint(0.0);
        ShooterSubsystem.getInstance().enable();
    }

    protected void execute() {
       
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
