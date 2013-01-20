/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.log;

/**
 *
 * @author Akshay
 */
public class Log {
    
    private static ILogOutput log;
    
    public static void setLogOutput(ILogOutput out){
        log = out;
    }
    
    public static void log(String s){
        if(log != null){
            log.log(s);     
        }
    }
    
}
