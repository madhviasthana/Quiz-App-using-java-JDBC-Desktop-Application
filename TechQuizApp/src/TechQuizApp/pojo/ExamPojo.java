/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.pojo;

/**
 *
 * @author Deepesh Dasani
 */
public class ExamPojo {
    private String examId;
    private String language;

    public String getExamId() {
        return examId;
    }

    @Override
    public String toString() {
        return "ExamPojo{" + "examId=" + examId + ", language=" + language + ", total_questions=" + total_questions + '}';
    }

    public ExamPojo(String examId, String languages, int total_questions) {
        this.examId = examId;
        this.language = languages;
        this.total_questions = total_questions;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public ExamPojo() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguages(String languages) {
        this.language = languages;
    }

    public int getTotal_questions() {
        return total_questions;
    }

    public void setTotal_questions(int total_questions) {
        this.total_questions = total_questions;
    }
    private int total_questions;
    
}
