/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutingdatabase;

import java.awt.EventQueue;

/**
 *
 * @author Thomas
 */
public class Main {
    
    static Display matchDisplay;
    static ChoseDisplay choseDisplay;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    matchDisplay = new Display();
                   
                    matchDisplay.setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    choseDisplay = new ChoseDisplay();
                    choseDisplay.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
		}
	});
    }
    
    /*
     * Set the match input to visible
     */
    public static void frameSetVisible(boolean b) {
        matchDisplay.setVisible(b);
    }
    public static void frame2SetVisible(boolean b) {
        //Set the input chooser to visibe
        choseDisplay.setVisible(b);
    }
    public static void frame3SetVisible(boolean b) {
        //Set the pit input to visible
    }
}
