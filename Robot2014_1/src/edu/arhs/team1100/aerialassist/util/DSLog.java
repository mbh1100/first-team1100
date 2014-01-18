package edu.arhs.team1100.aerialassist.util;

import edu.wpi.first.wpilibj.AnalogModule;
import edu.wpi.first.wpilibj.Dashboard;
import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Logs messages to the Driver Station
 */
public class DSLog {

    // Going to treat the LCD as a stack, in reverse here because
    // new lines appear on the bottom and scroll upwards (mostly)
    static DriverStationLCD.Line[] lcdLines = {
        DriverStationLCD.Line.kUser6, // bottom line
        DriverStationLCD.Line.kUser5,
        DriverStationLCD.Line.kUser4,
        DriverStationLCD.Line.kUser3,
        DriverStationLCD.Line.kUser2,
        DriverStationLCD.Line.kUser1 // top line
    };
    static String[] lcdHistory = new String[6]; // array to scroll lcd display
    static String clearLine = "                     "; // 21 spaces to clear a line

    /**
     * Removes all data for LCD history
     */
    public DSLog() {
        for (int i = 0; i < lcdHistory.length; i++) {
            lcdHistory[i] = "";
        }
    }

    /**
     * When run, the class starts a continuous loop to update the dashboard
     * constantly. This is probably a bad way to do it.
     */
    public void step() {
        updateDashboard();
    }

    /**
     * Messages to the LCD must be 21 characters long or you get artifacts from
     * previous lines. This should pad the desired message out to the proper
     * length.
     *
     * @param msg the message to be padded out
     * @return line the message line padded out to 21 characters
     */
    static private String padMsg(String msg) {
        String line = msg;
        while (line.length() < 21) {
            line += " ";
        }
        line = line.substring(0, 21);
        return line;
    }

    /**
     * Clears the Driver Station LCD
     */
    public static void clearLCD() {
        for (int i = 0; i < 6; i++) {
            lcdHistory[i] = clearLine;
            DriverStationLCD.getInstance().println(lcdLines[i], 1, lcdHistory[i]);
        }
        DriverStationLCD.getInstance().updateLCD();
    }

    /**
     * This makes it easier to send message to a specific line. Takes the
     * desired line number (top to bottom, 1-6) and the message to print as
     * arguments.
     *
     * @param line which line of the LCD the message should be displayed on
     * @param msg the message to be displayed
     */
    public static void log(int line, String msg) {

        int index = 6 - line; // array is set up bottom to top, this reverses it
        DriverStationLCD.getInstance().println(lcdLines[index], 1, padMsg(msg));
        DriverStationLCD.getInstance().updateLCD(); // keep forgetting this, d'oh!
    } // end method toLCDLine()

