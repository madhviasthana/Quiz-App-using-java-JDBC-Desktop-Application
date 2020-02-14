/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.pojo;

import java.util.ArrayList;

/**
 *
 * @author Deepesh Dasani
 */
public class QuestionStore {
    ArrayList<QuestionPojo> queList;

    public QuestionStore(ArrayList<QuestionPojo> queList) {
        this.queList = queList;
    }
    
    public QuestionStore(){
        queList=new ArrayList<>();
    }
    
    public void addQuestion(QuestionPojo q)
    {
        
        queList.add(q);
    }
    public QuestionPojo getQuestion(int pos)
    {
        return queList.get(pos);
    }
    
    public void removeQuestion(int pos){
        queList.remove(pos);
    }
    public void setQuestionAt(int pos,QuestionPojo q){
        queList.add(pos,q);
    }
    
    public ArrayList<QuestionPojo> getAllQuestions(){
        return queList;
    }
    public int getCount(){
        return queList.size();
    }
}

