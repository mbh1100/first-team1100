/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.util;

import edu.arhs.team1100.ultimateascent.subsystems.DriveSubsystem;

/**
 *
 * @author akshay
 */
public class ControllerState {
    
    public double X, Y, R;
    public int mode;
    
    public ControllerState(){
        this(0,0,0, DriveSubsystem.getInstance().getDriveMode());
    }
    
    public ControllerState(double x,double y,double r, int m){
        X = x;
        Y = y;
        R = r;
        mode = m;
    }
    
    public String toString(){
        return "new ControllerState("+X+","+Y+","+R+","+mode+"),";
    }
    
}