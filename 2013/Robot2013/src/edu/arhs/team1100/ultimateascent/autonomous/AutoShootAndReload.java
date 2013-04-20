/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author markbh
 */
public class AutoShootAndReload extends CommandGroup {

    public AutoShootAndReload() {
        // parallel group
        //    start the shooter wheel
        //    aim the shooter
        //    lower the floor scoop
        //    wait some for shooter aiming and spin-up
        // shoot 3 frisbees
        addSequential(new AutoAimAndShootCommandGroup(3, 4)); // frisbees, delay
        // drive forward
        // raise the floor scoop
        // load frisbee #1
        // load frisbee #2
        addSequential(new PickupAndLoadFrisbeesGroup());
        // shoot 2 frisbees
        addSequential(new AutoAimAndShootCommandGroup(2, 0));
        // get more frisbees
        addSequential(new PickupAndLoadFrisbeesGroup());
        // shoot 2 frisbees
        addSequential(new AutoAimAndShootCommandGroup(2, 0));


        // shoot 3 frisbees
    }
}
