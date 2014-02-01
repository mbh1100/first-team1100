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
    
    static Display frame;
    static ChoseDisplay frame2;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    frame = new Display();
                    frame.setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    frame2 = new ChoseDisplay();
                    frame2.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
		}
	});
    }
    
    public static void frameSetVisible(boolean b) {
        frame.setVisible(b);
    }
    public static void frame2SetVisible(boolean b) {
        frame2.setVisible(b);
    }
    public static void frame3SetVisible(boolean b) {
        
    }
}
