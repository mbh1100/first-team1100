package edu.arhs.team1100.aerialassist.util;

import com.sun.squawk.util.MathUtils;
import java.util.Vector;

/**
 * @author Team 1100
 */
public class Log {

    public final static int LEVEL_DEBUG = 0;
    public final static int LEVEL_WARN = 1;
    public final static int LEVEL_ERROR = 2;
    public final static int LEVEL_OFF = 3;
    private static int minLevel;
    private static Vector classes;

    /**
     * Creates new vector of classes
     */
    public static void init() {
        classes = new Vector();
        minLevel = LEVEL_DEBUG;
    }

    /**
     * Sets the minimum logging level that is shown
     *
     * @param mlvl minimum level to be set
     */
    public static void setMinLevel(int mlvl) {
        minLevel = mlvl;
    }

    /**
     * Adds a class to the class vector, with level
     *
     * @param c
     * @param level
     */
    public static void addClass(Class c, int level) {
        classes.addElement(new LogClass(c, level));
    }

    /**
     * Log a message
     *
     * @param source the object calling this function
     * @param message
     * @param level Log.LEVEL_*
     */
    public static void log(Object source, String message, int level) {
        LogClass lc = null;
        for (int i = 0; i < classes.size(); i++) {
            if (classes.elementAt(i).equals(source.getClass())) {
                lc = (LogClass) classes.elementAt(i);
            }
        }
        if (lc == null) {
            return;
        }
        if (level >= lc.maxLevel && level >= minLevel) {
            System.out.println("[" + simpleClassName(lc) + "] " + message);
        }
    }

    /**
     * Rounds
     *
     * @param num
     * @param places
     * @return rounded number
     */
    public static String round(double num, int places) {
        return MathUtils.round(num * MathUtils.pow(10, places)) / MathUtils.pow(10, places) + "";
    }

    private static String simpleClassName(LogClass c) {
        return c.mClass.getName().substring(c.mClass.getName().lastIndexOf('.') + 1);
    }
}

class LogClass {

    public Class mClass;
    public int maxLevel;

    public LogClass(Class c, int l) {
        mClass = c;
        maxLevel = l;
    }

    public boolean equals(Object c) {
        return c == mClass;
    }
}
