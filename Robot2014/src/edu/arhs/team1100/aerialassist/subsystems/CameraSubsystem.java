/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.arhs.team1100.aerialassist.subsystems;
import edu.arhs.team1100.aerialassist.OI;
import edu.arhs.team1100.aerialassist.RobotMap;
import edu.arhs.team1100.aerialassist.util.Log;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;


/**
 *
 * @author Team 1100
 */
public class CameraSubsystem extends Subsystem {
    private int MIN_RED = 0;
    private int MAX_RED = 50;
    private int MIN_GREEN = 235;
    private int MAX_GREEN = 255;
    private int MIN_BLUE = 235;
    private int MAX_BLUE = 255;
    private AxisCamera axisCamera = null;
    private BinaryImage binaryImg;
    private ParticleAnalysisReport[] particles = null;
    private ColorImage colorImage;
    static CameraSubsystem instance;
    /**
     * Constructs an ISubsystem. Initializes compressor, lift pistons,
     * intake motors. Starts compressor.
     */
    public CameraSubsystem() {
        
    }

    /**
     * Creates a IntakeSubsystem if not already created
     *
     * @return instance
     */
    public static CameraSubsystem getInstance() {
        if (instance == null) {
            instance = new CameraSubsystem();
            instance.initDefaultCommand();
        }
        return instance;
    }


    public boolean isHot()
    {
        if (axisCamera != null && axisCamera.freshImage()) {
            try {
                colorImage = axisCamera.getImage();
                binaryImg = colorImage.thresholdRGB(MIN_RED, MAX_RED, MIN_GREEN, MAX_GREEN, MIN_BLUE, MAX_BLUE);

                particles = binaryImg.getOrderedParticleAnalysisReports(3);  //get one (the largest) particle
       
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
        
        if(particles[0] != null)
        {
            return true;
        }  
        return false;
    }
    
    
    /**
     * Initializes shooter command. Do nothing.
     */
    protected void initDefaultCommand() {
    }
}
