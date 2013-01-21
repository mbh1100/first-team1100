/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Akshay
 */
public class DriveInASquareCommandGroup extends CommandGroup {
    
    public DriveInASquareCommandGroup(double speed, double duration){
        this.addSequential(new DriveInALineCommand(speed, 270, duration/4));
        this.addSequential(new DriveInALineCommand(speed, 0, duration/4));
        this.addSequential(new DriveInALineCommand(speed, 90, duration/4));
        this.addSequential(new DriveInALineCommand(speed, 180, duration/4));
    }
    
}
