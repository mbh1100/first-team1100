package displaygrid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Akshay
 */
public class Client extends Thread implements ActionListener {
    
    //lazy error handling
    //if the error has the word connection, I'll just assume that the connection was lost
    private static final String ERROR_CONNECTION_RESET = "Connection";
    
    //if there is no app, only check for a new one 10 times a second
    static final int CHECK_RATE = 100;
    
    //the client app for the server app this client is connected to
    private ClientApp app;
    
    private String ID;
    
    private String serverName;
    private Socket server;
    private DataInputStream in;
    private DataOutputStream out;
    
    private boolean isRunning = false;
    
    public Client(){}
    
    @Override
    public void run(){
        isRunning = true;
        ClientSetupDialog setup = new ClientSetupDialog();
        boolean connected = false;   

        
        do {            
            int setupResult = JOptionPane.showConfirmDialog(new JFrame(), setup, "Setup", JOptionPane.OK_CANCEL_OPTION);
            if(setupResult != JOptionPane.OK_OPTION){
                System.exit(0);
            }   
            
            ID = setup.clientName.getText();
            serverName = setup.serverName.getText();           
        
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
                }catch(Exception e){
                    if (e.getMessage().equalsIgnoreCase(ERROR_CONNECTION_RESET)) {
                        disconnect();
                    }
                    //could not connect, ask to try setup again
                    int result = JOptionPane.showConfirmDialog(new JFrame(), "Could not connect to server \""+serverName+"\". Client Name may already be in use or Server Address may be incorrect. Retry?", "Error", JOptionPane.YES_NO_OPTION);
                    if(result != JOptionPane.OK_OPTION){
                        System.exit(0);
                    }
                }
            }
        } while(!connected);
        
        try {           
            server.setSoTimeout(0);
        } catch(Exception e){}
        
        while(isRunning){                
            try{
                //server.setSoTimeout(CHECK_RATE);
                //first send either a pending command or a reqest ping to server
                if (app != null) {
                    String outCmd = app.getCommand();
                    if (outCmd == null) {
                        outCmd = " ";
                    }
                    //System.out.println("Write \"" + outCmd + "\"");
                    out.writeUTF(outCmd);

                    String cmd = readUTF();
                    if (!cmd.equals("")) {
                        app.commandRecieved(cmd);
                    }
                } else {
                    readUTF();
                }

            }catch(Exception e){
                if(e == null || e.getMessage() == null)continue;
                if(e.getMessage().contains(ERROR_CONNECTION_RESET)){
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
    private String readUTF(){
        try {
            String cmd =  in.readUTF();
            //System.out.println("Read \""+cmd+"\"");
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
            if (e.getMessage().equalsIgnoreCase(ERROR_CONNECTION_RESET)) {
                disconnect();
            }
        }
        return "";
    }
    
    private void startApp(String appname){
        app = DisplayGrid.getClientApp(appname);
        if(app != null){
            System.out.println("Started APP \""+app.toString()+"\"");
            app.start();
        }        
    }

    private void endApp(){        
        try {
            app.finish();
            app.join();
        } catch(Exception e){}
        app = null;
    }
    
    private void disconnect(){
        endApp();
        isRunning = false;
        try{
        server.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
