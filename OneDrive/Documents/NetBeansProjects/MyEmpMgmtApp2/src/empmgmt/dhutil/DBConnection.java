/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dhutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kalim
 */
public class DBConnection {
    private static Connection conn;
    static {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
             conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-P6QE1H1:1521/xe","project1","8757");
             JOptionPane.showMessageDialog(null, "connection opened successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException ex){
             JOptionPane.showMessageDialog(null,"Error in loading the driver","Driver Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             System.exit(1);
        }
         catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Error in opening Connection the driver","DB Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             System.exit(1);
        }
        
    }
    public static Connection getConnection(){
        return conn;
    }
 public static void closeConnetion(){
     try{
         conn.close();
         JOptionPane.showMessageDialog(null,"Connetion close successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
     }
     catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error in closing connection ","DB Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             
     }
 }
  
}
