 package displaygrid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Akshay
 */
public class DisplayGrid  extends JFrame implements ActionListener {
    
    JButton server, client;
    
     /**
     * @param args the command line arguments
     * to run automatically: java -jar DisplayGrid.jar c [Client Name] [Server Address]
     */
    public static void main(String[] args) {
        new DisplayGrid(args);
    }
    
    public DisplayGrid(String[] args){
        super();
        
        //get list of app names
        Config.appNames = new String[Config.serverAppClasses.length];
        for(int i = 0; i < Config.serverAppClasses.length; i++){
            try {
            Config.appNames[i] = Config.appNames[i] = ((ServerApp)(Config.serverAppClasses[i].newInstance())).getServerName();  
            } catch (Exception e){
                System.out.println(e.getMessage());
                Config.appNames[i] = "App "+i;
            }
        }
        
        if(args.length >= 3 && (args[0].startsWith("c") || args[0].startsWith("C"))){
            new Client(args[1], args[2]).start();
            return;            
        }

        try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.setTitle("DisplayGrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        

        server = new JButton("Start as Server");
        client = new JButton("Start as Client");
        server.addActionListener(this);
        client.addActionListener(this);
        panel.add(server);
        panel.add(client);		
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == server || e.getSource() == client){            
                this.setVisible(false);
        }

        if(e.getSource() == server){
            new Server().start();
        }
        else if (e.getSource() == client){
            new Client().start();
        }
		
    }
    
    /**
     * Creates a ClientApp of type appName
     * @param appName the appName of the type of client needed
     * @return a ClientApp
     */
    public static ClientApp getClientApp(String appName){
        for(int i = 0; i < Config.clientAppClasses.length; i++){
            try{
                ClientApp app = (ClientApp)Config.clientAppClasses[i].newInstance();
                if(appName.equals(app.toString())){
                    return app;
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;        
    }
    
    /**
     * Creates a ServerApp of type appName
     * @param appName the appName of the type of server needed
     * @param clients the clients assigned to this server
     * @return a ServerApp
     */
    public static ServerApp getServerApp(String appName, ArrayList<String> clients){
        for(int i = 0; i < Config.serverAppClasses.length; i++){
            try{
                ServerApp app = (ServerApp)Config.serverAppClasses[i].newInstance();
                if(appName.equals(app.getServerName())){
                    app.setClients(clients);
                    return app;
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    
}
