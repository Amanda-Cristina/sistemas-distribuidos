/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.UserDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.simple.JSONArray;
//import org.json.JSONObject;
import views.ServerView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author dinha
 */
public class ServerThread extends Thread{
    private final Server server;
    private final ServerView view;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;
    private ActiveUser user;
    
    public ServerThread(Socket clientSocket, Server server){
        this.server = server;
        this.clientSocket = clientSocket;
        this.view = server.getServerView();
    }
    
    public void desconnect() throws IOException{
        System.out.println("Client desconected " + this.clientSocket.getInetAddress().getHostAddress() + ":" +
                                        this.clientSocket.getPort());   
        this.clientSocket.close();         
        this.out.close(); 
        this.in.close();
        this.user.connected = false;  //duvida: não deveria tirar da lista
        this.server.updateTable();
        
    }
    
    private JSONObject signup(JSONObject msg_json) throws JSONException, IOException{
        JSONObject reply = new JSONObject();
        JSONObject dados = new JSONObject();
        JSONObject usuario = new JSONObject();
        
        JSONObject data_ = (JSONObject) msg_json.get("parametros");
               
        
        //Verifica se campos existem
        if(!data_.containsKey("nome")||!data_.containsKey("ra")||
                !data_.containsKey("senha")||!data_.containsKey("categoria_id")||!data_.containsKey("descricao")){
            reply.put("status", 400);
            reply.put("mensagem", "Parâmetros enviados não correspondem à operação!");
            reply.put("dados", dados);
            return reply;
        }
        
        String ra = data_.get("ra").toString();
        String nome = data_.get("nome").toString();
        String senha = data_.get("senha").toString();
        int categoria = Integer.parseInt(data_.get("categoria_id").toString());
        String descricao = data_.get("descricao").toString();

        //Verifica pelo RA se usuário já está no banco
        if(User.getUserByRa(ra) != null){
            reply.put("status", 202);
            reply.put("mensagem", "Usuário já encontra-se cadastrado!");
            reply.put("dados", dados);
            
        }
        
        //Se usuário não existe no banco insere
        else{
            User user = new User(nome, ra, categoria, descricao, senha);
            UserDAO userDAO = new UserDAO();
            try{
                userDAO.save(user);
                
                usuario.put("nome", nome);
                usuario.put("ra", ra);
                usuario.put("descricao", descricao);
                usuario.put("categoria_id", categoria);
                usuario.put("senha", senha);
                
                dados.put("usuario", usuario);
                reply.put("status", 201);
                reply.put("mensagem", "Usuário cadastrado com sucesso");
                reply.put("dados", dados);
                
                
            }
            // Erro servidor
            catch(IOException e){
                reply.put("status", 500);
                reply.put("mensagem", "Erro interno do servidor");
                reply.put("dados", dados);
            }
        }
        return reply;
    }
    
    private JSONObject login(JSONObject msg_json) throws JSONException, IOException{
        JSONObject reply = new JSONObject();
        JSONObject dados = new JSONObject();
        JSONObject usuario = new JSONObject();

        try{
        JSONObject data_ = (JSONObject) msg_json.get("parametros");
        String ra = data_.get("ra").toString();
        String senha = data_.get("senha").toString();
        
        if(ra.isEmpty() || senha.isEmpty()){
            reply.put("status", 404);
            reply.put("mensagem", "Usuário ou senha inválido!");
            reply.put("dados", dados);
            return reply;
        }
        
        User user_ = User.baseUser(ra, senha);
        if(user_ != null){
            if(!this.server.activeUserLoggedByIp(this.clientSocket.getInetAddress().getHostAddress())){
                usuario.put("nome", user_.nome);
                usuario.put("ra", user_.ra);
                usuario.put("descricao", user_.descricao);
                usuario.put("categoria_id", user_.categoria);
                usuario.put("senha", user_.senha);
                
                dados.put("usuario", usuario);
                reply.put("status", 200);
                reply.put("mensagem", "Usuário logado com sucesso!");
                reply.put("dados", dados);


                this.user.user = user_;
                this.user.loggedUser = true;
                this.user.connection = this.clientSocket;
                int user_index = this.server.getConnectedUsers().indexOf(this.user);
                this.server.updateActiveUsers(user_index, this.user);

                //this.server.addOnlineUser(this.user);
                this.server.updateTable();
            }
            else{
                reply.put("status", 403);
                reply.put("mensagem", "Usuário já encontra-se conectado!");
                reply.put("dados", dados);
            }
            
        }else{
            reply.put("status", 404);
            reply.put("mensagem", "Usuário ou senha inválido!");
            reply.put("dados", dados);
        }
        }catch(IOException e){
                reply.put("status", 500);
                reply.put("mensagem", "Erro interno do servidor");
                reply.put("dados", dados);
            }
        
        return reply;
    }
    
