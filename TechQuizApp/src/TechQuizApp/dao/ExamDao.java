/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.dbutil.DBConnection;
import TechQuizApp.pojo.ExamPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Deepesh Dasani
 */
public class ExamDao {
    public static String getExamId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        int rowcount=0;
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select count(*) as r from exam");
        if(rs.next())
            rowcount=rs.getInt(1);
        return "EX-"+(rowcount+1);
    }
    
    public static boolean addExam(ExamPojo ex) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into exam values(?,?,?)");
        ps.setString(1,ex.getExamId());
        ps.setString(2,ex.getLanguage());
        ps.setInt(3,ex.getTotal_questions());
        int res=ps.executeUpdate();
        return res==1;
    }
    
    public static boolean isPaperSet(String lang) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from exam where language=?");
        ps.setString(1,lang);
        return ps.executeQuery().next();
    }
    
    public static ArrayList<String> getExamIdBySubject(String userid,String subject) throws SQLException{
        String qur="Select examid from Exam where language=? minus select examid from performance where userid=?";
        ArrayList <String> examList=new ArrayList();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qur);
        ps.setString(1,subject);
        ps.setString(2,userid);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
            examList.add(rs.getString(1));
        return examList;
    }
    
    public static int getQuestionCountByExam(String examid) throws SQLException{
        String qry="select total_questions from exam where examid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,examid);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
}