    /**
     * Taken from DashboardExampleProject. I'll try to explain how this is
     * organized.
     *
     * sThe LabView dashboard is organized with all the various displays in
     * "clusters". These clusters are embedded in other clusters, which are
     * embedded in otherwise, and so on. For example, PWM display 1 is embedded
     * in the cluster for Digital Module 0, which is embedded in Digital Cluster
     * 1, which is in the cluster containing all the digital modules, which is
     * in the cluster containing everything. Whew. Basically it's a tree
     * structure.
     *
     * To send information to the dashboard, you have to "pack" this tree,
     * filling in all the various clusters with the correct data, and then send
     * the whole tree at one time to the dashboard. You create the tree by using
     * the addCluster() method, nesting each lower level of the tree in the
     * higher ones. When a cluster is loaded you finalize it, which basically
     * packs up that particular module for shipment to the dashboard. After all
     * the clusters are finalized you use the commit() method to send it to the
     * dashboard.
     *
     * I've extracted the tree structure from the LabView dashboard code to
     * interpret what's below. I'll try to provide enough comments for you to
     * understand which module is where, and which instrument display it
     * connects to.
     *
     * To keep the dashboard up to date you have to call this method repeatedly,
     * either in an infinite loop or in teleopContinuous() if you use
     * IterativeRobot. I use an infinite loop running in a separate thread.
     */
    private void updateDashboard() {

        // first, get an instance of the dashboard "packer" file.  This is
        // essentially a map of how the dashboard has the clusters configured.
        Dashboard lowDashData = DriverStation.getInstance().getDashboardPackerLow();

        // We now recreate the tree using the addCluster method, nesting
        // the individual display panels.

        // First, the overall container that holds everything else
        lowDashData.addCluster();  // overall container
        {
            // There are 3 clusters in the next level, the analog modules,
            // the digital modules, and the solenoids.

            // Add the cluster containing the analog modules.
            lowDashData.addCluster();
            {
                // The analog module cluster contains two analog modules, one
                // for each of the first two slots on the cRio.

                // Add the cluster for Analog Module 0 (Slot One on the cRio)
                lowDashData.addCluster();


                {
                    // Here we just iterate through the analog ports, adding
                    // float values containing the average voltage for the given
                    // port.
                    for (int i = 1; i <= 8; i++) {
                        lowDashData.addFloat((float) AnalogModule.getInstance(1).getAverageVoltage(i));
                    }
                }
                // Finished with Analog Module 0, finalize the cluster
                lowDashData.finalizeCluster(); // finalize analog module 0

                /// Add the cluster for Analog Module 1 (Slot Two on the cRio)
                lowDashData.addCluster();
                {
                    // And again, iterate through the voltages for each port
                    // on the module
                    for (int i = 1; i <= 8; i++) {
                        lowDashData.addFloat((float) AnalogModule.getInstance(2).getAverageVoltage(i));
                    }
                }
                // Finished with Analog Module 1, finalize the cluster.
                lowDashData.finalizeCluster(); // finalize analog module 1
            }
            // Done loading the data for the analog modules, so we finalize
            // the cluster that holds both of them.
            lowDashData.finalizeCluster(); // finalize analog cluster

            // Add the cluster containing the digital sub clusters.
            lowDashData.addCluster();
            {
                // The digital cluster contains two sub clusters, one for
                // slot 4 and one for slot 6 on the cRio.  Each of those
                // clusters contain modules for relays and for the PWM
                // slots.

                // Add the cluster for Digital SubCluster 1 (slot 4 on the cRio)
                lowDashData.addCluster();
                {
                    // The digital module itself contains two sub modules.
                    // The numbering system is screwey, but it's taken straight
                    // from the LabView code...

                    // Add the cluster Digital Module 0 in SubCluster 1
                    lowDashData.addCluster();
                    {
                        int module = 4; // this specifies the cRio slot

                        // And the next 4 lines handle relays
                        lowDashData.addByte(DigitalModule.getInstance(module).getRelayForward());
                        lowDashData.addByte(DigitalModule.getInstance(module).getRelayForward());
                        lowDashData.addShort(DigitalModule.getInstance(module).getAllDIO());
                        lowDashData.addShort(DigitalModule.getInstance(module).getDIODirection());

                        // Add the cluster for PWM module 1 - I know for a fact
                        // that these are the 10 PWM connections on the digital
                        // sidecar hooked to the module in cRio Slot 4 :)
                        lowDashData.addCluster();
                        {
                            // Iterate through the PWM values for each port
                            for (int i = 1; i <= 10; i++) {
                                lowDashData.addByte((byte) DigitalModule.getInstance(module).getPWM(i));
                            }
                        }
                        // Finished with PWM Module 1, finalize the cluster.
                        lowDashData.finalizeCluster(); // finalize PWM 1
                    }
                    // And finished with Digital Module 0
                    lowDashData.finalizeCluster(); // finalize digital module 0
                }
                // And with Digital SubCluster 1
                lowDashData.finalizeCluster(); // finalize subcluster 1

                // Add the cluster for Digital SubCluster 2 (slot 6 on the cRio)
                lowDashData.addCluster();
                {
                    // Add the cluster for Digital Module 1 in SubCluster 2
                    lowDashData.addCluster();
                    {
                        int module = 6; // cRio slot 6

                        // And again, load the relay data
                        lowDashData.addByte(DigitalModule.getInstance(module).getRelayForward());
                        lowDashData.addByte(DigitalModule.getInstance(module).getRelayReverse());
                        lowDashData.addShort(DigitalModule.getInstance(module).getAllDIO());
                        lowDashData.addShort(DigitalModule.getInstance(module).getDIODirection());

                        // Add the cluster for PWM Module 2
                        lowDashData.addCluster();
                        {
                            // iterate through all 10 PWM ports
                            for (int i = 1; i <= 10; i++) {
                                lowDashData.addByte((byte) DigitalModule.getInstance(module).getPWM(i));
                            }
                        }
                        // Finished with PWM Module 2, finalize it.
                        lowDashData.finalizeCluster(); // finalize PWM 2
                    }
                    // Finished with Digital Module 2
                    lowDashData.finalizeCluster(); // finalize digital 2
                }
                // And done with Digital SubCluster 2
                lowDashData.finalizeCluster(); // finalize subcluster 2
            }
            // And that completes the entire Digital Cluster
            lowDashData.finalizeCluster(); // finalize digital cluster

            // The solenoids, for some reason, are not in a cluster of their
            // own, but are instead sitting in the overall container.  As such,
            // we don't need to addCluster() for them, we just need to add
            // the data.
            lowDashData.addByte(Solenoid.getAllFromDefaultModule());

            // If you are going to add instruments to the dashboard the
            // easiest place to put them is in the overall cluster, and then
            // load the values for them here the same way the solenoid was
            // done.  Makes me think the solenoid was an afterthought.
            // Actually I think the whole dashboard was designed haphazardly
            // instead of in a planned manner, which is why this whole structure
            // sucks so bad.

        }

        // Once all the inputs are read and loaded, we close the overall container
        lowDashData.finalizeCluster(); // finalize entire tree structure.

        // We are now ready to send our packed up data tree to the dashboard
        // for display.
        lowDashData.commit(); // commit changes to update dashboard

    } // end method updateDashboard()
}