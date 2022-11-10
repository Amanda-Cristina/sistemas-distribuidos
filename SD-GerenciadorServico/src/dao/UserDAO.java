/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Database;
import java.io.IOException;
import java.util.List;
import model.User;

/**
 *
 * @author dinha
 */
public class UserDAO {
    public void save(User user) throws IOException{
        Database db = Database.getInstance();
        db.getUsers().add(user);
        db.saveState();
    }
    
    public List<User> selectAll() throws IOException{
        Database db = Database.getInstance();
        return (List<User>)db.getUsers();
    }
}
