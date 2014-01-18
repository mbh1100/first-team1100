package displaygrid;

/**
 *
 * @author Akshay
 */
public abstract class ClientApp extends Thread {
        
    private boolean isRunning = false;
    
    public ClientApp(){
        
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
     * Initializes the client app
     */
    public abstract void init();
    
     /**
     * updates the server app
     */
    public abstract void update();
    
     /**
     * Send the app a command recieved from the servers's ServerApp
     * @param id ID of the client
     * @param command the command recieved
     */
    public abstract void commandRecieved(String command);
    
     /**
     * Return the command that should be sent to the server's corresponding ServerApp
     * @param id
     * @return command
     */
    public abstract String getCommand();
    
    /**
     * Returns the target delta time for this app. Apps should override this method to set 
     * a custom delta
     * @return default delta, Config.TARGET_DELTA
     */
    public long getTargetDelta(){
        return Config.TARGET_DELTA;
    }
    
    /**
     * Called when the app has finished
     */
    public abstract void end();
    
    /**
     * Gets the app name
     * @return app name
     */
    @Override
    public abstract String toString(); 
    
    
    
    public final void finish(){
        isRunning = false;
    }
    
}
