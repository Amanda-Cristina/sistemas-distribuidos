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
import org.json.JSONException;
import org.json.simple.JSONObject;
import views.ServerView;


/**
 *
 * @author dinha
 */
public class Server extends Thread {
    private Socket clientSocket;
    private ServerSocket serverSocket;
    public ArrayList<ActiveUser> connectedUsers;
    private ArrayList<ServerThread> threads;
    private final ServerView view;
    private DefaultTableModel table;
    //public Categoria categorias;



    public Server(ServerView view){
        this.connectedUsers = new ArrayList<>(); //Controle usuários conectados
        this.threads = new ArrayList<>();

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
    
    public ActiveUser getActiveUserByIpPort(String ip, int porta){
        for(ActiveUser u:this.connectedUsers){
            if((u.ip.equals(ip)) & (u.port == porta)){
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
    
    public boolean activeUserLoggedByPort(int port){
        for(ActiveUser u:this.connectedUsers){
            if(u.port == port){
                if(u.loggedUser){
                    return true;
                }
            }
        } 
        return false;
    }
        public boolean activeUserLoggedByIpPort(String ip, int porta){
        for(ActiveUser u:this.connectedUsers){
            if((u.ip.equals(ip)) & (u.port == porta)){
                if(u.loggedUser){
                    return true;
                }
            }
        } 
        return false;
    }
    
    
    public boolean activeUserLoggedByRa(String ra){
        for(ActiveUser u:this.connectedUsers){
            if(u.loggedUser){
                if(u.user.ra.equals(ra)){
                    return true;
                }
            }
        } 
        return false;
    }
    //public void removeActiveUsers(ActiveUser user){
        //this.connectedUsers.remove(user);
    //}
    
    //public void updateActiveUsers(int user_index, ActiveUser activeUser){
        //sendall lista(logados ou ativos/categoria) para quem 
        //this.connectedUsers.set(user_index, activeUser);
    //}
    
    public ArrayList<ActiveUser> getConnectedUsers(){
        return this.connectedUsers;
    }
    
    public ArrayList<ActiveUser> getLoggedUsers(){
        ArrayList<ActiveUser> loggedUsers = new ArrayList<>();
        for(ActiveUser user_ : this.getConnectedUsers()){
            if(user_.loggedUser){
                loggedUsers.add(user_);
            }
        }
        return loggedUsers;
    }
    
    private void sendMessageFriend(ServerThread friend) throws JSONException, Exception{
        JSONObject reply = new JSONObject();
        JSONObject dados = new JSONObject();

        
    }
    
    
    public ServerThread getThreadByRa(String ra){
        for(ServerThread thread_ : this.threads){
            if(thread_.user.user.ra.equals(ra)){
                if(thread_.user.available){
                    return thread_;
                }
            }
        } 
        return null;
    }
    
    public void updateListAvailable() throws IOException, JSONException{
        ArrayList<ActiveUser> loggeddUsers = getLoggedUsers();
        if(!this.threads.isEmpty()){
            for(ServerThread thread_ : this.threads){
                if(thread_.user.loggedUser){
                    thread_.sendListUsers(loggeddUsers);
                    
                }
            }
        }
        
     }
    
    public void removeThread(ServerThread thread){
        this.threads.remove(thread);
    }
    
    //
    
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
                this.threads.add(thread);
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
     
    public void updateTable()throws ArrayIndexOutOfBoundsException{
        this.table = (DefaultTableModel) this.view.getModelTable();

        this.table.setRowCount(0);
        int i = 0;            

        for(ActiveUser user_ : this.getConnectedUsers()){

            if(user_.loggedUser){
                this.table.insertRow(i++,new Object[]{user_.ip,user_.port,user_.user.nome, user_.connected,user_.loggedUser,user_.available});
           }else{
                this.table.insertRow(i++,new Object[]{user_.ip,user_.port,"--", user_.connected,user_.loggedUser,user_.available});}
        }
        this.view.setTable(this.table,this.view.getTable());

    }
}
