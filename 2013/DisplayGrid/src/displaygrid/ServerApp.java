/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid;

import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public abstract class ServerApp extends Thread {
        
    protected ArrayList<String> clients;
    
    private String name;
    
    private boolean isRunning = false;
    
    public ServerApp(){
    }
    
    @Override
    public final void run(){
        isRunning = true;
        
        init();
        while(isRunning){
            update();
            try{
                Thread.sleep(Config.TARGET_DELTA);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        end();
    }
    
    /**
     * initialized the server app
     */
    public abstract void init();
    
    /**
     * updates the server app
     */
    public abstract void update();
    
    /**
     * Return the command that should be sent to the client's corresponding ClientApp
     * @param id
     * @return command
     */
    public abstract String getCommand(String id);
    
    /**
     * Send the app a command recieved from the client's ClientApp
     * @param id ID of the client
     * @param command the command recieved
     */
    public abstract void commandRecieved(String id, String command);
    
    public abstract void end();
    
    
    
    /**
     * get the app name
     * @return app name
     */
    @Override
    public final String toString(){
        return name;
    }
    
    public final void finish(){
        isRunning = false;
    }
    
    public final void removeClient(String id){
        clients.remove(id);                
    }  
   
    
    /**
     * set clients for this server app
     * @param c 
     */
    public final void setClients(ArrayList<String> c){
        clients = c;        
    }
    
    public final ArrayList<String> getClients(){
        return clients;
    }
    
    public final int getClientCount(){
        return clients.size();
    }
    
    public final void setNumber(int n){
        name = getServerName() + " " + n;
    }
    
    public abstract String getServerName();
}
