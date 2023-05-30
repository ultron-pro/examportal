package com.exam.examportal.services.impl;

import com.exam.examportal.model.exam.Category;
import com.exam.examportal.model.exam.Quiz;
import com.exam.examportal.repo.QuizRepository;
import com.exam.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizeServicesImpl implements QuizService {


      @Autowired
      private  QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizees() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long qizeId) {



        return this.quizRepository.findById(qizeId).get();
    }

    @Override
    public void deleteQuize(Long quizId) {
//        Quiz quiz=new Quiz();
//        quiz.setQid(quizId);
//        this.quizRepository.delete(quiz);

      this.quizRepository.deleteById(quizId);
    }

    @Override
    public List<Quiz> getQiuzzesofCategory(Category category) {
        return this.quizRepository.findByCategory(category);
    }



    //get Active boolean

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesofCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c,true);
    }
}
