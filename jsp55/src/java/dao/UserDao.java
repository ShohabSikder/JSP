/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.DbCon;

public class UserDao {

    public static int saveUser(User u) throws ClassNotFoundException, SQLException {

        int status = 0;

        String sql = "insert into user(uid,fullName,userName,password,email)values(?,?,?,?,?)";
        PreparedStatement ps = DbCon.getCon().prepareStatement(sql);
        ps.setString(1, u.getUid());
        ps.setString(2, u.getFullName());
        ps.setString(3, u.getUserName());
        ps.setString(4, u.getPassword());
        ps.setString(5, u.getEmail());

        status = ps.executeUpdate();
        System.out.println(status);
        ps.close();
        DbCon.getCon().close();

        return status;

    }

    public static List<User> getAllUser() throws ClassNotFoundException, SQLException {
        List<User> userList = new ArrayList<>();
        String sql="select * from user";
        PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
        User u= new User(
                 rs.getString("uid"),
                rs.getString("fullName"),
                rs.getString("userName"),
                rs.getString("password"),
                rs.getString("email")
        );
        
        userList.add(u);
        }
        ps.close();
        DbCon.getCon().close();
        rs.close();
        return userList;
    }
    
    public static User getIdByUser(String id) throws ClassNotFoundException, SQLException{
        User u= new User();
    String sql="select * from user where uid=?";
        PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
        ps.setString(1, "uid");
        ResultSet rs= ps.executeQuery();
        
        while(rs.next()){
        u.setUid(rs.getString("uid"));
        u.setFullName(rs.getString("fullName"));
        u.setUserName(rs.getString("userName"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        }
        rs.close();
        ps.close();
        DbCon.getCon().close();
        return u;
    
    }
    
    public static int deleteUser(User u) throws ClassNotFoundException, SQLException{
    
        int status=0;
        String sql="delete from student where uid=?";
        PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
        ps.setString(1, u.getUid());
        
        status=ps.executeUpdate();
        ps.close();
        DbCon.getCon().close();
        return status;
    }

}
