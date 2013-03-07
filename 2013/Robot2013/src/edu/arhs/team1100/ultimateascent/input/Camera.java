package edu.arhs.team1100.ultimateascent.input;

import edu.arhs.team1100.ultimateascent.util.DSLog;
import edu.arhs.team1100.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.camera.*;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author Team 1100
 */
public class Camera {

    private int MIN_RED = 0;
    private int MAX_RED = 30;
    private int MIN_GREEN = 230;
    private int MAX_GREEN = 255;
    private int MIN_BLUE = 230;
    private int MAX_BLUE = 255;
    private AxisCamera axisCamera = null;
    private ColorImage colorImage;
    private BinaryImage binaryImg;
    private ParticleAnalysisReport[] particles = null;
    private static Camera instance;
    private final int PARTICLE_SIZE = 1;
    private boolean enabled = false;
    private boolean hasParticle = false;

    /**
     * If a Camera object has not been created, construct one
     *
     * @return
     */
    public static Camera getInstance() {

        if (instance == null) {
            instance = new Camera();
        }
        return instance;

    }

    /**
     * Gets an Instance of Axis Camera
     */
    public Camera() {
        axisCamera = AxisCamera.getInstance();//at 10.11.0.11 btw (10.11.1.11 in 1101 network)

        //Camera Settings
//        if (axisCamera != null) {
//         axisCamera.writeCompression(0);
//         axisCamera.writeBrightness(0);
//         axisCamera.writeExposureControl(AxisCamera.ExposureT.hold);
//         axisCamera.writeRotation(AxisCamera.RotationT.k180);
//         axisCamera.writeResolution(AxisCamera.ResolutionT.k160x120);
//        }
    }

    //updates camera if there is a new image
    private void update() {
        if (axisCamera != null && axisCamera.freshImage()) {
            try {
                //Log.log(this, "Got an image!", Log.LEVEL_DEBUG);
                colorImage = axisCamera.getImage();
                binaryImg = colorImage.thresholdRGB(MIN_RED, MAX_RED, MIN_GREEN, MAX_GREEN, MIN_BLUE, MAX_BLUE);

                particles = binaryImg.getOrderedParticleAnalysisReports(1);  //get one (the largest) particle
                //colorImage.free();
                //binaryImg.free();
                enabled = true;
            } catch (Exception e) {
                Log.log(this, "Error: " + e.getMessage(), Log.LEVEL_ERROR);
            } finally {
                try {
                    binaryImg.free();
                    colorImage.free();
                } catch (Exception e2) {
                }
                
            }
        } else {
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
     * @return the horizontal center of the largest visible particle. If there
     * is no particle, returns 0.0
     *
     */
    public double getCenterX() {
        update();
        if (particles != null && particles.length != 0) {
            hasParticle = true;
            return particles[0].center_mass_x_normalized;
        } else {
            hasParticle = false;
        }
        return 0;
    }

    /**
     *
     * @return the vertical center of the largest visible particle. If there is
     * no particle ,returns 0.0
     */
    public double getCenterY() {
        update();
        if (particles != null && particles.length != 0) {
            hasParticle = true;
            return particles[0].center_mass_y_normalized;
        } else {
            hasParticle = false;
            return 0;
        }

    }

    /**
     * Catches Camera errors
     */
    public void free() {
        try {
        } catch (Exception e) {
            Log.log(e, "Error freeing camera resources", Log.LEVEL_ERROR);
        }
    }

    /**
     * @return enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @return hasParticle
     */
    public boolean hasParticle() {
        return hasParticle;
    }
}
