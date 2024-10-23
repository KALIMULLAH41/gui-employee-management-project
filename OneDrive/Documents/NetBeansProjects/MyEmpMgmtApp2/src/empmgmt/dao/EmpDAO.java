/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dhutil.DBConnection;
import empmgmt.pojo.Employee;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kalim
 */
public class EmpDAO {

    public static boolean addEmployee(Employee e) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into employees values(?,?,?)");
        ps.setInt(1, e.getEmpNo());
        ps.setString(2, e.getEmpName());
        ps.setDouble(3, e.getEmpSal());

        int result = ps.executeUpdate();
        return result == 1;

        //this logic same
        //if (result == 1) {
         //   return true;
        //} else {
         //   return false;
       // }
    }
    public static Employee findEmployeeById(int empno)throws SQLException
    {
          Connection conn = DBConnection.getConnection();
           PreparedStatement ps = conn.prepareStatement("select * from employees where empno=?");
           ps.setInt(1, empno);
           ResultSet rs=ps.executeQuery();
           Employee e =null;
           if(rs.next())
           {
              // Employee e= new Employee();
               e.setEmpNo(rs.getInt(1));
               e.setEmpName(rs.getString(2));
               e.setEmpSal(rs.getDouble(3));
              // return e;
           }
           return e;
          // else
              // return null;
    }
    public static ArrayList<Employee>getAllEmployees()throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement st =conn.createStatement();
        ResultSet rs=st.executeQuery("select * from employees");
        ArrayList<Employee>empList=new ArrayList<>();
        while(rs.next())
        {
            Employee e=new Employee();
             e.setEmpNo(rs.getInt(1));
               e.setEmpName(rs.getString(2));
               e.setEmpSal(rs.getDouble(3));
               empList.add(e);
        }
        return empList;
    }

}
