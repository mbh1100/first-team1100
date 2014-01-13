package displaygrid;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Akshay
 */
public class Client extends Thread {
    
    //lazy error handling
    //if the error has the word connection, just assume that the connection was lost
    private static final String ERROR_CONNECTION_RESET = "connection";
    
    private final int TIMEOUT = 100;
    private final long SLEEP_TIME = 500;
    
    //the client app for the server app this client is connected to
    private ClientApp app;
    private long targetDelta;
    
    private String ID;
    
    private String serverName;
    private Socket server;
    private DataInputStream in;
    private DataOutputStream out;
    
    private boolean isRunning = false;
    
    private boolean noGUI = false;
    private String argClientName;
    private String argServerName;
    
    public Client(){}
    
    public Client(String clientName, String serverName){
        noGUI = true;
        argClientName = clientName;
        argServerName = serverName;
    }
    
    @Override
    public void run(){
        targetDelta = Config.TARGET_DELTA;
        isRunning = true;
        ClientSetupDialog setup = new ClientSetupDialog();
        boolean connected = false;   

        
        do { 
            
            if(noGUI){
                ID = argClientName;
                serverName = argServerName;
            } else {
                int setupResult = JOptionPane.showConfirmDialog(new JFrame(), setup, "Setup", JOptionPane.OK_CANCEL_OPTION);
                if(setupResult != JOptionPane.OK_OPTION){
                    System.exit(0);
                }   

                ID = setup.clientName.getText();
                serverName = setup.serverName.getText();  
            }
        
            if(server == null){
                try {
                    server = new Socket(serverName, Config.PORT);
                    in = new DataInputStream(server.getInputStream());
                    out = new DataOutputStream(server.getOutputStream());	
                    //tell server the ID of this client
                    out.writeUTF(""+ID);
                    String result = in.readUTF();
                    if(result.equals("NAME")){
                        server = null;
                        throw new Exception();
                    } else {
                        ID = result;
                        connected = true;
                        if(serverName.equals("")){
                            serverName = server.getInetAddress().getHostName();
                        }
                    }
                    System.out.println("Connected to "+serverName+" as "+ID);
                    isRunning = true;
                }catch(Exception e){
                    e.printStackTrace();
                    if(e.getMessage() != null){
                        if (e.getMessage().toLowerCase().contains(ERROR_CONNECTION_RESET)) {
                            disconnect();
                        }
                    }
                    if(noGUI){ // no gui, wait 10 seconds and try again
                      try{
                          Thread.sleep(10000);
                      } catch(Exception e1) {
                          //do nothing
                      }
                    } else {
                        //could not connect, ask to try setup again
                        int result = JOptionPane.showConfirmDialog(new JFrame(), "Could not connect to server \""+serverName+"\". Client Name may already be in use or Server Address may be incorrect. Retry?", "Error", JOptionPane.YES_NO_OPTION);
                        if(result != JOptionPane.OK_OPTION){
                            System.exit(0);
                        }
                    }
                }
            }
        } while(!connected);
        
        try {           
            server.setSoTimeout(0);
        } catch(Exception e){}
        System.out.printf("isRunning = %b", isRunning);
        while(isRunning){            
            try{
                if (app != null) {
                    String outCmd = app.getCommand();
                    if (outCmd == null) {
                        outCmd = " ";
                    }
                    
                    out.writeUTF(outCmd);

                    String cmd = readUTF(false);
                    if (cmd != null) {
                        app.commandRecieved(cmd);
                    }
                    
                    Thread.sleep(targetDelta);                
                    
                } else {
                    readUTF(false);
                    Thread.sleep(SLEEP_TIME);
                }

            }catch(Exception e){
                if(e == null || e.getMessage() == null) {
                    continue;
                }
                if(e.getMessage().toLowerCase().contains(ERROR_CONNECTION_RESET)){
                    e.printStackTrace();
                    disconnect();
                }
            }       
        }   
        System.exit(0);
    }
    
    /**
     * Reads the next incoming command
     * If it is a server command, it executes the command
     * if it is an app command, it passes it back for the app to handle
     * @return 
     */
    private String readUTF(boolean useTimeout){
        
        try {
            if(useTimeout){
                server.setSoTimeout(TIMEOUT);
            }
            String cmd =  in.readUTF();
            server.setSoTimeout(0);
            if(cmd.split(":")[0].equals("APP") && app == null){
                startApp(cmd.split(":")[1]);
            } else if (cmd.equals("END")){
                endApp();
            } else if (cmd.equals("DISCONNECT")){
                disconnect();
            } else {
                return cmd;
            }
        } catch (Exception e){
            e.printStackTrace();
            if (e.getMessage().equalsIgnoreCase(ERROR_CONNECTION_RESET)) {
                disconnect();
            }
        }
        return null;
    }
    
    private void startApp(String appname){
        System.out.printf("startApp(%s)", appname);
        endApp();
        app = DisplayGrid.getClientApp(appname);        
        if(app != null){
            app.setName(ID);
            app.start();
            targetDelta = app.getTargetDelta();
            System.out.println("Started APP \""+app.toString()+"\"");
        }        
    }

    private void endApp(){ 
        System.out.println("endApp()");
        try {
            app.finish();
            app.join();
        } catch(Exception e){}
        app = null;
        targetDelta = Config.TARGET_DELTA;
    }
    
    private void disconnect(){
        System.out.println("disconnect()");
        endApp();
        isRunning = false;
        try{
        server.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }            
    }
}
