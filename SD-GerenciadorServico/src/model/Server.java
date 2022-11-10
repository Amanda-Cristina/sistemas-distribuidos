/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import views.ServerView;


/**
 *
 * @author dinha
 */
public class Server extends Thread {
    private Socket clientSocket;
    private ServerSocket serverSocket;
    public ArrayList<ActiveUser> connectedUsers;
    private final ServerView view;
    private DefaultTableModel table;
    //public Categoria categorias;



    public Server(ServerView view){
        this.connectedUsers = new ArrayList<>(); //Controle usuários conectados
        this.view = view;
   
   }
    
    //Controle Lista Usuários Conectados////////////////////////////////////////
    public void addActiveUser(ActiveUser activeUser){
        this.connectedUsers.add(activeUser);
    }
    
    public ActiveUser getActiveUserByPort(int port){
        for(ActiveUser u:this.connectedUsers){
            if(u.port == port){
                return u;
            }
        } 
        return null;
    }
    
    public ActiveUser getActiveUserByIp(String ip){
        for(ActiveUser u:this.connectedUsers){
            if(u.ip.equals(ip)){
                return u;
            }
        } 
        return null;
    }
    
    public boolean activeUserLoggedByIp(String ip){
        for(ActiveUser u:this.connectedUsers){
            if(u.ip.equals(ip)){
                if(u.loggedUser){
                    return true;
                }
            }
        } 
        return false;
    }
    
    public void removeActiveUsers(ActiveUser user){
        this.connectedUsers.remove(user);
    }
    
    public void updateActiveUsers(int user_index, ActiveUser activeUser){
        this.connectedUsers.set(user_index, activeUser);
    }
    
    public ArrayList<ActiveUser> getConnectedUsers(){
        return this.connectedUsers;
    }
    
    
    //Start Servidor////////////////////////////////////////////////////////////
    public void startServer(int port) throws IOException{
        this.serverSocket = new ServerSocket(port);
        System.out.println("Server start at port: " + port);
        this.start();

    }
    
    //Thread Servidor///////////////////////////////////////////////////////////
    @Override    
    public void run(){
        while(true){
            try{
                //Nova conexão com cliente abre uma nova thread
                this.clientSocket = serverSocket.accept();
                ServerThread thread = new ServerThread(this.clientSocket, this);
                thread.start();
                
            }catch(IOException e){
                e.printStackTrace();
                System.err.println("Accept failed."); //duvida:tem como identificar cliente
                //System.exit(1);
            }
        }
       
       

    }
    
    //Views Servidor////////////////////////////////////////////////////////////
    public ServerView getServerView(){
        return this.view;
    }
     
    public void updateTable() throws ArrayIndexOutOfBoundsException{
        this.table = (DefaultTableModel)view.getTable().getModel();
        this.table.setRowCount(0);
        int i = 0;
        for(ActiveUser user_ : this.getConnectedUsers()){
      
            this.table = (DefaultTableModel)view.getTable().getModel();
            if(user_.loggedUser){
                this.table.insertRow(i++,new Object[]{user_.ip,user_.port,user_.user.nome,"true", user_.connected});
            }else{
                this.table.insertRow(i++,new Object[]{user_.ip,user_.port,"--","false", user_.connected});
            }
        }
    }
}
