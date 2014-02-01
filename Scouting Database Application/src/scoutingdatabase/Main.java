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
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    Display frame = new Display();
                    frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
    }
}
