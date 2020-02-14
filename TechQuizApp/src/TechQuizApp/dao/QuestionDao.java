/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.dbutil.DBConnection;
import TechQuizApp.pojo.QuestionPojo;
import TechQuizApp.pojo.QuestionStore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Deepesh Dasani
 */
public class QuestionDao {
    
    public static void addQuestion(QuestionStore qs) throws SQLException{
        ArrayList<QuestionPojo> queList=qs.getAllQuestions();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into Questions values(?,?,?,?,?,?,?,?,?)");
        for(QuestionPojo p:queList){
            ps.setString(1,p.getExamid());
            ps.setInt(2,p.getQno());
            ps.setString(3,p.getQuestion());
            ps.setString(4,p.getAnswer1());
            ps.setString(5,p.getAnswer2());
            ps.setString(6,p.getAnswer3());
            ps.setString(7,p.getAnswer4());
            ps.setString(8,p.getCorrectAnswer());
            ps.setString(9, p.getLanguage());
            ps.executeUpdate();
        }
    }
    
    public static void updateQuestion(QuestionStore qs) throws SQLException{
        ArrayList<QuestionPojo> queList=qs.getAllQuestions();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update Questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where examid=? and qno=?");
        for(QuestionPojo p:queList){
            ps.setString(7,p.getExamid());
            ps.setInt(8,p.getQno());
            ps.setString(1,p.getQuestion());
            ps.setString(2,p.getAnswer1());
            ps.setString(3,p.getAnswer2());
            ps.setString(4,p.getAnswer3());
            ps.setString(5,p.getAnswer4());
            ps.setString(6,p.getCorrectAnswer());
            ps.executeUpdate();
        }
    }
    
    public static ArrayList<QuestionPojo> getQuestionsByExamId(String examId) throws SQLException{
        ArrayList <QuestionPojo> al=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        String qry="select * from questions where examid=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,examId);
        ResultSet rs=ps.executeQuery();
        QuestionPojo p;
        while(rs.next()){
            p=new QuestionPojo();
            p.setExamid(rs.getString(1));
            p.setQno(rs.getInt(2));
            p.setQuestion(rs.getString(3));
            p.setAnswer1(rs.getString(4));
            p.setAnswer2(rs.getString(5));
            p.setAnswer3(rs.getString(6));
            p.setAnswer4(rs.getString(7));
            p.setCorrectAnswer(rs.getString(8));
            p.setLanguage(rs.getString(9));
            al.add(p);
            
            
        }
        
        return al;
    }
    
}
