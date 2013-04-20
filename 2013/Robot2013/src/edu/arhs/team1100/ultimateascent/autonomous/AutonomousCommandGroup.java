/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Team 1100
 */
public class AutonomousCommandGroup extends CommandGroup {

    /**
     * Shoots 5 times in autonomous and drives towards feeder station.
     */
    public AutonomousCommandGroup() {
        addSequential(new AutoAimAndShootCommandGroup(5, 5));
        addSequential(new PyramidTowardsFeederCommand());
    }
}