    private JSONObject logout(JSONObject msg_json) throws JSONException, Exception{
        JSONObject reply = new JSONObject();
        JSONObject dados = new JSONObject();
        
        try{
            JSONObject data_ = (JSONObject) msg_json.get("parametros");
            String ra = data_.get("ra").toString();
            String senha = data_.get("senha").toString();
            
            User user_ = User.baseUser(ra, senha);
            if(user_ != null){
                if(this.server.activeUserLoggedByIp(this.clientSocket.getInetAddress().getHostAddress())){
                    int user_index = this.server.getConnectedUsers().indexOf(this.user);
                    this.user.loggedUser = false;
                    //this.user.connection = null; //duvida: desconectar
                    //this.user.connected = false;
                    this.server.updateActiveUsers(user_index, user);
                    //this.server.removeOnlineUser(user);
                    this.server.updateTable();
            
                    reply.put("status", 600);
                    reply.put("mensagem", "Usuário desconectado com sucesso!");
                    reply.put("dados", dados);
                    
                }
                else{
                    reply.put("status", 202);
                    reply.put("mensagem", "Usuário já  encontra-se desconectado!");
                    reply.put("dados", dados);
            }
            }
            else{
                reply.put("status", 404);
                reply.put("mensagem", "Usuário não encontrado!");
                reply.put("dados", dados);
            }
        
            
        }
        catch(Exception e){
            reply.put("status", 500);
            reply.put("mensagem", "Erro interno do servidor");
            reply.put("dados", dados);
        }
        return reply;    
    }
    
    private void setReply(JSONObject msg_json) throws JSONException, IOException, Exception{
        String operation =  msg_json.get("operacao").toString();
        //String operation = msg_json.getString("operacao");
       
        JSONObject reply = new JSONObject();
        switch (operation) {
            
            case "cadastrar" -> {
                reply = signup(msg_json);
                sendMessage(reply);
                this.desconnect();
            }
            
            case "login" -> {
                reply = login(msg_json);
                sendMessage(reply);
            }
            
            case "logout" -> {
                reply = logout(msg_json);
                sendMessage(reply);
                this.desconnect();
            }
            
            default -> {}
        }
        
    }
        //Envio Mensagem////////////////////////////////////////////////////////////
    public void sendMessage(JSONObject reply) throws IOException, JSONException{
        if(reply != null){
                        //sending reply to client
                        this.out.println(reply);
                        this.out.flush();
                        System.out.println("Message sent to " + this.clientSocket.getInetAddress().getHostAddress() + ":" + 
                                                this.clientSocket.getPort() + " = " + reply);
                     
                    }
       
    }
    
    public void run(){
        System.out.println ("New Communication Thread Started " + this.clientSocket.getInetAddress().getHostAddress()+":" + this.clientSocket.getPort());

        try { 
                //in e out server
                this.out = new PrintWriter(this.clientSocket.getOutputStream(), 
                                      true); 
                this.in = new BufferedReader( 
                 new InputStreamReader(this.clientSocket.getInputStream())); 
         
                //controle usuários conectados
                ActiveUser activeUser = this.server.getActiveUserByIp(this.clientSocket.getInetAddress().getHostAddress());
                if(activeUser == null){
                    activeUser = new ActiveUser(this.clientSocket.getInetAddress().getHostAddress(), 
                                                   this.clientSocket.getPort(), false, false);
                    this.server.addActiveUser(activeUser);
                }
                activeUser.connected = true;
                this.user = activeUser;
                this.server.updateTable();
          
         
            //Troca mensagem 
            while(true){
                String msg = this.in.readLine();
               
                //Sem resposta ou cliente fechado: desconecta (bool), fecha socket, atualiza tabela, mata loop 
                if (msg == null || this.clientSocket.isClosed()|| msg.equals("null")|| !this.clientSocket.isConnected()) {           
                    
                    this.desconnect();
                    
                    
                    
                //Recebe Mensagens
                }else{
                    JSONParser parserMessage = new JSONParser();
                    JSONObject JSONMsg = (JSONObject) parserMessage.parse(msg);
                    
                    System.out.println("Message received from " + this.clientSocket.getInetAddress().getHostAddress() + ":" +
                                        this.clientSocket.getPort() + " = " + msg);
                    //set the reply
                    this.setReply(JSONMsg);
                    //JSONObject reply = this.getReply(JSONMsg);
                    
                }
            }
        } 
        catch (IOException e) 
        { 
            //Desconecta cliente de forma forçada: desconecta client (bool), fechasocket clientes, mata thread 
            if(e.getMessage().equals("Connection reset")){
                
                //this.user.setLoggedUser(false);
                //this.server.removeActiveUsers(this.user); //duvida: tira da lista?
                
                try {
                    this.desconnect();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.interrupt();
            } 
         
         
         
        } catch (JSONException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
