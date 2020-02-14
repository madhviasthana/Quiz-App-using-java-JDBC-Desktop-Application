/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.dbutil.DBConnection;
import TechQuizApp.pojo.PerformancePojo;
import TechQuizApp.pojo.StudentScore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Deepesh Dasani
 */
public class PerformanceDao {
    
    public static ArrayList getAllStudents() throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select unique userid from performance";
        PreparedStatement ps=conn.prepareStatement(qry);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> userIdList=new ArrayList<>();
        while(rs.next()){
            String id=rs.getString(1);
            userIdList.add(id);
        }
        return userIdList;
    }
    
    public static ArrayList<String> getAllExamId(String stdid)throws SQLException{
        String qry="select examid from performance where userid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,stdid);
        ArrayList<String> examIdList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String id=rs.getString(1);
            examIdList.add(id);
        }
        return examIdList;
    }
    
    
    public static StudentScore getScore(String studentId,String examId)throws SQLException{
        Connection conn =DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select language,per from Performance where userid=? and examid=?");
        ps.setString(1,studentId);
        ps.setString(2,examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        StudentScore obj=new StudentScore();
        obj.setLanguage(rs.getString(1));
        obj.setPer(rs.getDouble(2));
        return obj;
    }
    
    public static ArrayList<PerformancePojo> getAllData() throws SQLException{
        String qry="select * from performance";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ResultSet rs=ps.executeQuery();
        ArrayList <PerformancePojo>performanceList=new ArrayList<>();
        while(rs.next())
        {
            String userid=rs.getString("userid");
            String examid=rs.getString("examid");
            String language=rs.getString("language");
            int right=rs.getInt("right");
            int wrong=rs.getInt("wrong");
            int unattempted=rs.getInt("unattempted");
            double per=rs.getDouble("per");
            PerformancePojo p=new PerformancePojo(examid,language,userid,right,wrong,unattempted,per);
            performanceList.add(p);
        }
        return performanceList;
    }
    
    public static void addPerformance(PerformancePojo p) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="insert into performance values(?,?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,p.getUserId());
        ps.setString(2,p.getExamId());
        ps.setInt(3, p.getRight());
        ps.setInt(4, p.getWrong());
        ps.setInt(5, p.getUnattempted());
        ps.setDouble(6, p.getPer());
        ps.setString(7,p.getLanguage());
        ps.executeUpdate();
    }
   
}
