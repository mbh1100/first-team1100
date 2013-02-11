package edu.arhs.team1100.ultimateascent.commands;

import edu.arhs.team1100.ultimateascent.sensors.Camera;
import edu.arhs.team1100.ultimateascent.util.Log;

/**
 *
 * @author akshay
 */
public class CameraTestCommand extends CommandBase{

    protected void initialize() {}

    protected void execute() {
        double cx = Camera.getInstance().getcenterX();
        double cy = Camera.getInstance().getCenterY();
        Log.log(this, "particle ( "+cx+" , "+cy+" )", Log.LEVEL_DEBUG);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {
        end();
    }
    
}
