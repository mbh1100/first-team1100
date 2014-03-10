package displaygrid;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akshay
 */
public class Server extends Thread implements ActionListener {
    
    
    private ServerFrame window;
    private DefaultTableModel clientTableModel;
    
    private HashMap<String, ClientHandler> clientList;
    private ArrayList<ServerApp> activeServerApps;
    private ServerSocket serverSocket;
    
    private boolean isRunning;
    
    public Server(){
        try{
            serverSocket = new ServerSocket(Config.PORT);
            serverSocket.setSoTimeout(0);
        } catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        activeServerApps = new ArrayList<>();
        clientList = new HashMap<>();
        window = new ServerFrame();
        try { 
            window.setTitle(InetAddress.getLocalHost().toString());
        } catch(Exception e){
            window.setTitle("Display Grid Server");
        }
        window.setAppList(Config.appNames);
        window.startButton.addActionListener(this);
        window.clientStopButton.addActionListener(this);
        window.appStopButton.addActionListener(this);
        window.disconnectClientButton.addActionListener(this);
        window.setVisible(true);
        
        clientTableModel = (DefaultTableModel)window.clientTable.getModel();
    }
    
    public void run(){
        isRunning = true;
        
        connectClients:while(isRunning){
            try{
                Socket newClient = serverSocket.accept();
                newClient.setSoTimeout(0);
                String newClientID = new DataInputStream(newClient.getInputStream()).readUTF();
                
                if(newClientID.equals("")){
                    newClientID = newClient.getInetAddress().getHostName();
                }
                
                if(clientList.keySet().contains(newClientID)){
                    //reject client because name already exists
                    new DataOutputStream(newClient.getOutputStream()).writeUTF("NAME");
                    continue connectClients;
                } else {
                    new DataOutputStream(newClient.getOutputStream()).writeUTF(newClientID);
                }
                ClientHandler newClientHandler = new ClientHandler(newClientID, newClient, this);
                String newClientAddr = newClient.getInetAddress().getHostAddress();
                clientTableModel.insertRow(clientTableModel.getRowCount(), new Object[]{newClientID, null, newClientAddr});                
                clientList.put(newClientID, newClientHandler);
                newClientHandler.start();
            } catch(Exception e){
                //JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());

            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == window.startButton){
            appStarted();             
        } else if (e.getSource() == window.clientStopButton) {
            clientsStopped();
        } else if (e.getSource() == window.appStopButton){
            appsStopped();           
        } else if (e.getSource() == window.disconnectClientButton){
            clientsDisconnected();
        }
        refreshAppList();
    }
    
    private void refreshAppList() {
        Iterator<ServerApp> i = activeServerApps.iterator();
        while(i.hasNext()){
            ServerApp app = i.next();
            if (app.getClientCount() == 0) {
                app.finish();
                window.tabPane.remove(app.getPanel());
                i.remove();
            }
        }

        DefaultListModel appListModel = new DefaultListModel();
        for (ServerApp app : activeServerApps) {
            appListModel.addElement(app);
        }
        window.activeAppList.setModel(appListModel);
    }
    
    /**
     * Starts an app with selected clients from table
     */
    private void appStarted() {
        String appName = (String) window.appSelection.getSelectedItem();
        ArrayList<String> selectedClients = window.getAllPendingAppClients();
        if (selectedClients.isEmpty()) {
            return;
        }
        ServerApp newApp = DisplayGrid.getServerApp(appName, selectedClients);
        
        //Get specific app number, so that different instances of the same app can be idetified
        int appNum = 0;
        for(ServerApp sa:activeServerApps){
            if(newApp.getClass() == sa.getClass()) appNum++;
        }
        newApp.setNumber(appNum);
        
        activeServerApps.add(newApp);
        newApp.start();
        for (String o : selectedClients) {
            ClientHandler clientHandle = clientList.get(o);
            clientHandle.setApp(newApp);
            window.renameTableApp(newApp.toString(), o);
        }
        
        window.tabPane.add(newApp.toString(),newApp.getPanel());
        
    }

    /**
     * Stop selected clients
     * Removes clients from apps, but apps are still running of other clients are connected
     */
    private void clientsStopped() {
        int[] selectedRows = window.clientTable.getSelectedRows();
        ArrayList<String> selectedClients = new ArrayList<>();
        for (int i = 0; i < selectedRows.length; i++) {
            String client = (String) clientTableModel.getValueAt(selectedRows[i], ServerFrame.CLIENT_ID_COL);
            selectedClients.add(client);
            window.renameTableApp("", client);
        }

        for (String c : selectedClients) {
            try {                
                clientList.get(c).exitCurrentApp();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Stops selected apps
     * All clients are stopped and then the app it stopped
     */
    private void appsStopped() {
        List selectedApps = window.activeAppList.getSelectedValuesList();
        Collection<ClientHandler> ch = clientList.values();
        for (Object a : selectedApps) {
            for (ClientHandler c : ch) {
                if (c.getApp() == a) {
                    c.exitCurrentApp();
                    window.renameTableApp("", c.getClientID());

                }
            }
        }
    }
    
    /**
     * Disconnects Selected clients from server
     */
    private void clientsDisconnected(){
        int[] selectedRows = window.clientTable.getSelectedRows();
        ArrayList<String> selectedClients = new ArrayList<>();
        for (int i = 0; i < selectedRows.length; i++) {
            String client = (String) clientTableModel.getValueAt(selectedRows[i], ServerFrame.CLIENT_ID_COL);
            selectedClients.add(client);
        }

        for (String c : selectedClients) {
            disconnectClient(c);
        }
    }
    

    /**
     * Disconnects clients from server
     * @param c Client to disconnect
     */
    public void disconnectClient(String c){
        ClientHandler h = clientList.get(c);
//        if(h.hasApp()){ //not needed, ClientHandler.finish() does this
//            h.getApp().removeClient(c);
//        }
        h.finish();
        try {
            h.join();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Disconnected "+c);
        window.removeClient(c);
        clientList.remove(c);       
    }
}
