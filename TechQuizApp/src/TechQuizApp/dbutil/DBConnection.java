/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dbutil;

/**
 *
 * @author Deepesh Dasani
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Deepesh Dasani
 */
public class DBConnection {
    
   public static Connection conn;
   static{
       try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-DEEPESH:1521/XE","onlineexam","student");
            JOptionPane.showMessageDialog(null,"Connected");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to connect ");
        }
   }
   
   public static Connection getConnection()
   {
       return conn;
   }
   
   public static void closeConnection()
   {
       try{
           conn.close();
           JOptionPane.showMessageDialog(null,"Disconnected Successfully");
       }
       catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to Close Connection ");
        }
   }
}
