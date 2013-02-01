/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.util;

/**
 *
 * @author akshay
 */
public class ControllerState {
    
    public double X, Y, R;
    
    public ControllerState(double x,double y,double r){
        X = x;
        Y = y;
        R = r;
    }
    
    public String toString(){
        return "new ControllerState("+X+","+Y+","+R+"),";
    }
    
}
