package com.exam.examportal.controller;
import com.exam.examportal.model.exam.Category;
import com.exam.examportal.model.exam.Quiz;
import com.exam.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
    {
        return  ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    @PutMapping("/")
    public  ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
    {
        return  ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    @GetMapping("/")
    public  ResponseEntity<?> getQuizes()
    {
        return  ResponseEntity.ok(this.quizService.getQuizees());
    }
    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid)
    {
        return this.quizService.getQuiz(qid);

    }
    //delete quizes

    @DeleteMapping("/{qid}")
    public void deleteQuize(@PathVariable("qid") Long qid)
    {
        System.out.println("id:-"+qid);
        this.quizService.deleteQuize(qid);
    }
    @GetMapping("/category/{cid}")
    public List<Quiz> getQiuzzesCategory(@PathVariable("cid") Long cid)
    {
        Category category=new Category();
        category.setCid(cid);
        return this.quizService.getQiuzzesofCategory(category);
    }
    //get Active quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes()
    {
        return this.quizService.getActiveQuizzes();
    }
    //get active of category
    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveCategoryQuiz(@PathVariable("cid") Long cid)
    {
        Category category=new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesofCategory(category);
    }

}
