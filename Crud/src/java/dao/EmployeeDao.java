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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import util.DbUtil;

/**
 *
 * @author USERAS
 */
public class EmployeeDao {
    public static DbUtil db = new DbUtil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";
    
    public static int saveEmployee(Employee e){
        int status = 0;

        sql = "insert into employee(name, address, email) "
                + "values(?,?,?)";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setString(2, e.getAddress());
            ps.setString(3, e.getEmail());
            
            status = ps.executeUpdate();
            System.out.println(status);

            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
    
    
    public static List<Employee> viewEmployee() {
        List<Employee> eList = new ArrayList<>();

        sql = "select * from employee";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("email")
                );

                eList.add(e);
            }

            rs.close();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eList;
    }
    
    
    public static void deleteEmployee(Employee e) {
        sql = "delete from employee where id=?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);

            ps.setInt(1, e.getId());

            ps.executeUpdate();

            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void updateEmployee(Employee e) {

        sql = "update employee set name=?, address=?, email=? where id=?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setString(2, e.getAddress());
            ps.setString(3, e.getEmail());
            ps.setInt(4, e.getId());

            ps.executeUpdate();

            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Employee getById(int id) {

        Employee e = null;

        sql = "select * from employee where id=?";

        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {

                e = new Employee(
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
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}
