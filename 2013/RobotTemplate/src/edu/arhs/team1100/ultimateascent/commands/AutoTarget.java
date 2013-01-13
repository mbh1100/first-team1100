
package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;
import edu.arhs.team1100.ultimateascent.sensors.Camera;
/**
 *
 * @author FITE
 * Testing with Imaging
 */
public class AutoTarget extends CommandBase {

    public AutoTarget() {
        
    }

    protected void initialize() {

    }
    
    public void shouldStop()
    {
    }

    protected void execute() {
    
    DriveSubsystem drive = new DriveSubsystem();
    Camera cam = new Camera();
    boolean shouldStop = false;
    
    int speed = 2;
    int angle = 0;
    int rotation = 0;
        
    while(shouldStop == false && cam.getCenterX() != 0)
    {
        if(cam.getCenterX() > 0)angle = 90;
        else if(cam.getCenterX() < 0)angle = 360;
        
        drive.drive(speed, angle, rotation);
    }
    
    while(shouldStop == false && cam.getCenterY() != 0)
    {
        if(cam.getCenterY() > 0) angle = 0;
        else if(cam.getCenterY() < 0)angle = 180;
        
        drive.drive(speed, angle, rotation);
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
