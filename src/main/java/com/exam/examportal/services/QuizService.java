package com.exam.examportal.services;

import com.exam.examportal.model.exam.Category;
import com.exam.examportal.model.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizees();
    public Quiz getQuiz(Long qizeId);
    public void deleteQuize(Long quizId);
    public List<Quiz> getQiuzzesofCategory(Category category);

    public List<Quiz> getActiveQuizzes();
    public List<Quiz> getActiveQuizzesofCategory(Category c);
}
