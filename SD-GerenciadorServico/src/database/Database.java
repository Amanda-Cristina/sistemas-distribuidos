/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author dinha
 */
public class Database implements Serializable{
    private List<User> users = new ArrayList<>();
    private static Database bd = null;
    
    private Database(){}
    
    public List<User> getUsers(){
        return users;
    }
    
    public void setUsers(List<User> users){
        this.users = users;
    }
     public static Database getInstance() throws IOException{
        if(bd == null){
            bd = reloadState();
            return bd;
        }else{
            return bd;
        }
    }
    
     private static Database reloadState() throws IOException{
        Database bd_;
        ObjectInputStream inputobj = null;
        try{
            inputobj = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("banco.dat"))));
            bd_ = (Database) inputobj.readObject();
            inputobj.close();
            return bd_;
        }catch(ClassNotFoundException | IOException ex){
            return new Database();
        }
    }
    
    public void saveState() throws IOException{
        ObjectOutputStream outputobj = null;
        outputobj = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("banco.dat")));
        outputobj.writeObject(Database.bd);
        outputobj.close();
    }
    
   
}
