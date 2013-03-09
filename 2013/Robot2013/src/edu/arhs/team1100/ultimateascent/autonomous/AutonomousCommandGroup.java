/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Aditya
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public AutonomousCommandGroup() {
        addSequential(new AutoAimAndShootCommandGroup());
        addSequential(new PyramidTowardsFeederCommand());
    }

}
