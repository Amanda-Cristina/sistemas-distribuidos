/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.net.Socket;


/**
 *
 * @author dinha
 */
public class ActiveUser {
    public String ip;
    public int port;
    public User user;
    public boolean loggedUser;
    public boolean connected;
    public Socket connection;
    
    public ActiveUser(String ip, int porta, boolean loggedUser, boolean connected){
        this.ip = ip;
        this.port = porta;
        this.loggedUser = loggedUser;
        this.connected = connected;
    }
    
    
}
