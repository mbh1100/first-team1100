package edu.arhs.team1100.ultimateascent.sensors;

import edu.wpi.first.wpilibj.camera.*;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 * the start of the camera system
 *
 * @author team1100
 */
public class Camera {

    public final int WHITE_THRESHOLD = 1;
    public final int RED_THRESHOLD = 2;
    public final int BLUE_THRESHOLD = 3;
    public final int GREEN_THRESHOLD = 4;
    private final int PARTICLE_SIZE = 3;
    //RGB Threshold
    private int minRed = 0;
    private int maxRed = 0;
    private int minGreen = 0;
    private int maxGreen = 0;
    private int minBlue = 0;
    private int maxBlue = 0;
    //Image related
    AxisCamera axisCamera = null;
    ColorImage colorImg;
    BinaryImage binaryImg; 
    ParticleAnalysisReport[] partReport = null;

    public Camera() {
        //ac = AxisCamera.getInstance();
        colorImg = null;
        binaryImg = null;

        //Camera Settings
        if (axisCamera != null) {
            axisCamera.writeCompression(0);
            axisCamera.writeBrightness(10);
            axisCamera.writeExposureControl(AxisCamera.ExposureT.hold);
            axisCamera.writeRotation(AxisCamera.RotationT.k0);
            axisCamera.writeResolution(AxisCamera.ResolutionT.k160x120);
        }
        setThreshold(GREEN_THRESHOLD);
    }

    public void start() {
        partReport = null;

    }
    /*public static Camera getInstance()
     {
      
        
     }*/

    /**
     * Tick
     */
    public void tick() {
        /**
         * Gets an image from the camera to find particles within the camera's
         * RGB threshold.
         */
        if (axisCamera != null && axisCamera.freshImage()) {
            try {
                colorImg = axisCamera.getImage();
                binaryImg = colorImg.thresholdRGB(minRed, maxRed, minGreen, maxGreen, minBlue, maxBlue);
                colorImg.free();
                partReport = binaryImg.getOrderedParticleAnalysisReports(PARTICLE_SIZE);
                binaryImg.free();
            } catch (Exception e) {
                //Log.defcon3(this, e.getMessage());
            }
            printPartReport();
        }
    }

    /**
     * Sets the brightness of the camera
     *
     * @param b Brightness
     */
    public void setBrightness(int b) {
        if (axisCamera != null) {
            axisCamera.writeBrightness(b);
        }
    }

    /**
     * Prints out the the boundaries and center of significant particles found
     * by the camera.
     */
    private void printPartReport() {
        String info = "";
        if (partReport != null && partReport.length != 0) {
            for (int i = 0; i < 1; i++) {
                info += "PARTICLE " + i + '\n';
                //info += "Top:    "+pRep[i].boundingRectTop+'\n';
                //info += "Left:   "+pRep[i].boundingRectLeft+'\n';
                //info += "Width:  "+pRep[i].boundingRectWidth+'\n';
                //info += "Height: "+pRep[i].boundingRectHeight+'\n';
                info += "Area:   " + partReport[i].particleArea + '\n';
                info += "Center: "
                        + partReport[i].center_mass_x_normalized
                        + ", "
                        + partReport[i].center_mass_y_normalized + "\n\n";
            }
            //Log.defcon2(this, info);
        }
    }

    /**
     * Set the threshold of colors the camera should look for. All parameters
     * must be 0-255.
     *
     * @param r Minimum RedValue
     * @param R Maximum Red Value
     * @param g Minimum Green Value
     * @param G Maximum Green Value
     * @param b Minimum Blue Value
     * @param B Maximum Blue Value
     */
    public synchronized void setThresholdRGB(int r, int R, int g, int G, int b, int B) {
        minRed = (r >= 0 && r <= 255 && r <= R) ? r : 0;
        maxRed = (R >= 0 && R <= 255 && R >= r) ? R : 255;
        minGreen = (g >= 0 && g <= 255 && g <= G) ? g : 0;
        maxGreen = (G >= 0 && G <= 255 && G >= g) ? G : 255;
        minBlue = (b >= 0 && b <= 255 && b <= B) ? b : 0;
        maxBlue = (B >= 0 && B <= 255 && B >= b) ? B : 255;
    }

    /**
     * Human way of setting the camera threshold.
     *
     * @param t Threshold
     */
    private synchronized void setThreshold(int t) {
        switch (t) {
            case WHITE_THRESHOLD:
                setThresholdRGB(190, 255, 210, 255, 210, 255);
                break;
            case BLUE_THRESHOLD:
                setThresholdRGB(0, 125, 160, 255, 210, 255);
                break;
            case GREEN_THRESHOLD:
                setThresholdRGB(0, 50, 100, 150, 0, 20);

        }
    }

    /**
     * Gets the center Y of the largest particle
     *
     * @return
     */
    public double getCenterY() {
        if (partReport != null && partReport.length != 0) {
            return partReport[0].center_mass_y_normalized;
        }
        return 0;
    }

    /**
     * Gets the center X of the largest particle
     *
     * @return double center mass x normalized
     */
    public double getCenterX() {
        if (partReport != null && partReport.length != 0) {
            return partReport[0].center_mass_x_normalized;
        }
        return 0;
    }

    /**
     * Returns the biggest particle found by the camera.
     *
     * @return ParticleAnalysisReport
     */
    public synchronized ParticleAnalysisReport getBiggestParticle() {

        if (partReport != null && partReport.length != 0) {
            return partReport[0];
        } else {
            return null;
        }
    }
}
