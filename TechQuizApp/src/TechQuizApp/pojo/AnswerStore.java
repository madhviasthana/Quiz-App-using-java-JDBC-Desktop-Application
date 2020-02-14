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
public class AnswerStore {
    ArrayList<AnswerPojo> ansList;

    public AnswerStore() {
        ansList=new ArrayList<>();
    }
    
    public void addAnswer(AnswerPojo ap){
        ansList.add(ap);
    }
    
    public AnswerPojo getAnswer(int pos){
        return ansList.get(pos);
    }
    
    public void removeAnswer(int pos){
        ansList.remove(pos);
    }
    
    public void setAnswerAt(int pos,AnswerPojo ans){
        ansList.add(pos,ans);
    }
    
    public ArrayList<AnswerPojo> getAllAnswers(){
        return ansList;
    }
    
    public int getCount(){
        return ansList.size();
    }
    
    public AnswerPojo getAnswerByQno(int qno){
        for(AnswerPojo a:ansList){
            if(a.getQno()==qno)
                return a;
            
        }
        return null;
    }
    
    public int removeAnswer(AnswerPojo ap){
        int pos=ansList.indexOf(ap);
        ansList.remove(pos);
        return pos;
    }
}
