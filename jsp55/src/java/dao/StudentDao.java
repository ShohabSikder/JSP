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

    public static int saveStudent(Student s) throws ClassNotFoundException, SQLException {
        int status = 0;
        String sql = "insert into student(firstname,lastname,subject,gender)values(?,?,?,?)";
        PreparedStatement ps = DbCon.getCon().prepareStatement(sql);

        ps.setString(1, s.getFirstName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getSubject());
        ps.setString(4, s.getGender());

        status = ps.executeUpdate();
        ps.close();
        DbCon.getCon().close();

        return status;

    }

    public static List<Student> getAllStudent() throws ClassNotFoundException, SQLException {

        List<Student> studentList = new ArrayList<>();

        String sql = "select * from student";

        PreparedStatement ps = DbCon.getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("subject"),
                    rs.getString("gender"));

            studentList.add(s);
        }
        rs.close();
        ps.close();
        DbCon.getCon().close();
        return studentList;
    }

    
    // for data catch by id 
    public static Student getStudentById(int id) throws ClassNotFoundException, SQLException {
        
        Student s = new Student();
        String sql = "select * from student where id=?";
        PreparedStatement ps = DbCon.getCon().prepareStatement(sql);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            s.setId(rs.getInt("id"));
            s.setFirstName(rs.getString("firstname"));
            s.setLastName(rs.getString("lastname"));
            s.setSubject(rs.getString("subject"));
            s.setGender(rs.getString("gender"));
        }
        ps.close();
        rs.close();
        DbCon.getCon().close();

        return s;

    }

    //edit data method
    public static int editStudentById(Student s) throws ClassNotFoundException, SQLException {
        int status = 0;
        String sql = "update student set firstname=?,lastname=?,subject=?,gender=? where id=?";
        PreparedStatement ps = DbCon.getCon().prepareStatement(sql);

        ps.setString(1, s.getFirstName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getSubject());
        ps.setString(4, s.getGender());
        ps.setInt(5, s.getId());

        status = ps.executeUpdate();
        ps.close();
        DbCon.getCon().close();
        return status;
    }

    // delete data method
    public static int deleteStudentById(Student s) throws ClassNotFoundException, SQLException {
        int status = 0;
        String sql = "delete from student  where id=?";
        PreparedStatement ps = DbCon.getCon().prepareStatement(sql);
        ps.setInt(1, s.getId());  // I have a question why i wrote set int
        status = ps.executeUpdate();
        ps.close();
        DbCon.getCon().close();
        return status;

    }

}
