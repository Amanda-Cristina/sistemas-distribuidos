/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
//import org.json.JSONObject;
import views.ClientView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dinha
 */
public class Client extends Thread{
    private ClientView clientView;
    public PrintWriter out;
    public BufferedReader in;
    protected Socket echoSocket;
    public String userName;
    public String senha;
    public String ip;
    public int port;
    //public ArrayList<String> categorias;
    
    public Client(ClientView clientView){
        this.clientView = clientView;
        
    }
    
    //Start Client//////////////////////////////////////////////////////////////
    public void connect(String ip, int port) throws IOException{
        this.ip = ip;
        this.port = port;
        this.echoSocket = new Socket(ip, port);
        this.out = new PrintWriter(this.echoSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(
                                        this.echoSocket.getInputStream()));
        System.out.println ("New Communication Started " + ip +":" + port);
        this.start();
    
    }
    
        //Close Client//////////////////////////////////////////////////////////////
    public void desconnect() throws IOException{
           
        this.echoSocket.close();                     
        this.out.close(); 
        this.in.close();
        System.out.println("Connection closed "+ this.ip + ":" + this.port);
        
    
    }
    
    
    //Reconnect Client//////////////////////////////////////////////////////////////
    public void reconnect() throws IOException{
        this.echoSocket = new Socket(this.ip, this.port);
        this.out = new PrintWriter(this.echoSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(
                                        this.echoSocket.getInputStream()));

        System.out.println ("New Communication Started " + this.ip +":" + this.port + " - " + this.echoSocket.getLocalPort());
    
    }
    
    //Envio Mensagem////////////////////////////////////////////////////////////
    public void sendMessage(JSONObject msg_json) throws IOException, JSONException{

        this.out.println(msg_json.toJSONString());
        this.out.flush();
        System.out.println("Message sent to "+ this.echoSocket.getInetAddress().getHostAddress() + ":" + this.echoSocket.getPort() + " = " + msg_json);
    }
    
    //Tratamento Mensagens e feedback///////////////////////////////////////////
    
    
    public void treatLogout(JSONObject json_msg, ClientView clientView) throws JSONException, IOException{
        
        clientView.setLoginpanelVisibility(true);
    }
    
    public synchronized void treatLogin(JSONObject json_msg, ClientView clientView) throws JSONException{
        clientView.setHomepanelVisibility(true);
    }
    
    public void treatSignup(JSONObject json_msg, ClientView clientView) throws JSONException, IOException{
        //desconnect();
        //reconnect();
        clientView.setLoginpanelVisibility(true);
        
    }
    
    
    
    //Thread Client Mensagens Recebidas/////////////////////////////////////////
    private synchronized Runnable createRunnable(final JSONObject json_msg, final ClientView clientView){
        Runnable runnable = () -> {
            try {
               
                int data = Integer.parseInt(json_msg.get("status").toString());
                
                //String operation = json_msg.keys().next().toString();
                switch (data) { 
                    case 201 -> {
                        treatSignup(json_msg, clientView);
                    }
                    case 200 -> {
                        treatLogin(json_msg, clientView);
                    }
                    case 600 -> {
                        treatLogout(json_msg, clientView);
                    }
                    case 400,202,500,404,403 -> {
                        JOptionPane.showMessageDialog(null, json_msg.get("mensagem"), "Erro Cadastro",
                    JOptionPane.WARNING_MESSAGE);
                    }
                                       
                    default -> {
                        System.out.println("JSON Key error");
                    }
                }
                return;
            } catch (JSONException ex) {
                
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return runnable;
    }    
    
    //Thread Client ////////////////////////////////////////////////////////////
    @Override 
    public void run(){
        try{
            while(true){
                String msg = this.in.readLine();
                
                //Sem resposta ou socket fechado: fecha socket, mata loop 
                if (msg == null ||  this.echoSocket.isClosed() || !this.echoSocket.isConnected() || msg.equals("null")) {
                    this.desconnect();
                    this.reconnect();
                    //break;
                //Recebe Mensagens
                }else{
                      JSONParser parserMessage = new JSONParser();
                      JSONObject JSONMsg = (JSONObject) parserMessage.parse(msg);
                      
                    
                    System.out.println("Message received from " + this.echoSocket.getInetAddress().getHostAddress() + ":" +
                                        this.echoSocket.getPort() + " = " + JSONMsg);
             
                    //ler mensagem em threads, pois servidor pode mandar continuamente mensagens
                    Thread thread = new Thread(createRunnable(JSONMsg, this.clientView));
                    thread.start();
                }
            }
        }catch(IOException e){
            //Desconecta server de forma forçada: fecha socket, mata thread 
            if(e.getMessage().equals("Connection reset")){
                System.out.println("Client desconected");
                try {
                    this.desconnect();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.interrupt(); //duvida: mata cliente
            }
        } catch (ParseException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
