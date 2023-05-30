package com.exam.examportal.services;

import com.exam.examportal.model.exam.Question;
import com.exam.examportal.model.exam.Quiz;

import java.util.Set;

public interface QuestionServices {

    public Question addQuestion(Question question);
    public  Question updateQuestion(Question question);
    public Set<Question> getQuestion();
    public Question getQuestion(Long questionId);
    public Set<Question> getQuestionofQuiz(Quiz quiz);

    public  void deleteQuestion(Long quesId);
    public Question get(Long questionId);

}
