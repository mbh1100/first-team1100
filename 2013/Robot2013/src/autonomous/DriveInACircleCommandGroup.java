/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autonomous;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Akshay
 */
public class DriveInACircleCommandGroup extends CommandGroup {
    
    public DriveInACircleCommandGroup(double speed, double duration){
        
        for(int angle = 0; angle <=360; angle+=45 )
        addSequential(new DriveInALineCommand(speed, angle, duration/8));
        addSequential(new StopDriveCommand(0.5));
        
    }
    
    
}