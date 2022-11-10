/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.UserDAO;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author dinha
 */
public class User implements Serializable{
    //public String id;
    public String nome;
    public String ra;
    public int categoria;
    public String descricao;
    public String senha;
    
    
    public User(//String id,
                String nome,
                String ra,
                int categoria,
                String descricao,
                String senha
               ){
        //this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.categoria = categoria;
        this.descricao = descricao;
        this.senha = senha;
        
    }
    
    public static User getUserByRa(String ra) throws IOException{
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.selectAll();
        User user = null;
        for(User u : users){
            if(u.ra.equals(ra)){
                return u;
            }
        }
        return user;
    }
    
    public static User baseUser(String ra, String senha) throws IOException{
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.selectAll();
        User user = null;
        for(User u : users){
            if(u.ra.equals(ra)){
                if(u.senha.equals(senha)){
                    return u;
                }
            }
        }
        return user;
    }
    
}
