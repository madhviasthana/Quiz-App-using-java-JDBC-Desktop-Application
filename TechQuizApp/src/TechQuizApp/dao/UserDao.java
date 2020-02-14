/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.dbutil.DBConnection;
import TechQuizApp.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Deepesh Dasani
 */
public class UserDao {
    
    public static boolean validateUser(UserPojo user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    
    public static boolean addUser(UserPojo user) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=?");
        ps.setString(1, user.getUserid());
        if(ps.executeQuery().next())
            return false;
        else{
            ps=conn.prepareStatement("insert into users values(?,?,?)");
            ps.setString(1, user.getUserid());
            ps.setString(2, user.getPassword());
            ps.setString(3,user.getUserType());
            ps.executeQuery();
            return true;
        }
    }
            
        public static boolean changePassword(String userId,String pass) throws SQLException{
            String qry="update users set password=? where userid=?";
            boolean status=true;
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(qry);
            ps.setString(1,pass);
            ps.setString(2,userId);
            int ans=ps.executeUpdate();
            if(ans==0)
                status=false;
            return status;
        }
    }

