/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JayJomJohn
 */
public class DBConnector {
        Connection conn = null;
              
        public static Connection ConnectToDB(String DB){
         
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName="+DB+";integratedSecurity=true;");
                return conn;         
            }
            catch (ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);                
            }
            return null;
        }
        
}
