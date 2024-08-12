package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.DbUtil;


public class StudentDao {
    static Student s = new Student();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";
    
    public static int saveStd(Student s){
        int status = 0;
        sql = "insert into student(name, address, email) values(?,?,?)";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setString(1, s.getName());
            ps.setString(2, s.getAddress());
            ps.setString(3, s.getEmail());
            
            status = ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
        
    }
    
    public static List<Student> viewStd(){
        List<Student> sList = new ArrayList<>();
        
        sql = "select * from student";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                );
                sList.add(s);
            }
            ps.close();
            rs.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sList;
        
    }
    
    public static void deleteStd(Student s){
        sql = "delete from student where id=?";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setInt(1, s.getId());
            
            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void updateStd(Student s){
        sql = "update student set name=?, address=?, emaail=? where id=?";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(3, s.getAddress());
            ps.setString(2, s.getEmail());
            ps.setInt(5, s.getId());

            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        }
        catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Student getById(int id){
        Student s = null;
        sql = "select * from student where id=?";
        
         try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {

                s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                        
                );

            }

            ps.close();
            DbUtil.getCon().close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
