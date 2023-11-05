/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;
import util.DbCon;

/**
 *
 * @author Shohab Sikder
 */
public class UserDao {
    public static int saveUser(User u) throws ClassNotFoundException, SQLException{
    
        int status=0;
        
        String sql="insert into user(uid,fullname,username,password,email)values(?,?,?,?,?)";
        PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
        ps.setString(1, u.getUid());
        ps.setString(2, u.getFullName());
        ps.setString(3, u.getUserName());
        ps.setString(4, u.getPassword());
        ps.setString(5, u.getEmail());
        
        status=ps.executeUpdate();
         System.out.println(status);
        ps.close();
        DbCon.getCon().close();
       
        return status;
   
    }
    
     
}
