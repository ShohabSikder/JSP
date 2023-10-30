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
import model.Student;
import util.DbCon;

/**
 *
 * @author user
 */
public class StudentDao {
    public static int saveStudent(Student s) throws ClassNotFoundException, SQLException{
    int status=0;
    String sql="insert into student(firstname,lastname,subject,gender)values(?,?,?,?)";
        PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
        
       ps.setString(1, s.getFirstName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getSubject());
        ps.setString(4, s.getGender());
        
        status = ps.executeUpdate();
        
        return status;
    
    }
    
    public static List<Student> getAllStudent() throws ClassNotFoundException, SQLException{
    
        List<Student> studentList= new ArrayList<>();
        
        String sql="select * from student";
    
        PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
        Student s= new Student(
                rs.getString("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("subject"),
                rs.getString("gender"));
        
        studentList.add(s);
        }
        return studentList;
    }
    
}
