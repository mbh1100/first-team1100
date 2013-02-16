package edu.arhs.team1100.ultimateascent.sensors;

import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.camera.*;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author Team 1100
 */
public class Camera {

    private int MIN_RED = 0;
    private int MAX_RED = 20;
    private int MIN_GREEN = 220;
    private int MAX_GREEN = 255;
    private int MIN_BLUE = 220;
    private int MAX_BLUE = 255;

    private AxisCamera axisCamera = null;
    private ColorImage colorImage;
    private BinaryImage binaryImg;
    private ParticleAnalysisReport[] particles = null;
    private static Camera instance;
    private final int PARTICLE_SIZE = 1;

    public static Camera getInstance() {

        if (instance == null) {
            instance = new Camera();
        }
        return instance;

    }

    public Camera() {
        axisCamera = AxisCamera.getInstance();//at 10.11.0.11 btw (10.11.1.11 in 1101 network)

        //Camera Settings
        if (axisCamera != null) {
            //axisCamera.writeCompression(0);
            //axisCamera.writeBrightness(0);
            //axisCamera.writeExposureControl(AxisCamera.ExposureT.hold);
            //axisCamera.writeRotation(AxisCamera.RotationT.k0);
            //axisCamera.writeResolution(AxisCamera.ResolutionT.k160x120);
        }
    }

    //updates camera if there is a new image
    private void update() {
        if (axisCamera != null && axisCamera.freshImage()) {
            try {
                //Log.log(this, "Got an image!", Log.LEVEL_DEBUG);
                colorImage = axisCamera.getImage();
                binaryImg = colorImage.thresholdRGB(MIN_RED, MAX_RED, MIN_GREEN, MAX_GREEN, MIN_BLUE, MAX_BLUE);
                
                particles = binaryImg.getOrderedParticleAnalysisReports(1);  //get one (the largest) particle
                colorImage.free();
                binaryImg.free();
            } catch (Exception e) {
                try {
                    binaryImg.free();
                }
                catch (Exception e2) {
                }
                Log.log(this, "Error: "+e.getMessage(), Log.LEVEL_ERROR);
            };
        }else {
            Log.log(this, "image not fresh yet", Log.LEVEL_DEBUG);
        }
    }


    /**
     * 
     * @return The largest visible particle.
     */
    public ParticleAnalysisReport getBiggestParticle() {
        update();
        if (particles != null && particles.length != 0) {
            return particles[0];
        } else {
            return null;
        }
    }

    /**
     * 
     * @return the horizontal center of the largest visible particle. If there is no particle, returns 0.0
     * 
     */
    public double getCenterX(){
        update();
        if (particles != null && particles.length != 0){
            DSLog.log(6, "PARTICLE: "+Log.round(particles [0].center_mass_x_normalized, 4));
            return particles [0].center_mass_x_normalized;
        }
        DSLog.log(6, "NO PARTICLE");
        return 0;
    }

    /**
     * 
     * @return the vertical center of the largest visible particle. If there is no particle ,returns 0.0 
     */
    public double getCenterY(){
        update();
        if (particles != null && particles.length != 0){
            return particles[0].center_mass_y_normalized;
        }
        return 0;
    }
}
