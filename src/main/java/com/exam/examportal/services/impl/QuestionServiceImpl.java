package com.exam.examportal.services.impl;

import com.exam.examportal.model.exam.Question;
import com.exam.examportal.model.exam.Quiz;
import com.exam.examportal.repo.QuestionRepository;
import com.exam.examportal.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionServices {

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestion() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionofQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question= new Question();
        question.setQuesId(quesId);
        this.questionRepository.delete(question);

    }

    @Override
    public Question get(Long questionId) {
        return this.questionRepository.getOne(questionId);
    }
}
