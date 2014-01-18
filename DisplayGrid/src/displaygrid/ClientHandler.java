package displaygrid;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Akshay
 */
public class ClientHandler extends Thread {
    
    
    private static final String ERROR_CONNECTION_RESET = "connection";
    
    //the server that created this handler
    private Server server;
    //the server app that the client is currently connected to
    private ServerApp app;
    
    private String clientID;
    private Socket client;
    
    private boolean isRunning = false;
    private boolean hasApp = false;

    private DataInputStream in;
    private DataOutputStream out;
    
    public ClientHandler(String id, Socket s, Server serv)throws Exception{
        clientID = id;
        client = s;
        server = serv;
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
    }
    
    public void run(){
        isRunning = true;
        while (isRunning) {
            if(app != null && hasApp){
                try {
                    String recieved = in.readUTF(); 
                    if(!recieved.equals(" ")){                         
                        app.commandRecieved(clientID, recieved);  
                    }  
                    String outCmd = app.getCommand(clientID);
                    if(outCmd == null){
                        outCmd = " ";
                    }
                    out.writeUTF(outCmd);                    

                } catch (Exception e) {
                    if (e.getMessage().toLowerCase().contains(ERROR_CONNECTION_RESET)) {
                        server.disconnectClient(clientID);
                    }
                }
            } else {
                System.out.print("");
                try{
                    Thread.sleep(Config.TARGET_DELTA);
                } catch(Exception e){
                    if(e == null || e.getMessage() == null){
                        server.disconnectClient(clientID);
                    }
                }
            }           
        }
    }
    
    public String getAppName(){
        return app.toString();        
    }
    
    public void setApp(ServerApp a){
        exitCurrentApp();
        try{            
            app = a;
            hasApp = true;
            out.writeUTF("APP:"+app.getServerName());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public ServerApp getApp(){
        return app;
    }
    
    public boolean hasApp(){
        return (hasApp && app != null);
    }
    
    public void exitCurrentApp(){
        if(app == null){
            return;
        } else {
            app.removeClient(clientID);
            try{
                out.writeUTF("END");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        hasApp = false;
    }
    
    public void finish(){
        exitCurrentApp();
        try{
            out.writeUTF("DISCONNECT");
            client.close();
        } catch (Exception e){
            //System.out.println(e.getMessage());
        }
        isRunning = false;
        
    }
    
    public String getClientID(){
        return clientID;
    }
   
    
}
